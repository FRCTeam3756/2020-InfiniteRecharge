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
  private static SpeedController frontIntakeVictor;
  private static SpeedController stopperVictor;
  private static SpeedController backIntakeVictor;

  //This method returns an instance of the Intake class if one does not exist
  public static Intake getInstance() {
    if (instance == null)
      instance = new Intake(RobotMap.INTAKE_PORT, RobotMap.INTAKE_STOPPER_PORT, RobotMap.INTAKE_PORT_2);
    return instance;
  }

  //This makes the speed controller a PWMVictorSPX
  public Intake(int port1, int port2, int port3) {
    frontIntakeVictor = new PWMVictorSPX(port1);
    stopperVictor = new PWMVictorSPX(port2);
    backIntakeVictor = new PWMVictorSPX(port3);
  }

  //This method is the main method
  public void move(Joystick stick){
   
    if (!stick.getRawButton(1)) {
      keepBallsIn(true);
    }

    if(stick.getRawButton(RobotMap.INTAKE_IN)){
      up(true);
    } //If the intake in button on the joystick is pressed, run the Up method

    else if(stick.getRawButton(RobotMap.INTAKE_OUT)){
      down(true);
    } //If the intake out button on the joystick is pressed, run the Down method

    else if(stick.getRawButton(1)){
      shoot(true);
    }

    else{
      off();
    } //If none of the buttons are pressed, run the Off method

  }
  
  //This method makes the intake go down by setting the victor speed as INTAKE_SPEED
  private void down(boolean down) {
    if(down == true) {
      frontIntakeVictor.set(RobotMap.INTAKE_SPEED);
      backIntakeVictor.set(RobotMap.INTAKE_SPEED);
    }

    stopperVictor.set(RobotMap.INTAKE_STOPPER_SPEED);
  }

  //This method stops the motor
  private void off() {
    frontIntakeVictor.stopMotor();
    stopperVictor.stopMotor();
    backIntakeVictor.stopMotor();
  }

  //This method makes the intake go up by setting the victor speed as -INTAKE_SPEED
  private void up(boolean up) {
    if (up == true)
    frontIntakeVictor.set(-RobotMap.INTAKE_SPEED);
    backIntakeVictor.set(-RobotMap.INTAKE_SPEED);
  }

  private void shoot(boolean shoot){
    if (shoot == true) {
      stopperVictor.set(RobotMap.INTAKE_STOPPER_SPEED*-5);
    }
    
  }

  private void keepBallsIn(boolean shoot) {
    if (shoot == true) {
      stopperVictor.set(RobotMap.INTAKE_STOPPER_SPEED * 5);
    }
  }

  @Override
  public void initDefaultCommand() {
  }
  
}//end of Intake
