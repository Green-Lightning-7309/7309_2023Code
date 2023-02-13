// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

//import javax.crypto.interfaces.DHPublicKey;

//import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.TankDrive;
import frc.robot.RobotContainer;
import java.lang.Math;

import javax.lang.model.util.ElementScanner14;

public class DriveFowardCommand extends CommandBase {
  /** Creates a new DriveFowardCommand. */
  private final TankDrive _tankDrive;



  public DriveFowardCommand(TankDrive t) {
    // Use addRequirements() here to declare subsystem dependencies.
    _tankDrive = t;
    addRequirements(_tankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double StickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.STICK_Y);
    //System.out.println("Y: " + StickY);   
   
    //assign motor values based on y-axis input from Joystick
    _tankDrive.setLeftMotors(StickY);
    _tankDrive.setRightMotors(StickY);
    
    
  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _tankDrive.stopAll();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
