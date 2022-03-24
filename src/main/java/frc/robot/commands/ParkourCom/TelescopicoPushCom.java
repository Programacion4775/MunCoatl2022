package frc.robot.commands.ParkourCom;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Parkour.TelescopicoPush;

public class TelescopicoPushCom extends CommandBase {
  double AuxUpDownTelescopicoR = 0;
  double AuxUpDownTelescopicoL = 0; 

  //Link command with subsistem//
  //Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TelescopicoPush AuxTelescopicoPush;
  public TelescopicoPushCom(TelescopicoPush ATelescopicoPush, double AUpDownTelescopicoR, double AUpDownTelescopicoL) {
    AuxTelescopicoPush = ATelescopicoPush;
    AuxUpDownTelescopicoR = AUpDownTelescopicoR;
    AuxUpDownTelescopicoL = AUpDownTelescopicoL;
    addRequirements(AuxTelescopicoPush);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxTelescopicoPush.VelocityTelescopicoPushR(AuxUpDownTelescopicoR);
    AuxTelescopicoPush.VelocityTelescopicoPushL(AuxUpDownTelescopicoL);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
