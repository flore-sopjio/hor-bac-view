package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeAction;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributeactions")
public class AttributeActionController {
    @Autowired
    private AttributeActionRepo attributeActionRepository;

    // get all attributeActions
    @GetMapping("")
    public List<AttributeAction> getAllAttributeActions() {
        return attributeActionRepository.findAll();
    }

    // get attributeAction by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeAction> getAttributeActionById(@PathVariable(value = "id") Long attributeActId) {
        Optional<AttributeAction> attributeAction = attributeActionRepository.findById(attributeActId);
        if (attributeAction.isPresent()) {
            return ResponseEntity.ok().body(attributeAction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new attributeAction
    @PostMapping("")
    public AttributeAction createAttributeAction(@RequestBody AttributeAction attributeAction) {
        return attributeActionRepository.save(attributeAction);
    }

    // Modified an existing attributeAction
    @PutMapping("/{id}")
    public ResponseEntity<AttributeAction> updateAttributeAction(@PathVariable(value = "id") Long attributeActId,
                                                                 @RequestBody AttributeAction attributeActionDetails) {
        Optional<AttributeAction> optionalAttributeAction = attributeActionRepository.findById(attributeActId);
        if (optionalAttributeAction.isPresent()) {
            AttributeAction attributeAction = optionalAttributeAction.get();
            attributeAction.setAttributeActType(attributeActionDetails.getAttributeActType());
            attributeAction.setAttributeActName(attributeActionDetails.getAttributeActName());
            attributeAction.setAttributeValueActions(attributeActionDetails.getAttributeValueActions());
            AttributeAction updatedAttributeAction = attributeActionRepository.save(attributeAction);
            return ResponseEntity.ok().body(updatedAttributeAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an existing attributeAction
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeAction(@PathVariable(value = "id") Long attributeActId) {
        Optional<AttributeAction> optionalAttributeAction = attributeActionRepository.findById(attributeActId);
        if (optionalAttributeAction.isPresent()) {
            attributeActionRepository.delete(optionalAttributeAction.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
