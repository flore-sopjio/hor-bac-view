package com.PolicyEditorBackend.PolicyEditor.controllers;

import com.PolicyEditorBackend.PolicyEditor.Beans.Person;
import com.PolicyEditorBackend.PolicyEditor.Repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepo personRepository;

    @GetMapping("/")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
