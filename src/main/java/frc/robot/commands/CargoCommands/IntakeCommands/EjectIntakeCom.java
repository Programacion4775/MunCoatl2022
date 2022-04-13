package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.EjectIntake;

public class EjectIntakeCom extends CommandBase {
  private EjectIntake AuxEjectIntake;
  
  public EjectIntakeCom(EjectIntake AEjectIntake) {
    AuxEjectIntake = AEjectIntake;
    addRequirements(AuxEjectIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    AuxEjectIntake.EjectReturnIntake(RobotContainer.Control3.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
