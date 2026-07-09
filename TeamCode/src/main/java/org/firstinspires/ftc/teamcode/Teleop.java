package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ClawSubsystem claw = new ClawSubsystem(hardwareMap);

        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {


            ClawSubsystem Claw;
            if (gamepad1.x) {
                claw.closeClaw();
            } else {
                claw.openClaw();
            }



            telemetry.update();
        }
    }
}