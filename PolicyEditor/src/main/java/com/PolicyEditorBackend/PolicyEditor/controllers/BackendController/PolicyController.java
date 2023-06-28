package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Policy;
import com.PolicyEditorBackend.PolicyEditor.Repositories.PolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyRepo policyRepository;

    // get all policies
    @GetMapping("")
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    // get policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable(value = "id") Long policyId) {
        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isPresent()) {
            return ResponseEntity.ok().body(policy.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new policy
    @PostMapping("")
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }

    // modified an existing policy
    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable(value = "id") Long policyId,
                                               @RequestBody Policy policyDetails) {
        Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
        if (optionalPolicy.isPresent()) {
            Policy policy = optionalPolicy.get();
            policy.setPolicyXmlns(policyDetails.getPolicyXmlns());
            policy.setPolicyVersion(policyDetails.getPolicyVersion());
            policy.setPolicyCombAlg(policyDetails.getPolicyCombAlg());
            policy.setPolicyDescription(policyDetails.getPolicyDescription());
            policy.setTarget(policyDetails.getTarget());
            policy.setPolicy_set(policyDetails.getPolicy_set());
            policy.setRules(policyDetails.getRules());
            Policy updatedPolicy = policyRepository.save(policy);
            return ResponseEntity.ok().body(updatedPolicy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an existing policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable(value = "id") Long policyId) {
        Optional<Policy> optionalPolicy = policyRepository.findById(policyId);
        if (optionalPolicy.isPresent()) {
            policyRepository.delete(optionalPolicy.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
