package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class Obligation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  obligationId;
    private String fulfillOn;
    private String AlgValidationReq;

    @ManyToOne
    private Rule rule;
    @ManyToOne
    private Policy policy;
    @ManyToOne
    private PolicySet policySet1;

    //Constructor

    public Obligation() {
    }

    public Obligation(Long obligationId, String fulfillOn, String algValidationReq, Rule rule, Policy policy, PolicySet policySet) {
        this.obligationId = obligationId;
        this.fulfillOn = fulfillOn;
        AlgValidationReq = algValidationReq;
        this.rule = rule;
        this.policy = policy;
        this.policySet1 = policySet;
    }

    //getter and setter

    public Long getObligationId() {
        return obligationId;
    }

    public void setObligationId(Long obligationId) {
        this.obligationId = obligationId;
    }

    public String getFulfillOn() {
        return fulfillOn;
    }

    public void setFulfillOn(String fulfillOn) {
        this.fulfillOn = fulfillOn;
    }

    public String getAlgValidationReq() {
        return AlgValidationReq;
    }

    public void setAlgValidationReq(String algValidationReq) {
        AlgValidationReq = algValidationReq;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public PolicySet getPolicySet() {
        return policySet1;
    }

    public void setPolicySet(PolicySet policySet1) {
        this.policySet1 = policySet1;
    }
}
