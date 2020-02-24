/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorCommands;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  private Victor wenchMotor = new Victor(RobotMap.WENCHPORT);
  private Victor elevatorMotor = new Victor(RobotMap.ELEVATORPORT);
  private boolean isOn = false; 
  

  public void setMotor(){
  if(Robot.isBrown==false){
    if(isOn==false){
      wenchMotor.set(RobotMap.WENCHMOTORSPEED);
      isOn=true;
    } else {
      wenchMotor.set(0);
      isOn=false;
    }
  }
}
  
  public void elevatorUp(){
    if(Robot.isBrown==false)
        elevatorMotor.set(RobotMap.ELEVATORSPEED);
  }
  public void elevatorDown(){
    if(Robot.isBrown==false)
      elevatorMotor.set(-RobotMap.ELEVATORSPEED);
  }
 
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorCommands());
  }

  public void quit(){
    if(Robot.isBrown){
      wenchMotor.set(0);
      elevatorMotor.set(0);
    }
  }
}
