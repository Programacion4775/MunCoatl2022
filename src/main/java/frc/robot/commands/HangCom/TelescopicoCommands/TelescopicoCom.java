//LIBRARIES//
//LIBRERIAS//
package frc.robot.commands.HangCom.TelescopicoCommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Hang.Telescopico;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TelescopicoCom extends CommandBase {

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
    //Dashboard Data//
   //Valores en la Dashboard//
    SmartDashboard.putNumber("Encoder Telescopico", AuxTelescopico.EncoderTelescopicoR()); //Encoder//
    SmartDashboard.putBoolean("TelescopicoPressed", AuxTelescopico.LimitSwitchTelescopico()); //Limit Switch//
    AuxTelescopico.VelocityTelescopico(RobotContainer.Control0.getRightTriggerAxis()-RobotContainer.Control0.getLeftTriggerAxis());
    if (AuxTelescopico.LimitSwitchTelescopico()){
      AuxTelescopico.ResetEncoderTelescopicoR();
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}