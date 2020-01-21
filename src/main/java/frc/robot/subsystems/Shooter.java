package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    
    WPI_TalonSRX shooterMotor;
    
    
    public Shooter() {

        shooterMotor = new WPI_TalonSRX(Constants.Shooter.SHOOTER_MOTOR);

        shooterMotor.configFactoryDefault();
        shooterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.Shooter.PID_ID,
            Constants.Shooter.TIMEOUT_MS);

        shooterMotor.setSensorPhase(true);

        shooterMotor.configNominalOutputForward(0, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.configNominalOutputReverse(0, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.configPeakOutputForward(1, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.configPeakOutputReverse(-1, Constants.Shooter.TIMEOUT_MS);

        shooterMotor.config_kF(Constants.Shooter.PID_ID, Constants.Shooter.PID_GAINS._F, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.config_kP(Constants.Shooter.PID_ID, Constants.Shooter.PID_GAINS._P, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.config_kI(Constants.Shooter.PID_ID, Constants.Shooter.PID_GAINS._I, Constants.Shooter.TIMEOUT_MS);
        shooterMotor.config_kD(Constants.Shooter.PID_ID, Constants.Shooter.PID_GAINS._D, Constants.Shooter.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        shooterMotor.feed();
    }

    public double getVelocity() {
        return shooterMotor.getSelectedSensorVelocity(Constants.Shooter.PID_ID);
    }

    public void in() {
        shooterMotor.set(ControlMode.PercentOutput, -1.0);
    }

    public void out() {
        shooterMotor.set(ControlMode.PercentOutput, 1.0);
    }

    public void setVelocity() {
        shooterMotor.set(ControlMode.Velocity, Constants.Shooter.SHOOTER_RPM);
    }

    public void stop() {
        shooterMotor.set(ControlMode.PercentOutput, 0);
    }
}
