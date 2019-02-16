/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Robot mappings
    public final static int FRONT_LEFT_DRIVE_MOTOR_PORT = RobotMap.RoboRIO.PWM_PORT_0;
    public final static int REAR_LEFT_DRIVE_MOTOR_PORT = RobotMap.RoboRIO.PWM_PORT_1;
    public final static int FRONT_RIGHT_DRIVE_MOTOR_PORT = RobotMap.RoboRIO.PWM_PORT_2;
    public final static int REAR_RIGHT_DRIVE_MOTOR_PORT = RobotMap.RoboRIO.PWM_PORT_3;
    public final static boolean FRONT_LEFT_DRIVE_MOTOR_INVERTED = false;
    public final static boolean REAR_LEFT_DRIVE_MOTOR_INVERTED = false;
    public final static boolean FRONT_RIGHT_DRIVE_MOTOR_INVERTED = false;
    public final static boolean REAR_RIGHT_DRIVE_MOTOR_INVERTED = false;

    public final static int ELEVATOR_MOTOR_PORT = RobotMap.RoboRIO.PWM_PORT_4;
    public final static boolean ELEVATOR_MOTOR_INVERT_DIRECTION = false;

    public final static int BALL_GATE_PORT = RobotMap.RoboRIO.PWM_PORT_5;
    public final static double BALL_GATE_OPEN_POSITION = 1.0;
    public final static double BALL_GATE_CLOSED_POSITION = 0.0;

    // Xbox Port
    public final static int XBOX_PORT = 0;

    // Drive motor scaling
    // Scaling factor to slow the motors down (e.g. 0.7 is 70% of max power)
    public final static double DRIVE_SPEED_SCALING_FACTOR = 0.85;

    // Elevator motor scaling
    // Scaling factor to slow the motor down (e.g. 0.7 is 70% of max power)
    public final static double ELEVATOR_SPEED_SCALING_FACTOR = 1.0;

    // ====== DO NOT MODIFY BELOW HERE ======

    public class Xbox {
        // http://team358.org/files/programming/ControlSystem2009-/XBoxControlMapping.jpg

        // Xbox controller button mappings
        public final static int A = 1;
        public final static int B = 2;
        public final static int X = 3;
        public final static int Y = 4;
        public final static int L_BUMPER = 5;
        public final static int R_BUMPER = 6;
        public final static int BACK = 7;
        public final static int START = 8;	

        // Xbox controller axis mappings
        public final static int LEFT_STICK_X_AXIS = 0;
        public final static int LEFT_STICK_Y_AXIS = 1;
        public final static int LEFT_TRIGGER = 2;
        public final static int RIGHT_TRIGGER = 3;
        public final static int RIGHT_STICK_X_AXIS = 4;
        public final static int RIGHT_STICK_Y_AXIS = 5;
    }
    
    public class RoboRIO {
        // PWM Ports
        public final static int PWM_PORT_0 = 0;
        public final static int PWM_PORT_1 = 1;
        public final static int PWM_PORT_2 = 2;
        public final static int PWM_PORT_3 = 3;
        public final static int PWM_PORT_4 = 4;
        public final static int PWM_PORT_5 = 5;
        public final static int PWM_PORT_6 = 6;
        public final static int PWM_PORT_7 = 7;
        public final static int PWM_PORT_8 = 8;
        public final static int PWM_PORT_9 = 9;
        
        // DIO Ports
        public final static int DIO_PORT_0 = 0;
        public final static int DIO_PORT_1 = 1;
        public final static int DIO_PORT_2 = 2;
        public final static int DIO_PORT_3 = 3;
        public final static int DIO_PORT_4 = 4;
        public final static int DIO_PORT_5 = 5;
        public final static int DIO_PORT_6 = 6;
        public final static int DIO_PORT_7 = 7;
        public final static int DIO_PORT_8 = 8;
        public final static int DIO_PORT_9 = 9;
    }
}
