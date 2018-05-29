package com.robot.wars.impl;

import com.robot.wars.Arena;
import com.robot.wars.Battle;
import com.robot.wars.impl.JohnnyFive;
import com.robot.wars.interfaces.Robot;
import com.robot.wars.model.Coordinate;
import com.robot.wars.utils.Heading;
import com.robot.wars.utils.Instruction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class JohnnyFiveTest {

    private Arena arena;
    private Robot johnny5;
    private List<Robot> robotList;
    private Battle battle;

    @Before
    public void setup() {
        //Create arena of certain size
        arena = new Arena(5,5);

        //Create instance of your robot
        johnny5 = new JohnnyFive();
        johnny5.setName("Johnny 5");

        //Create list of robotos for battle
        robotList = new ArrayList<>();
        robotList.add(johnny5);

        battle = new Battle(arena, robotList);
    }

    @After
    public void teardown() throws Exception {
        arena = null;
        johnny5 = null;
        robotList = null;
        battle = null;
    }

    @Test
    public void testOutOfBoundsMove(){
        johnny5.setStartLocation(new Coordinate(4,4), Heading.NORTH);
        johnny5.move(Instruction.M);

        //Robot should correct it's coordinate after attempt to move out of bounds
        Coordinate expected = new Coordinate(4,4);

        Coordinate robotLocation =  johnny5.getLocation();
        assertEquals(expected, robotLocation);
        assertEquals(Heading.NORTH, johnny5.getHeading());

        int total = battle.getPenaltyTotalForRobot(johnny5);
        assertEquals(1, total);
    }

    @Test
    public void testInsideOfBoundsMove(){
        johnny5.setStartLocation(new Coordinate(4,4), Heading.WEST);
        johnny5.move(Instruction.M);

        Coordinate expected = new Coordinate(3,4);
        Coordinate robotLocation =  johnny5.getLocation();
        assertEquals(expected, robotLocation);
        assertEquals(Heading.WEST, johnny5.getHeading());

        int total = battle.getPenaltyTotalForRobot(johnny5);

        assertEquals(0, total);

    }

    @Test
    public void testUpdateLocationLeftTurn(){
        johnny5.setStartLocation(new Coordinate(4,4), Heading.WEST);
        johnny5.move(Instruction.L);

        assertEquals(Heading.SOUTH, johnny5.getHeading());
        //coordinate should be the same
        Coordinate expected = new Coordinate(4,4);
        assertEquals(expected, johnny5.getLocation());
    }

    @Test
    public void testUpdateLocationRightTurn(){
        johnny5.setStartLocation(new Coordinate(2,4), Heading.NORTH);
        johnny5.move(Instruction.R);

        assertEquals(Heading.EAST, johnny5.getHeading());
        //coordinate should be the same
        Coordinate expected = new Coordinate(2,4);
        assertEquals(expected, johnny5.getLocation());
    }
}
