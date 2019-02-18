/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.RobotMap;

import frc.robot.commands.setCamMode;

/**
 * Add your docs here.
 */
public class Limelight_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new setCamMode(1));
  }

  public double getLimelightX(){
    double xAngle = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    System.out.println(xAngle);
    return xAngle;
  }

  public double getPSpeed(double degree){
    double speed = degree *RobotMap.maxTurnSpeed / RobotMap.maxLimelightAngle;
    return speed;
  }
}