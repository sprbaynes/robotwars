package com.robot.wars;

import com.robot.wars.impl.JohnnyFive;
import com.robot.wars.interfaces.Robot;
import com.robot.wars.model.Coordinate;
import com.robot.wars.utils.Heading;
import com.robot.wars.utils.Instruction;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {

        log.info("Starting Robot Wars");

        runBattle1();
        runBattle2();
        runBattle3();
        runBattle4();

    }

    public static void runBattle1(){
        //Create arena of certain size
        log.info("Creating arena");
        Arena arena = new Arena(5,5);


        log.info("Creating robot");
        //Create instance of your robot
        Robot johnny5 = new JohnnyFive();
        johnny5.setName("Johnny 5");

        log.info("Setting robot start location and heading");
        johnny5.setStartLocation(new Coordinate(0,2), Heading.EAST);


        //Create list of robotos for battle
        List<Robot> robotList = new ArrayList<>();
        robotList.add(johnny5);

        log.info("Creating battle");
        Battle battle = new Battle(arena, robotList);

        log.info("About to move robot");

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
        log.info("Penalty total = {}", penaltyTotal);
    }

    public static void runBattle2(){
        //Create arena of certain size
        log.info("Creating arena");
        Arena arena = new Arena(5,5);


        log.info("Creating robot");
        //Create instance of your robot
        Robot johnny5 = new JohnnyFive();
        johnny5.setName("Johnny 5");

        //4, 4, S
        log.info("Setting robot start location and heading");
        johnny5.setStartLocation(new Coordinate(4,4), Heading.SOUTH);


        //Create list of robotos for battle
        List<Robot> robotList = new ArrayList<>();
        robotList.add(johnny5);

        log.info("Creating battle");
        Battle battle = new Battle(arena, robotList);

        log.info("About to move robot");

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
        log.info("Penalty total = {}", penaltyTotal);
    }



    public static void runBattle3(){
        //Create arena of certain size
        log.info("Creating arena");
        Arena arena = new Arena(5,5);


        log.info("Creating robot");
        //Create instance of your robot
        Robot johnny5 = new JohnnyFive();
        johnny5.setName("Johnny 5");

        //2, 2, W
        log.info("Setting robot start location and heading");
        johnny5.setStartLocation(new Coordinate(2,2), Heading.WEST);


        //Create list of robotos for battle
        List<Robot> robotList = new ArrayList<>();
        robotList.add(johnny5);

        log.info("Creating battle");
        Battle battle = new Battle(arena, robotList);

        log.info("About to move robot");

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
        log.info("Penalty total = {}", penaltyTotal);
    }


    //

    public static void runBattle4(){
        //Create arena of certain size
        log.info("Creating arena");
        Arena arena = new Arena(5,5);


        log.info("Creating robot");
        //Create instance of your robot
        Robot johnny5 = new JohnnyFive();
        johnny5.setName("Johnny 5");

        //1, 3, N
        log.info("Setting robot start location and heading");
        johnny5.setStartLocation(new Coordinate(1,3), Heading.NORTH);


        //Create list of robotos for battle
        List<Robot> robotList = new ArrayList<>();
        robotList.add(johnny5);

        log.info("Creating battle");
        Battle battle = new Battle(arena, robotList);

        log.info("About to move robot");

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
        log.info("Penalty total = {}", penaltyTotal);
    }
}
