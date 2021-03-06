package com.mcm.entities.mongo.gameObjects;

import com.mcm.entities.mongo.BaseDocument;
import com.mcm.util.GeoUtil;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Created by alirezaghias on 10/18/2016 AD.
 */
public abstract class BaseGameObject extends BaseDocument {
    @GeoSpatialIndexed
    private double[] location;
    protected double health = 100.0;
    protected double defenceFactor = 0.0;
    protected double level = 0.0;

    //Constructors
    protected BaseGameObject() {    }
    //End Constructors

    //Method Accessors
    public void setLocation(double[] location) { this.location = location; }

    public double[] getLocation() { return location; }

    public Double getHealth() {
        return health;
    }

    public Double getDefenceFactor() { return defenceFactor; }

    public Double getLevel() { return level; }

    //End Method Accessors

    //Abstracts
    protected abstract double getExperience(double hitPower);

    protected abstract void levelIncreasedBy(double diff);

    protected abstract void healthIncreasedBy(double diff);

    protected abstract void levelDecreasedBy(double diff);

    protected abstract void healthDecreasedBy(double diff);
    //End Abstracts

    //Functions
    public void increaseLevel(double level) {
        if (level > 0) {
            double pre = this.level;
            this.level += level;
            levelIncreasedBy(this.level - pre);
        }
    }
    public void decreaseLevel(double level) {
        if (level > 0) {
            double pre = this.level;
            this.level -= level;
            levelDecreasedBy(pre - this.level);
        }
    }

    public void increaseHealth(double health) {
        if (health > 0) {
            double pre = this.health;
            this.health += health;
            healthIncreasedBy(this.health - pre);
        }
    }

    public void decreaseHealth(double health) {
        if (health > 0) {
            double pre = this.health;
            this.health -= health;
            healthDecreasedBy(pre - this.health);
        }
    }
    //End Functions

    public double distanceTo(double lat, double lon) {
        if (location == null || location.length != 2)
            return -1;
        return GeoUtil.distance(location[0], location[1], lat, lon, "K");
    }

    public double distanceTo(BaseGameObject otherGameObject) {
        if (otherGameObject.getLocation() == null || otherGameObject.getLocation().length != 2)
            return -1;
        return distanceTo(otherGameObject.location[0], otherGameObject.location[1]);
    }




}
