package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.Intake;

public class IntakeTriCom extends CommandBase {
  Intake AuxIntakeTri;
  public IntakeTriCom(Intake AuIntakeTri) {
    AuxIntakeTri=AuIntakeTri;
    addRequirements(AuxIntakeTri);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxIntakeTri.VelocityIntakeFront(RobotContainer.Control1.getRightTriggerAxis()*.8-RobotContainer.Control1.getLeftTriggerAxis()*.8);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
