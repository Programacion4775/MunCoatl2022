package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterComVels extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double VelsShooter = 0;
  double SetPointShooter = 0;
  double VelocityShooter = 0;
  double PIDOutShooter = 0; 
  boolean FlagShooter = false;

//Link command with subsistem//
//Unir comando con el subsitema//
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Shooter AuxShooter;
  public ShooterComVels(Shooter AShooter, double AVelsShooter) {
    AuxShooter = AShooter;
    VelsShooter = AVelsShooter;
    addRequirements(AuxShooter);
  }

  @Override
  public void initialize() {
    FlagShooter = false;
    AuxShooter.PIDResetShooter();
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("ShooterAct", true);
    VelocityShooter = AuxShooter.VelocityEncoderShooter();
    PIDOutShooter = AuxShooter.PIDCalculateOutputShooter(VelocityShooter, VelsShooter);
    AuxShooter.VelocityShooter(PIDOutShooter);
    if (Math.abs(SetPointShooter - VelocityShooter ) <= 15){
      FlagShooter = true;
      }
  }

  @Override
  public void end(boolean interrupted) {
    AuxShooter.VelocityShooter(0);
    SmartDashboard.putBoolean("ShooterAct", false);

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
