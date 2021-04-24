package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Square extends Shape {

    protected double leftTopX;
    protected double leftTopY;

    protected double sideX;

    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        double dx = firstPoint.getX() - secondPoint.getX();
        double dy = firstPoint.getY() - secondPoint.getY();
        leftTopX = dx > 0 ? firstPoint.getX() - Math.abs(dx) : firstPoint.getX();
        leftTopY = dy > 0 ? firstPoint.getY() - Math.abs(dy) :firstPoint.getY();
        sideX = Math.abs(dx);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(leftTopX, leftTopY, sideX, sideX);
    }

    public Square(double leftTopX, double leftTopY, double sideX) {
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.sideX = sideX;
    }
    public Square(){}
}
