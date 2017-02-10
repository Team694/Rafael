package com.stuypulse.frc2017.robot.commands.auton;

import com.stuypulse.frc2017.robot.commands.DriveForwardEncodersCommand;
import com.stuypulse.frc2017.robot.commands.RotateDegreesGyroCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ApproachBoilerGearFromBoilerCommand extends CommandGroup {
	private static final double BACK_UP_FROM_BOILER_DISTANCE = -1;
	private static final double TURN_FROM_BOILER_BACK_UP = -1;
	private static final double FOWARD_FROM_BOILER_TURN = -1;
	private static final double TURN_TO_BOILER_GEAR = -1;
	
    public ApproachBoilerGearFromBoilerCommand() {
    	int direction; 
    	if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			direction = 1;
		} else {
			direction = -1;
		}
    	
    	addSequential (new DriveForwardEncodersCommand(BACK_UP_FROM_BOILER_DISTANCE));
    	addSequential (new RotateDegreesGyroCommand(TURN_FROM_BOILER_BACK_UP * direction));
    	addSequential (new DriveForwardEncodersCommand(FOWARD_FROM_BOILER_TURN));
    	addSequential (new RotateDegreesGyroCommand(TURN_TO_BOILER_GEAR * direction));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
