// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class DriveWithJoysticks extends CommandBase {
  /** Creates a new DriveWithJoysticks. */
 
  private Chassis m_chassis; 
    private XboxController m_xboxController;

    public DriveWithJoysticks(Chassis chassis, XboxController joy) {
      m_chassis = chassis;
      m_xboxController = joy;
      addRequirements(chassis);
    }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double lSpeed = m_xboxController.getY(Hand.kLeft);
    double rSpeed = m_xboxController.getY(Hand.kRight);
    m_chassis.setSpeed(lSpeed, rSpeed);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

