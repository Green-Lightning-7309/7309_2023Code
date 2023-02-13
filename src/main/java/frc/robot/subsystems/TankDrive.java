// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveFowardCommand;

public class TankDrive extends SubsystemBase {
  private PWMSparkMax leftMotor = new PWMSparkMax(Constants.LEFTMOTOR_PORT);
  private PWMSparkMax rightMotor = new PWMSparkMax(Constants.RIGHTMOTOR_PORT);
  /** Creates a new TankDrive. */
  public TankDrive() {
   // setDefaultCommand(DriveFowardCommand());
  }



  //@Override
  /*public void initDefaultCommand() {
    setDefaultCommand(new DriveFowardCommand());
  }*/
  public void setLeftMotors(double speed) {
    leftMotor.set(-speed);
    //System.out.println("Left Speed: -" + leftMotor.get());
  }

  public void setRightMotors(double speed) {
    rightMotor.set(speed);
    //System.out.println("Right Speed: " + rightMotor.get());
  }

  public void stopAll()
  {
    leftMotor.stopMotor();
    rightMotor.stopMotor();
  }
  /*@Override
  public void periodic() {
    // This method will be called once per scheduler run
  }*/
}
