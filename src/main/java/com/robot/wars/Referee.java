package com.robot.wars;

import com.robot.wars.interfaces.Robot;
import com.robot.wars.model.Coordinate;
import com.robot.wars.model.Move;
import com.robot.wars.model.Penalty;
import com.robot.wars.utils.Instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Referee {

    private Battle battle;
    private Arena arena;
    private List<Penalty> penaltyList;

    public Referee(Battle battle) {
        this.battle = battle;
        this.arena = battle.getArena();
        this.penaltyList = new ArrayList();
    }

    public Battle getBattle() {
        return battle;
    }

    public List<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public boolean checkMove(Move move)
    {
        Robot robot = move.getRobot();
        Coordinate robotLocation =  robot.getLocation();
        Integer x = robotLocation.getX();
        Integer y = robotLocation.getY();

        boolean isLegalMove = isMoveWithinBounds(x,y);
        handlePenaltyPoints(robot, isLegalMove);

        return isLegalMove;
    }

    public void handlePenaltyPoints(Robot robot, boolean isLegalMove)
    {
        if(!isLegalMove)
        {
            penaltyList.add(new Penalty(robot, 1));
        }
    }

    public boolean isMoveWithinBounds(Integer x, Integer y){
        Integer arenaW = arena.getWidth() - 1;
        Integer arenaH = arena.getHeight() -1;

        if(x != null && (x > arenaW ||  x < 0 ) )
        {
            return false;
        }
        else if(y != null && (y > arenaH || y < 0 ) )
        {
            return false;
        }

        return true;
    }


    public int getPenaltyTotalForRobot(Robot robot){

        Stream<Penalty> penaltyStream = this.penaltyList.stream().filter(p -> p.getRobot().getName().equalsIgnoreCase(robot.getName()));
        int total = penaltyStream.mapToInt(p -> p.getDeduction()).sum();

        return total;
    }
}
