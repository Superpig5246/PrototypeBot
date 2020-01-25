/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.tankDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Make sure this is correct
  
  private Victor motorLeft1 = new Victor(RobotMap.MOTORLEFT1ID);
  //private Victor motorLeft2 = new Victor(RobotMap.MOTORLEFT2ID);
  private Victor motorRight1 = new Victor(RobotMap.MOTORRIGHT1ID);
 // private Victor motorRight2 = new Victor(RobotMap.MOTORRIGHT2ID);



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new tankDrive());
  }

  public void setLeftMotors(double speed){
    //May or may not work; check which one is actually negative
    motorLeft1.set(-speed);
   // motorLeft2.set(-speed);
  }

  public void setRightMotors(double speed){
    motorRight1.set(speed);
    //motorRight2.set(speed);
  }

}
