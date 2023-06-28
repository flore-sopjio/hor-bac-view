package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueAction;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalueactions")
public class AttributeValueActionController {
    @Autowired
    private AttributeValueActionRepo attributeValueActionRepository;

    // Récupérer tous les attributeValueActions
    @GetMapping("")
    public List<AttributeValueAction> getAllAttributeValueActions() {
        return attributeValueActionRepository.findAll();
    }

    // Récupérer un attributeValueAction par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValueAction> getAttributeValueActionById(@PathVariable(value = "id") Long attributeValueAct) {
        Optional<AttributeValueAction> attributeValueAction = attributeValueActionRepository.findById(attributeValueAct);
        if (attributeValueAction.isPresent()) {
            return ResponseEntity.ok().body(attributeValueAction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValueAction
    @PostMapping("")
    public AttributeValueAction createAttributeValueAction(@RequestBody AttributeValueAction attributeValueAction) {
        return attributeValueActionRepository.save(attributeValueAction);
    }

    // Modifier un attributeValueAction existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValueAction> updateAttributeValueAction(@PathVariable(value = "id") Long attributeValueAct,
                                                                           @RequestBody AttributeValueAction attributeValueActionDetails) {
        Optional<AttributeValueAction> optionalAttributeValueAction = attributeValueActionRepository.findById(attributeValueAct);
        if (optionalAttributeValueAction.isPresent()) {
            AttributeValueAction attributeValueAction = optionalAttributeValueAction.get();
            attributeValueAction.setAttributeVAlActType(attributeValueActionDetails.getAttributeVAlActType());
            attributeValueAction.setAttributeVAlActValue(attributeValueActionDetails.getAttributeVAlActValue());
            attributeValueAction.setAttributeValAssignActions(attributeValueActionDetails.getAttributeValAssignActions());
            AttributeValueAction updatedAttributeValueAction = attributeValueActionRepository.save(attributeValueAction);
            return ResponseEntity.ok().body(updatedAttributeValueAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValueAction existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValueAction(@PathVariable(value = "id") Long attributeValueAct) {
        Optional<AttributeValueAction> optionalAttributeValueAction = attributeValueActionRepository.findById(attributeValueAct);
        if (optionalAttributeValueAction.isPresent()) {
            attributeValueActionRepository.delete(optionalAttributeValueAction.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
