package com.myowndev.main.Entities.GroundEntities;

import java.util.Timer;
import java.util.TimerTask;

public class Player extends GroundEntity {

    // Init & Default parameters:
    private boolean isBot = true;
    private boolean pregnant = false;
    private boolean male = true;
    private boolean isAlive = true;
    private static int width = 15;
    private static int height = 15;

    // Technical:
    private Timer t = new Timer();
    private int deadTime = 2; // in seconds

    public Player(
            double x, double y, //int w, int h,
            boolean underCover,
            boolean isBot, boolean male, boolean pregnant, boolean isAlive)
    {
        super(x, y, width, height, underCover);
        this.isBot = isBot;
        this.male = male;
        this.pregnant = pregnant;
    }

    public boolean isBotCheck() {
        return this.isBot;
    }
    public boolean isMale() {
        return this.male;
    }

    // Server:
    public void connect() {
        this.isBot = false;
    }
    public void disconnect() {
        this.isBot = true;
    }
    /**/

    // Female options:
    public void setPregnant(boolean b) {
        this.pregnant = b;
    }
    public void giveBirth() {
        this.pregnant = false; // TODO: Доделать
    }
    /**/

    // life:
    public boolean isAliveCheck() {
        return this.isAlive;
    }
    public void setAlive(boolean b) {
        if (!b) {
            this.isAlive = b;
            setX(14500.0);
            setY(21000.0);
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    respawn();
                }
            }, deadTime * 1000);
        } else {
            respawn();
        }
    }
    private void respawn() {
        this.isAlive = true;
        setX(145.0);
        setY(210.0);
    }
    /**/

}
