package com.stuypulse.frc2017.robot.cv;

import static com.stuypulse.frc2017.robot.CVConstants.CAMERA_FOCAL_LENGTH_Y;
import static com.stuypulse.frc2017.robot.CVConstants.REFLEXITE_LENGTH;

import org.opencv.core.Point;

import com.stuypulse.frc2017.robot.CVConstants;
import com.stuypulse.frc2017.util.Vector;

/**
 * We have three alignment routines, ordered by complexity:
 * 1, "bisect": Rotate halfway between the two reflexite strips (by the angle
 *  bisector), then drive onto the peg.
 * 2, "tip": Rotate to the *tip of the peg*, then drive forward.
 * 3, "twostep": Drive first to the perpendicular bisector of the lift, turn
 *  toward the lift, then run alignment method (1).
 *
 * The "bisect" method code works as of 2017-02-18, but is too inaccurate.
 * The "tip" method is our best bet (as of 2017-02-18).
 * The "twostep" method, while fancy and hypothetically the most reliable, may
 * be too slow anyway.
 */
public class LiftMath {
    /**
     * @param lift_left Position of the left edge of the lift
     * relative to the lift camera
     * @param lift_right Position of the right edge of the lift
     * relative to the lift camera
     * @param intermediate_dist Distance from the peg base (along the
     * lift's normal) which the bot should go to before rotating and
     * approaching the peg head-on.
     * @param final_dist Distance from the peg to stop at
     * @return Path along which the robot should move, expressed as an
     * array of vectors describing discrete linear movements.
     */
    public static Vector[] getPath(
            Vector lift_left,
            Vector lift_right,
            double intermediate_dist,
            double final_dist
            ) {
        // Get average distance between lift targets (approximate position of peg)
        Vector peg = lift_left.plus(lift_right).scaleBy(0.5);
        // Get distance between left and right lift strips
        Vector lift_ltr = lift_right.minus(lift_left);
        // Get vector from peg to point on our path where we stop and turn
        Vector from_peg = lift_ltr.rotateBy(90).withMagnitude(intermediate_dist);
        // Get vector from current location to point on our path where we stop and turn
        Vector m1 = peg.plus(from_peg);
        // Get vector from m1 to where the bot will stop, right in front of the peg.
        Vector m2 = from_peg.scaleBy(-1.0).withMagnitude(intermediate_dist - final_dist);
        return new Vector[] {m1, m2};
    }

    /**
     * @param stripY Center y-coordinate of reflexite strip.
     * @return Distance from camera to the reflexite strip.
     */
    public static double stripYToDistance(double stripY, double stripHeight) {
        return REFLEXITE_LENGTH * CAMERA_FOCAL_LENGTH_Y / stripHeight;
        // System.out.println("Argument to stripYToDistance is " + stripY);
    }

    public static double distance(Point first, Point second) {
        return Math.sqrt(Math.pow(first.x - second.x, 2) + Math.pow(first.y - second.y, 2));
    }

    /**
     * @param stripX Center x-coordinate of reflexite
     * @return Angle between where the camera is pointing and the reflexite stnrip.
     */
    public static double stripXToAngle(double stripX) {
        return Camera.frameXPxToDegrees(stripX);
    }

    public static Vector stripFramePosToPhysicalPos(double stripX, double stripY, double stripHeight){        //double imgHeight, boolean left) {
        //System.out.println("Horizontal Angle: " + stripXToAngle(stripX));
        //System.out.println("Perpendicular length: " + stripYToDistance(stripY, stripHeight));
    	//System.out.println("------------------------------------");
        return Vector.fromPolar(stripXToAngle(stripX), stripYToDistance(stripY, stripHeight));
    }
}
