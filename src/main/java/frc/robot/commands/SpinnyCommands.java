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
  private boolean isBlue = false;
  public SpinnyCommands() {
   requires(Robot.spinnyThing);
   requires(Robot.gearboxes);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.spinnyThing.extendOut();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    spinThrice();
    spinToColor();
    Robot.spinnyThing.quit();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.spinnyThing.rectract();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.spinnyThing.rectract();
  }

  private void spinThrice(){
    
    while(Robot.m_oi.getSpinThreeButton()){
      Robot.gearboxes.lowGear();
      Robot.spinnyThing.motorOn();
      if(Robot.spinnyThing.getColor().equals("Blue") && isBlue==false){
        spinCount++;
        isBlue=true;
      } else if (!Robot.spinnyThing.getColor().equals("Blue")) {
        isBlue = false;
      }
      if(spinCount>=RobotMap.SPINCOUNTVALUE){
        Robot.spinnyThing.motorOff();
        Robot.gearboxes.highGear();
      }
    }
  }
  
  
private void spinToColor(){
String gameData;
gameData = DriverStation.getInstance().getGameSpecificMessage();
while(Robot.m_oi.getColorButton()){
  if(gameData.length() > 0)
  {
    switch (gameData.charAt(0))
    {
      case 'B' :
      Robot.spinnyThing.motorOn();
      Robot.gearboxes.lowGear();
      if(Robot.spinnyThing.getColor().equals("Red")){
        Robot.spinnyThing.motorOff();
        Robot.gearboxes.highGear();
      }
        break;
      case 'G' :
      Robot.spinnyThing.motorOn();
      Robot.gearboxes.lowGear();
      if(Robot.spinnyThing.getColor().equals("Yellow")){
        Robot.spinnyThing.motorOff();
        Robot.gearboxes.highGear();
      }
        break;
      case 'R' :
      Robot.spinnyThing.motorOn();
      Robot.gearboxes.lowGear();
      if(Robot.spinnyThing.getColor().equals("Blue")){
        Robot.spinnyThing.motorOff();
        Robot.gearboxes.highGear();
      }
        break;
      case 'Y' :
      Robot.spinnyThing.motorOn();
      Robot.gearboxes.lowGear();
      if(Robot.spinnyThing.getColor().equals("Green")){
        Robot.spinnyThing.motorOff();
        Robot.gearboxes.highGear();
      }
        break;
      default :
        SmartDashboard.putString("ERROR", "ERROR3467654 INVALID COLOR");
        break;
    }
  } 
  }
}
}
