package util.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;

public class AxisButton extends Button {

    Joystick j;
    int a;

    public AxisButton(Joystick joystick, int axis) {
        j = joystick;
        a = axis;
    }

    @Override
    public boolean get() {
        return j.getRawAxis(a) > Constants.AXIS_THRESHOLD;
    }
}
