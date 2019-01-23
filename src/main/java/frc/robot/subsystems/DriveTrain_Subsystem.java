/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class DriveTrain_Subsystem extends Subsystem {
  public CANSparkMax MotorL1 = new CANSparkMax(2,MotorType.kBrushless);
  public CANSparkMax MotorL2 = new CANSparkMax(3,MotorType.kBrushless);
  public CANSparkMax MotorR1 = new CANSparkMax(0,MotorType.kBrushless);
  public CANSparkMax MotorR2 = new CANSparkMax(1,MotorType.kBrushless);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}