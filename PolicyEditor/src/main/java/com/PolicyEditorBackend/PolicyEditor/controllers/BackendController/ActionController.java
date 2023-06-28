package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Action;
import com.PolicyEditorBackend.PolicyEditor.Repositories.ActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actions")
public class ActionController {
    @Autowired
    private ActionRepo actionRepo;

    // get all actions
    @GetMapping("")
    public List<Action> getAllActions() {
        return actionRepo.findAll();
    }

    // get action by ID
    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable(value = "id") Long actionId) {
        Optional<Action> action = actionRepo.findById(actionId);
        if (action.isPresent()) {
            return ResponseEntity.ok().body(action.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create new action
    @PostMapping("")
    public Action createAction(@RequestBody Action action) {
        return actionRepo.save(action);
    }

    // update existing action
    @PutMapping("/{id}")
    public ResponseEntity<Action> updateAction(@PathVariable(value = "id") Long actionId,
                                               @RequestBody Action actionDetails) {
        Optional<Action> optionalAction = actionRepo.findById(actionId);
        if (optionalAction.isPresent()) {
            Action action = optionalAction.get();
            action.setTarget3(actionDetails.getTarget3());
            Action updatedAction = actionRepo.save(action);
            return ResponseEntity.ok().body(updatedAction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete existing un action
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable(value = "id") Long actionId) {
        Optional<Action> optionalAction = actionRepo.findById(actionId);
        if (optionalAction.isPresent()) {
            actionRepo.delete(optionalAction.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
