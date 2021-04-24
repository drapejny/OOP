package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;

import sample.myshapes.*;
import sample.myshapes.Rectangle;
import sample.myshapes.Shape;

public class Controller {


    @FXML
    private Button circleBtn;
    @FXML
    private Button ellipseBtn;
    @FXML
    private Button rectangleBtn;
    @FXML
    private Button squareBtn;
    @FXML
    private Button triangleBtn;
    @FXML
    private Button lineBtn;
    @FXML
    private Button dotBtn;
    @FXML
    private Canvas canvas;
    public static GraphicsContext gc;
    boolean firstPointExist = false;



    Shape shape;

    @FXML
    public void initialize() {

        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(3);

        canvas.setOnMouseClicked(this::onMouseClicked);
        
        circleBtn.setOnAction(actionEvent -> {
            shape = new Circle();
            firstPointExist = false;
        });

        ellipseBtn.setOnAction(actionEvent -> {
        shape = new Ellipse();
        firstPointExist = false;
    });

        rectangleBtn.setOnAction(actionEvent -> {
            shape = new Rectangle();
            firstPointExist = false;
        });

        squareBtn.setOnAction(actionEvent -> {
            shape = new Square();
            firstPointExist = false;
        });

        triangleBtn.setOnAction(actionEvent -> {
            shape = new Triangle();
            firstPointExist = false;
        });

        lineBtn.setOnAction(actionEvent -> {
            shape = new Line();
            firstPointExist = false;
        });
    }


    private void onMouseClicked(MouseEvent e) {
        if(firstPointExist){
            shape.setSecondPoint(new Coordinates2D(e.getX(),e.getY()));
            firstPointExist = false;
            shape.draw(gc);
        } else  {
            shape.setFirstPoint(new Coordinates2D(e.getX(),e.getY()));
            firstPointExist = true;
        }
    }


}
