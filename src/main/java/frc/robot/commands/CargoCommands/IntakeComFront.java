package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.IntakeFront;

public class IntakeComFront extends CommandBase {
  double UpDownIntakeFront = 0;

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private IntakeFront AuxIntakeFront;
  public IntakeComFront(IntakeFront AIntakeFront, double AUpDownIntakeFront) {
  AuxIntakeFront = AIntakeFront;
  UpDownIntakeFront = AUpDownIntakeFront;
  addRequirements(AuxIntakeFront);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxIntakeFront.VelocityIntakeFront(UpDownIntakeFront);
  }

  @Override
  public void end(boolean interrupted) {
    AuxIntakeFront.VelocityIntakeFront(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
