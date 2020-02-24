/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeSole extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static IntakeSole instance;
  private Compressor compressor;
  private DoubleSolenoid sole;
  
  public IntakeSole() {
    this.compressor = new Compressor();
    this.sole = new DoubleSolenoid(7, 6); //TODO: find correct channels
  }

  public static IntakeSole getInstance() {
    if (instance == null) {
      instance = new IntakeSole();
    }
    return instance;
  }

  //TODO: find correct button values
  public void action (Joystick j) {
    
    if (j.getRawButton(RobotMap.SOLE_IN)) {
      sole.set(DoubleSolenoid.Value.kForward);
    }
    else if (j.getRawButton(RobotMap.SOLE_OUT)) {
      sole.set(DoubleSolenoid.Value.kReverse);
    }
    else {
      sole.set(DoubleSolenoid.Value.kOff);
    }

  }

  public void startCompressor() {
    this.compressor.setClosedLoopControl(true);
  }

  public boolean getPressure() {
    return compressor.getPressureSwitchValue();
  }

  public boolean isCompressorOn() {
    return compressor.getClosedLoopControl();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
