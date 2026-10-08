package org.firstinspires.ftc.teamcode.rw;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDriveRW {
    private DcMotor BackLeft;
    private DcMotor FrontLeft;

    private DcMotor BackRight;

    private DcMotor FrontRight;

    public void init(HardwareMap hwMap) {
        hwMap.get(DcMotor.class, "BackLeft");
        hwMap.get(DcMotor.class, "FrontLeft");
        hwMap.get(DcMotor.class, "Backright");
        hwMap.get(DcMotor.class, "FrontRight");

        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);






    }
public void Drive(double throttle, double spin){
        double leftpwr = throttle + spin;
        double rightpwr = throttle - spin;

        double largest = Math.max(Math.abs(leftpwr), Math.abs(rightpwr));
        if(largest > 1.0){
            leftpwr /= largest;
            rightpwr /= largest;


        }
        BackLeft.setPower(leftpwr);
    FrontLeft.setPower(leftpwr);
    BackRight.setPower(rightpwr);
    FrontRight.setPower(rightpwr);




}



}
