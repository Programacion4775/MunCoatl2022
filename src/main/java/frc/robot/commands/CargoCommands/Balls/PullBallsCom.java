package frc.robot.commands.CargoCommands.Balls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.PullBalls;

public class PullBallsCom extends CommandBase {
  private PullBalls AuxPullBalls; 
  public PullBallsCom(PullBalls APullBalls) {
    AuxPullBalls = APullBalls;
    addRequirements(AuxPullBalls);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxPullBalls.VelocityPullBalls(RobotContainer.Control1.getRightY());
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
