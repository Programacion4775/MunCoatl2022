//LIBRARIES//
//LIBRERIAS//
package frc.robot.commands.Parkour;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Telescopico;
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
    SmartDashboard.putNumber("Encoder Telescopico", AuxTelescopico.EncoderTelescopicoR());
 /*   SmartDashboard.putBoolean("TLimitR", AuxTelescopico.LimitTelesopicoR());
    SmartDashboard.putBoolean("TLimitL", AuxTelescopico.LimitTelesopicoL());*/
    AuxTelescopico.VelocityTelescipicoS(RobotContainer.Control0.getRightTriggerAxis()-RobotContainer.Control0.getLeftTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}