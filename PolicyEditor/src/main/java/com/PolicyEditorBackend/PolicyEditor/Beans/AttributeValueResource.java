package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeValueResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValueResId;
    private String attributeVAlResType;
    private String attributeVAlResValue;
    @OneToMany(mappedBy = "attributeValueResource")
    private List<AttributeValueAssignResource> attributeValueAssignResources = new ArrayList<>();
    @ManyToOne
    private AttributeResource attributeResource;

    //Constructor
    public AttributeValueResource() {
    }

    public AttributeValueResource(Long attributeValueRes, String attributeVAlResType, String attributeVAlResValue, AttributeResource attributeResource) {
        this.attributeValueResId = attributeValueRes;
        this.attributeVAlResType = attributeVAlResType;
        this.attributeVAlResValue = attributeVAlResValue;
        this.attributeResource = attributeResource;
    }

    //getter and setter
    public Long getAttributeValueRes() {
        return attributeValueResId;
    }

    public void setAttributeValueRes(Long attributeValueRes) {
        this.attributeValueResId = attributeValueRes;
    }

    public String getAttributeVAlResType() {
        return attributeVAlResType;
    }

    public void setAttributeVAlResType(String attributeVAlResType) {
        this.attributeVAlResType = attributeVAlResType;
    }

    public String getAttributeVAlResValue() {
        return attributeVAlResValue;
    }

    public void setAttributeVAlResValue(String attributeVAlResValue) {
        this.attributeVAlResValue = attributeVAlResValue;
    }

    public AttributeResource getAttributeResource() {
        return attributeResource;
    }

    public void setAttributeResource(AttributeResource attributeResource) {
        this.attributeResource = attributeResource;
    }

    public List<AttributeValueAssignResource> getAttributeValueAssignResources() {
        return attributeValueAssignResources;
    }

    public void setAttributeValueAssignResources(List<AttributeValueAssignResource> attributeValueAssignResources) {
        this.attributeValueAssignResources = attributeValueAssignResources;
    }
}
