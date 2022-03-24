//LIBRARIES//
//LIBRERIAS//
package frc.robot.commands.ParkourCom;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Parkour.Telescopico;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TelescopicoCom extends CommandBase {
  double AuxTelescopicoFR = 0;
  double AuxTelescopicoFL = 0; 
  double AuxTelescopicoBR = 0;
  double AuxTelescopicoBL = 0; 

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
    //Asign move to a controll// 
    //Asignarle el movimiento a un control//
    AuxTelescopico.VelocityTelescopicosRF(RobotContainer.Control0.getRightTriggerAxis()-RobotContainer.Control0.getLeftTriggerAxis()); 
    AuxTelescopico.VelocityTelescopicosLF(RobotContainer.Control0.getLeftTriggerAxis()-RobotContainer.Control0.getRightTriggerAxis()); 
    AuxTelescopico.VelocityTelescopicosRB(RobotContainer.Control0.getRightTriggerAxis()-RobotContainer.Control0.getLeftTriggerAxis()); 
    AuxTelescopico.VelocityTelescopicosLB(RobotContainer.Control0.getLeftTriggerAxis()-RobotContainer.Control0.getRightTriggerAxis()); 
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}