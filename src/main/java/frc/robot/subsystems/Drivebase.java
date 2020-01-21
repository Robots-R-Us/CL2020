package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivebase extends SubsystemBase {

    private WPI_TalonSRX fLMotor, fRMotor, rLMotor, rRMotor;
    private SpeedControllerGroup leftTank, rightTank;
    private DifferentialDrive driveBase;
    private Encoder leftEncoder, rightEncoder;

    public Drivebase() {
        fLMotor = new WPI_TalonSRX(Constants.Drivebase.FRONT_LEFT_MOTOR);
        fRMotor = new WPI_TalonSRX(Constants.Drivebase.FRONT_RIGHT_MOTOR);
        rLMotor = new WPI_TalonSRX(Constants.Drivebase.REAR_LEFT_MOTOR);
        rRMotor = new WPI_TalonSRX(Constants.Drivebase.REAR_RIGHT_MOTOR);

        leftTank = new SpeedControllerGroup(fLMotor, rLMotor);
        rightTank = new SpeedControllerGroup(fRMotor, rRMotor);

        driveBase = new DifferentialDrive(leftTank, rightTank);

        leftEncoder = new Encoder(Constants.Drivebase.LEFT_DRIVE_ENCODER_1, Constants.Drivebase.LEFT_DRIVE_ENCODER_2);
        rightEncoder = new Encoder(Constants.Drivebase.RIGHT_DRIVE_ENCODER_1, Constants.Drivebase.RIGHT_DRIVE_ENCODER_2);

        leftEncoder.setDistancePerPulse(Constants.Drivebase.DISTANCE_PER_PULSE);
        rightEncoder.setDistancePerPulse(Constants.Drivebase.DISTANCE_PER_PULSE);

        driveBase.setSafetyEnabled(true);
        driveBase.setExpiration(.1);

        this.setBrakeMode();
    }

    @Override
    public void periodic() {
        driveBase.feed();
    }

    public void drive(double speed, double rotation) {
        driveBase.arcadeDrive(speed, rotation);
    }

    public void pidDrive(double leftSpeed, double rightSpeed) {
        double heading_error = getLeftEncoderDistance() - getRightEncoderDistance();
        driveBase.tankDrive(leftSpeed + Constants.Drivebase.kP * heading_error, rightSpeed - Constants.Drivebase.kP * heading_error);
    }

    public void stop() {
        driveBase.arcadeDrive(0, 0);
    }

    public double getAvgEncoderDistance() {
        return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
    }

    public double getLeftEncoderDistance() {
        return -leftEncoder.getDistance();
    }

    public double getRightEncoderDistance() {
        return rightEncoder.getDistance();
    }

    public void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void setMaxOutput(double maxOutput) {
      driveBase.setMaxOutput(maxOutput);
    }

    public void setBrakeMode() {
        fLMotor.setNeutralMode(NeutralMode.Brake);
        fRMotor.setNeutralMode(NeutralMode.Brake);
        rLMotor.setNeutralMode(NeutralMode.Brake);
        rRMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setCoastMode() {
        fLMotor.setNeutralMode(NeutralMode.Coast);
        fRMotor.setNeutralMode(NeutralMode.Coast);
        rLMotor.setNeutralMode(NeutralMode.Coast);
        rRMotor.setNeutralMode(NeutralMode.Coast);
    }
}
