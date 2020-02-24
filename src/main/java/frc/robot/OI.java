/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

//add high gear and low gear
  private final Joystick leftStick = new Joystick(RobotMap.LEFTSTICK);
  private final Joystick rightStick = new Joystick(RobotMap.RIGHTSTICK);
  public XboxController xBox = new XboxController(RobotMap.XBOX);

  public Button highDriveGearL1 = new JoystickButton(leftStick, RobotMap.LOWGEARBUTTON); //2
  public Button lowDriveGearL = new JoystickButton(leftStick, RobotMap.WENCHBUTTON); //3
  public Button highDriveGearL2 = new JoystickButton(leftStick, RobotMap.HIGHGEARBUTTON); //4

  public Button highDriveGearR1 = new JoystickButton(rightStick, RobotMap.SPINTHREETIMESBUTTON); //2
  public Button lowDriveGearR = new JoystickButton(rightStick, RobotMap.AIMBUTTON); //3
  public Button highDriveGearR2 = new JoystickButton(rightStick, RobotMap.COLORBUTTON);//4

  public boolean getHighDriveR1(){
    return highDriveGearR1.get();
  }
  public boolean getHighDriveR2(){
    return highDriveGearR2.get();
  }
  public boolean getHighDriveL1(){
    return highDriveGearL1.get();
  }
  public boolean getHighDriveL2(){
    return highDriveGearL2.get();
  }
  public boolean getLowDriveL(){
    return lowDriveGearL.get();
  }
  public boolean getLowDriveR(){
    return lowDriveGearR.get();
  }
  public double getIntakeButton() {
    return xBox.getTriggerAxis(Hand.kLeft);
  }
  
  // public boolean getLowGear(){
  //   return lowGearButton.get();
  // }

 public double getHighGear() {
  return xBox.getTriggerAxis(Hand.kRight);
 }

 public boolean getAimButton(){
  return xBox.getBumper(Hand.kRight);
 }

 public boolean getColorButton(){
  return xBox.getYButton();
 }
 public boolean getSpinThreeButton(){
   return xBox.getBButton();
 }
 public boolean getWenchButton(){
   return xBox.getAButton();
 }
 public boolean getJoshButton(){
  return xBox.getXButton();
}
public boolean getElevatorUp(){
  return xBox.getBumper(Hand.kRight);
}
public boolean getElevatorDown(){
  return xBox.getBumper(Hand.kLeft);
}
  public double getLeftRawAxis(final int axis){
    return leftStick.getRawAxis(axis);
  }

  public double getRightRawAxis(final int axis){
    return rightStick.getRawAxis(axis);
  }




  
  // Before u create buttons, you must sing the hula hoop song and bathe yourslef in code
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
