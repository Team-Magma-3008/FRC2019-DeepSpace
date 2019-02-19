/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmUp extends Command {
  //public double R_ArmSRX_Position;

  public ArmUp() {
      requires(Robot.R_Arm);
      requires(Robot.L_Arm);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //this.R_ArmSRX_Position = R_ArmSRX_Position;
    //R_ArmSRX_Position = Robot.R_Arm.getSetpoint();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.R_Arm.setSetpointRelative(400);
    Robot.L_Arm.setSetpointRelative(400);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
