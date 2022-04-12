package frc.robot.commands.CargoCommands.Balls;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    AuxUpBalls.VelocityUpBalls(-RobotContainer.Control1.getLeftY());
  }

  @Override
  public void end(boolean interrupte2d) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}

