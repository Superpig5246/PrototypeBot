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
import frc.robot.RobotMap;


public class ShooterCommands extends Command {
  public ShooterCommands() {
    requires(Robot.shooter); 
    
  }
  private Timer timer = new Timer();
 

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.shooter.leftMotor.restoreFactoryDefaults();
    Robot.shooter.rightMotor.restoreFactoryDefaults();
    Robot.shooter.leftMotor.set(RobotMap.LOWGEARPERCENT);
    Robot.shooter.rightMotor.set(-RobotMap.LOWGEARPERCENT);
   
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //resets timer if one second has passed to ensure that the button input is not read twice
  if (timer.get()>=0.5){
    timer.stop();
    timer.reset();
  }
   //puts encoder data into the SmartDashboard
   Robot.shooter.getData();
   Robot.shooter.readTarget();

   // If half a second has passed before the last imput, the timer will read zero
    // and this will execute
    if(Robot.m_oi.getAimButton()){
      Robot.shooter.autoAim();
    }
    if(Robot.m_oi.getLowGear() && timer.get()==0){
      Robot.shooter.lowerToggle();
      timer.start();
    }
    if(Robot.m_oi.getHighGear() && timer.get()==0){
      Robot.shooter.highToggle();
      timer.start();
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
    Robot.shooter.leftMotor.set(0);
    Robot.shooter.rightMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  
}
