package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long targetId;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policySet_id", referencedColumnName = "policySetId")
    private PolicySet policySet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policy_id", referencedColumnName = "policyId")
    private Policy policy;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rule_id", referencedColumnName = "ruleId")
    private Rule rule;
    @OneToMany(mappedBy = "target1")
    private List<Employee> employees = new ArrayList<>();
    @OneToMany(mappedBy = "target2")
    private List<Resource> resources = new ArrayList<>();
    @OneToMany(mappedBy = "target3")
    private List<Action> actions = new ArrayList<>();
    @OneToMany(mappedBy = "target4")
    private List<Environment> environments = new ArrayList<>();

    //Constructor

    public Target() {
    }

    public Target(Long targetId, String description) {
        this.targetId = targetId;
        this.description = description;
    }

    //Getter and setter

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PolicySet getPolicySet() {
        return policySet;
    }

    public void setPolicySet(PolicySet policySet) {
        this.policySet = policySet;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<Environment> environments) {
        this.environments = environments;
    }
}
