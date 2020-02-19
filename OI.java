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
    public static OI getInstance() {
        if (instance == null) 
            instance = new OI(RobotMap.JOYSTICK_PORT_1);
       
       return instance;
    }


    //add Joystick(s)
    public static Joystick joy1;


    /*This is the OI class constructor
    * the port variable is the joystick port
    */
    private OI (int port) {
        joy1 = new Joystick(port);
    }

    //The first joystick
    public Joystick getJoystick1() {
        return joy1;
    }
    

}
