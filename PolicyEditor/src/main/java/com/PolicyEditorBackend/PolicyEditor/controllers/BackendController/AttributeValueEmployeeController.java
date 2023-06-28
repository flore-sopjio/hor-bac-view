package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueEmployee;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueEmplRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalueemployees")
public class AttributeValueEmployeeController {
    @Autowired
    private AttributeValueEmplRepo attributeValueEmployeeRepository;

    // Récupérer tous les attributeValueEmployees
    @GetMapping("")
    public List<AttributeValueEmployee> getAllAttributeValueEmployees() {
        return attributeValueEmployeeRepository.findAll();
    }

    // Récupérer un attributeValueEmployee par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValueEmployee> getAttributeValueEmployeeById(@PathVariable(value = "id") Long attributeVEId) {
        Optional<AttributeValueEmployee> attributeValueEmployee = attributeValueEmployeeRepository.findById(attributeVEId);
        if (attributeValueEmployee.isPresent()) {
            return ResponseEntity.ok().body(attributeValueEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValueEmployee
    @PostMapping("")
    public AttributeValueEmployee createAttributeValueEmployee(@RequestBody AttributeValueEmployee attributeValueEmployee) {
        return attributeValueEmployeeRepository.save(attributeValueEmployee);
    }

    // Modifier un attributeValueEmployee existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValueEmployee> updateAttributeValueEmployee(@PathVariable(value = "id") Long attributeVEId,
                                                                               @RequestBody AttributeValueEmployee attributeValueEmployeeDetails) {
        Optional<AttributeValueEmployee> optionalAttributeValueEmployee = attributeValueEmployeeRepository.findById(attributeVEId);
        if (optionalAttributeValueEmployee.isPresent()) {
            AttributeValueEmployee attributeValueEmployee = optionalAttributeValueEmployee.get();
            attributeValueEmployee.setType(attributeValueEmployeeDetails.getType());
            attributeValueEmployee.setValue(attributeValueEmployeeDetails.getValue());
            attributeValueEmployee.setAttributeValAEmps(attributeValueEmployeeDetails.getAttributeValAEmps());
            AttributeValueEmployee updatedAttributeValueEmployee = attributeValueEmployeeRepository.save(attributeValueEmployee);
            return ResponseEntity.ok().body(updatedAttributeValueEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValueEmployee existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValueEmployee(@PathVariable(value = "id") Long attributeVEId) {
        Optional<AttributeValueEmployee> optionalAttributeValueEmployee = attributeValueEmployeeRepository.findById(attributeVEId);
        if (optionalAttributeValueEmployee.isPresent()) {
            attributeValueEmployeeRepository.delete(optionalAttributeValueEmployee.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
