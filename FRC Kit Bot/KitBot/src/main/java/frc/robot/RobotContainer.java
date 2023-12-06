// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.DriveTank;

public class RobotContainer {

  Drivetrain driveTrain = new Drivetrain();
  DigitalInput digitalInput = new DigitalInput(Constants.LINE_BREAKER_PORT); 
  

  XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  
  public RobotContainer() {

    configureBindings();
    driveTrain.setDefaultCommand(new DriveTank(driveTrain, xboxController::getRightY, xboxController::getLeftY));
    driveTrain.putNumbers();
  }

  private void configureBindings() {
      new JoystickButton(xboxController, Button.kRightBumper.value).whileTrue(new DriveTank(driveTrain, xboxController :: getRightY, xboxController::getLeftY));
      new JoystickButton(xboxController, Button.kLeftBumper.value).whileTrue(new DriveTank(driveTrain, xboxController :: getRightY, xboxController::getLeftY));
  }
}