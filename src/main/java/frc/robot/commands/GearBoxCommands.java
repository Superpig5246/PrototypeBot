/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GearBoxCommands extends Command {
  public GearBoxCommands() {
    requires(Robot.gearboxes);
  }
  Timer timer = new Timer();
  
  @Override
  protected void initialize() {
  }
  //MAKE THE BOT STOP AT 6.5 VOLTS
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (timer.get()>=0.5){
      timer.stop();
      timer.reset();
    }
    if ((Robot.m_oi.getLowDriveL() || Robot.m_oi.getLowDriveR()) && timer.get()==0){
      timer.start();
      Robot.gearboxes.lowGear();
    }
    if ((Robot.m_oi.getHighDriveL1() || Robot.m_oi.getHighDriveL2() || Robot.m_oi.getHighDriveR1() || Robot.m_oi.getHighDriveR2()) && timer.get()==0){
      timer.start();
      Robot.gearboxes.highGear();
    }
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
}
