package com.robot.wars.impl;

import com.robot.wars.Battle;
import com.robot.wars.interfaces.Robot;
import com.robot.wars.model.Coordinate;
import com.robot.wars.model.Move;
import com.robot.wars.utils.Heading;
import com.robot.wars.utils.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class JohnnyFive implements Robot {

    private static final Logger log = LoggerFactory.getLogger(JohnnyFive.class);

    private String name;

    private Battle battle;

    private Coordinate currentLocation;
    private Heading currentHeading;

    private Coordinate lastLocation;
    private Heading lastHeading;

    @Override
    public void setStartLocation(Coordinate location, Heading heading) {
        if(currentHeading == null && currentLocation == null)
        {
            this.currentHeading = heading;
            this.currentLocation = location;
        }
    }

    @Override
    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    @Override
    public Boolean move(Instruction instruction) {
        this.updateLocation(instruction);
        Boolean result =  battle.registerMove(new Move(this, instruction));

        if(result != null && result == false)
        {
            this.resetToLastLocationAndHeading();
        }

        return result;
    }

    @Override
    public Coordinate getLocation() {
        return this.currentLocation;
    }

    @Override
    public Heading getHeading() {
        return this.currentHeading;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void resetToLastLocationAndHeading() {
        this.currentLocation = this.lastLocation;
    }

    private void updateLocation(Instruction instruction){
        Heading newHeading = null;

        switch (instruction)
        {
            case L:
                newHeading = this.currentHeading.turnLeft();
                this.setHeading(newHeading);
                break;
            case R:
                newHeading = this.currentHeading.turnRight();
                this.setHeading(newHeading);
                break;
            case M:
                Coordinate newLocation = this.currentHeading.moveForward(this.currentLocation);
                this.setLocation(newLocation);
                break;
        }
    }

    private void setHeading(Heading heading)
    {
        this.lastHeading = this.currentHeading;
        this.currentHeading = heading;
        log.info("Updating heading from {} to new location {}",this.lastHeading, this.currentHeading);
    }

    private void setLocation(Coordinate location)
    {

        this.lastLocation = this.currentLocation;
        this.currentLocation = location;

        log.info("Updating location from {} to new location {}",this.lastLocation, this.currentLocation );
    }

}
