package io.bootify.visitor_app.rest;

import io.bootify.visitor_app.model.CreateVisitorRequestDTO;
import io.bootify.visitor_app.model.VisitorDTO;
import io.bootify.visitor_app.model.VistDTO;
import io.bootify.visitor_app.service.GateKeeperPanelService;
import io.bootify.visitor_app.service.VisitService;
import io.bootify.visitor_app.service.VisitorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;

@RestController
@RequestMapping("/api/gateKeeper-panel")
public class GateKepperPanelController {

    static final String basePath = "G:/JAVA Backend Course/MyCode/Visitor-App-spring-security/src/main/resources/static";
    static final String relativePath = "/images/";
    static private Logger LOGGER = LoggerFactory.getLogger(GateKepperPanelController.class);

    @Autowired
    VisitorService visitorService;

    @Autowired
    VisitService visitService;

    @Autowired
    GateKeeperPanelService gateKeeperPanelService;

    @GetMapping("getVisitorByIdNumber")
    public ResponseEntity<VisitorDTO> getVisitor(@RequestParam final String idNumber) {
    return ResponseEntity.ok(visitorService.getByIdNumber(idNumber));
    }

    @PostMapping("/create-visitor")
    public ResponseEntity<Long> createVisitor(@RequestBody @Valid final CreateVisitorRequestDTO createVisitorRequestDTO) {
        return new ResponseEntity<>(gateKeeperPanelService.create(createVisitorRequestDTO), HttpStatus.CREATED);
    }


    @PostMapping("/create-visit")
    public ResponseEntity<Long> createVist(@RequestBody @Valid final VistDTO vistDTO) {
        return new ResponseEntity<>(visitService.create(vistDTO), HttpStatus.CREATED);
    }

    @PostMapping("/entry/{visitId}")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> markEntry(@PathVariable final Long visitId ) {
        visitService.markEntry(visitId);
        return new ResponseEntity<>("Updated", HttpStatus.CREATED);
    }

    @PostMapping("/exit/{visitId}")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> markExit(@PathVariable final Long visitId) {
        visitService.markExit(visitId);
        return new ResponseEntity<>("updated",HttpStatus.CREATED);
    }

    @PostMapping("/image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            String path = relativePath+"testfile_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
            String uploadPath = basePath+path;
            file.transferTo(new File(uploadPath));
            message = "Image URL : " + path;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}",e);
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }

    }


    /*
    upload image
     */


}
