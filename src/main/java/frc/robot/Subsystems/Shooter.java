/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  
  public static Shooter instance;

  private static SpeedController victor1;

  private static SpeedController victor2;

  public static Shooter getInstance(){
    if (instance == null) {
      instance = new Shooter(new int[] {RobotMap.SHOOTER_PORT1, RobotMap.SHOOTER_PORT2});
    }
    return instance;
  }

  public Shooter(int[] port){
    victor1 = new PWMVictorSPX(port[0]);
    victor2 = new PWMVictorSPX(port[1]);
  }

  public void action(Joystick joy) {

    if (joy.getRawButton(RobotMap.SHOOTER_SHOOT)) {
      shoot();
    }
    else {
      off();
    }

  }

  private void shoot() {
    victor1.set(RobotMap.SHOOTER_SPEED);
    victor2.set(RobotMap.SHOOTER_SPEED);
  }

  private void off() {
    victor1.stopMotor();
    victor2.stopMotor();
  }

 

}
