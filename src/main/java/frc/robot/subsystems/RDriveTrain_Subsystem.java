package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RightJoystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

/**
 * Add your docs here.
 */
public class RDriveTrain_Subsystem extends Subsystem {
  public CANSparkMax MotorR1 = new CANSparkMax(RobotMap.MotorR1ID,MotorType.kBrushless);
  public CANSparkMax MotorR2 = new CANSparkMax(RobotMap.MotorR2ID,MotorType.kBrushless);
  public CANSparkMax MotorR3 = new CANSparkMax(RobotMap.MotorR3ID,MotorType.kBrushless);
  public CANEncoder MotorR2_Encoder = MotorR2.getEncoder();
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RightJoystick());
  }
}