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
    
    
public class ElevatorCommands extends Command {    
      
  public ElevatorCommands() {    
    requires(Robot.elevator);    
  }    
    
  private Timer timer = new Timer();    
      
  // Called just before this Command runs the first time    
  @Override    
  protected void initialize() {    
  }    
    
  // Called repeatedly when this Command is scheduled to run    
  @Override    
  protected void execute() {    
    Robot.elevator.quit();
    if (timer.get()>=0.5){    
      timer.stop();    
      timer.reset();    
    }    
    if(Robot.m_oi.getWenchButton() && timer.get()==0){    
      Robot.gearboxes.lowGear();
      while(Robot.m_oi.getWenchButton()){
        Robot.elevator.setMotor(); 
      }
    Robot.gearboxes.highGear();   
    }    
    while(Robot.m_oi.getElevatorUp()){    
      Robot.gearboxes.lowGear();
      Robot.elevator.elevatorUp();
          
    }    
    while(Robot.m_oi.getElevatorDown()){
      Robot.gearboxes.lowGear();    
      Robot.elevator.elevatorDown();    
    }    
    Robot.gearboxes.highGear();
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
    