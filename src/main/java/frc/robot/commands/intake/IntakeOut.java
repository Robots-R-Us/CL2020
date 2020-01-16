package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeOut extends CommandBase {
    
    private final Intake intake;

    public IntakeOut(Intake _intake) {
        this.intake = _intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() { 
        intake.stop();
    }

    @Override
    public void execute() {
        intake.out();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}