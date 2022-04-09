package frc.robot.commands.CargoCommands.UpBalls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.UpBalls;

public class UpBallsCom extends CommandBase {
  private UpBalls AuxUpBalls;
  public UpBallsCom(UpBalls AUpBalls) {
    AuxUpBalls = AUpBalls;
    addRequirements(AuxUpBalls);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxUpBalls.VelocityUpBalls(RobotContainer.Control1.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}

