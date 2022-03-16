package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.UpBalls;

public class UpBallsAutoCom extends CommandBase {
  private UpBalls AuxUpBalls;
  double Up = 0;
  public UpBallsAutoCom(UpBalls AUpBalls, double AUp) {
    AuxUpBalls = AUpBalls;
    Up = AUp;
    addRequirements(AuxUpBalls);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxUpBalls.VelocityUpBalls(Up);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
