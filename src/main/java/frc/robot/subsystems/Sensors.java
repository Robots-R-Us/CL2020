package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {
    private DigitalInput intakeSensor;
    private DigitalInput beltLoopSensor;
    private DigitalInput shooterSensor;

    public Sensors() {
        intakeSensor = new DigitalInput(4);
        beltLoopSensor = new DigitalInput(5);
        shooterSensor = new DigitalInput(6);
    }

    public boolean getIntake() {
        return intakeSensor.get();
    }

    public boolean getBeltLoop() {
        return beltLoopSensor.get();
    }

    public boolean getShooter() {
        if(shooterSensor.get()) {
            return false;
        } else {
            return true;
        }
    }
}
