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

  //This creates an instance of the Intake class
  private static Intake instance;

  //This creates a speed controller for the victor
  private static SpeedController victor;

  //This method returns an instance of the Intake class if one does not exist
  public static Intake getInstance() {
    if (instance == null)
      instance = new Intake(RobotMap.INTAKE_PORT);
    return instance;
  }

  //This makes the speed controller a PWMVictorSPX
  public Intake(int port) {
    victor = new PWMVictorSPX(port);
  }

  //This method is the main method
  public void move(Joystick stick){
   
    if(stick.getRawButton(RobotMap.INTAKE_IN)){
      Up(true);
    } //If the intake in button on the joystick is pressed, run the Up method

    else if(stick.getRawButton(RobotMap.INTAKE_OUT)){
      Down(true);
    } //If the intake out button on the joystick is pressed, run the Down method

    else{
      Off();
    } //If none of the buttons are pressed, run the Off method

  }
  
  //This method makes the intake go down by setting the victor speed as INTAKE_SPEED
  private void Down(boolean down) {
    if(down == true)
      victor.set(RobotMap.INTAKE_SPEED);
  }

  //This method stops the motor
  private void Off() {
    victor.stopMotor();
  }

  //This method makes the intake go up by setting the victor speed as -INTAKE_SPEED
  private void Up(boolean up) {
    if (up == true)
     victor.set(-RobotMap.INTAKE_SPEED);
  }

  @Override
  public void initDefaultCommand() {
  }
  
}//end of Intake
