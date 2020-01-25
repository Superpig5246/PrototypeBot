/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

 package frc.robot.subsystems;

 import edu.wpi.first.wpilibj.DoubleSolenoid;
 import edu.wpi.first.wpilibj.Victor;
 import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
 import edu.wpi.first.wpilibj.command.Subsystem;
 import frc.robot.RobotMap;

// /**
//  * Add your docs here.
//  */
 public class Intake extends Subsystem {
   private static DoubleSolenoid leftSol = new DoubleSolenoid(RobotMap.LEFTSOLPORT1, RobotMap.LEFTSOLPORT2);
   private static DoubleSolenoid rightSol = new DoubleSolenoid(RobotMap.RIGHTSOLPORT1, RobotMap.RIGHTSOLPORT2);
   private static Victor intakeMotor = new Victor(RobotMap.INTAKEMOTORPORT);
   private static boolean isOut = false;

   public void intakeState(){
     if(isOut==false){
       leftSol.set(Value.kForward);
       rightSol.set(Value.kForward);
       intakeMotor.set(RobotMap.INTAKEMOTORSPEEDOUT);
     } else {
       leftSol.set(Value.kReverse);
       rightSol.set(Value.kReverse);
       intakeMotor.set(RobotMap.INTAKEMOTORSOEEDIN);
     }
   
   }
   public void intakeIn(){
     leftSol.set(Value.kReverse);
     rightSol.set(Value.kReverse);
     intakeMotor.set(RobotMap.INTAKEMOTORSOEEDIN);
   }

  @Override
  public void initDefaultCommand() {

   }
 }
