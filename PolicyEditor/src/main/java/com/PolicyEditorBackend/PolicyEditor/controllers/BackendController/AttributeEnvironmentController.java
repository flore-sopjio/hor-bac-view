package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeEnvironment;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeEnvironmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributeenvironments")
public class AttributeEnvironmentController {
    @Autowired
    private AttributeEnvironmentRepo attributeEnvironmentRepository;

    // get all attributeEnvironments
    @GetMapping("")
    public List<AttributeEnvironment> getAllAttributeEnvironments() {
        return attributeEnvironmentRepository.findAll();
    }

    // get attributeEnvironment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeEnvironment> getAttributeEnvironmentById(@PathVariable(value = "id") Long attributeEnvId) {
        Optional<AttributeEnvironment> attributeEnvironment = attributeEnvironmentRepository.findById(attributeEnvId);
        if (attributeEnvironment.isPresent()) {
            return ResponseEntity.ok().body(attributeEnvironment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new attributeEnvironment
    @PostMapping("")
    public AttributeEnvironment createAttributeEnvironment(@RequestBody AttributeEnvironment attributeEnvironment) {
        return attributeEnvironmentRepository.save(attributeEnvironment);
    }

    // Modified an existing attributeEnvironment
    @PutMapping("/{id}")
    public ResponseEntity<AttributeEnvironment> updateAttributeEnvironment(@PathVariable(value = "id") Long attributeEnvId,
                                                                           @RequestBody AttributeEnvironment attributeEnvironmentDetails) {
        Optional<AttributeEnvironment> optionalAttributeEnvironment = attributeEnvironmentRepository.findById(attributeEnvId);
        if (optionalAttributeEnvironment.isPresent()) {
            AttributeEnvironment attributeEnvironment = optionalAttributeEnvironment.get();
            attributeEnvironment.setAttributeEnvType(attributeEnvironmentDetails.getAttributeEnvType());
            attributeEnvironment.setAttributeEnvName(attributeEnvironmentDetails.getAttributeEnvName());
            attributeEnvironment.setAttributeValEnvironments(attributeEnvironmentDetails.getAttributeValEnvironments());
            AttributeEnvironment updatedAttributeEnvironment = attributeEnvironmentRepository.save(attributeEnvironment);
            return ResponseEntity.ok().body(updatedAttributeEnvironment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an existing attributeEnvironment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeEnvironment(@PathVariable(value = "id") Long attributeEnvId) {
        Optional<AttributeEnvironment> optionalAttributeEnvironment = attributeEnvironmentRepository.findById(attributeEnvId);
        if (optionalAttributeEnvironment.isPresent()) {
            attributeEnvironmentRepository.delete(optionalAttributeEnvironment.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
