/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static int DRIVER_CONTROLLER = 0;
    public static int OPERATOR_CONTROLLER = 1;
    public static double AXIS_THRESHOLD = 0.15;
    
    public static int LEFT_X = 0;
    public static int LEFT_Y = 1;
    public static int LEFT_TRIGGER = 2;
    public static int RIGHT_TRIGGER = 3;
    public static int RIGHT_X = 4;
    public static int RIGHT_Y = 5;
    public static int A_BUTTON = 1;
    public static int B_BUTTON = 2;
    public static int X_BUTTON = 3;
    public static int Y_BUTTON = 4;
    public static int LEFT_SHOULDER = 5;
    public static int RIGHT_SHOULDER = 6;
    public static int SELECT_BUTTON = 7;
    public static int START_BUTTON = 8;
    public static int LS_PUSH = 9;
    public static int RS_PUSH = 10;

    public static int FRONT_LEFT_MOTOR = 1;
    public static int FRONT_RIGHT_MOTOR = 4;
    public static int REAR_LEFT_MOTOR = 2;
    public static int REAR_RIGHT_MOTOR = 3;

    public static int SHOOTER_MOTOR = 10;
    public static int BELT_LOOP_MOTOR = 11;
    public static int INTAKE_MOTOR = 12;
    
    public static int LEFT_DRIVE_ENCODER_1 = 0;
    public static int LEFT_DRIVE_ENCODER_2 = 1;
    public static int RIGHT_DRIVE_ENCODER_1 = 2;
    public static int RIGHT_DRIVE_ENCODER_2 = 3;

    // we put encoder declarations in their own class
    public static class Drivebase {

            public static double kP = 1.0;
            public static double kI = 0.0;
            public static double kD = 0.0;

            public static int PULSE_PER_REVOLUTION = 360;
            public static double DRIVE_GEAR_RATIO = 5.95/1.0;
            public static double ENCODER_GEAR_RATIO = 1.0;
            public static double FUDGE_FACTOR = 0.5;
            public static double DRIVE_WHEEL_DIAMETER = 6; // in inches
            public static double DISTANCE_PER_PULSE = (Math.PI * DRIVE_WHEEL_DIAMETER/ PULSE_PER_REVOLUTION /
                                                        ENCODER_GEAR_RATIO / DRIVE_GEAR_RATIO) * FUDGE_FACTOR;
    
        }

    public static class Shooter {

        public static double kP = 1.0; // need to measure
        public static double kI = 0.0; // need to measure
        public static double kD = 0.0; // need to measure

        public static double FREE_RPM = 5000; // need to measure
        public static double TARGET_RPM = 4000; // need to measure
        public static double RPM_TOLERENCE = 50;

        public static int DISTANCE_PER_PULSE = 1000; // need to measure
        public static double INCREMENTAL_VOLTS = 0.5;
        public static double VOLT_PER_ROTATION = 12.0 / FREE_RPM;

    }

}
