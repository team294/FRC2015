package org.usfirst.frc.team294.robot.commands;

import org.usfirst.frc.team294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDriveWithJoysticks extends Command {

    public TankDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("did something");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println("tank drive");
    	try {
    		Robot.drivetrain.tankDrive(Robot.oi.leftStick.getY(), Robot.oi.rightStick.getY());
    		//System.out.println(Robot.oi.leftStick.getY() + ", " + Robot.oi.rightStick.getY());
    	} catch (ArrayIndexOutOfBoundsException e) {
    		Robot.drivetrain.tankDrive(0, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
