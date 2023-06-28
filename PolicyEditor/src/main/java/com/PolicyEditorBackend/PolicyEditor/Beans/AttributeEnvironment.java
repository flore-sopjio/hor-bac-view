package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeEnvironment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeEnvId;
    private String attributeEnvType;
    private String attributeEnvName;
    @OneToMany(mappedBy = "attributeEnvironment")
    private List<AttributeValEnvironment> attributeValEnvironments = new ArrayList<>();

    //constructor

    public AttributeEnvironment() {
    }

    public AttributeEnvironment(Long attributeEnvId, String attributeEnvType, String attributeEnvName) {
        this.attributeEnvId = attributeEnvId;
        this.attributeEnvType = attributeEnvType;
        this.attributeEnvName = attributeEnvName;
    }

    //getter and setter

    public Long getAttributeEnvId() {
        return attributeEnvId;
    }

    public void setAttributeEnvId(Long attributeEnvId) {
        this.attributeEnvId = attributeEnvId;
    }

    public String getAttributeEnvType() {
        return attributeEnvType;
    }

    public void setAttributeEnvType(String attributeEnvType) {
        this.attributeEnvType = attributeEnvType;
    }

    public String getAttributeEnvName() {
        return attributeEnvName;
    }

    public void setAttributeEnvName(String attributeEnvName) {
        this.attributeEnvName = attributeEnvName;
    }

    public List<AttributeValEnvironment> getAttributeValEnvironments() {
        return attributeValEnvironments;
    }

    public void setAttributeValEnvironments(List<AttributeValEnvironment> attributeValEnvironments) {
        this.attributeValEnvironments = attributeValEnvironments;
    }
}
