/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommands;



/**
 * Add your docs here.
 */

public class Shooter extends Subsystem {

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  
  
  
 public  CANSparkMax leftMotor = new CANSparkMax(RobotMap.LEFTSIDESHOOTER, MotorType.kBrushless);
 public  CANSparkMax rightMotor = new CANSparkMax(RobotMap.RIGHTSIDESHOOTER, MotorType.kBrushless);
 private CANEncoder leftEncoder = leftMotor.getEncoder();
 private CANEncoder rightEncoder = rightMotor.getEncoder();

 private static boolean isLow = true;
 private static boolean isHigh = false;

 public void getData(){
   SmartDashboard.putNumber("Right motor CPR", rightEncoder.getCountsPerRevolution());
   SmartDashboard.putNumber("Left motor CPR", leftEncoder.getCountsPerRevolution());
   SmartDashboard.putNumber("Right encoder velocity", rightEncoder.getVelocity());
   SmartDashboard.putNumber("Left encoder velocity", leftEncoder.getVelocity());
   SmartDashboard.putNumber("Right encoder position", rightEncoder.getPosition());
   SmartDashboard.putNumber("Left encoder velocity", leftEncoder.getPosition());
 }

public void readTarget(){
  //read values periodically
  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  double area = ta.getDouble(0.0);
  
  //post to smart dashboard periodically
  SmartDashboard.putNumber("LimelightX", x);
  SmartDashboard.putNumber("LimelightY", y);
  SmartDashboard.putNumber("LimelightArea", area);
}

public void lowerToggle(){
  if (isLow){
    rightMotor.set(0);
    leftMotor.set(0);
    isLow=false;
  } else {
    rightMotor.set(-RobotMap.LOWGEARPERCENT);
    leftMotor.set(RobotMap.LOWGEARPERCENT);
    
    isLow=true;
  }
}

public void highToggle (){
  if (isHigh){
    if (isLow==false){
      rightMotor.set(0);
      leftMotor.set(0);
    } else {
      rightMotor.set(-RobotMap.LOWGEARPERCENT);
      leftMotor.set(RobotMap.LOWGEARPERCENT);
    }
    isHigh = false;
  } else {
    rightMotor.set(-RobotMap.HIGHGEARPERCENT);
    leftMotor.set(RobotMap.HIGHGEARPERCENT);
    isHigh = true; 
  }
}
public Shooter (){
  
}
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShooterCommands());
  }
}