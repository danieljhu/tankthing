
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  /** Creates a new Drive. */
  Drivetrain driveTrain;
  double power;
  double rotation;
  public Drive(Drivetrain driveTrain, double power, double rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.power = power;
    this.rotation  = rotation;
    //change
  }

  @Override
  public void initialize() {
    driveTrain.tankDrive(power, rotation);
    System.out.println("init");
  }

  @Override
  public void execute() {
    driveTrain.tankDrive(power, rotation);
    System.out.println("exec");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}