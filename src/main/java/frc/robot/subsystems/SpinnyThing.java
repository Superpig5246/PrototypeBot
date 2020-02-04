// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import frc.robot.RobotMap;
import frc.robot.commands.SpinnyCommands;

import com.revrobotics.CANSparkMax;
//import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SpinnyThing extends Subsystem {
  
  public SpinnyThing(){}

  //This might be kMXP
  private static I2C.Port i2cPort = I2C.Port.kOnboard;

  //Going to need to do something with this eventually
  //private static Encoder spinEncoder = new Encoder(RobotMap.SPINDIGITALINPUT1, RobotMap.SPINDIGITALINPUT2);
  //Making everything needed to detect color
  private static ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private static ColorMatch colorMatch = new ColorMatch();
  private final Color Blue = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color Green = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color Red = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color Yellow = ColorMatch.makeColor(0.361, 0.524, 0.113);
  public CANSparkMax spinnyMotor = new CANSparkMax(RobotMap.SPINNYMOTORID, MotorType.kBrushless);
  //Creating a timer
  private Timer timer = new Timer();


//Returns the current color value detected by the color detector
public String getColor(){
    colorMatch.addColorMatch(Red);
    colorMatch.addColorMatch(Green);
    colorMatch.addColorMatch(Blue);
    colorMatch.addColorMatch(Yellow);
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = colorMatch.matchClosestColor(detectedColor);
    if (match.color == Blue) {
        return "Blue";
      } else if (match.color == Red) {
        return "Red";
      } else if (match.color == Green) {
        return "Green";
      } else if (match.color == Yellow) {
        return "Yellow";
      } else {
        return "Unknown";
      }
}
public void motorOn(){
  spinnyMotor.set(RobotMap.SPINNYMOTORSPEED);
}
public void motorOff(){
  spinnyMotor.set(0);
}
public void switchColor(){
    timer.start();
    while(timer.get()<=RobotMap.SPINTIME)
        spinnyMotor.set(RobotMap.SPINNYMOTORSPEED);
    timer.stop();
    timer.reset();;
}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SpinnyCommands());
  }
}
