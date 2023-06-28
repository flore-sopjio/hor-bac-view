package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueResource;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalueresources")
public class AttributeValueResourceController {
    @Autowired
    private AttributeValueResourceRepo attributeValueResourceRepository;

    // Récupérer tous les attributeValueResources
    @GetMapping("")
    public List<AttributeValueResource> getAllAttributeValueResources() {
        return attributeValueResourceRepository.findAll();
    }

    // Récupérer un attributeValueResource par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValueResource> getAttributeValueResourceById(@PathVariable(value = "id") Long attributeValueRes) {
        Optional<AttributeValueResource> attributeValueResource = attributeValueResourceRepository.findById(attributeValueRes);
        if (attributeValueResource.isPresent()) {
            return ResponseEntity.ok().body(attributeValueResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValueResource
    @PostMapping("")
    public AttributeValueResource createAttributeValueResource(@RequestBody AttributeValueResource attributeValueResource) {
        return attributeValueResourceRepository.save(attributeValueResource);
    }

    // Modifier un attributeValueResource existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValueResource> updateAttributeValueResource(@PathVariable(value = "id") Long attributeValueRes,
                                                                               @RequestBody AttributeValueResource attributeValueResourceDetails) {
        Optional<AttributeValueResource> optionalAttributeValueResource = attributeValueResourceRepository.findById(attributeValueRes);
        if (optionalAttributeValueResource.isPresent()) {
            AttributeValueResource attributeValueResource = optionalAttributeValueResource.get();
            attributeValueResource.setAttributeVAlResType(attributeValueResourceDetails.getAttributeVAlResType());
            attributeValueResource.setAttributeVAlResValue(attributeValueResourceDetails.getAttributeVAlResValue());
            attributeValueResource.setAttributeValueAssignResources(attributeValueResourceDetails.getAttributeValueAssignResources());
            AttributeValueResource updatedAttributeValueResource = attributeValueResourceRepository.save(attributeValueResource);
            return ResponseEntity.ok().body(updatedAttributeValueResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValueResource existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValueResource(@PathVariable(value = "id") Long attributeValueRes) {
        Optional<AttributeValueResource> optionalAttributeValueResource = attributeValueResourceRepository.findById(attributeValueRes);
        if (optionalAttributeValueResource.isPresent()) {
            attributeValueResourceRepository.delete(optionalAttributeValueResource.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
