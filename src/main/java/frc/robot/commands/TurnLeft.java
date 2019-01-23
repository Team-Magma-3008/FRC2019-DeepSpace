/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnLeft extends Command {
  private double turnSpeed;
  public TurnLeft(double turnSpeed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.turnSpeed = turnSpeed;
    requires(Robot.Limelight);
    requires(Robot.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

      Robot.DriveTrain.MotorR1.set(this.turnSpeed);
      Robot.DriveTrain.MotorR2.set(this.turnSpeed);
      Robot.DriveTrain.MotorL1.set(-this.turnSpeed);
      Robot.DriveTrain.MotorL2.set(-this.turnSpeed);
  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}