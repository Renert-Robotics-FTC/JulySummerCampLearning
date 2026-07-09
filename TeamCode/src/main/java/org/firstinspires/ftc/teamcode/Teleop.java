package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ClawSubsystem claw = new ClawSubsystem(hardwareMap);
        DriveSubsystem drive = new DriveSubsystem(hardwareMap);
        ArmSubsystem arm = new ArmSubsystem(hardwareMap);
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


            if (gamepad1.a)
                arm.setTarget(0);

            if (gamepad1.b)
                arm.setTarget(170);

            if (gamepad1.y)
                arm.setTarget(90);

        }



            telemetry.update();
        }
    }
