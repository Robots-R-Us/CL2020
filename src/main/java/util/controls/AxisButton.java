package util.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;

public class AxisButton extends Button {

    XboxController j;
    int a;
    double d;

    public AxisButton(XboxController joystick, int axis) {
        j = joystick;
        a = axis;
    }

    public AxisButton(XboxController joystick, double axis) {
        j = joystick;
        d = axis;
    }

    @Override
    public boolean get() {
        return j.getRawAxis(a) > Constants.AXIS_THRESHOLD;
    }
}
