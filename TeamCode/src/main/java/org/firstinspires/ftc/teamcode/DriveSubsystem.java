package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


public class DriveSubsystem {
    //Motors vrm vrm
    DcMotorEx FL;
    DcMotorEx FR;
    DcMotorEx BL;
    DcMotorEx BR;

    //Constructor
    public DriveSubsystem(HardwareMap hardwareMap) {
        FL = hardwareMap.get(DcMotorEx.class, "frontLeft");
        FR = hardwareMap.get(DcMotorEx.class, "frontRight");
        BL = hardwareMap.get(DcMotorEx.class, "backLeft");
        BR = hardwareMap.get(DcMotorEx.class, "backRight");

        // Motor Directions spinny spinny yay
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        //Motor Breaks skdd
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //Driving Method vrm vrm
    public void drive(double x, double y, double turn) {
        double frontLeftPower = y + x + turn;
        double frontRightPower = y - x - turn;
        double backLeftPower = y - x + turn;
        double backRightPower = y + x - turn;

        double max = Math.max(1.0, Math.max(

                Math.abs(frontLeftPower),
                Math.max(
                        Math.abs(frontRightPower),
                        Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))
                )
        ));

        FL.setPower(frontLeftPower / max);
        FR.setPower(frontRightPower / max);
        BL.setPower(backLeftPower / max);
        BR.setPower(backRightPower / max);
    }

    //more method but finished pushing
    public void stop() {
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }
}













