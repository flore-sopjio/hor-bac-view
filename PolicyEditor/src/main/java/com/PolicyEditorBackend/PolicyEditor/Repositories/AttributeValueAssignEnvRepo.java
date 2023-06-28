package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValAssignEnviron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueAssignEnvRepo extends JpaRepository<AttributeValAssignEnviron,Long> {
}
