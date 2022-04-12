package frc.robot.commands.HangCom.TelescopicoCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hang.Telescopico;

public class TelescopicoAutoZeroCom extends CommandBase {

  //Variables declaration//
  //Declaracion de variables//
  double TelZerPos = 0; 
  private boolean StopTelLim;

  //Link command with subsistem//
  //Unir comando con el subsitema//
  private final Telescopico AuxTelescopicoAutoZero; 
  public TelescopicoAutoZeroCom(Telescopico ATelescopicoAutoZero) {
    AuxTelescopicoAutoZero = ATelescopicoAutoZero; 
    StopTelLim = false; 
    addRequirements(AuxTelescopicoAutoZero);
  }

  @Override
  public void initialize() {
    AuxTelescopicoAutoZero.ResetEncoderTelescopicoR();
    AuxTelescopicoAutoZero.PIDResetTelescopico();
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("LimitPressed", AuxTelescopicoAutoZero.LimitSwitchTelescopico());
    TelZerPos = AuxTelescopicoAutoZero.EncoderTelescopicoR();
    AuxTelescopicoAutoZero.VelocityTelescopico(-1);
    StopTelLim = AuxTelescopicoAutoZero.LimitSwitchTelescopico();
  }

  @Override
  public void end(boolean interrupted) {
    AuxTelescopicoAutoZero.ResetEncoderTelescopicoR();
  }

  @Override
  public boolean isFinished() {
    return StopTelLim;
  }
}
