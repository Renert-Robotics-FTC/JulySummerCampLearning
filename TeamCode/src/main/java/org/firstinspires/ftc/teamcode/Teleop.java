package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ExampleSubsystem Subsystem = new ExampleSubsystem(hardwareMap);
        ArmSubsystem Armsubsystem = new ArmSubsystem(hardwareMap);
        ClawSubsystem clawSubsystem = new ClawSubsystem(hardwareMap);
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);


        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        boolean clawOpen = false;
        boolean lastLB = false;

        while (opModeIsActive()) {

            //How to drive
            //Use left-stick for strafe and forwards
            //Right-stick determines turning
            double forward = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            driveSubsystem.drive(
                    forward,
                    strafe,
                    turn,
                    gamepad1.x
            );


            // Preset Positions, change these numbers to determine where the arm settings go
            // You only get 3 settings. You can add more if you would like but not recommended
            if (gamepad1.a) {
                Armsubsystem.setTargetPosition(0);
            }

            if (gamepad1.b) {
                Armsubsystem.setTargetPosition(500);
            }

            if (gamepad1.y) {
                Armsubsystem.setTargetPosition(1000);
            }

            // The left bumper controls the claw and this servo has 2 positions set
            //Check ClawSubsystem to change numerical values
            if (gamepad1.left_bumper && !lastLB) {

                clawOpen = !clawOpen;

                if (clawOpen) {
                    clawSubsystem.open();
                } else {
                    clawSubsystem.close();
                }
            }

            lastLB = gamepad1.left_bumper;

            // Run the PID every loop

            // Telemetry is constantly updating every time this part of the code runs in repeat

            Armsubsystem.update();

            telemetry.addData("Target", Armsubsystem.getTargetPosition());
            telemetry.addData("Current", Armsubsystem.getCurrentPosition());
            telemetry.addData("Power", Armsubsystem.getPower());

            telemetry.update();

        }
    }
}
