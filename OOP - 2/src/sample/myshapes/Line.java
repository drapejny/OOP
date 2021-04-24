package sample.myshapes;


import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Line extends Shape {

    private double x1;
    private double x2;
    private double y1;
    private double y2;


    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        x1 = firstPoint.getX();
        x2 = secondPoint.getX();
        y1 = firstPoint.getY();
        y2 = secondPoint.getY();
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(x1,y1,x2,y2);
    }


    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public Line(){}
}
