package com.robot.wars.util;

import com.robot.wars.model.Coordinate;
import com.robot.wars.utils.Heading;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class HeadingTest {
    Heading NORTH = Heading.NORTH;
    Heading EAST = Heading.EAST;
    Heading SOUTH = Heading.SOUTH;
    Heading WEST = Heading.WEST;

    Heading leftTurn = null;
    Heading rightTurn = null;

    Coordinate coordinate = null;

    @Before
    public void setup() {
        coordinate = new Coordinate(2,2);
    }

    @After
    public void teardown() throws Exception {
        leftTurn = null;
        rightTurn = null;
    }


    @Test
    public void testNorthTurns(){
        leftTurn =  NORTH.turnLeft();
        assertEquals(WEST, leftTurn);

        rightTurn = NORTH.turnRight();
        assertEquals(EAST, rightTurn);
    }

    @Test
    public void testNorthMove(){
        Coordinate expected = new Coordinate(2,3);
        Coordinate newCoordinate = NORTH.moveForward(coordinate);

        assertEquals(expected, newCoordinate);
    }

    @Test
    public void testEastTurns(){
        leftTurn =  EAST.turnLeft();
        assertEquals(NORTH, leftTurn);

        rightTurn = EAST.turnRight();
        assertEquals(SOUTH, rightTurn);
    }

    @Test
    public void testEastMove(){
        Coordinate expected = new Coordinate(3,2);
        Coordinate newCoordinate = EAST.moveForward(coordinate);

        assertEquals(expected, newCoordinate);
    }

    @Test
    public void testSouthTurns(){
        leftTurn =  SOUTH.turnLeft();
        assertEquals(EAST, leftTurn);

        rightTurn = SOUTH.turnRight();
        assertEquals(WEST, rightTurn);
    }

    @Test
    public void testSouthMove(){
        Coordinate expected = new Coordinate(2,1);
        Coordinate newCoordinate = SOUTH.moveForward(coordinate);

        assertEquals(expected, newCoordinate);
    }

    @Test
    public void testWestTurns(){
        leftTurn =  WEST.turnLeft();
        assertEquals(SOUTH, leftTurn);

        rightTurn = WEST.turnRight();
        assertEquals(NORTH, rightTurn);
    }

    @Test
    public void testWestMove(){
        Coordinate expected = new Coordinate(1,2);
        Coordinate newCoordinate = WEST.moveForward(coordinate);

        assertEquals(expected, newCoordinate);
    }

    @Test
    public void testGetHeadingForString(){
        Heading N = NORTH.getHeadingForString("N");
        assertEquals(NORTH, N);

        Heading E = NORTH.getHeadingForString("E");
        assertEquals(EAST, E);

        Heading S = NORTH.getHeadingForString("S");
        assertEquals(SOUTH,S);

        Heading W = NORTH.getHeadingForString("W");
        assertEquals(WEST, W);
    }

}
