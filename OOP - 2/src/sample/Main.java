package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.myshapes.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        shapesList.drawList(Controller.gc);
    }

    public static ShapesList shapesList;

    static {
        shapesList = new ShapesList();
        shapesList.add(new Circle(200,200,100));
        shapesList.add(new Ellipse(350,500,100,40));
        shapesList.add( new Square(400,400,100));
        shapesList.add(new Rectangle(120,270,300,100));
        shapesList.add( new Triangle(340,300,110,50));
        shapesList.add(  new Line(450,450,300,278));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
