/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.commands.HatchArm_Feeder;
import frc.robot.commands.HatchArm_Stowed;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import java.beans.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
//import edu.wpi.first.wpilibj.command.WaitUntilCommand;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class HatchArm_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX HA_SRX = new TalonSRX(6);
  Encoder HA_enc = new Encoder();
  //static DigitalInput HatAm_Enc = new DigitalInput(OI.HatchArm_Enc); 

  
  //Direction Methods for motors
  public void Up(){ 
		HA_SRX.set(ControlMode.Position, 1.0);
	}
	public void Stop(){ 
    HA_SRX.set(ControlMode.Position, 0);
	}
	public void Down(){ 
    HA_SRX.set(ControlMode.Position, -0.5);
  }
  
  //Encoder Methods
  public void reset_enc(){ 
    reset_enc();
    //do we need to set and reset a pulse width
  }

	public void getValue_enc(){ 
    getValue_enc();
	}


  //Set Speed
  public void setSpeed() {
    HA_SRX.set(ControlMode.Position, 1.0);
}



  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HatchArm_Feeder());
  }
  
}