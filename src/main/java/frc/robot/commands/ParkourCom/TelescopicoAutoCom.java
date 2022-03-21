package frc.robot.commands.ParkourCom;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Parkour.Telescopico;

public class TelescopicoAutoCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double PositionTelescopico = 0;
  double SetPointTelescopico = 0; 
  double OutPutTelescopico = 0; 

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Telescopico AuxTelescopicoAuto;
  public TelescopicoAutoCom(Telescopico ATelescopicoAuto) {
    AuxTelescopicoAuto = ATelescopicoAuto; 
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
