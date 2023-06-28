package com.PolicyEditorBackend.PolicyEditor.controllers.BackendController;

import com.PolicyEditorBackend.PolicyEditor.Beans.Resource;
import com.PolicyEditorBackend.PolicyEditor.Repositories.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    @Autowired
    private ResourceRepo resourceRepository;

    // get all resources
    @GetMapping("")
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    // get resource by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable(value = "id") Long resourceId) {
        Optional<Resource> resource = resourceRepository.findById(resourceId);
        if (resource.isPresent()) {
            return ResponseEntity.ok().body(resource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create new resource
    @PostMapping("")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceRepository.save(resource);
    }

    // Modified existing resource
    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable(value = "id") Long resourceId,
                                                   @RequestBody Resource resourceDetails) {
        Optional<Resource> optionalResource = resourceRepository.findById(resourceId);
        if (optionalResource.isPresent()) {
            Resource resource = optionalResource.get();
            resource.setTarget2(resourceDetails.getTarget2());
            Resource updatedResource = resourceRepository.save(resource);
            return ResponseEntity.ok().body(updatedResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete existing resource
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable(value = "id") Long resourceId) {
        Optional<Resource> optionalResource = resourceRepository.findById(resourceId);
        if (optionalResource.isPresent()) {
            resourceRepository.delete(optionalResource.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
