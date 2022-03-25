package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.IntakeBack;

public class IntakeComBack extends CommandBase {
  double UpDownIntakeBack = 0;

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeBack AuxIntakeBack;
  public IntakeComBack(IntakeBack AIntakeBack, double AUpDownIntakeBack) {
    AuxIntakeBack = AIntakeBack;
    UpDownIntakeBack = AUpDownIntakeBack;
    addRequirements(AuxIntakeBack);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxIntakeBack.VelocityIntakeBack(UpDownIntakeBack);
  }

  @Override
  public void end(boolean interrupted) {
    AuxIntakeBack.VelocityIntakeBack(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
