package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeActionRepo extends JpaRepository<AttributeAction,Long> {
}
