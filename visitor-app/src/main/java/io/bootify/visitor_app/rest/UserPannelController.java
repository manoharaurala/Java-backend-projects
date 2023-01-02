package io.bootify.visitor_app.rest;

import io.bootify.visitor_app.domain.Visit;
import io.bootify.visitor_app.model.VisitStatus;
import io.bootify.visitor_app.model.VistDTO;
import io.bootify.visitor_app.service.VisitService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-panel")
public class UserPannelController {

    @Autowired
    private VisitService visitService;

    @PostMapping("/approve-visit/{visitId}")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> approve(@PathVariable final Long visitId, @RequestHeader final long userid ) {
        visitService.updateVisit(visitId,userid, VisitStatus.APPROVED);
        return new ResponseEntity<>("Approved", HttpStatus.OK);
    }

    @PostMapping("/reject-visit/{visitId}")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> reject(@PathVariable final Long visitId, @RequestHeader final long userid ) {
        visitService.updateVisit(visitId,userid,VisitStatus.REJECTED);
        return new ResponseEntity<>("Reject", HttpStatus.OK);
    }

    @GetMapping("/get-pending-visits")
    public ResponseEntity<List<VistDTO>> getPendingVists(@RequestHeader final long userId) {

        return ResponseEntity.ok(visitService.getPendingVisits(userId));
    }


}
