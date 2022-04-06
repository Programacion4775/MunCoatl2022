//LIBRARIES//
//LIBRERIAS//
package frc.robot.commands.HangCom;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Hang.Telescopico;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TelescopicoCom extends CommandBase {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//Link command with subsistem//
//Unir comando con el subsitema//
  private final Telescopico AuxTelescopico;
  public TelescopicoCom(Telescopico ATelescopico) { 
    AuxTelescopico = ATelescopico;
    addRequirements(AuxTelescopico);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    SmartDashboard.putNumber("Encoder Telescopico", AuxTelescopico.EncoderTelescopicoR()); //Send to dashboard encoder value//Mandar el valor de encoder a la Dashboard//
    AuxTelescopico.VelocityTelescopico(RobotContainer.Control0.getRightTriggerAxis()*0.5-RobotContainer.Control0.getLeftTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}