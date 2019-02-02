/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;
import frc.robot.commands.Ball_Rocket_Low_Command;
import frc.robot.commands.Cargo_Load_Command;
import frc.robot.commands.Feeder_Height_Command;
import frc.robot.commands.TalonSRX_Test_Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  Joystick stick0 = new Joystick(RobotMap.Joystick_Port);
  // Button button = new JoystickButton(stick, buttonNumber);
  Button button1 = new JoystickButton(stick0, RobotMap.Feeder_Height_Trigger);
  Button button2 = new JoystickButton(stick0, RobotMap.SRX_Test_Trigger);
  Button button3 = new JoystickButton(stick0, RobotMap.Ball_Rocket_Low_Trigger);
  Button button4 = new JoystickButton(stick0, RobotMap.Cargo_Load_Trigger);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  public OI() {
    button1.whenPressed(new Feeder_Height_Command());
    button2.whenPressed(new TalonSRX_Test_Command());
    button3.whenPressed(new Ball_Rocket_Low_Command());
    button4.whenPressed(new Cargo_Load_Command());
  }
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
