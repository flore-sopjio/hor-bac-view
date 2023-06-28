package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValAssignAction;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueAssignActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalassignactions")
public class AttributeValAssignActionController {
    @Autowired
    private AttributeValueAssignActionRepo attributeValAssignActionRepository;

    // Récupérer tous les attributeValAssignActions
    @GetMapping("")
    public List<AttributeValAssignAction> getAllAttributeValAssignActions() {
        return attributeValAssignActionRepository.findAll();
    }

    // Récupérer un attributeValAssignAction par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValAssignAction> getAttributeValAssignActionById(@PathVariable(value = "id") Long attributeValAssignActId) {
        Optional<AttributeValAssignAction> attributeValAssignAction = attributeValAssignActionRepository.findById(attributeValAssignActId);
        if (attributeValAssignAction.isPresent()) {
            return ResponseEntity.ok().body(attributeValAssignAction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValAssignAction
    @PostMapping("")
    public AttributeValAssignAction createAttributeValAssignAction(@RequestBody AttributeValAssignAction attributeValAssignAction) {
        return attributeValAssignActionRepository.save(attributeValAssignAction);
    }

    // Modifier un attributeValAssignAction existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValAssignAction> updateAttributeValAssignAction(@PathVariable(value = "id") Long attributeValAssignActId,
                                                                                   @RequestBody AttributeValAssignAction attributeValAssignActionDetails) {
        Optional<AttributeValAssignAction> optionalAttributeValAssignAction = attributeValAssignActionRepository.findById(attributeValAssignActId);
        if (optionalAttributeValAssignAction.isPresent()) {
            AttributeValAssignAction attributeValAssignAction = optionalAttributeValAssignAction.get();
            attributeValAssignAction.setAction(attributeValAssignActionDetails.getAction());
            attributeValAssignAction.setAttributeValueAction(attributeValAssignActionDetails.getAttributeValueAction());
            AttributeValAssignAction updatedAttributeValAssignAction = attributeValAssignActionRepository.save(attributeValAssignAction);
            return ResponseEntity.ok().body(updatedAttributeValAssignAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValAssignAction existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValAssignAction(@PathVariable(value = "id") Long attributeValAssignActId) {
        Optional<AttributeValAssignAction> optionalAttributeValAssignAction = attributeValAssignActionRepository.findById(attributeValAssignActId);
        if (optionalAttributeValAssignAction.isPresent()) {
            attributeValAssignActionRepository.delete(optionalAttributeValAssignAction.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
