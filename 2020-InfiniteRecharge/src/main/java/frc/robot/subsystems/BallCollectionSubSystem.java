/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* Todo: 
      - Determine neccesary class imports
      - Find out what motors and classes are being used
      - PIDs?
*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants;

public class BallCollectionSubSystem extends SubsystemBase {
  
  static CANSparkMax motorSpin = new CANSparkMax(Constants.BallCollectConstants.kBallID ,MotorType.kBrushless);

  public BallCollectionSubSystem() {

  }
  
  public static void setSpin(boolean spin){ //boolean bc it's a button
    if (spin) {
      motorSpin.set(.65); // sets the motor to 65% speed
    }
    else {
      motorSpin.set(0); // if the button is not pressed it sets the motor to 0% speed
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.getBoolean("BallCollection: ", true);
    SmartDashboard.getNumber("CollectorCurrent: ", motorSpin.getOutputCurrent());
    SmartDashboard.getNumber("CollectorVoltage: ", motorSpin.getBusVoltage()); 
  }
}
