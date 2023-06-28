package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.AttributeValueResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueResourceRepo extends JpaRepository<AttributeValueResource,Long> {
}
