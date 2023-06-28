package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeValueEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeVEId;
    private String type;
    private String value;
    @OneToMany(mappedBy = "attributeValueEmployee")
    private List<AttributeValAEmp> attributeValAEmps = new ArrayList<>();

    @ManyToOne
    private AttributeEmployee attributeEmployee;

    //Constructor
    public AttributeValueEmployee() {
    }

    public AttributeValueEmployee(Long attributeVEId, String type, String value, AttributeEmployee attributeEmployee) {
        this.attributeVEId = attributeVEId;
        this.type = type;
        this.value = value;
        this.attributeEmployee = attributeEmployee;
    }
    //getter and setter

    public Long getAttributeVEId() {
        return attributeVEId;
    }

    public void setAttributeVEId(Long attributeVEId) {
        this.attributeVEId = attributeVEId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<AttributeValAEmp> getAttributeValAEmps() {
        return attributeValAEmps;
    }

    public void setAttributeValAEmps(List<AttributeValAEmp> attributeValAEmps) {
        this.attributeValAEmps = attributeValAEmps;
    }

    public AttributeEmployee getAttributeEmployee() {
        return attributeEmployee;
    }

    public void setAttributeEmployee(AttributeEmployee attributeEmployee) {
        this.attributeEmployee = attributeEmployee;
    }
}
