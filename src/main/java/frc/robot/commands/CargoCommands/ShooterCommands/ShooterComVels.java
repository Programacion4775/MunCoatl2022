package frc.robot.commands.CargoCommands.ShooterCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Cargo.Shooter;

public class ShooterComVels extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

//Variables declaration//
//Declaracion de variables//
  double VelsShooter = 0;
  double VelocityShooter = 0;
  double PIDOutShooter = 0; 
  boolean FlagShooter = false;

//Link command with subsistem//
//Unir comando con el subsitema//
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
    SmartDashboard.putNumber("azulval", AuxShooter.GetColor().blue);
    SmartDashboard.putData("Current alliance", Robot.AllianceCh);
    SmartDashboard.putBoolean("ShooterAct", true);
    SmartDashboard.putNumber("encoder shoot", AuxShooter.VelocityEncoderShooter());
    AuxShooter.VelocityShooter(VelsShooter);
    VelocityShooter = AuxShooter.VelocityEncoderShooter();
    /*PIDOutShooter = AuxShooter.PIDCalculateOutputShooter(VelocityShooter, VelsShooter);
    if (Math.abs(VelsShooter - VelocityShooter ) <= 15){
      FlagShooter = true;
      }*/
  }

  @Override
  public void end(boolean interrupted) {
    AuxShooter.VelocityShooter(0);
    SmartDashboard.putBoolean("ShooterAct", false);

  }

  @Override
  public boolean isFinished() {
    return FlagShooter;
  }
}
