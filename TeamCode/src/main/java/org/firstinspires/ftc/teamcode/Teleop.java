package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {
    private ClawSubsystem claw;
    private NautilusArmSubsystem arm;
    private DriveSubsystem drive;


    @Override
    public void runOpMode() {
        //initialize this bs
        claw=new ClawSubsystem(hardwareMap);
        arm=new NautilusArmSubsystem(hardwareMap);
        drive=new DriveSubsystem(hardwareMap);


        waitForStart();

        while (opModeIsActive()) {

            //drive bs
            double y=-gamepad1.left_stick_y;
            double x=gamepad1.left_stick_x;
            double turn=gamepad1.right_stick_x;
            drive.drive(x,y,turn);

            //arm bs
            arm.update();

            // Open the damn claw
            if (gamepad1.a) {
                claw.open();
            }
            if (gamepad1.b){
                claw.close();
            }

            telemetry.addData("A", "Open Claw");
            telemetry.addData("B", "Close Claw");
            telemetry.update();

            //More arm bs
            telemetry.addData("Arm Position",arm.getPosition());
            telemetry.addData("Arm Target",arm.getTarget());
            telemetry.update();

            //Move the fuckass arm
            if (gamepad2.a) {
                arm.target(0);
            }
            if (gamepad2.a) {
                arm.target(50);
            }
            if (gamepad2.y) {
                arm.target(100);
            }
            arm.update();

            }


        }


    }











