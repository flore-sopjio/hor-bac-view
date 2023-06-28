package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;


import com.PolicyEditorBackend.PolicyEditor.Beans.Environment;
import com.PolicyEditorBackend.PolicyEditor.Repositories.EnvironmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/environments")
public class EnvironmentController {
    @Autowired
    private EnvironmentRepo environmentRepo;

    // get all environments
    @GetMapping("")
    public List<Environment> getAllEnvironment() {
        return environmentRepo.findAll();
    }

    // get environment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Environment> getEnvironmentById(@PathVariable(value = "id") Long environmentId) {
        Optional<Environment> environment = environmentRepo.findById(environmentId);
        if (environment.isPresent()) {
            return ResponseEntity.ok().body(environment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new environment
    @PostMapping("")
    public Environment createEnvironment(@RequestBody Environment environment) {
        return environmentRepo.save(environment);
    }

    // modified existing environment
    @PutMapping("/{id}")
    public ResponseEntity<Environment> updateEnvironment(@PathVariable(value = "id") Long environmentId,
                                                   @RequestBody Environment environmentDetails) {
        Optional<Environment> optionalEnvironment = environmentRepo.findById(environmentId);
        if (optionalEnvironment.isPresent()) {
            Environment environment = optionalEnvironment.get();
            environment.setTarget4(environmentDetails.getTarget4());
            Environment updatedEnvironment = environmentRepo.save(environment);
            return ResponseEntity.ok().body(updatedEnvironment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete environment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironment(@PathVariable(value = "id") Long environmentId) {
        Optional<Environment> optionalEnvironment = environmentRepo.findById(environmentId);
        if (optionalEnvironment.isPresent()) {
            environmentRepo.delete(optionalEnvironment.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
