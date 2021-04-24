package sample.myshapes;

import javafx.scene.canvas.GraphicsContext;
import sample.Coordinates2D;

public class Triangle extends Shape{

    private double leftTopX;
    private double leftTopY;

    private double height;
    private double base;


    @Override
    public void setSecondPoint(Coordinates2D secondPoint) {
        this.secondPoint = secondPoint;
        double dx = firstPoint.getX() - secondPoint.getX();
        double dy = firstPoint.getY() - secondPoint.getY();
        leftTopX = dx > 0 ? firstPoint.getX() - Math.abs(dx) : firstPoint.getX();
        leftTopY = dy > 0 ? firstPoint.getY() - Math.abs(dy) :firstPoint.getY();

        height = Math.abs(dy);
        base = Math.abs(dx);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokePolygon(new double[]{leftTopX,leftTopX + base, leftTopX + base / 2},
                         new double[]{leftTopY + height, leftTopY + height, leftTopY}, 3);
    }

    public Triangle(double leftTopX, double leftTopY, double height, double base) {
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.height = height;
        this.base = base;
    }
    public Triangle(){}
}
