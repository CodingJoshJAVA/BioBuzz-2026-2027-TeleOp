package org.firstinspires.ftc.teamcode.rw.mop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Console;

@TeleOp
public class DebugLayerTest extends OpMode {
    private Console console;
    Telemetry tm;

    public void init() {
        tm = telemetry;
        tm.setDisplayFormat(Telemetry.DisplayFormat.HTML);
        console = new Console(tm);
    }

    public void loop() {
        double fw = 0.825;
        double bw = 0;
        double sw = 0.4;

        console.log("Values", "FW: " + fw + " | BW: " + bw + " | SW: " + sw);
        tm.update();
    }
}
