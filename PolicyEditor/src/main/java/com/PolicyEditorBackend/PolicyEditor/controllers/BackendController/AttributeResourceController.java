package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeResource;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributeresources")
public class AttributeResourceController {
    @Autowired
    private AttributeResourceRepo attributeResourceRepository;

    // get all attributeResources
    @GetMapping("")
    public List<AttributeResource> getAllAttributeResources() {
        return attributeResourceRepository.findAll();
    }

    // get attributeResource by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeResource> getAttributeResourceById(@PathVariable(value = "id") Long attributeResId) {
        Optional<AttributeResource> attributeResource = attributeResourceRepository.findById(attributeResId);
        if (attributeResource.isPresent()) {
            return ResponseEntity.ok().body(attributeResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new attributeResource
    @PostMapping("")
    public AttributeResource createAttributeResource(@RequestBody AttributeResource attributeResource) {
        return attributeResourceRepository.save(attributeResource);
    }

    // Modifier un attributeResource existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeResource> updateAttributeResource(@PathVariable(value = "id") Long attributeResId,
                                                                     @RequestBody AttributeResource attributeResourceDetails) {
        Optional<AttributeResource> optionalAttributeResource = attributeResourceRepository.findById(attributeResId);
        if (optionalAttributeResource.isPresent()) {
            AttributeResource attributeResource = optionalAttributeResource.get();
            attributeResource.setAttributeResType(attributeResourceDetails.getAttributeResType());
            attributeResource.setAttributeResName(attributeResourceDetails.getAttributeResName());
            attributeResource.setAttributeValueResources(attributeResourceDetails.getAttributeValueResources());
            AttributeResource updatedAttributeResource = attributeResourceRepository.save(attributeResource);
            return ResponseEntity.ok().body(updatedAttributeResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeResource existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeResource(@PathVariable(value = "id") Long attributeResId) {
        Optional<AttributeResource> optionalAttributeResource = attributeResourceRepository.findById(attributeResId);
        if (optionalAttributeResource.isPresent()) {
            attributeResourceRepository.delete(optionalAttributeResource.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
