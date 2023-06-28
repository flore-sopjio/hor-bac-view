package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Rule;
import com.PolicyEditorBackend.PolicyEditor.Repositories.RuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    @Autowired
    private RuleRepo ruleRepository;

    // get all rules
    @GetMapping("")
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // get rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<Rule> getRuleById(@PathVariable(value = "id") Long ruleId) {
        Optional<Rule> rule = ruleRepository.findById(ruleId);
        if (rule.isPresent()) {
            return ResponseEntity.ok().body(rule.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //create a new rule
    @PostMapping("")
    public Rule createRule(@RequestBody Rule rule) {
        return ruleRepository.save(rule);
    }

    // modified an existing rule
    @PutMapping("/{id}")
    public ResponseEntity<Rule> updateRule(@PathVariable(value = "id") Long ruleId,
                                           @RequestBody Rule ruleDetails) {
        Optional<Rule> optionalRule = ruleRepository.findById(ruleId);
        if (optionalRule.isPresent()) {
            Rule rule = optionalRule.get();
            rule.setEffect(ruleDetails.getEffect());
            rule.setRuleDescription(ruleDetails.getRuleDescription());
            rule.setConditionText(ruleDetails.getConditionText());
            rule.setTarget(ruleDetails.getTarget());
            rule.setPolicy2(ruleDetails.getPolicy2());
            Rule updatedRule = ruleRepository.save(rule);
            return ResponseEntity.ok().body(updatedRule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete existing rule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable(value = "id") Long ruleId) {
        Optional<Rule> optionalRule = ruleRepository.findById(ruleId);
        if (optionalRule.isPresent()) {
            ruleRepository.delete(optionalRule.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
