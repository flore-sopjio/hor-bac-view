package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueAssignResource;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueAssignResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalueassignresources")
public class AttributeValAssignResController {
    @Autowired
    private AttributeValueAssignResRepo attributeValueAssignResourceRepository;

    // Récupérer tous les attributeValueAssignResources
    @GetMapping("")
    public List<AttributeValueAssignResource> getAllAttributeValueAssignResources() {
        return attributeValueAssignResourceRepository.findAll();
    }

    // Récupérer un attributeValueAssignResource par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValueAssignResource> getAttributeValueAssignResourceById(@PathVariable(value = "id") Long attributeValAssignResId) {
        Optional<AttributeValueAssignResource> attributeValueAssignResource = attributeValueAssignResourceRepository.findById(attributeValAssignResId);
        if (attributeValueAssignResource.isPresent()) {
            return ResponseEntity.ok().body(attributeValueAssignResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValueAssignResource
    @PostMapping("")
    public AttributeValueAssignResource createAttributeValueAssignResource(@RequestBody AttributeValueAssignResource attributeValueAssignResource) {
        return attributeValueAssignResourceRepository.save(attributeValueAssignResource);
    }

    // Modifier un attributeValueAssignResource existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValueAssignResource> updateAttributeValueAssignResource(@PathVariable(value = "id") Long attributeValAssignResId,
                                                                                           @RequestBody AttributeValueAssignResource attributeValueAssignResourceDetails) {
        Optional<AttributeValueAssignResource> optionalAttributeValueAssignResource = attributeValueAssignResourceRepository.findById(attributeValAssignResId);
        if (optionalAttributeValueAssignResource.isPresent()) {
            AttributeValueAssignResource attributeValueAssignResource = optionalAttributeValueAssignResource.get();
            attributeValueAssignResource.setResource(attributeValueAssignResourceDetails.getResource());
            attributeValueAssignResource.setAttributeValueResource(attributeValueAssignResourceDetails.getAttributeValueResource());
            AttributeValueAssignResource updatedAttributeValueAssignResource = attributeValueAssignResourceRepository.save(attributeValueAssignResource);
            return ResponseEntity.ok().body(updatedAttributeValueAssignResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValueAssignResource existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValueAssignResource(@PathVariable(value = "id") Long attributeValAssignResId) {
        Optional<AttributeValueAssignResource> optionalAttributeValueAssignResource = attributeValueAssignResourceRepository.findById(attributeValAssignResId);
        if (optionalAttributeValueAssignResource.isPresent()) {
            attributeValueAssignResourceRepository.delete(optionalAttributeValueAssignResource.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
