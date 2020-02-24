/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;



import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  double leftVelocity ;
  double rightVelocity;
  
  public DriveTrain() {

  }

 /*
  *This method allows the robot to drive
  */
  public void drive(final Joystick controller){
    leftVelocity = (-1 * controller.getX() + controller.getY()) * RobotMap.TICK_SPEED*0.75;
    rightVelocity = (-1 * controller.getX() - controller.getY()) * RobotMap.TICK_SPEED*0.75;

   // differentialDrive.arcadeDrive(RobotMap.ROBOT_SPEED * -controller.getY(), RobotMap.ROBOT_TURNING_SPEED * -controller.getX());
  }  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
