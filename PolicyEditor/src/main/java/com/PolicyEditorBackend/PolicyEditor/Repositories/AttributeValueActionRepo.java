package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueActionRepo extends JpaRepository<AttributeValueAction,Long> {
}
