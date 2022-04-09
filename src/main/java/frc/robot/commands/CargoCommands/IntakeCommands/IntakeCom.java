package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.Intake;

public class IntakeCom extends CommandBase {

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake AuxIntakeFront;
  public IntakeCom(Intake AIntakeFront) {
  AuxIntakeFront = AIntakeFront;
  addRequirements(AuxIntakeFront);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxIntakeFront.VelocityIntakeFront(RobotContainer.Control1.getRightTriggerAxis()-RobotContainer.Control1.getLeftTriggerAxis());
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
