package frc.robot.commands.ParkourCom;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Parkour.TelescopicoPush;

public class TelescopicoPushCom extends CommandBase {
  double AuxUpDownTelescopico = 0;
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  //Link command with subsistem//
  //Unir comando con el subsitema//
  private final TelescopicoPush AuxTelescopicoPush;
  public TelescopicoPushCom(TelescopicoPush ATelescopicoPush, double AUpDownTelescopico) {
    AuxTelescopicoPush = ATelescopicoPush;
    AuxUpDownTelescopico = AUpDownTelescopico;
    addRequirements(AuxTelescopicoPush);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxTelescopicoPush.VelocityTelescopicoPush(AuxUpDownTelescopico);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
