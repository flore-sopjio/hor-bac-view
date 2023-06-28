package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeEmpId;
    private String attributeType;
    private String attributeName;
    @OneToMany(mappedBy = "attributeEmployee")
    private List <AttributeValueEmployee> attributeValueEmployeeId = new ArrayList<>();

    //Constructor
    public AttributeEmployee() {
    }

    public AttributeEmployee(Long attributeEmpId, String attributeType, String attributeName) {
        this.attributeEmpId = attributeEmpId;
        this.attributeType = attributeType;
        this.attributeName = attributeName;
    }

    //getter and setter

    public Long getAttributeEmpId() {
        return attributeEmpId;
    }

    public void setAttributeEmpId(Long attributeEmpId) {
        this.attributeEmpId = attributeEmpId;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public List<AttributeValueEmployee> getAttributeValueEmployeeId() {
        return attributeValueEmployeeId;
    }

    public void setAttributeValueEmployeeId(List<AttributeValueEmployee> attributeValueEmployeeId) {
        this.attributeValueEmployeeId = attributeValueEmployeeId;
    }
}
