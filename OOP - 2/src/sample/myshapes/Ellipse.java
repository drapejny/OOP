package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Ellipse extends Circle {

    private double diameterY;


    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        double dx = firstPoint.getX() - secondPoint.getX();
        double dy = firstPoint.getY() - secondPoint.getY();
        leftTopX = dx > 0 ? firstPoint.getX() - Math.abs(dx) : firstPoint.getX();
        leftTopY = dy > 0 ? firstPoint.getY() - Math.abs(dy) :firstPoint.getY();
        diameterX = Math.abs(dx);
        diameterY = Math.abs(dy);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(leftTopX, leftTopY, diameterX, diameterY);
    }

    public Ellipse(double leftTopX, double leftTopY, double diameterX, double diameterY) {
        super(leftTopX, leftTopY, diameterX);
        this.diameterY = diameterY;
    }
    public Ellipse(){}
}
