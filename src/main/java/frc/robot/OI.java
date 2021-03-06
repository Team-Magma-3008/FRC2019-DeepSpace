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
import edu.wpi.first.wpilibj.GenericHID;


/*COMMADS */
//import frc.robot.commands.TunnelIntake;
//import frc.robot.commands.TunnelIntakeOff;
import frc.robot.commands.Box_Intake_On;
import frc.robot.commands.Box_Outtake_On;
import frc.robot.commands.Box_Off;
import frc.robot.commands.Hatch_Intake_On_For_T;
import frc.robot.commands.Hatch_Intake_Off;

import frc.robot.commands.TrackLimelightX;
import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
import frc.robot.commands.DriveForward;
import frc.robot.commands.DriveBackwards;
import frc.robot.commands.Elevator_Up;
import frc.robot.commands.Elevator_Down;






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

  static Joystick stick0 = new Joystick(RobotMap.JoystickPort);
  
  public JoystickAnalogButton LTrigger = new JoystickAnalogButton(stick0, RobotMap.LTrigger);
  public JoystickAnalogButton RTrigger = new JoystickAnalogButton(stick0, RobotMap.RTrigger);
  
  Button RMiddle = new JoystickButton(stick0, RobotMap.RMiddle);
  Button LMiddle = new JoystickButton(stick0, RobotMap.LMiddle);
  

  Button buttonA = new JoystickButton(stick0, RobotMap.ButtonA);
  Button buttonB = new JoystickButton(stick0, RobotMap.ButtonB);
  Button buttonX = new JoystickButton(stick0, RobotMap.ButtonX);
  Button buttonY = new JoystickButton(stick0, RobotMap.ButtonY);

  
  Button LBumper = new JoystickButton(stick0, RobotMap.LBumper); // elevator goes down
  public JoystickAnalogButton TriggerL = new JoystickAnalogButton(stick0, RobotMap.LTrigger); // elevator goes up



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
    RMiddle.whileHeld(new Box_Outtake_On());
    RTrigger.whileHeld(new Box_Intake_On());
    LMiddle.whileHeld(new Box_Off());
    
    buttonB.whileHeld(new TurnRight(.05));
    buttonX.whileHeld(new TurnLeft(.05));
    buttonY.whileHeld(new DriveForward(.05));
    buttonA.whileHeld(new DriveBackwards(.05));
    
    LTrigger.whenPressed(new Hatch_Intake_On_For_T());
    RTrigger.whenPressed(new Hatch_Intake_Off());

    TriggerL.whileHeld(new Elevator_Up()); //play around with this; may or may not use whileHeld
    LBumper.whileHeld(new Elevator_Down());
  }

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static int GetDPadAngle() {
    return stick0.getPOV();
  }

  public class JoystickAnalogButton extends Button {

    GenericHID m_joystick;
    int m_axisNumber;
    private double THRESHOLD = 0.5;
  
    /**
     * Create a button for triggering commands off a joystick's analog axis
     * 
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param axisNumber The axis number
     */
    public JoystickAnalogButton(GenericHID joystick, int axisNumber) {
        m_joystick = joystick;
        m_axisNumber = axisNumber;
    }
  
    /**
     * Create a button for triggering commands off a joystick's analog axis
     * 
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param axisNumber The axis number
     * @param threshold The threshold to trigger above (positive) or below (negative)
     */
    public JoystickAnalogButton(GenericHID joystick, int axisNumber, double threshold) {
      m_joystick = joystick;
      m_axisNumber = axisNumber;
      THRESHOLD = threshold;
    }
  
    /**
     * Set the value above which triggers should occur (for positive thresholds)
     *  or below which triggers should occur (for negative thresholds)
     * The default threshold value is 0.5
     *  
     * @param threshold the threshold value (1 to -1)
     */
    public void setThreshold(double threshold){
      THRESHOLD = threshold;
    }
   
    /**
     * Get the defined threshold value.
     * @return the threshold value
     */
    public double getThreshold(){
      return THRESHOLD;
    }
    
  
    public boolean get() {
      if(THRESHOLD < 0){
        return m_joystick.getRawAxis(m_axisNumber) < THRESHOLD;    //Return true if axis value is less than negative threshold
      } else {
        return m_joystick.getRawAxis(m_axisNumber) > THRESHOLD;    //Return true if axis value is greater than positive threshold
      }
    }
  }

    public static double getLeftStickY(){
      return (stick0.getRawAxis(RobotMap.LeftJoystickID));
    
    }

    public static double getRightStickY(){
      return (stick0.getRawAxis(RobotMap.RightJoystickID));
    }
}