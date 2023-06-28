package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resourceId;
    @ManyToOne
    private Target target2;
    @OneToMany(mappedBy = "resource")
    private List<AttributeValueAssignResource> attributeValueAssignResources = new ArrayList<>();

    //constructor

    public Resource() {
    }

    public Resource(long resourceId, Target target2) {
        this.resourceId = resourceId;
        this.target2 = target2;
    }

    //getter and setter

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public Target getTarget2() {
        return target2;
    }

    public void setTarget2(Target target2) {
        this.target2 = target2;
    }

    public List<AttributeValueAssignResource> getAttributeValueAssignResources() {
        return attributeValueAssignResources;
    }

    public void setAttributeValueAssignResources(List<AttributeValueAssignResource> attributeValueAssignResources) {
        this.attributeValueAssignResources = attributeValueAssignResources;
    }
}
