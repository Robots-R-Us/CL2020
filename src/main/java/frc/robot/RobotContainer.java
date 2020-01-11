/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivebase;
import util.controls.AxisButton;
import edu.wpi.first.wpilibj2.command.Command;

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

  // Robot Commands
  private final Drive driveCommand = new Drive(driveBaseSystem);
  private final AutoDrive autoDriveCommand = new AutoDrive(driveBaseSystem);

  // Joysticks and etc.
  private Joystick driverController = new Joystick(Constants.DRIVER_CONTROLLER);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default commands
    //driveBaseSystem.setDefaultCommand(new RunCommand(() -> driveBaseSystem.drive(getDriverAxis(1), getDriverAxis(0)), driveBaseSystem));
    driveBaseSystem.setDefaultCommand(driveCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new AxisButton(driverController, getDriverAxis(Constants.RIGHT_TRIGGER)).whenPressed(() -> driveBaseSystem.setMaxOutput(0.5));
    new AxisButton(driverController, getDriverAxis(Constants.RIGHT_TRIGGER)).whenReleased(() -> driveBaseSystem.setMaxOutput(1.0));
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
