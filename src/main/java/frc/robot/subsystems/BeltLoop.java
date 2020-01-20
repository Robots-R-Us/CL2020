package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltLoop extends SubsystemBase{

    WPI_TalonSRX loopMotor;

    @Override
    public void periodic() {
    }

    public BeltLoop() {
        loopMotor=new WPI_TalonSRX(Constants.BELT_LOOP_MOTOR);
    }
    
    public void in() {
        loopMotor.set(-.8); // 100% output
    }

    public void out() {
        loopMotor.set(.8);
    }

    public void stop() {
        loopMotor.set(0);
    }
}
