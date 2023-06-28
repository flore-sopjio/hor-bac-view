package com.PolicyEditorBackend.PolicyEditor.controllers;

import com.PolicyEditorBackend.PolicyEditor.Beans.Person;
import com.PolicyEditorBackend.PolicyEditor.Repositories.PersonRepo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class PersonControllerView implements Initializable {

    @Autowired
    private PersonRepo personRepository;

    @FXML
    private TableView<Person> personTable;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load all persons from the database
        List<Person> persons = personRepository.findAll();

        // Add the persons to the table
        personTable.getItems().addAll(persons);
    }

    @FXML
    private void onRefreshButtonClick() {
        // Refresh the table content
        personTable.getItems().clear();
        personTable.getItems().addAll(personRepository.findAll());
    }
}
