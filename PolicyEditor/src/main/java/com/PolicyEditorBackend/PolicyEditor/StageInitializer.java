package com.PolicyEditorBackend.PolicyEditor;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.PolicyEditorBackend.PolicyEditor.JavaFxApplication.StageReadyEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    @Value("classpath:/person.fxml")
    private Resource chartResource;
    private String title;
    private ApplicationContext applicationContext;

    public StageInitializer(@Value("${app.window.title}") String title,
            ApplicationContext applicationContext) {
        this.title = title;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();

            Stage stage = event.getStage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            System.out.println("$$$$$$$$$$"+e+"$$$$$$$$$$$$$");
            throw new RuntimeException();
        }

    }
}
