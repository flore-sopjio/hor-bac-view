package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class AttributeValAEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValAEmpId;

    @ManyToOne
    private Employee employee;
    @ManyToOne
    private AttributeValueEmployee attributeValueEmployee;

    // constructor

    public AttributeValAEmp() {
    }

    public AttributeValAEmp(Long attributeValAEmpId, Employee employee, AttributeValueEmployee attributeValueEmployee) {
        this.attributeValAEmpId = attributeValAEmpId;
        this.employee = employee;
        this.attributeValueEmployee = attributeValueEmployee;
    }
// getter and setter

    public Long getAttributeValAEmpId() {
        return attributeValAEmpId;
    }

    public void setAttributeValAEmpId(Long attributeValAEmpId) {
        this.attributeValAEmpId = attributeValAEmpId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AttributeValueEmployee getAttributeValueEmployee() {
        return attributeValueEmployee;
    }

    public void setAttributeValueEmployee(AttributeValueEmployee attributeValueEmployee) {
        this.attributeValueEmployee = attributeValueEmployee;
    }
}
