package com.PolicyEditorBackend.PolicyEditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class PolicyEditorApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PolicyEditorApplication.class, args);
		Application.launch(JavaFxApplication.class, args);
	}

}
