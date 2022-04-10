package frc.robot.commands.CargoCommands.Balls;

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
  public void initialize() {}

  @Override
  public void execute() {
    AuxShootPullBalls.VelocityPullBalls(AuxShootPull);

    if (AuxShootPullBalls.GetColorPBCargo().red > 100){
      CargoPresencePB = true; 
    }
    else {
      CargoPresencePB = false; 
    }
    AuxShootPullBalls.PresencePBCargo(CargoPresencePB);

    if (AuxShootUpBalls.GetColorUBCargo().red > 100){
      CargoPresenceUB = true; 
    }
    else {
      CargoPresenceUB = false; 
    }
    AuxShootUpBalls.PresenceUBCargo(CargoPresenceUB);

    if(!(CargoPresencePB && CargoPresenceUB)){
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
