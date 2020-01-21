package frc.robot.commands.sensors;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BeltLoop;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sensors;

public class IntakeSensors extends CommandBase {

    private final Intake intake;
    private final BeltLoop beltLoop;
    private final Sensors sensors;

    public IntakeSensors(Intake _intake, BeltLoop _beltloop, Sensors _sensors) {
        this.intake = _intake;
        this.beltLoop = _beltloop;
        this.sensors = _sensors;
        addRequirements(intake, beltLoop, sensors);
    }

    @Override
    public void initialize() {
        intake.stop();
        beltLoop.stop();
    }

    @Override
    public void execute() {
        intake.in();
        while(!sensors.getBeltLoop() && sensors.getIntake() && !sensors.getShooter()) {
            do{
                beltLoop.in();
            } while(!sensors.getBeltLoop() && !sensors.getShooter());
        }

        while(sensors.getBeltLoop() && sensors.getIntake() && !sensors.getShooter()||
        sensors.getBeltLoop() && !sensors.getIntake() && !sensors.getShooter()) {
            beltLoop.in();
        }
        beltLoop.stop();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
        beltLoop.stop();
    }

    @Override
    public boolean isFinished() {
        if((!sensors.getBeltLoop() && sensors.getIntake() && sensors.getShooter()) || 
        (!RobotContainer.getInstance().getDriverButton(Constants.Controller.A_BUTTON))) {
            return true;
        } else {
            return false;
        }
    }
}