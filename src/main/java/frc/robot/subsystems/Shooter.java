package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class Shooter extends PIDSubsystem {
    
    WPI_TalonSRX shooterMotor;
    private SimpleMotorFeedforward feedForward;
    
    public Shooter() {
        super(new PIDController(Constants.Shooter.kP, Constants.Shooter.kI, Constants.Shooter.kD));
        shooterMotor = new WPI_TalonSRX(Constants.Shooter.SHOOTER_MOTOR);
        feedForward = new SimpleMotorFeedforward(Constants.Shooter.INCREMENTAL_VOLTS, Constants.Shooter.VOLT_PER_ROTATION);

        getController().setTolerance(Constants.Shooter.RPM_TOLERENCE);
        shooterMotor.setSelectedSensorPosition(0); // zero it at the start
    }

    public double getPosition() {
        return shooterMotor.getSelectedSensorPosition();
    }

    public double getVelocity() {
        return shooterMotor.getSelectedSensorVelocity();
    }

    public void in() {
        shooterMotor.set(-1.0);
    }

    public void out() {
        shooterMotor.set(1.0);
    }

    public void stop() {
        shooterMotor.set(0);
    }

    @Override
    protected void useOutput(double output, double setpoint) {
        shooterMotor.setVoltage(output + feedForward.calculate(setpoint));
    }

    @Override
    protected double getMeasurement() {
        return shooterMotor.getSelectedSensorVelocity();
    }

    public boolean atSetpoint() {
        return getController().atSetpoint();
    }
}
