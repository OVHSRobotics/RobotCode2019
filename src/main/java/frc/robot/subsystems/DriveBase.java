package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
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
        
        SpeedControllerGroup leftMotors = new SpeedControllerGroup(this.frontLeftMotor, this.rearLeftMotor);
        SpeedControllerGroup rightMotors = new SpeedControllerGroup(this.frontRightMotor, this.rearRightMotor);

        this.driveTrain = new DifferentialDrive(leftMotors, rightMotors);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void arcadeDrive(double speed, double rotation) {
        this.arcadeDrive(speed, rotation, true);
    }

    public void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        this.driveTrain.arcadeDrive(speed, rotation, squareInputs);
    }
}