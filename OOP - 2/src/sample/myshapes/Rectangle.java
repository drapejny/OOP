package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Rectangle extends Square{

    private double sideY;


    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        double dx = firstPoint.getX() - secondPoint.getX();
        double dy = firstPoint.getY() - secondPoint.getY();
        leftTopX = dx > 0 ? firstPoint.getX() - Math.abs(dx) : firstPoint.getX();
        leftTopY = dy > 0 ? firstPoint.getY() - Math.abs(dy) :firstPoint.getY();
        sideX = Math.abs(dx);
        sideY = Math.abs(dy);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(leftTopX, leftTopY, sideX, sideY);
    }

    public Rectangle(double leftTopX, double leftTopY, double sideX, double sideY) {
        super(leftTopX, leftTopY, sideX);
        this.sideY = sideY;
    }
    public Rectangle(){}
}
