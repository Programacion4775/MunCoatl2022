package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class ShooterComControl extends CommandBase {

//Link command with subsistem//
//Unir comando con el subsitema//
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private Shooter AuxShooter;
public ShooterComControl(Shooter AShooter) {
  AuxShooter = AShooter;
  addRequirements(AuxShooter);
}

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxShooter.VelocityShooter(RobotContainer.Control1.getRightTriggerAxis()-RobotContainer.Control1.getLeftTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
