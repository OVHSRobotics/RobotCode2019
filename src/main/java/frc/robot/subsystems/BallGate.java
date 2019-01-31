package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CloseBallGate;

public class BallGate extends Subsystem {

    private Servo servo;

    public BallGate() {
        this.servo = new Servo(RobotMap.BALL_GATE_PORT);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CloseBallGate());
    }

    public void setPosition(double position) {
        // keep position values between -1 and 1
        position = Math.min(position, 1.0);
        position = Math.max(position, 0.0);

        this.servo.set(position);
    }
}
