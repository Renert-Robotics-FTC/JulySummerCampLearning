package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class NautilusArmSubsystem {

    private DcMotor armMotor;
    private final double kP = 0.05;
    private double target = 0;

    public NautilusArmSubsystem(HardwareMap hardwareMap) {
        armMotor = hardwareMap.get(DcMotor.class, "arm");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void target(double newTarget) {
        target = newTarget;
    }

    public void update(){
        double position = armMotor.getCurrentPosition();

        double error = target - position;
        double power = error * kP;

        armMotor.setPower(power);
    }

    public double getTarget() {
        return target;
    }

    public int getPosition(){
        return armMotor.getCurrentPosition();
    }

}
