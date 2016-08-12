package com.myowndev.main.Entities.GroundEntities;

import com.myowndev.main.Entities.MainEntity;

import com.myowndev.main.VarContainer.GlobalVars;

public class GroundEntity extends MainEntity {

    private boolean underCover = false;

    GroundEntity(double x, double y, int w, int h, boolean underCover) {
        super(x, y, w, h);
        this.underCover = underCover;
    }

    public void boundChecker() {
        if (getY() < GlobalVars.gArea_upperBound)
            setY(GlobalVars.gArea_upperBound);
        if (getY() > GlobalVars.gArea_bottomBound)
            setY(GlobalVars.gArea_bottomBound);
        if (getX() < GlobalVars.gArea_leftBound)
            setX(GlobalVars.gArea_leftBound);
        if (getX() > GlobalVars.gArea_rightBound)
            setX(GlobalVars.gArea_rightBound);
    }

    public void coverChecker() {
        underCover = this.intersects(GlobalVars.cover);
    }
    public boolean isCoveredCheck() {
        return underCover;
    }

    public void rainInfluence() {

    }
    public void windInfluence() {

    }
}
