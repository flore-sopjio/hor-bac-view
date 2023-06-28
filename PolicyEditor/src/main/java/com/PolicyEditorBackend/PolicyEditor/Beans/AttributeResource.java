package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeResId;
    private String attributeResType;
    private String attributeResName;
    @OneToMany(mappedBy = "attributeResource")
    private List<AttributeValueResource> attributeValueResources = new ArrayList<>();

    //constructor
    public AttributeResource() {
    }

    public AttributeResource(Long attributeResId, String attributeResType, String attributeResName) {
        this.attributeResId = attributeResId;
        this.attributeResType = attributeResType;
        this.attributeResName = attributeResName;
    }

    //getter and setter

    public Long getAttributeResId() {
        return attributeResId;
    }

    public void setAttributeResId(Long attributeResId) {
        this.attributeResId = attributeResId;
    }

    public String getAttributeResType() {
        return attributeResType;
    }

    public void setAttributeResType(String attributeResType) {
        this.attributeResType = attributeResType;
    }

    public String getAttributeResName() {
        return attributeResName;
    }

    public void setAttributeResName(String attributeResName) {
        this.attributeResName = attributeResName;
    }

    public List<AttributeValueResource> getAttributeValueResources() {
        return attributeValueResources;
    }

    public void setAttributeValueResources(List<AttributeValueResource> attributeValueResources) {
        this.attributeValueResources = attributeValueResources;
    }
}
