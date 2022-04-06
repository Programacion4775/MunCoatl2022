
package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.Intake;
import frc.robot.subsystems.Cargo.UpBalls;

public class UpBIntakeCom extends CommandBase {
  private Intake AuxIntakeF;
  private UpBalls AuxUpB;
  public UpBIntakeCom(Intake AIF, UpBalls AUP) {
    AuxIntakeF = AIF;
    AuxUpB = AUP;
    addRequirements(AuxUpB);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double eje = RobotContainer.Control1.getLeftY();
    AuxIntakeF.VelocityIntakeFront(-eje);
    AuxUpB.VelocityUpBalls(eje);
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
