package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorMove;

public class Elevator extends Subsystem {

    private VictorSP motor;

    public Elevator() {
        this.motor = new VictorSP(RobotMap.ELEVATOR_MOTOR_PORT);
        this.motor.setInverted(RobotMap.ELEVATOR_MOTOR_INVERT_DIRECTION);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorMove());
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            speed = speed * RobotMap.ELEVATOR_SPEED_DOWN_SCALING_FACTOR;
        } else if (speed > 0) {
            speed = speed * RobotMap.ELEVATOR_SPEED_UP_SCALING_FACTOR;
        }

        // keep speed values between -1 and 1
        speed = Math.min(speed, 1.0);
        speed = Math.max(speed, -1.0);

        this.motor.set(speed);
    }

    public void moveUp() {
        this.motor.set(1.0);
    }

    public void moveDown() {
        this.motor.set(-1.0);
    }

    public void stop() {
        this.motor.stopMotor();
    }
}
