package com.robot.wars.model;

import com.robot.wars.interfaces.Robot;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class Penalty {

    private Robot robot;
    private Integer deduction;

    public Penalty(Robot robot, Integer deduction) {
        this.robot = robot;
        this.deduction = deduction;
    }

    public Robot getRobot() {
        return robot;
    }

    public Integer getDeduction() {
        return deduction;
    }
}
