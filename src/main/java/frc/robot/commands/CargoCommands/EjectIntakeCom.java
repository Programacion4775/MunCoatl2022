
package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.EjectIntake;

public class EjectIntakeCom extends CommandBase {
  private EjectIntake AuxEjectIntake;
  public EjectIntakeCom(EjectIntake aEjectIntake){
    AuxEjectIntake = aEjectIntake;
    addRequirements(AuxEjectIntake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
