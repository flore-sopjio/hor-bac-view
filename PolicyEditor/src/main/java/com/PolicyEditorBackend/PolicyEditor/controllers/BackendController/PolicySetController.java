package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.PolicySet;
import com.PolicyEditorBackend.PolicyEditor.Repositories.PolicySetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policySets")
public class PolicySetController {
    @Autowired
    private PolicySetRepo policySetRepository;

    // get all policySets
    @GetMapping("")
    public List<PolicySet> getAllPolicySets() {
        return policySetRepository.findAll();
    }

    // get policySet by ID
    @GetMapping("/{id}")
    public ResponseEntity<PolicySet> getPolicySetById(@PathVariable(value = "id") Long policySetId) {
        Optional<PolicySet> policyset = policySetRepository.findById(policySetId);
        if (policyset.isPresent()) {
            return ResponseEntity.ok().body(policyset.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new policySet
    @PostMapping("")
    public PolicySet createPolicySet(@RequestBody PolicySet policySet) {
        return policySetRepository.save(policySet);
    }

    // Modified an existing policySet
    @PutMapping("/{id}")
    public ResponseEntity<PolicySet> updatePolicySet(@PathVariable(value = "id") Long policySetId,
                                                     @RequestBody PolicySet policySetDetails) {
        Optional<PolicySet> optionalPolicySet = policySetRepository.findById(policySetId);
        if (optionalPolicySet.isPresent()) {
            PolicySet policySet = optionalPolicySet.get();
            policySet.setXmlns(policySetDetails.getXmlns());
            policySet.setVersion(policySetDetails.getVersion());
            policySet.setPolicyCombAlg(policySetDetails.getPolicyCombAlg());
            policySet.setDescription(policySetDetails.getDescription());
            policySet.setTarget(policySetDetails.getTarget());
            policySet.setPolicySets(policySetDetails.getPolicySets());
            policySet.setPolicies(policySetDetails.getPolicies());
            policySet.setPolicy_Set(policySetDetails.getPolicy_Set());
            PolicySet updatedPolicySet = policySetRepository.save(policySet);
            return ResponseEntity.ok().body(updatedPolicySet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an existing policySet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicySet(@PathVariable(value = "id") Long policySetId) {
        Optional<PolicySet> optionalPolicySet = policySetRepository.findById(policySetId);
        if (optionalPolicySet.isPresent()) {
            policySetRepository.delete(optionalPolicySet.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
