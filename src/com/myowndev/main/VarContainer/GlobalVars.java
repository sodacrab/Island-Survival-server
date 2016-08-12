package com.myowndev.main.VarContainer;

import com.myowndev.main.Entities.GroundEntities.Banana;
import com.myowndev.main.Entities.GroundEntities.Cover;
import com.myowndev.main.Entities.GroundEntities.Player;
import com.myowndev.main.Entities.Raindrop;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Random;

public class GlobalVars {

    // Technical vars:
    public static Random rand = new Random();
    public static int sleepTime = 10;


    // Game vars:
    // GamingArea:
    public static int gArea_upperBound = 195;
    public static int gArea_leftBound = 20;
    public static int gArea_bottomBound = 270;
    public static int gArea_rightBound = 260;
    private static int gArea_width = gArea_rightBound - gArea_leftBound;
    private static int gArea_height = gArea_bottomBound - gArea_upperBound;
    public static Rectangle2D gArea_rectangle = new Rectangle2D( // TODO: сделать ли этот ректангл объектом MainEntity?
            gArea_leftBound,
            gArea_upperBound,
            gArea_width,
            gArea_height);

    // Game objects:
    public static Player[] players = {new Player(StartingCoords.P1.getX(), StartingCoords.P1.getY(), false, true, true, false, true),
            new Player(StartingCoords.P1.getX(), StartingCoords.P1.getY(), false, true, false, false, true),
            new Player(StartingCoords.P2.getX(), StartingCoords.P2.getY(), false, true, true, false, true),
            new Player(StartingCoords.P3.getX(), StartingCoords.P3.getY(), false, true, false, false, true)};


    private static int cover_upperBound = 195;
    private static int cover_leftBound = 112;
    private static int cover_bottomBound = 207;
    private static int cover_rightBound = 166;
    private static int cover_width = cover_rightBound - cover_leftBound;
    private static int cover_height = cover_bottomBound - cover_upperBound;
    public static Cover cover = new Cover(cover_leftBound, cover_upperBound, cover_width, cover_height);
    //public static Cover cover = new Cover(105, 180, 180 - 105, 218 - 180);

    public static ArrayList<Raindrop> raindrops = new ArrayList<>();

    public static Banana banana = new Banana(0,0,0,0);

}
