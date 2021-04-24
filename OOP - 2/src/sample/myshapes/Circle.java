package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Circle extends Shape {

    protected double leftTopX;
    protected double leftTopY;
    protected double diameterX;


    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        double dx = firstPoint.getX() - secondPoint.getX();
        double dy = firstPoint.getY() - secondPoint.getY();
        leftTopX = dx > 0 ? firstPoint.getX() - Math.abs(dx) : firstPoint.getX();
        leftTopY = dy > 0 ? firstPoint.getY() - Math.abs(dy) :firstPoint.getY();
        diameterX = Math.abs(dx);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(leftTopX, leftTopY, diameterX, diameterX);
    }

    public Circle(double leftTopX, double leftTopY, double diameterX) {
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.diameterX = diameterX;
    }
    public Circle(){}
}