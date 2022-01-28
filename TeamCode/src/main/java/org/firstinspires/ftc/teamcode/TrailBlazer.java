package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.gamepadex.DriverInterface;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadEventName;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadEventType;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadListener;
import org.firstinspires.ftc.teamcode.gamepadex.listener.GamepadType;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "TrailBlazer")
public class TrailBlazer extends TrailBlazerOpMode implements GamepadListener {


    public static Pose2d startPose = new Pose2d(0, 0, 0); //Editable via Dashboard...can it do Pose2d?
    private DriverInterface driverInterface;
    private List<Pose2d> trackedPoses = new ArrayList<Pose2d>(); //May need to make it not track every pose but track only the pose the driver wants
    private Pose2d currentPose;
    private SampleMecanumDrive sampleMecanumDrive;

    @Override
    public void onInit() {
        driverInterface = new DriverInterface(gamepad1, this);
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        currentPose = startPose;
    }

    @Override
    public void update() {
        driverInterface.update();

        updatePosition();


        telemetry.update();
    }


    private void updatePosition() {
        if (sampleMecanumDrive.getPoseEstimate() != currentPose) {

            /*
            //If ((A) is toggled on) {
            trackedPoses.add(currentPose);
            }
           */

            currentPose = sampleMecanumDrive.getPoseEstimate();
            telemetry.addData("Current Pose", currentPose);
        }
    }


    @Override
    public void actionPerformed(GamepadEventName eventName, GamepadEventType eventType, GamepadType gamepadType) {

        if (gamepadType == GamepadType.DRIVER && eventType == GamepadEventType.BUTTON_PRESSED) { // If button pressed on driver controller
            if (eventName == GamepadEventName.A) { //If it was button A


                telemetry.addData("Button A", "PRESSED");
            }
        }
    }
}
