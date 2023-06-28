package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValEnvironment;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueEnvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalenvironments")
public class AttributeValueEnvironmentController {
    @Autowired
    private AttributeValueEnvRepo attributeValEnvironmentRepository;

    // Récupérer tous les attributeValEnvironments
    @GetMapping("")
    public List<AttributeValEnvironment> getAllAttributeValEnvironments() {
        return attributeValEnvironmentRepository.findAll();
    }

    // Récupérer un attributeValEnvironment par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValEnvironment> getAttributeValEnvironmentById(@PathVariable(value = "id") Long attributeValueEnv) {
        Optional<AttributeValEnvironment> attributeValEnvironment = attributeValEnvironmentRepository.findById(attributeValueEnv);
        if (attributeValEnvironment.isPresent()) {
            return ResponseEntity.ok().body(attributeValEnvironment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValEnvironment
    @PostMapping("")
    public AttributeValEnvironment createAttributeValEnvironment(@RequestBody AttributeValEnvironment attributeValEnvironment) {
        return attributeValEnvironmentRepository.save(attributeValEnvironment);
    }

    // Modifier un attributeValEnvironment existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValEnvironment> updateAttributeValEnvironment(@PathVariable(value = "id") Long attributeValueEnv,
                                                                                 @RequestBody AttributeValEnvironment attributeValEnvironmentDetails) {
        Optional<AttributeValEnvironment> optionalAttributeValEnvironment = attributeValEnvironmentRepository.findById(attributeValueEnv);
        if (optionalAttributeValEnvironment.isPresent()) {
            AttributeValEnvironment attributeValEnvironment = optionalAttributeValEnvironment.get();
            attributeValEnvironment.setAttributeVAlEnvType(attributeValEnvironmentDetails.getAttributeVAlEnvType());
            attributeValEnvironment.setAttributeVAlEnvValue(attributeValEnvironmentDetails.getAttributeVAlEnvValue());
            attributeValEnvironment.setAttributValAssignEnvirons(attributeValEnvironmentDetails.getAttributValAssignEnvirons());
            AttributeValEnvironment updatedAttributeValEnvironment = attributeValEnvironmentRepository.save(attributeValEnvironment);
            return ResponseEntity.ok().body(updatedAttributeValEnvironment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValEnvironment existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValEnvironment(@PathVariable(value = "id") Long attributeValueEnv) {
        Optional<AttributeValEnvironment> optionalAttributeValEnvironment = attributeValEnvironmentRepository.findById(attributeValueEnv);
        if (optionalAttributeValEnvironment.isPresent()) {
            attributeValEnvironmentRepository.delete(optionalAttributeValEnvironment.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
