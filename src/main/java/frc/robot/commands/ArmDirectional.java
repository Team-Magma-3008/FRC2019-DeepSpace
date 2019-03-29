/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class ArmDirectional extends Command {
  public int DPADAngle;
  public double SensorPosition;

  public ArmDirectional() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Roller_Arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    DPADAngle = OI.GetDPadAngle();
    SensorPosition = Robot.Roller_Arm.getSetpoint();

    //System.out.println("Arm Directional: execute");
    //System.out.println("Setpoint: " + SensorPosition);

    if (DPADAngle == 180) {
      //Robot.Roller_Arm.setSetpointRelative(-20); //Full = 4096; start = 0
      //System.out.println("Arm Directional: DPAD 180");
      Robot.Roller_Arm.setSetpoint(SensorPosition - 80);

    } else if (DPADAngle == 0) {
      //Robot.Roller_Arm.setSetpointRelative(20); //setSetPointRelative adds to current position of the encoder
      //System.out.println("Arm Directional: DPAD 0");
      Robot.Roller_Arm.setSetpoint(SensorPosition + 80);
    } else {
      return;
    }
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