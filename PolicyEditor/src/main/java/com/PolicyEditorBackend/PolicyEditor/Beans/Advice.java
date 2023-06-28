package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  AdviceId;
    private String AdviceFulfillOn;

    @ManyToOne
    private Rule rule1;
    @ManyToOne
    private Policy policy1;
    @ManyToOne
    private PolicySet policySet1;

    //Constructor

    public Advice() {
    }

    public Advice(Long adviceId, String adviceFulfillOn, Rule rule1, Policy policy1, PolicySet policySet1) {
        AdviceId = adviceId;
        AdviceFulfillOn = adviceFulfillOn;
        this.rule1 = rule1;
        this.policy1 = policy1;
        this.policySet1 = policySet1;
    }

    //getter and setter

    public Long getAdviceId() {
        return AdviceId;
    }

    public void setAdviceId(Long adviceId) {
        AdviceId = adviceId;
    }

    public String getAdviceFulfillOn() {
        return AdviceFulfillOn;
    }

    public void setAdviceFulfillOn(String adviceFulfillOn) {
        AdviceFulfillOn = adviceFulfillOn;
    }

    public Rule getRule1() {
        return rule1;
    }

    public void setRule1(Rule rule1) {
        this.rule1 = rule1;
    }

    public Policy getPolicy1() {
        return policy1;
    }

    public void setPolicy1(Policy policy1) {
        this.policy1 = policy1;
    }

    public PolicySet getPolicySet1() {
        return policySet1;
    }

    public void setPolicySet1(PolicySet policySet1) {
        this.policySet1 = policySet1;
    }
}
