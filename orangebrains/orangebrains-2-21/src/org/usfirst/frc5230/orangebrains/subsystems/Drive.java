// RobotBuilder Version: 2.0


package org.usfirst.frc5230.orangebrains.subsystems;

import org.usfirst.frc5230.orangebrains.commands.joystickDrive;
import org.usfirst.frc5230.orangebrains.Robot;
import org.usfirst.frc5230.orangebrains.RobotMap;
import org.usfirst.frc5230.orangebrains.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rfrontmotor = RobotMap.driveRfrontmotor;
    private final SpeedController rrearmotor = RobotMap.driveRrearmotor;
    private final SpeedController lfrontmotor = RobotMap.driveLfrontmotor;
    private final SpeedController lrearmotor = RobotMap.driveLrearmotor;
    private final RobotDrive robotDrive41 = RobotMap.driveRobotDrive41;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {

 
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new joystickDrive());
    	
    }
 
    public void takeJoystickInputs(Joystick leftStick, final int leftAxis, Joystick rightStick, final int rightAxis){
    	robotDrive41.tankDrive(leftStick, leftAxis, rightStick, rightAxis);
    }
    public void arcadeDrive(Joystick stick) {
    	robotDrive41.arcadeDrive(stick);
    }
    
    public void stop() {
    	robotDrive41.drive(0, 0);
    }
    
    public void driveStraight(double speed) {
    	robotDrive41.tankDrive(speed, speed);
    }
    
    public void turnLeft(double speed) {
    	robotDrive41.tankDrive(speed, 0);
    }

    public void turnRight(double speed) {
    	robotDrive41.tankDrive(0, speed);
    }

}

