package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    WPI_TalonSRX shooterMotor;
    
    public Shooter (){
        shooterMotor = new WPI_TalonSRX(Constants.Shooter_Motor);
    }
    public void in(){
        shooterMotor.set(1.0);
    }
    public void out(){
        shooterMotor.set(-1.0);
    }
    public void stop(){
        shooterMotor.set(0);
    }
}
