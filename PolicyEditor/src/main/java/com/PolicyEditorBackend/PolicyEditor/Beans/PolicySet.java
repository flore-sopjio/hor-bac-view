package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PolicySet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policySetId;
    private String xmlns;
    private String version;
    private String policyCombAlg;
    private String description;
    @OneToOne(mappedBy = "policySet", cascade = CascadeType.ALL)
    private Target target;
    @OneToMany(mappedBy = "policy_Set")
    private List<PolicySet> policySets = new ArrayList<>();
    @OneToMany(mappedBy = "policy_set")
    private List<Policy> policies = new ArrayList<>();
    @OneToMany(mappedBy = "policySet1")
    private List<Obligation> obligations = new ArrayList<>();
    @OneToMany(mappedBy = "policySet1")
    private List<Advice> advices = new ArrayList<>();
    @ManyToOne
    private PolicySet policy_Set;

    // constructor
    public PolicySet() {
    }

    public PolicySet(Long policySetId, String xmlns, String version, String policyCombAlg,
                     String description, Target target, List<PolicySet> policySets, List<Policy> policies,
                     PolicySet policy_Set)
    {
        this.policySetId = policySetId;
        this.xmlns = xmlns;
        this.version = version;
        this.policyCombAlg = policyCombAlg;
        this.description = description;
        this.target = target;
        this.policySets = policySets;
        this.policies = policies;
        this.policy_Set = policy_Set;
    }

    // getter and setter
    public Long getPolicySetId() {
        return policySetId;
    }

    public void setPolicySetId(Long policySetId) {
        this.policySetId = policySetId;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPolicyCombAlg() {
        return policyCombAlg;
    }

    public void setPolicyCombAlg(String policyCombAlg) {
        this.policyCombAlg = policyCombAlg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<PolicySet> getPolicySets() {
        return policySets;
    }

    public void setPolicySets(List<PolicySet> policySets) {
        this.policySets = policySets;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public PolicySet getPolicy_Set() {
        return policy_Set;
    }

    public void setPolicy_Set(PolicySet policy_Set) {
        this.policy_Set = policy_Set;
    }
}
