package frc.robot.commands.CargoCommands.Balls;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.PullBalls;
import frc.robot.subsystems.Cargo.UpBalls;

public class ShootUpBallsCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double AuxShootUp = 0;
  double AuxShootSPull =0; 
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
    SmartDashboard.putBoolean("Verde", true);
    SmartDashboard.putBoolean("presence", AuxShootSUpBalls.GetPresenceCargoUB());
    SmartDashboard.putBoolean("presencep", AuxShootSPullBalls.GetPresencePB());
    AuxShootSUpBalls.VelocityUpBalls(AuxShootUp);
    AuxShootSPullBalls.VelocityPullBalls(AuxShootSPull);


    if (AuxShootSUpBalls.GetPresenceCargoUB()){
      AuxShootSPullBalls.VelocityPullBalls(0);
    }
  }



  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Verde", false);
    AuxShootSPullBalls.VelocityPullBalls(0);
    AuxShootSUpBalls.VelocityUpBalls(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
