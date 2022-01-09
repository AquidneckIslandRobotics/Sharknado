// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  private TalonFX leftLeader;
  private TalonFX leftFollower1;
  private TalonFX leftFollower2;
  private TalonFX rightLeader;
  private TalonFX rightFollower1;
  private TalonFX rightFollower2;

  /** Creates a new Chassis. */
  public Chassis() {
  leftLeader = new TalonFX(Constants.leftLeader);
  leftFollower1 = new TalonFX(Constants.leftFollower1);
  leftFollower2 = new TalonFX(Constants.leftFollower2);
  rightLeader = new TalonFX(Constants.rightLeader);
  rightFollower1 = new TalonFX(Constants.rightFollower1);
rightFollower2 = new TalonFX(Constants.rightFollower2);

  leftFollower1.follow(leftLeader);
  leftFollower2.follow(leftLeader);
  rightFollower1.follow(rightLeader);
  rightFollower2.follow(rightLeader);

  leftLeader.setInverted(true);
  leftFollower1.setInverted(true);
  leftFollower2.setInverted(true);

  leftLeader.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

  leftLeader.setNeutralMode(NeutralMode.Brake);
  rightLeader.setNeutralMode(NeutralMode.Brake);
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
leftLeader.set(ControlMode.PercentOutput, leftSpeed);
rightLeader.set(ControlMode.PercentOutput, rightSpeed);

  }

  public double getRobotDistanceTraveled() {
    double encoderPosition = leftLeader.getSelectedSensorPosition(0);
    int encoderResolution = 2048;
    double totalRotations = encoderPosition / encoderResolution;

    return (totalRotations / 8.33) * (4 * Math.PI); // Rotation of the motor multiplied by the gearbox ratio multiplied by wheel circumference
  }

  public void resetSensors() {
  leftLeader.setSelectedSensorPosition(0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Distance", this.getRobotDistanceTraveled());
  }
}
