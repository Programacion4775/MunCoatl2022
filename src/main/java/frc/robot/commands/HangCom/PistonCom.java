package frc.robot.commands.HangCom;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hang.Piston;

public class PistonCom extends CommandBase {
  
  //Variables declaration//
  //Declaracion de variables//
  boolean PistonOC = false;

  //Link command with subsistem//
  //Unir comando con el subsitema//
  private final Piston AuxPiston; 
  public PistonCom(Piston APiston, Boolean APistonOC) {
    AuxPiston = APiston;
    PistonOC = APistonOC;
    addRequirements(AuxPiston);
  }

  @Override
  public void initialize() {
    AuxPiston.OpenClosePiston(PistonOC);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
