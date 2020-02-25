/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * Add your docs here.
 */
public class RobotMap {
   
    //this is where all the consistent variables for the robot are held
    //variables include ports and speeds


    //controller and joystick ports
    public static final int JOYSTICK_PORT_1 = 0;
    //public static final int CONTROLLER_PORT1 = 0;
    //public static final int CONTROLLER_PORT2 = 2;

   
    //This is the speed of the robot        //0.8 or 0.47?
    public static final double ROBOT_SPEED = 0.6;
    public static final double ROBOT_TURNING_SPEED = 0.6;
    
    //This is the speed of the robot in auto
    public static final double AUTO_ROBOT_SPEED = 1;

    public static final double PEAK_OUTPUT = 0.5;

    public static final double KF = 0.4;

    public static final double KP = 0.07;
    public static final double KI = 0.0;
    public static final double KD = 0.0;
    //public static final double AUTO_ROBOT_TURNING_SPEED = 1;

    public static final int SOLE_IN = 6;
    public static final int SOLE_OUT = 7;

    public static final double TICK_SPEED = 2048;

    public static final double INTAKE_SPEED = 0.5;
    public static final int INTAKE_PORT = 1;
    public static final int INTAKE_IN = 3;
    public static final int INTAKE_OUT = 2;

    public static final int SHOOTER_PORT1 = 2;
    public static final int SHOOTER_PORT2 = 3;

    public static final int SHOOTER_SHOOT = 1;
    public static final int SHOOTER_SPEED = 1;


}//end of class RobotMap
