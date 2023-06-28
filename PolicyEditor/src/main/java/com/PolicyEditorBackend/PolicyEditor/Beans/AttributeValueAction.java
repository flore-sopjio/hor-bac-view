package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AttributeValueAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValueAct;
    private String attributeVAlActType;
    private String attributeVAlActValue;
    @OneToMany(mappedBy = "attributeValueAction")
    private List<AttributeValAssignAction> attributeValAssignActions = new ArrayList<>();
    @ManyToOne
    private AttributeAction attributeAction;

    //Constructor

    public AttributeValueAction() {
    }

    public AttributeValueAction(Long attributeValueAct, String attributeVAlActType, String attributeVAlActValue, AttributeAction attributeAction) {
        this.attributeValueAct = attributeValueAct;
        this.attributeVAlActType = attributeVAlActType;
        this.attributeVAlActValue = attributeVAlActValue;
        this.attributeAction = attributeAction;
    }

    //getter and Setter

    public Long getAttributeValueAct() {
        return attributeValueAct;
    }

    public void setAttributeValueAct(Long attributeValueAct) {
        this.attributeValueAct = attributeValueAct;
    }

    public String getAttributeVAlActType() {
        return attributeVAlActType;
    }

    public void setAttributeVAlActType(String attributeVAlActType) {
        this.attributeVAlActType = attributeVAlActType;
    }

    public String getAttributeVAlActValue() {
        return attributeVAlActValue;
    }

    public void setAttributeVAlActValue(String attributeVAlActValue) {
        this.attributeVAlActValue = attributeVAlActValue;
    }

    public List<AttributeValAssignAction> getAttributeValAssignActions() {
        return attributeValAssignActions;
    }

    public void setAttributeValAssignActions(List<AttributeValAssignAction> attributeValAssignActions) {
        this.attributeValAssignActions = attributeValAssignActions;
    }

    public AttributeAction getAttributeAction() {
        return attributeAction;
    }

    public void setAttributeAction(AttributeAction attributeAction) {
        this.attributeAction = attributeAction;
    }
}
