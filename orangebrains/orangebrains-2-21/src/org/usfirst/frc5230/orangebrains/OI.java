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

import org.usfirst.frc5230.orangebrains.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc5230.orangebrains.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton winchpull;
    public JoystickButton winchrelease;
    public JoystickButton fullup;
    public JoystickButton fulldown;
    public Joystick driveStick;
    public JoystickButton trigger;
    public JoystickButton up1;
    public JoystickButton up2;
    public JoystickButton down1;
    public JoystickButton down2;
    public JoystickButton armRaise;
    public JoystickButton armlower;
    public JoystickButton triggerdown;
    public JoystickButton collect;
    public JoystickButton reversecollect;
    public Joystick buttonStick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonStick = new Joystick(1);
        
        reversecollect = new JoystickButton(buttonStick, 5);
        reversecollect.whileHeld(new reversegather());
        collect = new JoystickButton(buttonStick, 4);
        collect.whileHeld(new gather());
        triggerdown = new JoystickButton(buttonStick, 2);
        triggerdown.whenPressed(new ThrowDown());
        armlower = new JoystickButton(buttonStick, 9);
        armlower.whileHeld(new armdown());
        armRaise = new JoystickButton(buttonStick, 8);
        armRaise.whileHeld(new armUp());
        down2 = new JoystickButton(buttonStick, 11);
        down2.whenPressed(new L2down());
        down1 = new JoystickButton(buttonStick, 10);
        down1.whenPressed(new L1down());
        up2 = new JoystickButton(buttonStick, 6);
        up2.whenPressed(new L2up());
        up1 = new JoystickButton(buttonStick, 7);
        up1.whenPressed(new L1up());
        trigger = new JoystickButton(buttonStick, 1);
        trigger.whileHeld(new Throwup());
        driveStick = new Joystick(0);
        
        fulldown = new JoystickButton(driveStick, 1);
        fulldown.whileHeld(new L12down());
        fullup = new JoystickButton(driveStick, 4);
        fullup.whileHeld(new L12up());
        winchrelease = new JoystickButton(driveStick, 6);
        winchrelease.whileHeld(new wrelease());
        winchpull = new JoystickButton(driveStick, 5);
        winchpull.whileHeld(new wpull());


        // SmartDashboard Buttons
        SmartDashboard.putData("DriveStraight", new DriveStraight());
        SmartDashboard.putData("Rturn", new Rturn());
        SmartDashboard.putData("Lturn", new Lturn());
        SmartDashboard.putData("Throw up", new Throwup());
        SmartDashboard.putData("armUp", new armUp());
        SmartDashboard.putData("arm down", new armdown());
        SmartDashboard.putData("L1up", new L1up());
        SmartDashboard.putData("L2up", new L2up());
        SmartDashboard.putData("L1down", new L1down());
        SmartDashboard.putData("L2down", new L2down());
        SmartDashboard.putData("gather", new gather());
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("joystickDrive", new joystickDrive());
        SmartDashboard.putData("Throw Down", new ThrowDown());
        SmartDashboard.putData("w pull", new wpull());
        SmartDashboard.putData("w release", new wrelease());
        SmartDashboard.putData("reverse gather", new reversegather());
        SmartDashboard.putData("L12up", new L12up());
        SmartDashboard.putData("L12down", new L12down());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getButtonStick() {
        return buttonStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

