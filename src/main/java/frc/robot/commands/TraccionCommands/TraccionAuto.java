package frc.robot.commands.TraccionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Traccion;

public class TraccionAuto extends CommandBase {

  double SetPointHorizontalRightTraccion = 0;
  double SetPointHorizontalLeftTraccion = 0; 
  double PositionFrontRightH = 0;
  double PositionFrontLeftH = 0; 
  double LOut = 0;
  double ROut = 0;
  boolean VerHorTra; 
  boolean FlagHorizontalTraccion = false;

//Link command with subsistem//
//Unir comando con el subsitema//
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private Traccion AuxTraccionAuto;
  public TraccionAuto(Traccion ATraccionAuto, boolean AVerHorTra, double ASetPointHorizontalRightTraccion, double ASetPointHorizontalLeftTraccion) {
    AuxTraccionAuto = ATraccionAuto;
    VerHorTra = AVerHorTra; 
    SetPointHorizontalRightTraccion = ASetPointHorizontalRightTraccion;
    SetPointHorizontalLeftTraccion = ASetPointHorizontalLeftTraccion;
    addRequirements(AuxTraccionAuto);
  }
  
  @Override
  public void initialize() {
    PositionFrontRightH = 0;
    PositionFrontLeftH = 0; 
    LOut = 0;
    ROut = 0;
    FlagHorizontalTraccion = false;
  }

  @Override
  public void execute() {
    PositionFrontRightH = AuxTraccionAuto.EncoderRightBackTraccion();
    if (Math.abs(SetPointHorizontalRightTraccion) - Math.abs(PositionFrontRightH) <= 5 && (Math.abs(SetPointHorizontalRightTraccion) - Math.abs(PositionFrontLeftH) <= 5)){
      FlagHorizontalTraccion = true;
      } 
        if (SetPointHorizontalLeftTraccion>0) {
          LOut = .25;
        }
        if(SetPointHorizontalLeftTraccion<0){        
          LOut= -.25;
        }
        if(SetPointHorizontalRightTraccion<0){        
          ROut = -.25;
        }
        if(SetPointHorizontalRightTraccion>0){        
          ROut = .25;
        }
        if (VerHorTra == true){
          AuxTraccionAuto.diferentialVel(ROut, LOut);
        }
        else if (VerHorTra == false){
          AuxTraccionAuto.LateralVelocity(ROut, LOut);
        }
  }

  @Override
  public void end(boolean interrupted) {
    AuxTraccionAuto.diferentialVel(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FlagHorizontalTraccion;
  }
}