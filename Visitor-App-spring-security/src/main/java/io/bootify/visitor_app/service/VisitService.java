package io.bootify.visitor_app.service;

import io.bootify.visitor_app.domain.Flat;
import io.bootify.visitor_app.domain.User;
import io.bootify.visitor_app.domain.Visitor;
import io.bootify.visitor_app.domain.Visit;
import io.bootify.visitor_app.model.VisitStatus;
import io.bootify.visitor_app.model.VisitorDTO;
import io.bootify.visitor_app.model.VistDTO;
import io.bootify.visitor_app.repos.FlatRepository;
import io.bootify.visitor_app.repos.UserRepository;
import io.bootify.visitor_app.repos.VisitorRepository;
import io.bootify.visitor_app.repos.VistRepository;
import io.bootify.visitor_app.util.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class VisitService {

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private String pendingVisitPrefix="Pending_Flat_";

    private final VistRepository vistRepository;
    private final VisitorRepository visitorRepository;



    public VisitService(final VistRepository vistRepository,
                        final VisitorRepository visitorRepository) {
        this.vistRepository = vistRepository;
        this.visitorRepository = visitorRepository;
    }

    public List<VistDTO> findAll() {
        final List<Visit> vists = vistRepository.findAll(Sort.by("id"));
        return vists.stream()
                .map((vist) -> mapToDTO(vist, new VistDTO()))
                .collect(Collectors.toList());
    }

    public List<VistDTO> getPendingVisits(long userId) {
        User user=userRepository.findById(userId).get();
        Flat flat=user.getFlat();
        String key=pendingVisitPrefix+flat.getId();
        List<VistDTO> vistDTOList= (List<VistDTO>) redisTemplate.opsForValue().get(key);

        if(vistDTOList==null){
            vistDTOList=vistRepository.findByFlatAndStatus(flat.getId(), String.valueOf(VisitStatus.PENDING))
                    .stream()
                    .map((vist) -> mapToDTO(vist, new VistDTO()))
                    .collect(Collectors.toList());
            redisTemplate.opsForValue().set(key,vistDTOList);
        }


        return vistDTOList;

    }

    public VistDTO get(final Long id) {
        return vistRepository.findById(id)
                .map(vist -> mapToDTO(vist, new VistDTO()))
                .orElseThrow(() -> new NotFoundException());
    }

    public Long create(final VistDTO vistDTO) {
        vistDTO.setStatus(VisitStatus.PENDING);
        final Visit vist = new Visit();
        mapToEntity(vistDTO, vist);
        return vistRepository.save(vist).getId();
    }

    public void markEntry(Long visitId){
        Visit visit= vistRepository.findById(visitId).get();
        if(visit!=null && visit.getStatus().equals(VisitStatus.APPROVED)) {
            visit.setInTime(LocalDateTime.now());
            vistRepository.save(visit);
            return;
        }
        else {
           throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Visit not approved yet");
        }
    }



    public void updateVisit(Long visitId, long userId,VisitStatus status){
        Visit visit=vistRepository.findById(visitId).get();
        Flat flat=visit.getFlat();
        User user=userRepository.findById(userId).get();
        Flat usersFlat= user.getFlat();

        if(flat.getId()==usersFlat.getId() && visit.getStatus().equals(VisitStatus.PENDING)){
            visit.setStatus(status);
            vistRepository.save(visit);
            String key=pendingVisitPrefix+flat.getId();
            redisTemplate.delete(key);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flat is not mapped or Visit not approved");
        }

    }


    public void markExit(Long visitId){
        Visit visit= vistRepository.findById(visitId).get();
        if(visit!=null && visit.getStatus().equals(VisitStatus.APPROVED)) {
            visit.setOutTime(LocalDateTime.now());
            visit.setStatus(VisitStatus.COMPLETED);
            vistRepository.save(visit);
            return;
        }
        else {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Visit not approve dyet");
        }
    }

    public void update(final Long id, final VistDTO vistDTO) {
        final Visit vist = vistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        mapToEntity(vistDTO, vist);
        vistRepository.save(vist);
    }

    public void delete(final Long id) {
        vistRepository.deleteById(id);
    }

    private VistDTO mapToDTO(final Visit vist, final VistDTO vistDTO) {
        vistDTO.setId(vist.getId());
        vistDTO.setStatus(vist.getStatus());
        vistDTO.setInTime(vist.getInTime());
        vistDTO.setOutTime(vist.getOutTime());
        vistDTO.setPurpose(vist.getPurpose());
        vistDTO.setUrlofimage(vist.getUrlofimage());
        vistDTO.setNoOfPeople(vist.getNoOfPeople());
        vistDTO.setFlatId(vist.getFlat().getId());
        vistDTO.setVistor(vist.getVistor() == null ? null : vist.getVistor().getId());
        return vistDTO;
    }

    private Visit mapToEntity(final VistDTO vistDTO, final Visit vist) {
        vist.setStatus(vistDTO.getStatus());
        vist.setInTime(vistDTO.getInTime());
        vist.setOutTime(vistDTO.getOutTime());
        vist.setPurpose(vistDTO.getPurpose());
        vist.setUrlofimage(vistDTO.getUrlofimage());
        vist.setNoOfPeople(vistDTO.getNoOfPeople());
        Flat flat= flatRepository.findById(vistDTO.getFlatId()).get();
        vist.setFlat(flat);
        final Visitor vistor = vistDTO.getVistor() == null ? null : visitorRepository.findById(vistDTO.getVistor())
                .orElseThrow(() -> new NotFoundException("vistor not found"));
        vist.setVistor(vistor);
        return vist;
    }

}
