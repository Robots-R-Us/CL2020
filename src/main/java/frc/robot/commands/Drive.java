package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
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
        driveBase.drive(RobotContainer.getInstance().getDriverAxis(Constants.Controller.LEFT_Y), RobotContainer.getInstance().getDriverAxis(Constants.Controller.LEFT_X));
    }

    @Override
    public void end(boolean interrupted) {
        driveBase.stop();
    }

    @Override
    public boolean isFinished() {
        if(GameData.getMatchTime() <= 0) {
            isFinished = true;
        }
        return isFinished;
    }
}
