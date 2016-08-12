package com.myowndev.main.Entities.GroundEntities;

import com.myowndev.main.Entities.MainEntity;

import com.myowndev.main.VarContainer.GlobalVars;

public class Banana extends MainEntity {

    public Banana(double x, double y, int w, int h) {
        super(x, y, w, h);
    }

    public void respawn() {
        this.setX(GlobalVars.rand.nextInt(GlobalVars.gArea_rightBound) - GlobalVars.gArea_leftBound);
        this.setY(GlobalVars.rand.nextInt(GlobalVars.gArea_bottomBound) - GlobalVars.gArea_upperBound);
    }


}
