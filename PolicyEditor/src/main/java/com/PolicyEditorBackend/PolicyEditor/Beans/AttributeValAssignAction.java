package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;

@Entity
public class AttributeValAssignAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeValAssignActId;

    @ManyToOne
    private Action action;
    @ManyToOne
    private AttributeValueAction attributeValueAction;
    // constructor

    public AttributeValAssignAction() {
    }

    public AttributeValAssignAction(Long attributeValAssignActId, Action action, AttributeValueAction attributeValueAction) {
        this.attributeValAssignActId = attributeValAssignActId;
        this.action = action;
        this.attributeValueAction = attributeValueAction;
    }

    // getter and setter

    public Long getAttributeValAssignActId() {
        return attributeValAssignActId;
    }

    public void setAttributeValAssignActId(Long attributeValAssignActId) {
        this.attributeValAssignActId = attributeValAssignActId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public AttributeValueAction getAttributeValueAction() {
        return attributeValueAction;
    }

    public void setAttributeValueAction(AttributeValueAction attributeValueAction) {
        this.attributeValueAction = attributeValueAction;
    }
}
