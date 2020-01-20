package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class AutoDrive extends CommandBase {

    private Drivebase driveBase;
    private boolean isFinished = false;
    
    public AutoDrive(Drivebase _driveBase) {
        driveBase = _driveBase;
        addRequirements(_driveBase);
    }

    @Override
    public void initialize() {
        driveBase.resetEncoders();
    }

    @Override
    public void execute() {
        driveBase.pidDrive(-.5, .5);
    }

    @Override
    public void end(boolean interrupted) {
        driveBase.stop();
    }

    @Override
    public boolean isFinished() {
        if(driveBase.getAvgEncoderDistance() >= 3) {
            isFinished = true;
        } else {
            isFinished = false;
        }

        return isFinished;
    }
}