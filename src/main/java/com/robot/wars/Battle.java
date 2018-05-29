package com.robot.wars;

import com.robot.wars.interfaces.Robot;
import com.robot.wars.model.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Battle {

    private Arena arena;
    private List<Robot> robotList;
    private Referee referee;
    private List<Move> moveList;

    public Battle(Arena arena, List<Robot> robotList) {
        this.arena = arena;
        this.robotList = robotList;

        for(Robot r : this.robotList)
        {
            r.setBattle(this);
        }

        this.referee = new Referee(this);
        this.moveList = new ArrayList<>();
    }

    public Arena getArena() {
        return arena;
    }

    public List<Robot> getRobotList() {
        return robotList;
    }

    public boolean registerMove(Move move)
    {
        this.moveList.add(move);
        return this.referee.checkMove(move);
    }

    public Referee getReferee() {
        return referee;
    }

    public int getPenaltyTotalForRobot(Robot robot)
    {
        return this.referee.getPenaltyTotalForRobot(robot);
    }


}
