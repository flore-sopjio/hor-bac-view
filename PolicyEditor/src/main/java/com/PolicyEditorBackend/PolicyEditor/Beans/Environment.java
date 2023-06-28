package com.PolicyEditorBackend.PolicyEditor.Beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Environment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long environmentId;
    @ManyToOne
    private Target target4;

    @OneToMany(mappedBy = "environment")
    private List<AttributeValAssignEnviron> attributeValAssignEnvirons = new ArrayList<>();

    public Environment() {
    }

    //getter and setter

    public Environment(long environmentId, Target target4) {
        this.environmentId = environmentId;
        this.target4 = target4;
    }

    public long getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(long environmentId) {
        this.environmentId = environmentId;
    }

    public Target getTarget4() {
        return target4;
    }

    public void setTarget4(Target target4) {
        this.target4 = target4;
    }

    public List<AttributeValAssignEnviron> getAttributValAssignEnvirons() {
        return attributeValAssignEnvirons;
    }

    public void setAttributValAssignEnvirons(List<AttributeValAssignEnviron> attributeValAssignEnvirons) {
        this.attributeValAssignEnvirons = attributeValAssignEnvirons;
    }
}
