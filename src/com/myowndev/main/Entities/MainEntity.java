package com.myowndev.main.Entities;

import javafx.geometry.Rectangle2D;

public class MainEntity {

    private double x;
    private double y;
    private int w;
    private int h;

    public MainEntity(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, w, h);
    }

    public boolean intersects(MainEntity s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getVector() {
        return String.valueOf(x + "," + y);
    }
}
