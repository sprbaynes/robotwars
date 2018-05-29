package com.robot.wars.interfaces;

import com.robot.wars.Battle;
import com.robot.wars.model.Coordinate;
import com.robot.wars.utils.Heading;
import com.robot.wars.utils.Instruction;

/**
 * Created by baynescorps on 29/05/2018.
 */
public interface Robot {

    public void setStartLocation(Coordinate location, Heading heading);

    public void setBattle(Battle battle);

    public Boolean move(Instruction instruction);

    public Coordinate getLocation();

    public Heading getHeading();

    public String getName();

    public void setName(String name);

    public void resetToLastLocationAndHeading();

}
