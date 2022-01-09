// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

/** Add your docs here. */
public class DriveDistance extends CommandBase {

    private Chassis m_chassis;
    private double distanceToDrive = 0;

    /* Creates a new Drive Distance. */
    public DriveDistance(Chassis subsystem, double dist) {
        m_chassis = subsystem;
        distanceToDrive = dist;

        addRequirements(m_chassis);
        // Use addRequrements() here to declare subsystem dependencies.

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_chassis.resetSensors();
    }

    // Called everytime a scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_chassis.setSpeed(0.25, 0.25);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_chassis.setSpeed(0, 0);
    }
    

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (m_chassis.getRobotDistanceTraveled() >= distanceToDrive) {
                return true;
        }   else {
                return false;
        }
    }
}
