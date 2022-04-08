//LIBRARIES//
//LIBRERIAS//
package frc.robot.commands.TraccionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Traccion;

public class TraccionCom extends CommandBase {

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Traccion AuxTraccion;
  public TraccionCom(Traccion ATraccion) {
  AuxTraccion = ATraccion;
  addRequirements(AuxTraccion);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxTraccion.VelocityTraccion(RobotContainer.Control0.getLeftX(), -RobotContainer.Control0.getLeftY(), RobotContainer.Control0.getRightX());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}