/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //map for DriveTrain
	public static final int MOTORLEFT1ID = 1;
	public static final int MOTORRIGHT1ID = 0;

  //Map for controllers
  public static final int LEFTSTICK = 0;
  public static final int RIGHTSTICK = 1;
  public static final int XBOX = 2;

  //Map for shooter
  public static final double LOWGEARPERCENT = 0.2;
  public static final double HIGHGEARPERCENT = 1;
  public static final int LOWGEARBUTTON = 2;
  public static final int HIGHGEARBUTTON = 4;
  public static final int LEFTSIDESHOOTER = 2;
  public static final int RIGHTSIDESHOOTER = 3;


  //Map for intake
  public static final int LEFTSOLPORT1 = 0;
  public static final int LEFTSOLPORT2 = 1;
  public static final int RIGHTSOLPORT1 = 2;
  public static final int RIGHTSOLPORT2 = 3;
  public static final int INTAKEMOTORPORT = 3;
  public static final int INTAKEBUTTON = 1;
  public static final double INTAKEMOTORSPEEDOUT = 1;
  public static final double INTAKEMOTORSOEEDIN = 0;

  //Map for Spinny
  public static final int SPINNYMOTORID = 4;
  public static final double SPINTIME = 2;
  public static final double SPINNYMOTORSPEED = .8;
  public static final int SPINTHREETIMESBUTTON = 2;
  public static final int COLORBUTTON = 4;  
  public static final int EXTENDERPORT1 = 10;
  public static final int EXTENDERPORT2 = 11;

  //Auto aim constants
  public static final int AIMBUTTON = 3;
  public static final int SPINCOUNTVALUE = 0;

  //elevator constants
  public static final int WENCHPORT = 2;
  public static final int ELEVATORPORT = 3;
  public static final double WENCHMOTORSPEED = .1;
  public static final int WENCHBUTTON = 3;
  public static final double ELEVATORSPEED = .4;

  //Autonomous constants
  public static final double AUTONOMOUSTURNSPEED = .3;
  public static final double AUTOSHOOTIME = 2;
  public static final double DRIVEBACKTIME = 2;

  //Autonomous times
  public static final int PHASE2TIME = 3;
  public static final int PHASE3TIME = 5;
  public static final int PHASE4TIME = 8;
  public static final int PHASE5TIME = 10;
  
  //Gearbox constants
  public static final int GEARSOL1CHANNEL1 = 4;
  public static final int GEARSOL1CHANNEL2 = 5;
  public static final int GEARSOL2CHANNEL1 = 6;
  public static final int GEARSOL2CHANNEL2 = 7;

  //Josh constants
  public static final int JOSHMOTOR = 1;
  public static final int JOSHSOLPORT1 = 8;
  public static final int JOSHSOLPORT2 = 9;
  public static final double JOSHMOTORSPEED = .3;
  public static final int JOSHBUTTON = 1;




}
