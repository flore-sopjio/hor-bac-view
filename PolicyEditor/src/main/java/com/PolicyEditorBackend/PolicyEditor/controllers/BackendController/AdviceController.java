package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Advice;
import com.PolicyEditorBackend.PolicyEditor.Repositories.AdviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {
    @Autowired
    private AdviceRepo adviceRepository;

    // get all advices
    @GetMapping("")
    public List<Advice> getAllAdvices() {
        return adviceRepository.findAll();
    }

    // get advice by ID
    @GetMapping("/{id}")
    public ResponseEntity<Advice> getAdviceById(@PathVariable(value = "id") Long adviceId) {
        Optional<Advice> advice = adviceRepository.findById(adviceId);
        if (advice.isPresent()) {
            return ResponseEntity.ok().body(advice.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create a new advice
    @PostMapping("")
    public Advice createAdvice(@RequestBody Advice advice) {
        return adviceRepository.save(advice);
    }

    // modified an existing advice
    @PutMapping("/{id}")
    public ResponseEntity<Advice> updateAdvice(@PathVariable(value = "id") Long adviceId,
                                               @RequestBody Advice adviceDetails) {
        Optional<Advice> optionalAdvice = adviceRepository.findById(adviceId);
        if (optionalAdvice.isPresent()) {
            Advice advice = optionalAdvice.get();
            advice.setAdviceFulfillOn(adviceDetails.getAdviceFulfillOn());
            advice.setRule1(adviceDetails.getRule1());
            advice.setPolicy1(adviceDetails.getPolicy1());
            advice.setPolicySet1(adviceDetails.getPolicySet1());
            Advice updatedAdvice = adviceRepository.save(advice);
            return ResponseEntity.ok().body(updatedAdvice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete existing advice
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvice(@PathVariable(value = "id") Long adviceId) {
        Optional<Advice> optionalAdvice = adviceRepository.findById(adviceId);
        if (optionalAdvice.isPresent()) {
            adviceRepository.delete(optionalAdvice.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
