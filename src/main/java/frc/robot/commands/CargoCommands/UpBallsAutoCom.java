package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.UpBalls;

public class UpBallsAutoCom extends CommandBase {
  
//Variables declaration//
//Declaracion de variables//
double VelsUpBalls = 0; 
  private UpBalls AuxUpBallsAutoCom; 
  public UpBallsAutoCom(UpBalls AUpBallS, double AVelsUpBalls) {
    AuxUpBallsAutoCom = AUpBallS; 
    VelsUpBalls = AVelsUpBalls; 
    addRequirements(AuxUpBallsAutoCom);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxUpBallsAutoCom.VelocityUpBalls(VelsUpBalls);
  }

  @Override
  public void end(boolean interrupted) {
    AuxUpBallsAutoCom.VelocityUpBalls(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
