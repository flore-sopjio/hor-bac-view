package com.PolicyEditorBackend.PolicyEditor.Repositories;

import com.PolicyEditorBackend.PolicyEditor.Beans.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepo extends JpaRepository<Target, Long> {
}
