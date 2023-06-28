package com.PolicyEditorBackend.PolicyEditor.Beans;

import com.PolicyEditorBackend.PolicyEditor.Beans.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;
    private String policyXmlns;
    private String PolicyVersion;
    private String policyCombAlg;
    private String policyDescription;
    @OneToOne(mappedBy = "policy", cascade = CascadeType.ALL)
    private Target target;
    @ManyToOne
    private PolicySet policy_set;
    @OneToMany(mappedBy = "policy2")
    private List<Rule> rules = new ArrayList<>();
    @OneToMany(mappedBy = "policy")
    private List<Obligation> obligations = new ArrayList<>();
    @OneToMany(mappedBy = "policy1")
    private List<Advice> advices = new ArrayList<>();

    //constructor
    public Policy() {
    }

    public Policy(Long policyId, String policyXmlns, String policyVersion, String policyCombAlg, String policyDescription, PolicySet policy_set) {
        this.policyId = policyId;
        this.policyXmlns = policyXmlns;
        PolicyVersion = policyVersion;
        this.policyCombAlg = policyCombAlg;
        this.policyDescription = policyDescription;
        this.policy_set = policy_set;
    }

    //getter and setter

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyXmlns() {
        return policyXmlns;
    }

    public void setPolicyXmlns(String policyXmlns) {
        this.policyXmlns = policyXmlns;
    }

    public String getPolicyVersion() {
        return PolicyVersion;
    }

    public void setPolicyVersion(String policyVersion) {
        PolicyVersion = policyVersion;
    }

    public String getPolicyCombAlg() {
        return policyCombAlg;
    }

    public void setPolicyCombAlg(String policyCombAlg) {
        this.policyCombAlg = policyCombAlg;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public PolicySet getPolicy_set() {
        return policy_set;
    }

    public void setPolicy_set(PolicySet policy_set) {
        this.policy_set = policy_set;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
