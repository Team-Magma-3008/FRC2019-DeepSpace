/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Elevator_Height_Position extends Command {

  public Elevator_Height_Position() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator_Lift_Subsystem);
    requires(Robot.MaisanDaiskue_Subsystem);
    // public int Height_id = Height_ID;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Elevator_Lift_Subsystem.setSetpoint(RobotMap.Height_List[Robot.Elevator_Lift_Subsystem.Elevator_Height]);
    Robot.MaisanDaiskue_Subsystem.setSetpoint(RobotMap.Height_List[Robot.Elevator_Lift_Subsystem.Elevator_Height]);
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