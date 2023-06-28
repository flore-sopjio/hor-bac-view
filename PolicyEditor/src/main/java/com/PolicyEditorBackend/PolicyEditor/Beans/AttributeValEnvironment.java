package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeValEnvironment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValueEnv;
    private String attributeVAlEnvType;
    private String attributeVAlEnvValue;
    @OneToMany(mappedBy = "attributeValEnvironment")
    private List<AttributeValAssignEnviron> attributeValAssignEnvirons = new ArrayList<>();

    //Constructor

    public AttributeValEnvironment() {
    }

    public AttributeValEnvironment(Long attributeValueEnv, String attributeVAlEnvType, String attributeVAlEnvValue, AttributeEnvironment attributeEnvironment) {
        this.attributeValueEnv = attributeValueEnv;
        this.attributeVAlEnvType = attributeVAlEnvType;
        this.attributeVAlEnvValue = attributeVAlEnvValue;
        this.attributeEnvironment = attributeEnvironment;
    }

    //getter and setter
    @ManyToOne
    private AttributeEnvironment attributeEnvironment;

    public Long getAttributeValueEnv() {
        return attributeValueEnv;
    }

    public void setAttributeValueEnv(Long attributeValueEnv) {
        this.attributeValueEnv = attributeValueEnv;
    }

    public String getAttributeVAlEnvType() {
        return attributeVAlEnvType;
    }

    public void setAttributeVAlEnvType(String attributeVAlEnvType) {
        this.attributeVAlEnvType = attributeVAlEnvType;
    }

    public String getAttributeVAlEnvValue() {
        return attributeVAlEnvValue;
    }

    public void setAttributeVAlEnvValue(String attributeVAlEnvValue) {
        this.attributeVAlEnvValue = attributeVAlEnvValue;
    }

    public List<AttributeValAssignEnviron> getAttributValAssignEnvirons() {
        return attributeValAssignEnvirons;
    }

    public void setAttributValAssignEnvirons(List<AttributeValAssignEnviron> attributeValAssignEnvirons) {
        this.attributeValAssignEnvirons = attributeValAssignEnvirons;
    }

    public AttributeEnvironment getAttributeEnvironment() {
        return attributeEnvironment;
    }

    public void setAttributeEnvironment(AttributeEnvironment attributeEnvironment) {
        this.attributeEnvironment = attributeEnvironment;
    }
}
