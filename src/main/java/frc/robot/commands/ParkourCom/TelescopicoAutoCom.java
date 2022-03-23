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
    PositionTelescopico = AuxTelescopicoAuto.EncoderTelescopicoR(); //Get Telescopico Current Position////Obtener la posición actual del Telescopico//
    OutPutTelescopico = AuxTelescopicoAuto.PIDCalculateOutPutTelescopico(PositionTelescopico, SetPointTelescopico); //Calculate PID TelescopicoOutput//Clacular la salida PID del Telescopico//
    AuxTelescopicoAuto.VelocityTelescopicos(OutPutTelescopico); //Give that output to the motors//Darle esa salida al telescopico//
    ErrorTelescopico = SetPointTelescopico -  PositionTelescopico; 
    if(Math.abs(ErrorTelescopico) <= 30){
      FlagTelescopicoAuto = true;
    }
  }
  
  @Override
  public void end(boolean interrupted) {
    AuxTelescopicoAuto.PIDResetTelescopico();
  }

  @Override
  public boolean isFinished() {
    return FlagTelescopicoAuto;
  }
}
