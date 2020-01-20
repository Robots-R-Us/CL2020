package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {
    private DigitalInput intakeSensor;
    private DigitalInput beltLoopSensor;

    public Sensors() {
        intakeSensor = new DigitalInput(4);
        beltLoopSensor = new DigitalInput(5);
    }

    public boolean getIntake() {
        return intakeSensor.get();
    }

    public boolean getBeltLoop() {
        return beltLoopSensor.get();
    }
}