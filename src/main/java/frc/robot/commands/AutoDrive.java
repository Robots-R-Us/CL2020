package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class AutoDrive extends CommandBase {

    private Drivebase driveBase;
    private boolean isFinished = false;
    private int stage = 0;
    
    public AutoDrive(Drivebase _driveBase) {
        driveBase = _driveBase;
        addRequirements(_driveBase);
    }

    @Override
    public void initialize() {
        stage = 0;
        driveBase.resetEncoders();
    }

    @Override
    public void execute() {
        switch(stage) {
            case 0: {
                driveBase.pidDrive(-.7, -.7);
                if(driveBase.getAvgEncoderDistance() >= 3) {
                    driveBase.stop();
                    stage = 1;
                }
                break;
            }
            case 1: {
                driveBase.pidDrive(.7, -.7);
                if(driveBase.getLeftEncoderDistance() >= 1) {
                    driveBase.stop();
                    stage = 2;
                    isFinished = true;
                }
                break;
            }
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