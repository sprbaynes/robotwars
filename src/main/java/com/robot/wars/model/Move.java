package com.robot.wars.model;

import com.robot.wars.interfaces.Robot;
import com.robot.wars.utils.Instruction;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Move {

    private Robot robot;
    private Instruction instruction;

    public Move(Robot robot, Instruction instruction) {
        this.robot = robot;
        this.instruction = instruction;
    }

    public Robot getRobot() {
        return robot;
    }

    public Instruction getInstruction() {
        return instruction;
    }
}
