package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValAEmp;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AttributeValueAssignEmplRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributevalassignemps")
public class AttributeValAssignEmplController {
    @Autowired
    private AttributeValueAssignEmplRepo attributeValAEmpRepository;

    // Récupérer tous les attributeValAEmps
    @GetMapping("")
    public List<AttributeValAEmp> getAllAttributeValAEmps() {
        return attributeValAEmpRepository.findAll();
    }

    // Récupérer un attributeValAEmp par ID
    @GetMapping("/{id}")
    public ResponseEntity<AttributeValAEmp> getAttributeValAEmpById(@PathVariable(value = "id") Long attributeValAEmpId) {
        Optional<AttributeValAEmp> attributeValAEmp = attributeValAEmpRepository.findById(attributeValAEmpId);
        if (attributeValAEmp.isPresent()) {
            return ResponseEntity.ok().body(attributeValAEmp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer un nouveau attributeValAEmp
    @PostMapping("")
    public AttributeValAEmp createAttributeValAEmp(@RequestBody AttributeValAEmp attributeValAEmp) {
        return attributeValAEmpRepository.save(attributeValAEmp);
    }

    // Modifier un attributeValAEmp existant
    @PutMapping("/{id}")
    public ResponseEntity<AttributeValAEmp> updateAttributeValAEmp(@PathVariable(value = "id") Long attributeValAEmpId,
                                                                   @RequestBody AttributeValAEmp attributeValAEmpDetails) {
        Optional<AttributeValAEmp> optionalAttributeValAEmp = attributeValAEmpRepository.findById(attributeValAEmpId);
        if (optionalAttributeValAEmp.isPresent()) {
            AttributeValAEmp attributeValAEmp = optionalAttributeValAEmp.get();
            attributeValAEmp.setEmployee(attributeValAEmpDetails.getEmployee());
            attributeValAEmp.setAttributeValueEmployee(attributeValAEmpDetails.getAttributeValueEmployee());
            AttributeValAEmp updatedAttributeValAEmp = attributeValAEmpRepository.save(attributeValAEmp);
            return ResponseEntity.ok().body(updatedAttributeValAEmp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un attributeValAEmp existant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValAEmp(@PathVariable(value = "id") Long attributeValAEmpId) {
        Optional<AttributeValAEmp> optionalAttributeValAEmp = attributeValAEmpRepository.findById(attributeValAEmpId);
        if (optionalAttributeValAEmp.isPresent()) {
            attributeValAEmpRepository.delete(optionalAttributeValAEmp.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
