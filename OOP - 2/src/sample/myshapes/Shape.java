package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public abstract class Shape {
    protected Coordinates2D firstPoint;
    protected Coordinates2D secondPoint;


    public void setFirstPoint(Coordinates2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
    }

    public abstract void draw(GraphicsContext gc);


}
