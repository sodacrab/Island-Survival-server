package com.myowndev.main.VarContainer;

enum StartingCoords {

    P1 (130.0, 200.0),
    P2 (140.0, 200.0),
    P3 (150.0, 200.0),
    P4 (160.0, 200.0);

    private final double x;
    private final double y;
    StartingCoords(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() { return x; }
    public double getY() { return y; }

}
