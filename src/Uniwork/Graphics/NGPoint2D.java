package Uniwork.Graphics;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class NGPoint2D extends NGGeometryObject2D implements Comparable<NGPoint2D> {

    protected double FX;
    protected double FY;

    public NGPoint2D() {
        this(0.0, 0.0);
    }

    public NGPoint2D(double aX, double aY) {
        super();
        FX = aX;
        FY = aY;
    }

    public void setX(double aValue) {
        FX = aValue;
    }

    public double getX() {
        return FX;
    }

    public Integer getXAsInt() {
        return (int)round(getX());
    }

    public void setY(double aValue) {
        FY = aValue;
    }

    public double getY() {
        return FY;
    }

    public Integer getYAsInt() {
        return (int)round(getY());
    }

    public double getEuclidDistance(NGPoint2D aPoint) {
        return sqrt(pow(getX() - aPoint.getX(), 2.0) + pow(getY() - aPoint.getY(), 2.0));
    }

    @Override
    public int compareTo(NGPoint2D o) {
        if (o.getY() < getY())
            return 1;
        else if (o.getY() > getY())
            return -1;
        else if (o.getX() < getX())
            return 1;
        else if (o.getX() > getX())
            return -1;
        else
            return 0;
    }

    public String AsString() {
        return String.format("%.0f/%.0f",FX,FY);
    }

}
