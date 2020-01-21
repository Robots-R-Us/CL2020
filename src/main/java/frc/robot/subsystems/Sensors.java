package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase {
    private DigitalInput intakeSensor;
    private DigitalInput beltLoopSensor;
    private DigitalInput shooterSensor;

    private ColorSensorV3 colorSensor;
    private I2C.Port i2cPort = I2C.Port.kOnboard;
    private ColorMatch colorMatcher = new ColorMatch();

    private Color BlueProfileColor = ColorMatch.makeColor(0.12, 0.42, 0.45);
    private Color GreenProfileColor = ColorMatch.makeColor(0.15, 0.55, 0.25);
    private Color RedProfileColor = ColorMatch.makeColor(0.50, 0.35, 0.13);
    private Color YellowProfileColor = ColorMatch.makeColor(0.31, 0.56, 0.12);

    public Sensors() {
        intakeSensor = new DigitalInput(4);
        beltLoopSensor = new DigitalInput(5);
        shooterSensor = new DigitalInput(6);
        colorSensor = new ColorSensorV3(i2cPort);

        colorMatcher.addColorMatch(RedProfileColor);
        colorMatcher.addColorMatch(BlueProfileColor);
        colorMatcher.addColorMatch(GreenProfileColor);
        colorMatcher.addColorMatch(YellowProfileColor);
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

    public String getColorInfo() {
        Color detectedColor = colorSensor.getColor();
        ColorMatchResult matchResult = colorMatcher.matchClosestColor(detectedColor);

        if(matchResult.color == RedProfileColor) {
            return "Red (" + matchResult.confidence + "%)";
        } else if(matchResult.color == GreenProfileColor) {
            return "Green (" + matchResult.confidence + "%)";
        } else if(matchResult.color == BlueProfileColor) {
            return "Blue (" + matchResult.confidence + "%)";
        } else if(matchResult.color == YellowProfileColor) {
            return "Yellow (" + matchResult.confidence + "%)";
        } else {
            return "N/A";
        }
    }
}
