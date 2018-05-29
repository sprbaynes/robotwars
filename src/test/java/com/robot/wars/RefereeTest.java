package com.robot.wars;

import com.robot.wars.impl.JohnnyFive;
import com.robot.wars.interfaces.Robot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class RefereeTest {

    private Arena arena;
    private Robot johnny5;
    private List<Robot> robotList;
    private Battle battle;
    private Referee referee;

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

        referee = battle.getReferee();
    }

    @After
    public void teardown() throws Exception {
        arena = null;
        johnny5 = null;
        robotList = null;
        battle = null;
        referee = null;
    }

    @Test
    public void testIsMoveWithinBounds(){
        assertEquals(false, referee.isMoveWithinBounds(4,5));
        assertEquals(false, referee.isMoveWithinBounds(-1,5));
        assertEquals(false, referee.isMoveWithinBounds(5,4));
        assertEquals(false, referee.isMoveWithinBounds(5,-1));
        assertEquals(true, referee.isMoveWithinBounds(0,0));
        assertEquals(true, referee.isMoveWithinBounds(4,4));
    }

    @Test
    public void testHandlePenaltyPoints(){
        referee.handlePenaltyPoints(johnny5, false);
        referee.handlePenaltyPoints(johnny5, false);

        int penaltyTotal = referee.getPenaltyTotalForRobot(johnny5);

        assertEquals(2, penaltyTotal);

        referee.handlePenaltyPoints(johnny5, true);
        referee.handlePenaltyPoints(johnny5, false);

        penaltyTotal = referee.getPenaltyTotalForRobot(johnny5);

        assertEquals(3, penaltyTotal);
    }
}
