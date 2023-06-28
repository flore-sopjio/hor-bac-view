package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    @ManyToOne
    private Target target1;
    @OneToMany(mappedBy = "employee")
    private List<AttributeValAEmp> attributeValAEmps = new ArrayList<>();
    @ManyToOne
    private Employee supervisor;
    @OneToMany(mappedBy = "supervisor")
    private List<Employee> employees = new ArrayList<>();

    //Constructor

    public Employee() {
    }

    public Employee(long employeeId, Target target1, Employee supervisor) {
        this.employeeId = employeeId;
        this.target1 = target1;
        this.supervisor = supervisor;
    }

    //getter and setter

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Target getTarget1() {
        return target1;
    }

    public void setTarget1(Target target1) {
        this.target1 = target1;
    }

    public List<AttributeValAEmp> getAttributeValAEmps() {
        return attributeValAEmps;
    }

    public void setAttributeValAEmps(List<AttributeValAEmp> attributeValAEmps) {
        this.attributeValAEmps = attributeValAEmps;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
