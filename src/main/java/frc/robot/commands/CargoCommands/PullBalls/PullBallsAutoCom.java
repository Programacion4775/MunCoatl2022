package frc.robot.commands.CargoCommands.PullBalls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.PullBalls;

public class PullBallsAutoCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double PullBall; 

  private PullBalls AuxPullBallsAutoCom;
  public PullBallsAutoCom(PullBalls APullBallsAutoCom, double APullBall) {
    PullBall = APullBall;
    AuxPullBallsAutoCom = APullBallsAutoCom;
    addRequirements(AuxPullBallsAutoCom);
  }


  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxPullBallsAutoCom.VelocityPullBalls(PullBall);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
