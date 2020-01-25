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


  //find out what this is and change it!!
  public static final int DIGITALSOURCEA = 0;
  public static final int DIGITALSOURCEB = 1;

  //Map for Spinny
  public static final int SPINNYMOTORPORT = 4;
  public static final double SPINTIME = 2;
  public static final double SPINNYMOTORSPEED = .8;
  //Change these as well because I have no idea what they're for
  public static final int SPINDIGITALINPUT1 = 2;
  public static final int SPINDIGITALINPUT2 = 3;


}
