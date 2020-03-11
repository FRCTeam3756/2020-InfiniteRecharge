/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Falcon_500_Config;

import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  public static DriveTrain instance;

  public double leftVelocity;
  public double rightVelocity;
  
  //public DriveTrain() {

  //}
  public static DriveTrain getInstance(){
    if (instance == null) {
      instance = new DriveTrain();
    }
    return instance;
  }

 /*
  *This method allows the robot to drive
  */
  public void drive(final Joystick controller){
    
    leftVelocity = (-1 * controller.getX() + controller.getY()) * RobotMap.TICK_SPEED;
    rightVelocity = (-1 * controller.getX() - controller.getY()) * RobotMap.TICK_SPEED;
    
    if(RobotMap.SHOOTER_SPEED * -(controller.getZ() + 1)/2 > 0){
      Falcon_500_Config._talonLeftMaster.set(ControlMode.Velocity, leftVelocity);
      Falcon_500_Config._talonRightMaster.set(ControlMode.Velocity, rightVelocity);
    }

  }  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
