// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import javax.crypto.interfaces.DHPublicKey;

//import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.TankDrive;
import frc.robot.RobotContainer;

public class TurningCommand extends CommandBase {
  
  private final TankDrive _tankDrive;



  public TurningCommand(TankDrive t) {
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
    //Get the Z axis value
    double TwistZ= Robot.m_robotContainer.GetTwistValue();
    //System.out.println("Z: " + TwistZ);
    //Assign Z-axis value to motors using opposite signs so the robot quickly turns
    _tankDrive.setLeftMotors(-TwistZ);
    _tankDrive.setRightMotors(TwistZ);
    
    
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