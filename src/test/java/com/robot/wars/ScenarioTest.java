package com.robot.wars;

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
public class ScenarioTest {

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
    public void testScenario1() throws Exception {
        johnny5.setStartLocation(new Coordinate(0,2), Heading.EAST);

        //MLMRMMMRMMRR

        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.R);

        int penaltyTotal =  battle.getPenaltyTotalForRobot(johnny5);
        assertEquals(0, penaltyTotal);

        assertEquals(new Coordinate(4,1), johnny5.getLocation());

        assertEquals(Heading.NORTH , johnny5.getHeading());

    }

    @Test
    public void testScenario2() throws Exception {
        johnny5.setStartLocation(new Coordinate(4,4), Heading.SOUTH);

        //LMLLMMLMMMRMM

        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);

        int penaltyTotal =  battle.getPenaltyTotalForRobot(johnny5);
        assertEquals(1, penaltyTotal);
        assertEquals(new Coordinate(0,1), johnny5.getLocation());

        assertEquals(Heading.WEST , johnny5.getHeading());
    }

    @Test
    public void testScenario3() throws Exception {
        johnny5.setStartLocation(new Coordinate(2,2), Heading.WEST);

        //MLM LML MRM RMR MRM

        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.R);
        johnny5.move(Instruction.M);

        int penaltyTotal =  battle.getPenaltyTotalForRobot(johnny5);
        assertEquals(0, penaltyTotal);

        assertEquals(new Coordinate(2,2), johnny5.getLocation());

        assertEquals(Heading.NORTH , johnny5.getHeading());
    }

    @Test
    public void testScenario4() throws Exception {
        johnny5.setStartLocation(new Coordinate(1,3), Heading.NORTH);
        //MML MML MMM MM

        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.L);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);
        johnny5.move(Instruction.M);

        int penaltyTotal =  battle.getPenaltyTotalForRobot(johnny5);

        assertEquals(3, penaltyTotal);

        assertEquals(new Coordinate(0,0), johnny5.getLocation());

        assertEquals(Heading.SOUTH , johnny5.getHeading());
    }
}
