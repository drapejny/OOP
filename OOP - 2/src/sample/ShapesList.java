package sample;

import javafx.scene.canvas.GraphicsContext;
import sample.myshapes.*;

import java.util.ArrayList;

public class ShapesList {

    public ArrayList<Shape> SHAPES;

    public ShapesList() {
        SHAPES = new ArrayList<Shape>();
    }

    public void add(Shape shape){
        SHAPES.add(shape);
    }

    public void drawList(GraphicsContext gs){
        for (Shape shape : SHAPES) {
            shape.draw(gs);
        }
    }
}
