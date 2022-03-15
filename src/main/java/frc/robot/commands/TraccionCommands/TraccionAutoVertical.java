// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.TraccionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Traccion;

public class TraccionAutoVertical extends CommandBase {
  double SetPointVerticalRightTraccion = 0;
  double SetPointVerticalLeftTraccion = 0; 
  double PositionFrontRightV = 0;
  double PositionFrontLeftV = 0; 
  double lPIDOut = 0;
  double rPIDOut = 0;
  boolean FlagVerticalTraccion = false;

//Link command with subsistem//
//Unir comando con el subsitema//
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private Traccion AuxTraccionAutoVertical;
  public TraccionAutoVertical(Traccion ATraccionAutoVertical, double ASetPointVerticalRightTraccion, double ASetPointVerticalLeftTraccion) {
    AuxTraccionAutoVertical = ATraccionAutoVertical;
    SetPointVerticalRightTraccion = ASetPointVerticalRightTraccion;
    SetPointVerticalLeftTraccion = ASetPointVerticalLeftTraccion;
    addRequirements(AuxTraccionAutoVertical);
  }

  @Override
  public void initialize() {
    lPIDOut = 0;
    rPIDOut = 0;
    PositionFrontRightV = 0;
    PositionFrontLeftV = 0; 
    FlagVerticalTraccion = false;
    AuxTraccionAutoVertical.EncodersReset();
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
    PositionFrontRightV = AuxTraccionAutoVertical.EncoderRightBackTraccion();
    PositionFrontLeftV = AuxTraccionAutoVertical.EncoderLeftBackTraccion();
    /*rPIDOut = AuxTraccionAutoVertical.PIDCalculateOutputFrontRightTraccion(PositionFrontRightV, SetPointVerticalRightTraccion);
    lPIDOut = AuxTraccionAutoVertical.PIDCalculateOutputFrontLeftTraccion(PositionFrontLeftV, SetPointVerticalLeftTraccion);
    if (Math.abs(SetPointVerticalRightTraccion - PositionFrontRightV ) <= 5 && (Math.abs(SetPointVerticalRightTraccion - PositionFrontLeftV) <= 5)){
      FlagVerticalTraccion = true;
      } 
    AuxTraccionAutoVertical.diferentialVel(rPIDOut, lPIDOut);*/
    if (Math.abs(SetPointVerticalRightTraccion) - Math.abs(PositionFrontRightV) <= 5 && (Math.abs(SetPointVerticalRightTraccion) - Math.abs(PositionFrontLeftV) <= 5)){
      FlagVerticalTraccion = true;
      } 
        if (SetPointVerticalLeftTraccion>0) {
            lPIDOut = .25;
        }
        if(SetPointVerticalLeftTraccion<0){        
          lPIDOut = -.25;
        }
        if(SetPointVerticalRightTraccion<0){        
          rPIDOut = -.25;
        }
        if(SetPointVerticalRightTraccion>0){        
          rPIDOut = .25;
        }
        AuxTraccionAutoVertical.diferentialVel(rPIDOut, lPIDOut);
  }

  @Override
  public void end(boolean interrupted) {
    AuxTraccionAutoVertical.diferentialVel(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FlagVerticalTraccion;
  }
}

