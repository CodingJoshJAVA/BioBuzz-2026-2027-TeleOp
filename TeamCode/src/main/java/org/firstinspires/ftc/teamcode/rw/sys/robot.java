package org.firstinspires.ftc.teamcode.rw.sys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.*;

public class robot {
    private DcMotor br;
    private DcMotor bl;
    private DcMotor fr;
    private DcMotor fl;
    private DcMotor in;
    private DcMotor out;
    Map<String, MotorEquation> kinematics = new HashMap<>();

    public void init(HardwareMap hwMap) {
        // Touch

        // Motors
        br = hwMap.get(DcMotor.class, "BackRight");
        bl = hwMap.get(DcMotor.class, "BackLeft");
        fr = hwMap.get(DcMotor.class, "FrontRight");
        fl = hwMap.get(DcMotor.class, "FrontLeft");
        in = hwMap.get(DcMotor.class, "Intake");
        out = hwMap.get(DcMotor.class, "Outtake");

        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        in.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        out.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);

        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Motor Equations
        kinematics.put("br", (fb, st, cw) -> fb - st + cw);
        kinematics.put("bl", (fb, st, cw) -> fb + st - cw);
        kinematics.put("fr", (fb, st, cw) -> fb - st - cw);
        kinematics.put("fl", (fb, st, cw) -> fb + st + cw);
    }

    @FunctionalInterface
    public interface MotorEquation { double calculate(double fb, double st, double cw); }

    public void drive(double fb, double st, double cw) {
        double flSpeed = Objects.requireNonNull(kinematics.get("fl")).calculate(fb, st, cw);
        double frSpeed = Objects.requireNonNull(kinematics.get("fr")).calculate(fb, st, cw);
        double blSpeed = Objects.requireNonNull(kinematics.get("bl")).calculate(fb, st, cw);
        double brSpeed = Objects.requireNonNull(kinematics.get("br")).calculate(fb, st, cw);

        // Prevent limit passing //
        double max = Math.max(Math.abs(flSpeed), Math.abs(frSpeed));
        max = Math.max(max, Math.abs(blSpeed));
        max = Math.max(max, Math.abs(brSpeed));

        if (max > 1.0) {
            flSpeed /= max;
            frSpeed /= max;
            blSpeed /= max;
            brSpeed /= max;
        }
        //==========================//

        if (fl != null) fl.setPower(flSpeed);
        if (fr != null) fr.setPower(frSpeed);
        if (bl != null) bl.setPower(blSpeed);
        if (br != null) br.setPower(brSpeed);
    }

    public void take(String inout, double takePower) {
        if (inout == "in") {
            in.setPower(takePower);
        } else if (inout == "out") {
            out.setPower(takePower);
        }
    }
}
