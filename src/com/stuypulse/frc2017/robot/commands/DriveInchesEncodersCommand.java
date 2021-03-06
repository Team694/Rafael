package com.stuypulse.frc2017.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveInchesEncodersCommand extends EncoderDrivingCommand {

    private double inches;
    private boolean set;

    public DriveInchesEncodersCommand() {
        super();
        set = false;
    }

    public DriveInchesEncodersCommand(double inches) {
        super();
        this.inches = inches;
        set = true;
    }

    protected void setInchesToMove(double inches) {
        this.inches = inches;
    }

    @Override
    protected double getInchesToMove() {
        return set ? inches : SmartDashboard.getNumber("encoder-drive-inches", 0.0);
    }

    @Override
    public boolean isFinished() {
        //make public instead of protected so that OptionalCVPositionForGearCommand can call
        return super.isFinished();
    }

    @Override
    public void initialize() {
        //make public instead of protected so that OptionalCVPositionForGearCommand can call
        super.initialize();
    }

    @Override
    public void execute() {
        //make public instead of protected so that OptionalCVPositionForGearCommand can call
        super.execute();
    }

    @Override
    public void end() {
        //make public instead of protected so that OptionalCVPositionForGearCommand can call
        super.end();
    }

    @Override
    public void interrupted() {
        //make public instead of protected so that OptionalCVPositionForGearCommand can call
        super.interrupted();
    }
}
