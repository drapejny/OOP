package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.Controller;
import sample.things.Thing;

import java.io.IOException;

public class Main extends Application {

    public static ObservableList<Thing> things = FXCollections.observableArrayList();

    public static Stage stage;
    public static Scene scene;
    public static Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/forms/MainWindow.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root);
        primaryStage.setScene(scene);
        stage = primaryStage;
        controller = loader.getController();
        primaryStage.show();

//        Parent root = FXMLLoader.load(getClass().getResource("forms/MainWindow.fxml"));
//        primaryStage.setTitle("sample.things.Shoes");
//        scene = new Scene(root);
//        primaryStage.setScene(scene);
//        stage = primaryStage;
//        stage.show();
    }

    public static void main(String args[]) throws IOException {
        launch(args);
    }
}