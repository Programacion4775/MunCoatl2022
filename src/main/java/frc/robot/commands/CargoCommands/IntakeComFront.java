package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.IntakeFront;

public class IntakeComFront extends CommandBase {

  double UpDownIntakeFront = 0;

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeFront AuxIntakeIn;
  public IntakeComFront(IntakeFront AIntake, double AUpDownIntakeFront) {
  AuxIntakeIn = AIntake;
  UpDownIntakeFront = AUpDownIntakeFront;
  addRequirements(AuxIntakeIn);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxIntakeIn.VelocityIntakeFront(UpDownIntakeFront);
  }

  @Override
  public void end(boolean interrupted) {
    AuxIntakeIn.VelocityIntakeFront(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
