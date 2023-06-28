package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Target;
import com.PolicyEditorBackend.PolicyEditor.Repositories.TargetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/targets")
public class TargetController {
    @Autowired
    private TargetRepo targetRepository;

    // get all targets
    @GetMapping("")
    public List<Target> getAllTargets() {
        return targetRepository.findAll();
    }

    // get target by ID
    @GetMapping("/{id}")
    public ResponseEntity<Target> getTargetById(@PathVariable(value = "id") Long targetId) {
        Optional<Target> target = targetRepository.findById(targetId);
        if (target.isPresent()) {
            return ResponseEntity.ok().body(target.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new target
    @PostMapping("")
    public Target createTarget(@RequestBody Target target) {
        return targetRepository.save(target);
    }

    // Modified and existing target
    @PutMapping("/{id}")
    public ResponseEntity<Target> updateTarget(@PathVariable(value = "id") Long targetId,
                                               @RequestBody Target targetDetails) {
        Optional<Target> optionalTarget = targetRepository.findById(targetId);
        if (optionalTarget.isPresent()) {
            Target target = optionalTarget.get();
            target.setDescription(targetDetails.getDescription());
            target.setPolicySet(targetDetails.getPolicySet());
            target.setPolicy(targetDetails.getPolicy());
            target.setRule(targetDetails.getRule());
            Target updatedTarget = targetRepository.save(target);
            return ResponseEntity.ok().body(updatedTarget);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an existing target
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarget(@PathVariable(value = "id") Long targetId) {
        Optional<Target> optionalTarget = targetRepository.findById(targetId);
        if (optionalTarget.isPresent()) {
            targetRepository.delete(optionalTarget.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
