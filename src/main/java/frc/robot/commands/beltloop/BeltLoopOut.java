package frc.robot.commands.beltloop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltLoop;

public class BeltLoopOut extends CommandBase {
    
    private final BeltLoop beltLoop;

    public BeltLoopOut(BeltLoop _beltLoop) {
        this.beltLoop = _beltLoop;
        addRequirements(beltLoop);
    }

    @Override
    public void initialize() { 
        beltLoop.stop();
    }

    @Override
    public void execute() {
        beltLoop.out();
    }

    @Override
    public void end(boolean interrupted) {
        beltLoop.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}