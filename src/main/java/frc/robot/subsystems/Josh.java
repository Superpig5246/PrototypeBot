/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.JoshCommands;

/**
 * Add your docs here.
 */
public class Josh extends Subsystem {
  public static CANSparkMax joshMotor = new CANSparkMax(RobotMap.JOSHMOTOR, MotorType.kBrushless);
  public static DoubleSolenoid joshSol = new DoubleSolenoid(RobotMap.JOSHSOLPORT1, RobotMap.JOSHSOLPORT2);
  // joshSol.set(Value.k);

  public void shootSol() {
  if(Robot.isBrown == false){
    try{
    if(joshSol.get()==Value.kForward){
      joshSol.set(Value.kReverse);
      Thread.sleep(200);
      joshSol.set(Value.kForward);
    } else {
      joshSol.set(Value.kForward);
      Thread.sleep(200);
      joshSol.set(Value.kReverse);
    }
  } catch(Exception ex){
    SmartDashboard.putString("ERROR", "Solenoid issue");
  }
}
  }

  public void motorMove(){
    if(Robot.isBrown==false)
     joshMotor.set(RobotMap.JOSHMOTORSPEED);
  }

  public void motorStop(){
    joshMotor.set(0);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoshCommands());
  }
  public void quit(){
    if(Robot.isBrown){
      joshMotor.set(0);      
    }
  }
}
