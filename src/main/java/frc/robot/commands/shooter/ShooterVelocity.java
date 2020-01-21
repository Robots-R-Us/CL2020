package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class ShooterVelocity extends CommandBase {

    private final Shooter shooter;

    public ShooterVelocity(Shooter _shooter) {
        this.shooter = _shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() { 
        shooter.stop();
    }

    @Override
    public void execute() {
        shooter.setVelocity();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        if(!RobotContainer.getInstance().getDriverButton(Constants.Controller.B_BUTTON)) {
            return true;
        } else {
            return false;
        }
    }
}