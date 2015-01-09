package org.fix4j.pad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class PadMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("fix4j fixpad");
        Control myPane = FXMLLoader.load(getClass().getResource("/org/fix4j/pad/pad.fxml"));
        Scene scene = new Scene(myPane);
        scene.getStylesheets().addAll("/org/fix4j/pad/pad.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
