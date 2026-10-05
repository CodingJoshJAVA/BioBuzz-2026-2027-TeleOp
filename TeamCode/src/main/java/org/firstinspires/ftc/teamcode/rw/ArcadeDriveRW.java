package org.firstinspires.ftc.teamcode.rw;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDriveRW {
    private DcMotor backLeft;
    private DcMotor frontLeft;

    private DcMotor backright;

    private DcMotor frontRight;

    public void init(HardwareMap hwMap) {
        hwMap.get(DcMotor.class, "BackLeft");
        hwMap.get(DcMotor.class, "FrontLeft");
        hwMap.get(DcMotor.class, "Backright");
        hwMap.get(DcMotor.class, "FrontRight");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);






    }
public void Drive(double throttle, double spin){
        double leftpwr = throttle + spin;
        double rightpwr = throttle - spin;

        double largest = Math.max(Math.abs(leftpwr), Math.abs(rightpwr));
        if(largest > 1.0){
            leftpwr /= largest;
            rightpwr /= largest;


        }
        backLeft.setPower(leftpwr);
    frontLeft.setPower(leftpwr);
    backright.setPower(rightpwr);
    frontRight.setPower(rightpwr);




}



}
