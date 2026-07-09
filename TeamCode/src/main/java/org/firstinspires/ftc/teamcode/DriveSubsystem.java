package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


public class DriveSubsystem {
//Motors vrm vrm
    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;

    //Constructor
    public DriveSubsystem(HardwareMap hardwareMap) {
        frontLeft=hardwareMap.get(DcMotorEx.class,"frontLeft");
        frontRight=hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft=hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight=hardwareMap.get(DcMotorEx.class, "backRight");

        // Motor Directions spinny spinny yay
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        //Motor Breaks skdd
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




    }

}


