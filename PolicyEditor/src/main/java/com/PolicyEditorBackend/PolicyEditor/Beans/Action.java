package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ActionId;
    @ManyToOne
    private Target target3;
    @OneToMany(mappedBy = "action")
    private List<AttributeValAssignAction> attributeValAssignActions = new ArrayList<>();

    //Constructor
    public Action() {
    }

    public Action(long actionId, Target target3) {
        ActionId = actionId;
        this.target3 = target3;
    }

    //getter and setter

    public long getActionId() {
        return ActionId;
    }

    public void setActionId(long actionId) {
        ActionId = actionId;
    }

    public Target getTarget3() {
        return target3;
    }

    public void setTarget3(Target target3) {
        this.target3 = target3;
    }

    public List<AttributeValAssignAction> getAttributeValAssignActions() {
        return attributeValAssignActions;
    }

    public void setAttributeValAssignActions(List<AttributeValAssignAction> attributeValAssignActions) {
        this.attributeValAssignActions = attributeValAssignActions;
    }
}
