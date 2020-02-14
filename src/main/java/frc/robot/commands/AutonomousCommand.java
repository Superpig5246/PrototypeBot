/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AutonomousCommand extends Command {
Timer timer = new Timer();
  public AutonomousCommand() {
    requires(Robot.driveTrain);
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    try{
    SmartDashboard.putString("Auto phase", "spin to target");
    Robot.driveTrain.spinToTarget();
    Thread.sleep(5000);
    SmartDashboard.putString("Auto phase", "autoAim");
    Robot.shooter.autoAim();
    Thread.sleep(2000);
    SmartDashboard.putString("Autp phase", "high Toggle");
    timer.start();
    while(timer.get()<RobotMap.AUTOSHOOTIME)
      Robot.shooter.highToggle();
    timer.stop();
    timer.reset();
    Thread.sleep(3000);
    SmartDashboard.putString("Auto phase", "drve back");
    Robot.shooter.lowerToggle();
    timer.start();
    while(timer.get()<RobotMap.DRIVEBACKTIME)
      Robot.driveTrain.setBothMotors(0.5);
    timer.stop(); 
    } catch (Exception ex){
      SmartDashboard.putString("ERROR", "AUTONOMOUS EXCEPTION");
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
