package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class AttributeValAssignEnviron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValAssignEnvId;

    @ManyToOne
    private Environment environment;
    @ManyToOne
    private AttributeValEnvironment attributeValEnvironment;
    // constructor

    public AttributeValAssignEnviron() {
    }

    public AttributeValAssignEnviron(Long attributeValAssignEnvId, Environment environment, AttributeValEnvironment attributeValEnvironment) {
        this.attributeValAssignEnvId = attributeValAssignEnvId;
        this.environment = environment;
        this.attributeValEnvironment = attributeValEnvironment;
    }

    //getter and setter

    public Long getAttributeValAssignEnvId() {
        return attributeValAssignEnvId;
    }

    public void setAttributeValAssignEnvId(Long attributeValAssignEnvId) {
        this.attributeValAssignEnvId = attributeValAssignEnvId;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public AttributeValEnvironment getAttributeValEnvironment() {
        return attributeValEnvironment;
    }

    public void setAttributeValEnvironment(AttributeValEnvironment attributeValEnvironment) {
        this.attributeValEnvironment = attributeValEnvironment;
    }
}
