package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends JpaRepository<Resource, Long> {
}
