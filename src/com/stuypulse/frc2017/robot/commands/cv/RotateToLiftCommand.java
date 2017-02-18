package com.stuypulse.frc2017.robot.commands.cv;

import java.util.Arrays;

import com.stuypulse.frc2017.robot.Robot;
import com.stuypulse.frc2017.robot.commands.GyroRotationalCommand;

/**
 *
 */
public class RotateToLiftCommand extends GyroRotationalCommand {

    private double[] cvReading;

    public RotateToLiftCommand() {
        super(Robot.stopAutoMovement, false);
    }

    public RotateToLiftCommand(boolean gentle) {
        super(Robot.stopAutoMovement, gentle);
    }

    public RotateToLiftCommand(boolean gentle, double tolerance) {
        super(Robot.stopAutoMovement, gentle, tolerance);
    }

    protected void setDesiredAngle() {
        cvReading = Robot.liftVision.processImage();
        if (cvReading != null) {
            System.out.println(Arrays.toString(cvReading));
            desiredAngle = cvReading[1];
        } else {
            System.out.println("No reading");
            desiredAngle = 0.0;
            cancelCommand = true;
        }
    }

    @Override
    protected void onEnd() {
    }
}
