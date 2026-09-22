package org.firstinspires.ftc.teamcode.rw.mop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class PGamepadVals extends OpMode {
    @Override
    public void init() {}

    @Override
    public void loop() {
        double sf = -gamepad1.left_stick_y;
        telemetry.addData("x", sf);
        telemetry.addData("y", gamepad1.left_stick_y);
        telemetry.addData("a", gamepad1.a);
    }
}
