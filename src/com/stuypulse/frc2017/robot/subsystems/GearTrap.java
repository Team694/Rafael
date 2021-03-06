package com.stuypulse.frc2017.robot.subsystems;

import com.stuypulse.frc2017.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearTrap extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Solenoid gearTrap;
    private boolean trapped;

    public GearTrap() {
        gearTrap = new Solenoid(RobotMap.PCM, RobotMap.GEAR_TRAP_SOLENOID_PORT);
        trapped = true; // Starts out trapped
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    private void set(boolean trap) {
        gearTrap.set(!trap);
        // Setting the solenoid to `true` opens the trap and setting to `false`
        // closes it
        // The default position is closed
        trapped = trap;
    }

    public void trap() {
        set(true);
    }

    public void release() {
        set(false);
    }

    public boolean isTrapped() {
        return trapped;
    }
}
