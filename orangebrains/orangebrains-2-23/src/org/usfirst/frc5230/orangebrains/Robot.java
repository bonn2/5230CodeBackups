// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5230.orangebrains;


import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import java.awt.Frame;

import org.usfirst.frc5230.orangebrains.commands.*;
import org.usfirst.frc5230.orangebrains.subsystems.*;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	int session;
	int frontsession;
	int backsession;
	Image frame;
	
	CameraServer server;

	Command autonomousCommand;
	SendableChooser autoChooser;
	
	Joystick driveStick;
	Joystick buttonStick;
	
	

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drive drive;
    public static catapult catapult;
    public static armlift armlift;
    public static armclimb armclimb;
    public static Intakewheels intakewheels;
    public static Winch winch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	 
    	 frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

         // the camera name (ex "cam0") can be found through the roborio web interface
    	 backsession = NIVision.IMAQdxOpenCamera("cam0", 
                 NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	 frontsession = NIVision.IMAQdxOpenCamera("cam1", 
    			 NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    	 session = frontsession;
         NIVision.IMAQdxConfigureGrab(session);
         
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drive = new Drive();
        catapult = new catapult();
        armlift = new armlift();
        armclimb = new armclimb();
        intakewheels = new Intakewheels();
        winch = new Winch();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        autonomousCommand = new AutonomousCommand();
        SendableChooser autonomousModes;//puts to sender??
        

        // instantiate the command used for the autonomous period
 autonomousModes = new SendableChooser();
 
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new autongr1();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
		// schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();//put something here maybe whoknows
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	 if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
   
    public Robot() {
    	
    	 
    }
    public void operatorControl() {
    	 
    	 CameraServer.getInstance().setImage(frame);

         /**
          * grab an image, draw the circle, and provide it for the camera server
          * which will in turn send it to the dashboard.
          */
         NIVision.Rect rect = new NIVision.Rect(200, 275, 100, 100);

    	while (isOperatorControl() && isEnabled()) {
            /** robot code here! **/
            Timer.delay(0.0001);		// wait for a motor update time
            NIVision.IMAQdxGrab(session, frame, 1);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            CameraServer.getInstance().setImage(frame);
            
            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
            
            CameraServer.getInstance().setImage(frame);
            
    	}
    	NIVision.IMAQdxGrab(session, frame, 1);
    	CameraServer.getInstance().setImage(frame);
    	
    	if(driveStick.getRawButton(2)){
    		if (session == frontsession){
    			session = backsession;
    			NIVision.IMAQdxConfigureGrab(session);
    		}
    		else if (session == backsession){
    			session = frontsession;
    			NIVision.IMAQdxConfigureGrab(session);
    			
    		}
    	}
    }

     public void test() {
        }
    }
    