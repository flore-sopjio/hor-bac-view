package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeActId;
    private String attributeActType;
    private String attributeActName;
    @OneToMany(mappedBy = "attributeAction")
    private List<AttributeValueAction> attributeValueActions = new ArrayList<>();

    //Constructor

    public AttributeAction() {
    }

    public AttributeAction(Long attributeActId, String attributeActType, String attributeActName) {
        this.attributeActId = attributeActId;
        this.attributeActType = attributeActType;
        this.attributeActName = attributeActName;
    }

    //getter and setter
    public Long getAttributeActId() {
        return attributeActId;
    }

    public void setAttributeActId(Long attributeActId) {
        this.attributeActId = attributeActId;
    }

    public String getAttributeActType() {
        return attributeActType;
    }

    public void setAttributeActType(String attributeActType) {
        this.attributeActType = attributeActType;
    }

    public String getAttributeActName() {
        return attributeActName;
    }

    public void setAttributeActName(String attributeActName) {
        this.attributeActName = attributeActName;
    }

    public List<AttributeValueAction> getAttributeValueActions() {
        return attributeValueActions;
    }

    public void setAttributeValueActions(List<AttributeValueAction> attributeValueActions) {
        this.attributeValueActions = attributeValueActions;
    }
}
