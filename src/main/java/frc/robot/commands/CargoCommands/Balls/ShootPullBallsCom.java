package frc.robot.commands.CargoCommands.Balls;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.PullBalls;
import frc.robot.subsystems.Cargo.UpBalls;

public class ShootPullBallsCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double AuxShootPull = 0;
  boolean ShootPBFlag = false;  
  boolean CargoPresencePB = false; 
  boolean CargoPresenceUB = false; 
  private PullBalls AuxShootPullBalls; 
  private UpBalls AuxShootUpBalls; 
  public ShootPullBallsCom(PullBalls AShootPullBalls, UpBalls AShootUpBalls, double AShootPull) {
    AuxShootPullBalls = AShootPullBalls;
    AuxShootUpBalls = AShootUpBalls;
    AuxShootPull = AShootPull; 
    addRequirements(AuxShootPullBalls);
  }

  @Override
  public void initialize() {
    ShootPBFlag = false; 
  }

  @Override
  public void execute() {
    AuxShootPullBalls.VelocityPullBalls(AuxShootPull);


    if((AuxShootPullBalls.GetPresencePB() && AuxShootUpBalls.GetPresenceCargoUB())){
      ShootPBFlag = true;
    }
    }


  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return ShootPBFlag;
  }
}
