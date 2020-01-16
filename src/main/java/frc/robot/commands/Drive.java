package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import util.GameData;

public class Drive extends CommandBase {

    private Drivebase driveBase;
    private boolean isFinished = false;
    
    public Drive(Drivebase _driveBase) {
        this.driveBase = _driveBase;

        addRequirements(_driveBase);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(GameData.getMatchTime() <= 0) {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveBase.stop();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}