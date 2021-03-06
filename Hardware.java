package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREVColorDistance;


/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 ***  Hardware Motor Controllers Settings ***
 RL Controller (AL025T7Z)
 0 - NeveRest 40 Gearmotor (FLMotor)
 RR Controller (AL025T80)
 1 - NeveRest 40 Gearmotor (FRMotor)
 FL Controller (A7008KTV)
 2 - NeveRest 40 Gearmotor (LRMotor)
 FR Controller (A7008KBB)
 3 - NeveRest 40 Gearmotor (RRMotor)
 */

public class Hardware

        /**Unnecessary values are left as examples -- DON'T DELETE */

{
    //Define values for servos
    public static final double stabbyIniOpen = 0.00;


    /* Public Motors */
    public DcMotor frontLeftMotor      = null;     // H2 channel 0     FLMotor
    public DcMotor frontRightMotor     = null;     // H2 channel 1     FRMotor
    public DcMotor rearLeftMotor       = null;     // H2 channel 2     RLMotor
    public DcMotor rearRightMotor      = null;     // H2 channel 3     RRMotor



    /* Public Servos */
    //public Servo markyBoi              = null;     // H3 servo 1        markyBoi
    //public Servo hookyBoi              = null;     // H2 servo 0        hookyBoi


    /* Public Sensors */
   // public TouchSensor cantTouchThis = null;    // H2 port 0        cantTouchThis



    /* local OpMode members. */
    HardwareMap hwMap             =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware(){

    }


    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {

        // Save reference to Hardware map
        hwMap = ahwMap;


        // Define and Initialize Motors
        frontLeftMotor  = ahwMap.get(DcMotor.class, "LF_Motor");
        frontRightMotor = ahwMap.get(DcMotor.class, "RF_Motor");
        rearLeftMotor   = ahwMap.get(DcMotor.class, "LR_Motor");
        rearRightMotor  = ahwMap.get(DcMotor.class,"RR_Motor");





        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

    }

    /***
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }


}
