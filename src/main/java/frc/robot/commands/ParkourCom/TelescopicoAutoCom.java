package frc.robot.commands.ParkourCom;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Parkour.Telescopico;

public class TelescopicoAutoCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double PositionTelescopico = 0;
  double SetPointTelescopico = 0; 
  double OutPutTelescopico = 0; 
  double ErrorTelescopico = 0;
  boolean FlagTelescopicoAuto = false; 

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Telescopico AuxTelescopicoAuto;
  public TelescopicoAutoCom(Telescopico ATelescopicoAuto, double ASetPointTelescopico){
    AuxTelescopicoAuto = ATelescopicoAuto; 
    SetPointTelescopico = ASetPointTelescopico;
    addRequirements(AuxTelescopicoAuto);
  }

  @Override
  public void initialize() {
    FlagTelescopicoAuto = false; 
    AuxTelescopicoAuto.PIDResetTelescopico();
  }

  @Override
  public void execute() {
    PositionTelescopico = AuxTelescopicoAuto.EncoderTelescopicoR();
    OutPutTelescopico = AuxTelescopicoAuto.PIDCalculateOutPutTelescopico(PositionTelescopico, SetPointTelescopico);
    AuxTelescopicoAuto.VelocityTelescopicos(OutPutTelescopico);
    ErrorTelescopico = SetPointTelescopico -  PositionTelescopico; 
    if(Math.abs(ErrorTelescopico) <= 30){
      FlagTelescopicoAuto = true;
    }
  }
  
  @Override
  public void end(boolean interrupted) {
    AuxTelescopicoAuto.PIDResetTelescopico();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FlagTelescopicoAuto;
  }
}
