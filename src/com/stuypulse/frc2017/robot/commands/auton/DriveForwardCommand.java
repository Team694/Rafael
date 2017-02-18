package com.stuypulse.frc2017.robot.commands.auton;

import com.stuypulse.frc2017.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//TEST
/**
 *
 */
public class DriveForwardCommand extends Command {

	private double distanceInInches;
	private double timeInSeconds;
	private double motorSpeed;
	
	private double startTime;

    public DriveForwardCommand(double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.motorSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	Robot.drivetrain.tankDrive(motorSpeed, motorSpeed);
    	Robot.drivetrain.resetEncoders();
        setTimeout(SmartDashboard.getNumber("drive fwd time", 3.0));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = SmartDashboard.getNumber("drive fwd speed", 0.5);
        Robot.drivetrain.tankDrive(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.driverIsOverriding() || isTimedOut();//(Robot.drivetrain.encoderDistance() >= distanceInInches
        		//|| Timer.getFPGATimestamp() - startTime >= timeInSeconds);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
