package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltLoop extends SubsystemBase{
    WPI_TalonSRX LoopMotor;
    @Override
    public void periodic(){
    }
    public BeltLoop(){

        LoopMotor=new WPI_TalonSRX(Constants.BeltLoopMotor);
    }
    public void in() {
        LoopMotor.set(1.0); // 100% output
    }

    public void out() {
        LoopMotor.set(-1.0);
    }

    public void stop() {
        LoopMotor.set(0);
    }
}
