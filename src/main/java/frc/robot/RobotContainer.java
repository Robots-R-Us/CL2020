/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.beltloop.BeltLoopIn;
import frc.robot.commands.beltloop.BeltLoopOut;
import frc.robot.commands.intake.IntakeIn;
import frc.robot.commands.intake.IntakeOut;
import frc.robot.commands.shooter.ShooterIn;
import frc.robot.commands.shooter.ShooterOut;
import frc.robot.subsystems.BeltLoop;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static final RobotContainer _instance = new RobotContainer();

  // Robot Subsystems
  private final Drivebase driveBaseSystem = new Drivebase();
  private final Intake intakeSystem = new Intake();
  private final BeltLoop beltLoopSystem = new BeltLoop();
  private final Shooter shooterSystem = new Shooter();

  // Robot Commands
  private final AutoDrive autoDriveCommand = new AutoDrive(driveBaseSystem);
  private final IntakeIn intakeInCommand = new IntakeIn(intakeSystem);
  private final IntakeOut intakeOutCommand = new IntakeOut(intakeSystem);
  private final BeltLoopIn beltLoopInCommand = new BeltLoopIn(beltLoopSystem);
  private final BeltLoopOut beltLoopOutCommand = new BeltLoopOut(beltLoopSystem);
  private final ShooterIn shooterInCommand = new ShooterIn(shooterSystem);
  private final ShooterOut shooterOutCommand = new ShooterOut(shooterSystem);

  private final ParallelCommandGroup intakeAllCommand = new ParallelCommandGroup(intakeInCommand, beltLoopInCommand);
  private final ParallelCommandGroup outtakeAllCommand = new ParallelCommandGroup(intakeOutCommand, beltLoopOutCommand);

  // Joysticks and etc.
  private XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Add data to the dashboard
    this.populateDashboard();

    // Configure the button bindings
    this.configureButtonBindings();

    // Set default commands
    driveBaseSystem.setDefaultCommand(new RunCommand(() -> driveBaseSystem.drive(-getDriverAxis(Constants.LEFT_Y), getDriverAxis(Constants.LEFT_X)), driveBaseSystem));
  }

  private void populateDashboard() {
    //SmartDashboard.putData(shooterSystem.getController());
    SmartDashboard.putNumber("DB Encoder Dist.:", driveBaseSystem.getAvgEncoderDistance());
  }

  public void printShooterPosition() {
    System.out.println("Pos: " + shooterSystem.getPosition() + ", Vel: " + shooterSystem.getVelocity());
  }

  private void configureButtonBindings() {
    new JoystickButton(driverController, Constants.RIGHT_SHOULDER)
        .whileHeld(intakeAllCommand)
        .whenReleased(() -> intakeSystem.stop())
        .whenReleased(() -> beltLoopSystem.stop());

    new JoystickButton(driverController, Constants.LEFT_SHOULDER)
        .whileHeld(outtakeAllCommand)
        .whenReleased(() -> intakeSystem.stop())
        .whenReleased(() -> beltLoopSystem.stop());

    new JoystickButton(driverController, Constants.B_BUTTON)
        .whileHeld(shooterOutCommand)
        .whenReleased(() -> shooterSystem.stop());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoDriveCommand;
  }

  public double getDriverAxis(int axis) {
    return driverController.getRawAxis(axis);
  }

  public boolean getDriverButton(int button) {
    return driverController.getRawButton(button);
  }

  public static RobotContainer getInstance() {
    return _instance;
  }
}
