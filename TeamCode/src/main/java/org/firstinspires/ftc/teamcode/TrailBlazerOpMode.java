package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class TrailBlazerOpMode extends LinearOpMode {


    protected void onInit() {
    }

    protected void initLoop() {
    }

    protected void onMount() {
    }

    protected void update() {
    }

    protected void onStop() {
    }

    @Override
    public void runOpMode() throws InterruptedException {


        onInit();


        while (!isStarted() && !isStopRequested()) {

            initLoop();
        }


        onMount();

        while (opModeIsActive() && !isStopRequested()) {

            update();
        }


        onStop();
    }
}

