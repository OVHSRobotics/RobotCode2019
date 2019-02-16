/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    XboxController xbox = new XboxController(RobotMap.XBOX_PORT);

    public OI() {
        Button aButton = new JoystickButton(xbox, RobotMap.Xbox.A);
        Button bButton = new JoystickButton(xbox, RobotMap.Xbox.B);

        try {
            aButton.whenPressed(new OpenBallGate());
            bButton.whenPressed(new CloseBallGate());
        }
        finally {
            aButton.close();
            bButton.close();
        }
    }

    public double getDriveRotation() {
        return xbox.getRawAxis(RobotMap.Xbox.RIGHT_STICK_X_AXIS);
    }

    public double getDriveSpeed() {
        // Use negative because -1.0 is up on the controller
        return -xbox.getRawAxis(RobotMap.Xbox.LEFT_STICK_Y_AXIS);
    }

    public boolean getDriveTurboStatus() {
        return xbox.getRawButton(RobotMap.Xbox.START);
    }

    public double getElevatorSpeed() {
        // Use negative because -1.0 is up on the controller
        //double axisValue = -xbox.getRawAxis(RobotMap.Xbox.RIGHT_STICK_Y_AXIS);
        // Triggers go from 0 to 1, so we need to negate the left trigger value to get the full range
        double axisValue = -xbox.getRawAxis(RobotMap.Xbox.LEFT_TRIGGER) + xbox.getRawAxis(RobotMap.Xbox.RIGHT_TRIGGER);
        if (axisValue == 0) {
            // return if it's 0 to avoid division by 0
            return axisValue;
        }

        // Use square inputs
        double sign = axisValue / Math.abs(axisValue);
        axisValue = sign * Math.pow(axisValue, 2);

        return axisValue;
    }
}
