package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ClawSubsystem claw = new ClawSubsystem(hardwareMap);
        DriveSubsystem drive = new DriveSubsystem(hardwareMap);
        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            DriveSubsystem Drive;


            ClawSubsystem Claw;
            if (gamepad1.x) {
                claw.closeClaw();
            } else {
                claw.openClaw();

            }
            drive.updateInputs(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            }



            telemetry.update();
        }
    }
