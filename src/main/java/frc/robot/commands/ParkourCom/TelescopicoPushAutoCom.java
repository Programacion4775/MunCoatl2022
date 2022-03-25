/*package frc.robot.commands.ParkourCom;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Parkour.TelescopicoPush;

public class TelescopicoPushAutoCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double PositionTelescopicoPush = 0;
  double SetPointTelescopicoPush = 0; 
  double OutPutTelescopicoPush = 0; 
  double ErrorTelescopicoPush = 0;
  boolean FlagTelescopicoPushAuto = false; 

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TelescopicoPush AuxTelescopicoPushAuto; 
  public TelescopicoPushAutoCom(TelescopicoPush ATelescopicoPushAuto, double ASetPointTelescopicoPush) {
    AuxTelescopicoPushAuto = ATelescopicoPushAuto;
    SetPointTelescopicoPush = ASetPointTelescopicoPush;
    addRequirements(AuxTelescopicoPushAuto);
  }

  @Override
  public void initialize() {
    FlagTelescopicoPushAuto = false;
    AuxTelescopicoPushAuto.PIDResetTelescopico();
  }

  @Override
  public void execute() {
    PositionTelescopicoPush = AuxTelescopicoPushAuto.EncoderTelescopicoPush(); //Get Telescopico Current Position////Obtener la posición actual del Telescopico//
    OutPutTelescopicoPush = AuxTelescopicoPushAuto.PIDCalculateOutPutTelescopicoPush(PositionTelescopicoPush, SetPointTelescopicoPush); //Calculate PID TelescopicoOutput//Clacular la salida PID del Telescopico//
    AuxTelescopicoPushAuto.VelocityTelescopicoPushR(OutPutTelescopicoPush); //Give that output to the motors//Darle esa salida al telescopico//
    AuxTelescopicoPushAuto.VelocityTelescopicoPushL(OutPutTelescopicoPush); 
    ErrorTelescopicoPush = SetPointTelescopicoPush - PositionTelescopicoPush;
    if (Math.abs(ErrorTelescopicoPush)<=30){
      FlagTelescopicoPushAuto = true;
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return FlagTelescopicoPushAuto;
  }
}
*/