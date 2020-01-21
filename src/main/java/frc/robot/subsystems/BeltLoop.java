package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltLoop extends SubsystemBase{

    WPI_TalonSRX loopMotor;

    public BeltLoop() {
        loopMotor = new WPI_TalonSRX(Constants.BeltLoop.BELT_LOOP_MOTOR);
    }

    @Override
    public void periodic() {
        loopMotor.feed();
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
