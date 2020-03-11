/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.RobotMap;

public class Falcon_500_Config extends PIDSubsystem {
  /**
   * Creates a new Falcon_500_Config.
   */

  public static TalonFX _talonLeftMaster = new TalonFX(3);
  public static TalonFX _talonLeftSlave = new TalonFX(4);
  public static TalonFX _talonRightMaster = new TalonFX(5);
  public static TalonFX _talonRightSlave = new TalonFX(6);

  public static Joystick joy = new Joystick(0);

  public Falcon_500_Config() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.0, 0.0, 0));

      
        _talonLeftMaster.configFactoryDefault();
        _talonLeftSlave.configFactoryDefault();
        _talonRightMaster.configFactoryDefault();
        _talonRightSlave.configFactoryDefault();
        _talonLeftSlave.follow(_talonLeftMaster);

    _talonLeftMaster.configNominalOutputForward(0);
    _talonLeftMaster.configNominalOutputReverse(0);
    _talonLeftMaster.configPeakOutputForward(RobotMap.PEAK_OUTPUT);
    _talonLeftMaster.configPeakOutputReverse(-RobotMap.PEAK_OUTPUT);

    _talonLeftMaster.selectProfileSlot(0, 0);
    _talonLeftMaster.config_kF(0, RobotMap.KF);
    _talonLeftMaster.config_kP(0,RobotMap.KP);
    _talonLeftMaster.config_kI(0,RobotMap.KI);
    _talonLeftMaster.config_kD(0,RobotMap.KD);

    _talonLeftMaster.configMotionAcceleration(1000);
    _talonLeftMaster.configMotionCruiseVelocity(8192);



    
    
    _talonRightSlave.follow(_talonRightMaster);

    _talonRightMaster.configNominalOutputForward(0);
    _talonRightMaster.configNominalOutputReverse(0);
    _talonRightMaster.configPeakOutputForward(RobotMap.PEAK_OUTPUT);
    _talonRightMaster.configPeakOutputReverse(-RobotMap.PEAK_OUTPUT);

    _talonRightMaster.selectProfileSlot(0, 0);
    _talonRightMaster.config_kF(0, RobotMap.KF);
    _talonRightMaster.config_kP(0,RobotMap.KP);
    _talonRightMaster.config_kI(0,RobotMap.KI);
    _talonRightMaster.config_kD(0,RobotMap.KD);

    _talonRightMaster.configMotionAcceleration(1000);
    _talonRightMaster.configMotionCruiseVelocity(8192);

    
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    double leftVelocity = (-1 * joy.getX() + joy.getY()) * RobotMap.TICK_SPEED*0.75;
    double rightVelocity = (-1 * joy.getX() - joy.getY()) * RobotMap.TICK_SPEED*0.75;
    _talonLeftMaster.set(ControlMode.Velocity, leftVelocity);
    _talonRightMaster.set(ControlMode.Velocity, rightVelocity);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }
}
