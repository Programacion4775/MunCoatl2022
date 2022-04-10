package frc.robot.commands.CargoCommands.Balls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.PullBalls;
import frc.robot.subsystems.Cargo.UpBalls;

public class ShootUpBallsCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double AuxShootUp = 0;
  double AuxShootSPull =0; 
  boolean CargoPresenceSPB = false; 
  boolean CargoPresenceSUB = false; 
  private UpBalls AuxShootSUpBalls; 
  private PullBalls AuxShootSPullBalls; 
  public ShootUpBallsCom(UpBalls AShootSUpBalls, PullBalls AShootSPullBalls, double AShootUp, double AShootSPull) {
    AuxShootSUpBalls = AShootSUpBalls;
    AuxShootSPullBalls = AShootSPullBalls;
    AuxShootUp = AShootUp; 
    AuxShootSPull = AShootSPull; 
    addRequirements(AuxShootSUpBalls);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxShootSUpBalls.VelocityUpBalls(AuxShootUp);

    if (AuxShootSUpBalls.GetColorUBCargo().red > 100){
      CargoPresenceSUB = true; 
      AuxShootSPullBalls.VelocityPullBalls(0);
    }
    else {
      CargoPresenceSUB = false; 
      AuxShootSPullBalls.VelocityPullBalls(AuxShootSPull);
    }
    }



  @Override
  public void end(boolean interrupted) {
    AuxShootSPullBalls.VelocityPullBalls(0);
    AuxShootSUpBalls.VelocityUpBalls(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
