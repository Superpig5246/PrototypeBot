/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;

public class SpinnyCommands extends Command {
  static int spinCount = 0; 
  public SpinnyCommands() {
   requires(Robot.spinnyThing);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    spinThrice();
    spinToColor();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  private void spinThrice(){
    
    if(Robot.m_oi.getSpinThreeButton()){
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Blue")){
        spinCount++;
      }
      if(spinCount>=RobotMap.SPINCOUNTVALUE){
        Robot.spinnyThing.motorOff();
      }
    }
  }
  
  
private void spinToColor(){
String gameData;
gameData = DriverStation.getInstance().getGameSpecificMessage();
if(Robot.m_oi.getColorButton()){
  if(gameData.length() > 0)
  {
    switch (gameData.charAt(0))
    {
      case 'B' :
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Red"))
        Robot.spinnyThing.motorOff();
        break;
      case 'G' :
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Yellow"))
        Robot.spinnyThing.motorOff();
        break;
      case 'R' :
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Blue"))
        Robot.spinnyThing.motorOff();
        break;
      case 'Y' :
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Green"))
        Robot.spinnyThing.motorOff();
        break;
      default :
        SmartDashboard.putString("ERROR", "ERROR3467654 INVALID COLOR");
        break;
    }
  } 
  }
}
}
