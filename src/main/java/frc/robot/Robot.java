/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GearBoxes;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Josh;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SpinnyThing;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;
  
  Command  m_autonomousCommand;
  
  public static DriveTrain driveTrain = new DriveTrain();
  public static Shooter shooter = new Shooter();
  public  static Intake intake = new Intake();
  public static SpinnyThing spinnyThing = new SpinnyThing();
  public static Elevator elevator = new Elevator();
  private static Timer autoTimer = new Timer();
  public static GearBoxes gearboxes = new GearBoxes();
  public static Josh josh = new Josh();
  public static boolean isBrown = false;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
   //m_autonomousCommand = new AutonomousCommand();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if(RobotController.getBatteryVoltage()<=6.5){
      isBrown = true;
    }
    if(RobotController.getBatteryVoltage()>6.5){
      isBrown = false;
    }
    SmartDashboard.putNumber("Battery Voltage", RobotController.getBatteryVoltage());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to resetde any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example) 
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
    autoTimer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    if(autoTimer.get()<RobotMap.PHASE2TIME){
      driveTrain.spinToTarget();
    } else if (autoTimer.get()>=RobotMap.PHASE2TIME && autoTimer.get()<RobotMap.PHASE3TIME){
      shooter.autoAim();
    } else if (autoTimer.get()>=RobotMap.PHASE3TIME && autoTimer.get()<RobotMap.PHASE4TIME){
        Robot.shooter.highToggle();
        for (int i = 0; i<=3; i++){
          josh.shootSol();
          try{
          Thread.sleep(500);
          } catch (final Exception ex){
            SmartDashboard.putString("ERROR", "Autonomous thread woke up!");
          }
        }
    } else if (autoTimer.get()>=RobotMap.PHASE4TIME && autoTimer.get()<RobotMap.PHASE5TIME){
      Robot.shooter.lowerToggle();
      Robot.driveTrain.setBothMotors(0.3);
    } else if (autoTimer.get()>=RobotMap.PHASE5TIME){
      autoTimer.stop();
    } 
  } 

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    
  } 

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putString("Color", spinnyThing.getColor());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }


}
