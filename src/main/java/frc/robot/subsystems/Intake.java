package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    WPI_TalonSRX intakeMotor;

    public Intake() {
        intakeMotor = new WPI_TalonSRX(Constants.INTAKE_MOTOR);
    }

    @Override
    public void periodic() {
    }

    public void in() {
        intakeMotor.set(-.33); // 33% output
    }

    public void out() {
        intakeMotor.set(.33);
    }

    public void stop() {
        intakeMotor.set(0);
    }

}