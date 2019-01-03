
package org.usfirst.frc.team5230.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

// import edu.wpi.first.wpilibj.command.Command;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

public class Robot extends SampleRobot {
	int currentSession;
	int frontSession;
	int backSession;
	Image frame;
	CameraServer server;
	
    RobotDrive Robot;
    
    Joystick DriveStick;
    Joystick ButtonStick;
    
    Talon Defense;
   // DoubleSolenoid ArmLift;
    DoubleSolenoid Catapult;
    Talon Intake;
    DoubleSolenoid ArmClimb;
    //Talon Winch;
    
    public Robot() {
        Robot = new RobotDrive(3,4,2,1);
        Robot.setExpiration(0.1);
        DriveStick = new Joystick(0);
        ButtonStick = new Joystick(1);
        // ArmLift = new DoubleSolenoid (?,?);
        Intake = new Talon(5);
        Catapult = new DoubleSolenoid(0,7);
        ArmClimb = new DoubleSolenoid(1,2);
        Defense = new Talon(8);
        //winch = new talon 6 and 7??? How to. Make two separate in "operator control"?
      
    }
    
    public void robotInit() {
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	//frontcam = intake cam
    	frontSession = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	//backcam = shooting cam
    	backSession = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	currentSession = frontSession;
    	NIVision.IMAQdxConfigureGrab(currentSession);
    }

    public void autonomous() {
    	
    	Defense.set(1);

    	Robot.setSafetyEnabled(false);
    	Robot.drive(-0.8, 0.0); // Second value = curve (for turning)
    	Timer.delay(4.0);
    	Robot.drive(0.0, 0.0);
    	
    	}

    public void operatorControl() {
        Robot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	
        	
        	// DRIVE STRUFF
            if(DriveStick.getRawButton(6)) {
            	Robot.tankDrive(DriveStick.getRawAxis(5), DriveStick.getRawAxis(1));
            }	
            	else {
                	Robot.tankDrive(-DriveStick.getRawAxis(1),-DriveStick.getRawAxis(5));
                	
                }
           
            // CATAPULT
            if(ButtonStick.getRawButton(1)){
            	Catapult.set(DoubleSolenoid.Value.kForward);
            }
            else if(ButtonStick.getRawButton(2)){
            	Catapult.set(DoubleSolenoid.Value.kReverse);
            }
            else {
            	Catapult.set(DoubleSolenoid.Value.kOff); {
            }
            	
            // INTAKE
            if(ButtonStick.getRawButton(4)) {
            	Intake.set(.8);
            }
            else if(ButtonStick.getRawButton(5)) {
            	Intake.set(-1);
            }
            else {
            	Intake.stopMotor();
            }
            
            // CLIMBY
            if(ButtonStick.getRawButton(6)){
            	ArmClimb.set(DoubleSolenoid.Value.kForward);
            	}
            else if(ButtonStick.getRawButton(7)){
            	ArmClimb.set(DoubleSolenoid.Value.kReverse);
            	}
            else {
            	ArmClimb.set(DoubleSolenoid.Value.kOff); {}
            }
            	
            // winch stuff
            //if (buttonStick.getRawButton(10)){
            	//Winch.set(1);
            //}
            //else if (buttonStick.getRawButton(11)){
            	//Winch.set(-1);
            //}
            //else{
            	//Winch.stopMotor();
            //}
            
            
            // Defense Arm
            if (ButtonStick.getRawButton(8)){
            	Defense.set(-1);
            }
            else if (ButtonStick.getRawButton(9)){
            	Defense.set(1);
            }
            else {
            	Defense.stopMotor();
            }	
          
            
            // Camera
          NIVision.IMAQdxGrab(currentSession, frame, 2);
          CameraServer.getInstance().setImage(frame);           
           if(ButtonStick.getRawButton(3)) {
            	if(currentSession == frontSession) {
            		NIVision.IMAQdxStopAcquisition(currentSession);
            		currentSession = backSession;
            		NIVision.IMAQdxConfigureGrab(currentSession);
            	}
            	else if(currentSession == backSession) {
            		NIVision.IMAQdxStopAcquisition(currentSession);
            		currentSession = frontSession;
            		NIVision.IMAQdxConfigureGrab(currentSession);
            	}
           } 
            
          }    
         }
            Timer.delay(0.005);		// wait for a motor update time
      }

    

    public void test() {
    }
}
