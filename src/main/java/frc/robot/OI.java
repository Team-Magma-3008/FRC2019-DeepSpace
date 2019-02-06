/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
 

//Import additional commands 
import frc.robot.commands.TunnelIntake;
import frc.robot.commands.TunnelIntakeOff;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  Joystick stick0 = new Joystick(RobotMap.R_joy); //create new joystick input. stick0 is name of right stick

  Button tunBut = new JoystickButton(stick0, RobotMap.TunOn); //Tunnel starts on X-button
  Button tunBut_off = new JoystickButton(stick0, RobotMap.TunOff); //Tunnel turns off on Y-button


public OI() {

  ////Tunnel turns on only when specified button is pressed
  tunBut.whenPressed(new TunnelIntake()); 
  tunBut_off.whenPressed(new TunnelIntakeOff());

}

}