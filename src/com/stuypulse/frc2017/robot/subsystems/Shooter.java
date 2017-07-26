package com.stuypulse.frc2017.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.stuypulse.frc2017.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // There are two motors on the shooter, hooked up to one gearbox, with the
    // sole purpose of doubling torque.
    private CANTalon shooterMotorA;
    private CANTalon shooterMotorB;

    public Shooter() {
        /* DISABLED shooterMotorA = new CANTalon(RobotMap.SHOOTER_MOTOR_A_PORT);
        shooterMotorB = new CANTalon(RobotMap.SHOOTER_MOTOR_B_PORT);
        shooterMotorA.enableBrakeMode(false);
        shooterMotorB.enableBrakeMode(false);
        shooterMotorA.setInverted(true);
        shooterMotorB.setInverted(true);
        shooterMotorA.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        */
        
        //shooterMotorA.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        //shooterMotorA.changeControlMode(TalonControlMode.Speed);
        //shooterMotorB.changeControlMode(TalonControlMode.Speed);

        // DISABLED shooterMotorA.configEncoderCodesPerRev(RobotMap.SHOOTER_ENCODER_PULSES_PER_REVOLUTION);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void setSpeed(double speed) {
        //shooterMotorA.set(speed);
        //shooterMotorB.set(speed);
    }

    // cut current to motor so it stops eventually, but doesn't apply brakes
    public void stop() {
        //shooterMotorA.set(0.0);
        //shooterMotorB.set(0.0);
    }

    public void resetEncoder() {
        /*shooterMotorA.reset();
        shooterMotorA.enable();
        shooterMotorA.set(0.0);*/
    }

    public double getDistance() {
        return 0;//shooterMotorA.getPosition();

    }

    public double getSpeed() {
        return 0;//shooterMotorA.getEncVelocity();
        //return shooterMotorA.getSpeed();
    }

    public double getCurrentShooterMotorA() {
        return 0;//shooterMotorA.getOutputCurrent();
    }

    public double getCurrentShooterMotorB() {
        return 0;//shooterMotorB.getOutputCurrent();
    }

    // set motor PID values
    public void setPIDF(double p, double i, double d, double f) {
        /*shooterMotorA.setPID(p, i, d);
        shooterMotorA.setF(f);
        shooterMotorB.setPID(p, i, d);
        shooterMotorB.setF(f);*/
    }

}
