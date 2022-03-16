package frc.robot.commands.TraccionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Traccion;

public class TraccionAutoHorizontal extends CommandBase {

  double SetPointHorizontalRightTraccion = 0;
  double SetPointHorizontalLeftTraccion = 0; 
  double PositionFrontRightH = 0;
  double PositionFrontLeftH = 0; 
  double lPIDOuth = 0;
  double rPIDOuth = 0;
  boolean FlagHorizontalTraccion = false;

//Link command with subsistem//
//Unir comando con el subsitema//
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private Traccion AuxTraccionAutoHorizontal;
  public TraccionAutoHorizontal(Traccion ATraccionAutoHorizontal, double ASetPointHorizontalRightTraccion, double ASetPointHorizontalLeftTraccion) {
    AuxTraccionAutoHorizontal = ATraccionAutoHorizontal;
    SetPointHorizontalRightTraccion = ASetPointHorizontalRightTraccion;
    SetPointHorizontalLeftTraccion = ASetPointHorizontalLeftTraccion;
    addRequirements(AuxTraccionAutoHorizontal);
  }
  
  @Override
  public void initialize() {
    lPIDOuth = 0;
    rPIDOuth = 0;
    PositionFrontRightH = 0;
    PositionFrontLeftH = 0; 
    FlagHorizontalTraccion = false;
    //AuxTraccionAutoVertical.PIDResetFrontRightTraccion();
    //AuxTraccionAutoVertical.PIDResetFrontLeftTraccion();
  }

  @Override
  public void execute() {
    /*SmartDashboard.putNumber("derecha", rPIDOut);
    SmartDashboard.putNumber("izquierda", lPIDOut);
    SmartDashboard.putNumber("encoderdere", PositionFrontRightV);
    SmartDashboard.putNumber("encodeizq", PositionFrontLeftV);
    SmartDashboard.putBoolean("flagtraccion", FlagVerticalTraccion);*/
    PositionFrontRightH = AuxTraccionAutoHorizontal.EncoderRightBackTraccion();
    PositionFrontLeftH = AuxTraccionAutoHorizontal.EncoderLeftBackTraccion();
    /*rPIDOut = AuxTraccionAutoVertical.PIDCalculateOutputFrontRightTraccion(PositionFrontRightV, SetPointVerticalRightTraccion);
    lPIDOut = AuxTraccionAutoVertical.PIDCalculateOutputFrontLeftTraccion(PositionFrontLeftV, SetPointVerticalLeftTraccion);
    if (Math.abs(SetPointVerticalRightTraccion - PositionFrontRightV ) <= 5 && (Math.abs(SetPointVerticalRightTraccion - PositionFrontLeftV) <= 5)){
      FlagVerticalTraccion = true;
      } 
    AuxTraccionAutoVertical.diferentialVel(rPIDOut, lPIDOut);*/
    if (Math.abs(SetPointHorizontalRightTraccion) - Math.abs(PositionFrontRightH) <= 5 && (Math.abs(SetPointHorizontalRightTraccion) - Math.abs(PositionFrontLeftH) <= 5)){
      FlagHorizontalTraccion = true;
      } 
        if (SetPointHorizontalLeftTraccion>0) {
            lPIDOuth = .25;
        }
        if(SetPointHorizontalLeftTraccion<0){        
          lPIDOuth= -.25;
        }
        if(SetPointHorizontalRightTraccion<0){        
          rPIDOuth = -.25;
        }
        if(SetPointHorizontalRightTraccion>0){        
          rPIDOuth = .25;
        }
        AuxTraccionAutoHorizontal.diferentialVel(rPIDOuth, lPIDOuth);
  }

  @Override
  public void end(boolean interrupted) {
    AuxTraccionAutoHorizontal.diferentialVel(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FlagHorizontalTraccion;
  }
}



