package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import sample.myshapes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyClass {

    public static  List<Shape> SHAPES = Arrays.asList(
            new Circle(200,200,100),
            new Ellipse(350,500,100,40),
            new Square(400,400,100),
            new Rectangle(120,270,300,100),
            new Triangle(340,300,110,50),
            new Line(450,450,300,278));



    public static void drawList(GraphicsContext gs){
        Iterator<Shape> iterator = SHAPES.iterator();
        while (iterator.hasNext()){
            iterator.next().draw(gs);
        }
    }
}
