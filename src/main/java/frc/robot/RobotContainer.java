// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveFowardCommand;
import frc.robot.commands.TurningCommand;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final TankDrive m_TankDrive = new TankDrive();
  private final DriveFowardCommand c_driveForward = new DriveFowardCommand(m_TankDrive);
  private final TurningCommand c_turn = new TurningCommand(m_TankDrive);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public CommandJoystick m_driverController = new CommandJoystick(Constants.JoyStick_Port);
  Trigger joystickButton1 = m_driverController.button(1);
  Trigger joystickButton2 = m_driverController.button(2); 
  
  public double GetDriverRawAxis(int axis) {
     return m_driverController.getRawAxis(axis);
  }

  public double GetTwistValue()
  {
    return m_driverController.getTwist();
  }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link     .wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new Trigger(m_DriveSubsystem::DriveFowardCommand).onTrue(new DriveFowardCommand());
   
   

    m_driverController.axisGreaterThan(Constants.STICK_Y, 0).whileTrue(c_driveForward);
    m_driverController.axisLessThan(Constants.STICK_Y, 0).whileTrue(c_driveForward);
   //joystickButton1.whileTrue(c_driveForward); 
    //joystickButton2.whileTrue(c_turn);  
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.axisGreaterThan(Constants.STICK_Z, 0.2).whileTrue(c_turn);
    m_driverController.axisLessThan(Constants.STICK_Z, -0.2).whileTrue(c_turn);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /* 
  public Command getAutonomousCommand() {
    return new DriveFowardCommand(m_TankDrive);
    }
    */
}
