
package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.IntakeBack;
import frc.robot.subsystems.Cargo.IntakeFront;
import frc.robot.subsystems.Cargo.UpBalls;

public class UpBIntakeCom extends CommandBase {
  private IntakeBack AuxIntakeB;
  private IntakeFront AuxIntakeF;
  private UpBalls AuxUpB;
  public UpBIntakeCom(IntakeBack AIB, IntakeFront AIF, UpBalls AUP) {
    AuxIntakeB = AIB;
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
    AuxIntakeB.VelocityIntakeBack(-eje);
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
