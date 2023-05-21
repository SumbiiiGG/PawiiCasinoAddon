package me.casinoaddon.math;

public class Vector2d {
    double x,y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Vector2d vector){
        return Math.sqrt((x - vector.getX()) * (x - vector.getX()) + (y - vector.getY()) * (y - vector.getY()));
    }
}
