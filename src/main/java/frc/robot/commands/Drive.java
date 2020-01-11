package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivebase;
import util.GameData;

public class Drive extends CommandBase {

    private Drivebase driveBase;
    private RobotContainer robotContainer;
    private boolean isFinished = false;
    
    public Drive(Drivebase _driveBase) {
        this.driveBase = _driveBase;

        addRequirements(_driveBase);
        robotContainer = RobotContainer.getInstance();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveBase.drive(robotContainer.getDriverAxis(Constants.LEFT_Y), robotContainer.getDriverAxis(Constants.LEFT_X));

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