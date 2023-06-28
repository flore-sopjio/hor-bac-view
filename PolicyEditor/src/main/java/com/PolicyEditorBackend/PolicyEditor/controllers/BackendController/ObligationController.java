package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;


import com.PolicyEditorBackend.PolicyEditor.Beans.Obligation;
import com.PolicyEditorBackend.PolicyEditor.Repositories.ObligationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/obligations")
public class ObligationController {

    @Autowired
    private ObligationRepo obligationRepo;

    // get all obligations
    @GetMapping("")
    public List<Obligation> getAllObligation() {
        return obligationRepo.findAll();
    }

    // get obligation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Obligation> getObligationById(@PathVariable(value = "id") Long obligationId) {
        Optional<Obligation> obligation = obligationRepo.findById(obligationId);
        if (obligation.isPresent()) {
            return ResponseEntity.ok().body(obligation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new obligation
    @PostMapping("")
    public Obligation createObligation(@RequestBody Obligation obligation) {
        return obligationRepo.save(obligation);
    }

    // modified an existing obligation
    @PutMapping("/{id}")
    public ResponseEntity<Obligation> updateObligation(@PathVariable(value = "id") Long obligationId,
                                               @RequestBody Obligation obligationDetails) {
        Optional<Obligation> optionalObligation = obligationRepo.findById(obligationId);
        if (optionalObligation.isPresent()) {
            Obligation obligation = optionalObligation.get();
            obligation.setFulfillOn(obligationDetails.getFulfillOn());
            obligation.setRule(obligationDetails.getRule());
            obligation.setPolicy(obligationDetails.getPolicy());
            obligation.setPolicySet(obligationDetails.getPolicySet());
            Obligation updatedObligation = obligationRepo.save(obligation);
            return ResponseEntity.ok().body(updatedObligation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete existing obligation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObligation(@PathVariable(value = "id") Long obligationId) {
        Optional<Obligation> optionalObligation = obligationRepo.findById(obligationId);
        if (optionalObligation.isPresent()) {
            obligationRepo.delete(optionalObligation.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
