/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class OI {

    //create instance of OI
    public static OI instance;

    //add Joystick(s)
    public static Joystick driverJoystick;
    public static Joystick operatorJoystick;



    public static OI getInstance() {
        if (instance == null) {
            instance = new OI(RobotMap.JOYSTICK_PORT_DRIVER, RobotMap.JOYSTICK_PORT_OPERATOR);
        }
       return instance;
    }



    /*This is the OI class constructor
    *@param port the port variable is the joystick port
    */
    private OI (int port, int port2) {
        driverJoystick = new Joystick(port);
        operatorJoystick = new Joystick(port2);
    }

    //The first joystick
    public Joystick getDriverJoystck() {
        return driverJoystick;
    }
    public Joystick getOperatorJoystick() {
        return operatorJoystick;
    }

}
