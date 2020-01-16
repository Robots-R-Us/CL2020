package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterIn extends CommandBase {
    
    private final Shooter shooter;

    public ShooterIn(Shooter _shooter) {
        this.shooter = _shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() { 
        shooter.stop();
    }

    @Override
    public void execute() {
        shooter.in();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}