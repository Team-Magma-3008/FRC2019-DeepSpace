/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class R_DriveTrain_Subsystem extends Subsystem {
  public CANSparkMax MotorR1 = new CANSparkMax(RobotMap.MotorR1ID,MotorType.kBrushless);
  public CANSparkMax MotorR2 = new CANSparkMax(RobotMap.MotorR2ID,MotorType.kBrushless);
  public CANSparkMax MotorR3 = new CANSparkMax(RobotMap.MotorR3ID,MotorType.kBrushless);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void DriveBackRDriveTrain(){
    Robot.RDriveTrain.MotorR1.set(-0.5);
    Robot.RDriveTrain.MotorR2.set(-0.5);
    Robot.RDriveTrain.MotorR3.set(-0.5);
  }

  public void DriveForRDriveTrain(){
    Robot.RDriveTrain.MotorR1.set(0.5);
    Robot.RDriveTrain.MotorR2.set(0.5);
    Robot.RDriveTrain.MotorR3.set(0.5);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
