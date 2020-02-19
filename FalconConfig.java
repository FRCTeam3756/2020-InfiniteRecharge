/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import frc.robot.RobotMap;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;


/**
 * Add your docs here.
 */
public class FalconConfig {    
    public static TalonFX _talonLeftMaster;
    public static TalonFX _talonLeftSlave;
    public static TalonFX _talonRightMaster;
    public static TalonFX _talonRightSlave;

   public static void config(){
    _talonLeftMaster = new TalonFX(3);
    _talonLeftSlave = new TalonFX(4);
    _talonRightMaster = new TalonFX(5);
    _talonRightSlave = new TalonFX(6);

    
    _talonLeftMaster.configFactoryDefault();
    _talonLeftSlave.configFactoryDefault();
    _talonRightMaster.configFactoryDefault();
    _talonRightSlave.configFactoryDefault();


    _talonLeftSlave.follow(_talonLeftMaster);

    _talonLeftMaster.configNominalOutputForward(0);
    _talonLeftMaster.configNominalOutputReverse(0);
    _talonLeftMaster.configPeakOutputForward(0.5);
    _talonLeftMaster.configPeakOutputReverse(-0.5);

    _talonLeftMaster.selectProfileSlot(0, 0);
    _talonLeftMaster.config_kF(0, 0.4);
    _talonLeftMaster.config_kP(0,0.07);
    _talonLeftMaster.config_kI(0,0);
    _talonLeftMaster.config_kD(0,0);

    _talonLeftMaster.configMotionAcceleration(1000);
    _talonLeftMaster.configMotionCruiseVelocity(8192);



    
    
    _talonRightSlave.follow(_talonRightMaster);

    _talonRightMaster.configNominalOutputForward(0);
    _talonRightMaster.configNominalOutputReverse(0);
    _talonRightMaster.configPeakOutputForward(0.5);
    _talonRightMaster.configPeakOutputReverse(-0.5);

    _talonRightMaster.selectProfileSlot(0, 0);
    _talonRightMaster.config_kF(0, 0.4);
    _talonRightMaster.config_kP(0,0.07);
    _talonRightMaster.config_kI(0,0);
    _talonRightMaster.config_kD(0,0);

    _talonRightMaster.configMotionAcceleration(1000);
    _talonRightMaster.configMotionCruiseVelocity(8192);
    
}}
