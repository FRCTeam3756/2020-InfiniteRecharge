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
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

  public static Shooter instance;

  // Creates speed controllers for each victor
  private static SpeedController victor1;
  private static SpeedController victor2;

  // This method returns an instance of the Shooter class if one does not exist
  public static Shooter getInstance() {
    if (instance == null) {
      instance = new Shooter(new int[] { RobotMap.SHOOTER_PORT1, RobotMap.SHOOTER_PORT2 });
    }
    return instance;
  }

  // This makes each speed controller a PWMVictorSPX
  public Shooter(int[] port) {
    victor1 = new PWMVictorSPX(port[0]);
    victor2 = new PWMVictorSPX(port[1]);
  }

  // This method is the main method
  public void action(Joystick joy) {

    if (joy.getRawButton(RobotMap.SHOOTER_SHOOT)) {
      shoot();
    } // If the shoot button on the joystick is pressed, run the shoot method
    else {
      off();
    } // If the shoot button on the joystick is not pressed, run the off method

  }

  // This method makes the robot shoot the ball
  // It sets each victor to the shooter speed
  private void shoot() {
    victor1.set(-0.25);
    victor2.set(-0.25);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    victor1.set(-0.45);
    victor2.set(-0.45);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    victor1.set(-0.65);
    victor2.set(-0.65);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    victor1.set(-RobotMap.SHOOTER_SPEED);
    victor2.set(-RobotMap.SHOOTER_SPEED);
  }

  //This method makes the robot not shoot the ball
  //It stops each motor
  private void off() {
    victor1.stopMotor();
    victor2.stopMotor();
  }

}
