package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cargo.EjectIntake;
import frc.robot.subsystems.Cargo.Intake;

public class IntakeCom extends CommandBase {

//Link command with subsistem//
//Unir comando con el subsitema//
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Intake AuxIntake;
  private EjectIntake AuxEjectIntakeIntake; 
  public IntakeCom(Intake AIntake, EjectIntake AEjectIntakeIntake) {
  AuxIntake = AIntake;
  AuxEjectIntakeIntake = AEjectIntakeIntake;
  addRequirements(AuxIntake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Intake", true);
    SmartDashboard.putBoolean("LimitPressed", AuxEjectIntakeIntake.LimitSwitchEjectIntakeReverse());
    AuxIntake.VelocityIntakeFront(.7);
    if(AuxEjectIntakeIntake.LimitSwitchEjectIntakeReverse()){
      AuxIntake.VelocityIntakeFront(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    AuxIntake.VelocityIntakeFront(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
