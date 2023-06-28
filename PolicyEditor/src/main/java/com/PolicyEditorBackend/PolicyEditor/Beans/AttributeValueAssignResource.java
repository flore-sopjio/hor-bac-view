package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class AttributeValueAssignResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValAssignResId;

    @ManyToOne
    private Resource resource;
    @ManyToOne
    private AttributeValueResource attributeValueResource;
    // constructor

    public AttributeValueAssignResource() {
    }

    public AttributeValueAssignResource(Long attributeValAssignResId, Resource resource, AttributeValueResource attributeValueResource) {
        this.attributeValAssignResId = attributeValAssignResId;
        this.resource = resource;
        this.attributeValueResource = attributeValueResource;
    }

    //Getter and setter

    public Long getAttributeValAssignResId() {
        return attributeValAssignResId;
    }

    public void setAttributeValAssignResId(Long attributeValAssignResId) {
        this.attributeValAssignResId = attributeValAssignResId;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public AttributeValueResource getAttributeValueResource() {
        return attributeValueResource;
    }

    public void setAttributeValueResource(AttributeValueResource attributeValueResource) {
        this.attributeValueResource = attributeValueResource;
    }
}
