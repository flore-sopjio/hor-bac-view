package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeEmployee;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributeemployees")
public class AttributeEmployeeController {
    @Autowired
    private AttributeEmployeeRepo attributeEmployeeRepository;

    // get all attributeEmployees
    @GetMapping("")
    public List<AttributeEmployee> getAllAttributeEmployees() {
        return attributeEmployeeRepository.findAll();
    }

    // get attributeEmployee by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeEmployee> getAttributeEmployeeById(@PathVariable(value = "id") Long attributeEmpId) {
        Optional<AttributeEmployee> attributeEmployee = attributeEmployeeRepository.findById(attributeEmpId);
        if (attributeEmployee.isPresent()) {
            return ResponseEntity.ok().body(attributeEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new attributeEmployee
    @PostMapping("")
    public AttributeEmployee createAttributeEmployee(@RequestBody AttributeEmployee attributeEmployee) {
        return attributeEmployeeRepository.save(attributeEmployee);
    }

    // Modified an existing attributeEmployee
    @PutMapping("/{id}")
    public ResponseEntity<AttributeEmployee> updateAttributeEmployee(@PathVariable(value = "id") Long attributeEmpId,
                                                                     @RequestBody AttributeEmployee attributeEmployeeDetails) {
        Optional<AttributeEmployee> optionalAttributeEmployee = attributeEmployeeRepository.findById(attributeEmpId);
        if (optionalAttributeEmployee.isPresent()) {
            AttributeEmployee attributeEmployee = optionalAttributeEmployee.get();
            attributeEmployee.setAttributeType(attributeEmployeeDetails.getAttributeType());
            attributeEmployee.setAttributeName(attributeEmployeeDetails.getAttributeName());
            attributeEmployee.setAttributeValueEmployeeId(attributeEmployeeDetails.getAttributeValueEmployeeId());
            AttributeEmployee updatedAttributeEmployee = attributeEmployeeRepository.save(attributeEmployee);
            return ResponseEntity.ok().body(updatedAttributeEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an attributeEmployee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeEmployee(@PathVariable(value = "id") Long attributeEmpId) {
        Optional<AttributeEmployee> optionalAttributeEmployee = attributeEmployeeRepository.findById(attributeEmpId);
        if (optionalAttributeEmployee.isPresent()) {
            attributeEmployeeRepository.delete(optionalAttributeEmployee.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
