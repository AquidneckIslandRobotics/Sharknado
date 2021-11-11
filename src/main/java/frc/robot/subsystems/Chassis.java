// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  private TalonFX leftLeader;
  private TalonFX leftFollower;
  private TalonFX rightLeader;
  private TalonFX rightFollower;

  /** Creates a new Chassis. */
  public Chassis() {
  leftLeader = new TalonFX(Constants.leftLeader);
  leftFollower = new TalonFX(Constants.leftFollower);
  rightLeader = new TalonFX(Constants.rightLeader);
  rightFollower = new TalonFX(Constants.rightFollower);

  leftFollower.follow(leftLeader);
  rightFollower.follow(rightLeader);

  leftLeader.setInverted(true);
  leftFollower.setInverted(true);
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
leftLeader.set(ControlMode.PercentOutput, leftSpeed);
rightLeader.set(ControlMode.PercentOutput, rightSpeed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
