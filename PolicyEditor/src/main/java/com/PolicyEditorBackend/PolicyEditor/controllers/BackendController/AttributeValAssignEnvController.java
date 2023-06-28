package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValAssignEnviron;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueAssignEnvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalassignenvirons")
public class AttributeValAssignEnvController {
    @Autowired
    private AttributeValueAssignEnvRepo attributeValAssignEnvironRepository;

    // Récupérer tous les attributeValAssignEnvirons
    @GetMapping("")
    public List<AttributeValAssignEnviron> getAllAttributeValAssignEnvirons() {
        return attributeValAssignEnvironRepository.findAll();
    }

    // Récupérer un attributeValAssignEnviron par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValAssignEnviron> getAttributeValAssignEnvironById(@PathVariable(value = "id") Long attributeValAssignEnvId) {
        Optional<AttributeValAssignEnviron> attributeValAssignEnviron = attributeValAssignEnvironRepository.findById(attributeValAssignEnvId);
        if (attributeValAssignEnviron.isPresent()) {
            return ResponseEntity.ok().body(attributeValAssignEnviron.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValAssignEnviron
    @PostMapping("")
    public AttributeValAssignEnviron createAttributeValAssignEnviron(@RequestBody AttributeValAssignEnviron attributeValAssignEnviron) {
        return attributeValAssignEnvironRepository.save(attributeValAssignEnviron);
    }

    // Modifier un attributeValAssignEnviron existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValAssignEnviron> updateAttributeValAssignEnviron(@PathVariable(value = "id") Long attributeValAssignEnvId,
                                                                                     @RequestBody AttributeValAssignEnviron attributeValAssignEnvironDetails) {
        Optional<AttributeValAssignEnviron> optionalAttributeValAssignEnviron = attributeValAssignEnvironRepository.findById(attributeValAssignEnvId);
        if (optionalAttributeValAssignEnviron.isPresent()) {
            AttributeValAssignEnviron attributeValAssignEnviron = optionalAttributeValAssignEnviron.get();
            attributeValAssignEnviron.setEnvironment(attributeValAssignEnvironDetails.getEnvironment());
            attributeValAssignEnviron.setAttributeValEnvironment(attributeValAssignEnvironDetails.getAttributeValEnvironment());
            AttributeValAssignEnviron updatedAttributeValAssignEnviron = attributeValAssignEnvironRepository.save(attributeValAssignEnviron);
            return ResponseEntity.ok().body(updatedAttributeValAssignEnviron);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValAssignEnviron existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValAssignEnviron(@PathVariable(value = "id") Long attributeValAssignEnvId) {
        Optional<AttributeValAssignEnviron> optionalAttributeValAssignEnviron = attributeValAssignEnvironRepository.findById(attributeValAssignEnvId);
        if (optionalAttributeValAssignEnviron.isPresent()) {
            attributeValAssignEnvironRepository.delete(optionalAttributeValAssignEnviron.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
