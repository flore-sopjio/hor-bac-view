package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;
    private String effect;
    private String ruleDescription;
    private String conditionText;
    @OneToMany(mappedBy = "rule")
    private List<Obligation> obligations = new ArrayList<>();
    @OneToMany(mappedBy = "rule1")
    private List<Advice> advices = new ArrayList<>();
    @OneToOne(mappedBy = "rule", cascade = CascadeType.ALL)
    private Target target;
    @ManyToOne
    private Policy policy2;

    //Constructor

    public Rule() {
    }

    public Rule(Long ruleId, String effect, String ruleDescription, String conditionText, Policy policy2) {
        this.ruleId = ruleId;
        this.effect = effect;
        this.ruleDescription = ruleDescription;
        this.conditionText = conditionText;
        this.policy2 = policy2;
    }

    //getter and setter
    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public List<Obligation> getObligations() {
        return obligations;
    }

    public void setObligations(List<Obligation> obligations) {
        this.obligations = obligations;
    }

    public List<Advice> getAdvices() {
        return advices;
    }

    public void setAdvices(List<Advice> advices) {
        this.advices = advices;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public Policy getPolicy2() {
        return policy2;
    }

    public void setPolicy2(Policy policy2) {
        this.policy2 = policy2;
    }
}
