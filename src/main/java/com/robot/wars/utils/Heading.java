package com.robot.wars.utils;

import com.robot.wars.model.Coordinate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by baynescorps on 29/05/2018.
 */
public enum Heading {

    NORTH("W", "E",0,1), EAST("N", "S",1,0), SOUTH("E", "W", 0,-1), WEST("S", "N", -1,0);

    private static final Logger log = LoggerFactory.getLogger(Heading.class);

    private String left;
    private String right;
    private int moveX;
    private int moveY;


    Heading(String left, String right, int moveX, int moveY)
    {
        this.left = left;
        this.right = right;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public Heading getHeadingForString(String headingCharacter) {

        if (headingCharacter.equalsIgnoreCase("N"))
        {
            return Heading.NORTH;
        }
        else if (headingCharacter.equalsIgnoreCase("E"))
        {
            return Heading.EAST;
        }
        else if (headingCharacter.equalsIgnoreCase("S"))
        {
            return Heading.SOUTH;
        }
        else if (headingCharacter.equalsIgnoreCase("W"))
        {
            return Heading.WEST;
        }

        return null;
    }

    public Heading turnLeft(){
        return this.getHeadingForString(this.left);
    }

    public Heading turnRight(){
        return this.getHeadingForString(this.right);
    }

    public Coordinate moveForward(Coordinate coordinate){
        int x = coordinate.getX();
        int y = coordinate.getY();

        x += moveX;
        y += moveY;

        return new Coordinate(x,y);
    }
}
