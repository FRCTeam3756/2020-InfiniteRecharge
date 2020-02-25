/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

//This is the code that controls the movement of the intake

public class Intake extends Subsystem {

  private static Intake instance;

  private static SpeedController victor;



  public static Intake getInstance() {
    if (instance == null)
      instance = new Intake(RobotMap.INTAKE_PORT);
    return instance;
  }

  public Intake(int port) {
    victor = new PWMVictorSPX(port);
  }

  public void move(Joystick stick){
    if(stick.getRawButton(RobotMap.INTAKE_IN)){
      Up(true);
    }
    else if(stick.getRawButton(RobotMap.INTAKE_OUT)){
        Down(true);
      }

    else{
      Off();
    }
    }
    

  
  

  private void Down(boolean down) {
    if(down == true)
      victor.set(RobotMap.INTAKE_SPEED);
  }

  private void Off() {
    victor.stopMotor();
  }

  private void Up(boolean up) {
    if (up == true)
     victor.set(-RobotMap.INTAKE_SPEED);
  }

  @Override
  public void initDefaultCommand() {
  }
}
