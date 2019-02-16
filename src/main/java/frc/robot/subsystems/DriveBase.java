package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoystick;

public class DriveBase extends Subsystem {

    public DifferentialDrive driveTrain;

    private VictorSP frontLeftMotor;
    private VictorSP rearLeftMotor;
    private VictorSP frontRightMotor;
    private VictorSP rearRightMotor;

    public DriveBase() {
        this.frontLeftMotor = new VictorSP(RobotMap.FRONT_LEFT_DRIVE_MOTOR_PORT);
        this.rearLeftMotor = new VictorSP(RobotMap.REAR_LEFT_DRIVE_MOTOR_PORT);
        this.frontRightMotor = new VictorSP(RobotMap.FRONT_RIGHT_DRIVE_MOTOR_PORT);
        this.rearRightMotor = new VictorSP(RobotMap.REAR_RIGHT_DRIVE_MOTOR_PORT);

        this.frontLeftMotor.setInverted(RobotMap.FRONT_LEFT_DRIVE_MOTOR_INVERTED);
        this.rearLeftMotor.setInverted(RobotMap.REAR_LEFT_DRIVE_MOTOR_INVERTED);
        this.frontRightMotor.setInverted(RobotMap.FRONT_RIGHT_DRIVE_MOTOR_INVERTED);
        this.rearRightMotor.setInverted(RobotMap.REAR_RIGHT_DRIVE_MOTOR_INVERTED);
        
        SpeedControllerGroup leftMotors = new SpeedControllerGroup(this.frontLeftMotor, this.rearLeftMotor);
        SpeedControllerGroup rightMotors = new SpeedControllerGroup(this.frontRightMotor, this.rearRightMotor);

        this.driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveJoystick());
    }

    public void arcadeDrive(double speed, double rotation) {
        this.arcadeDrive(speed, rotation, true);
    }

    public void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        if (!Robot.oi.getDriveTurboStatus()) {
            speed = speed * RobotMap.DRIVE_SPEED_SCALING_FACTOR;
            rotation = rotation * RobotMap.DRIVE_SPEED_SCALING_FACTOR;
        }

        // Compensate for motors running at different max speeds
        if (Math.abs(rotation) < 0.1) {
            if (speed > 0) {
                rotation = rotation - 0.05;
            } else {
                rotation = rotation - 0.12;
            }
        }

        // Make sure we don't ask the robot to go past its limits
        if (speed > 1) {
            speed = 1;
        } else if (speed < -1) {
            speed = -1;
        }

        this.driveTrain.arcadeDrive(speed, rotation, squareInputs);
    }
}
