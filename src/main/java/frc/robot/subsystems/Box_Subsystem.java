/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.Box_Off;

/**
 * Add your docs here.
 */
public class Box_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public static Spark Box_Spark = new Spark(1);

  public void Box_Intake(){
    Box_Spark.set(0.5);
  }

  public void Box_Outtake(){
    Box_Spark.set(-0.5);
  }

  public void Box_Stop(){
    Box_Spark.set(0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Box_Off());
  }
}
