
package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.EjectIntake;

public class EjectIntakeZeroForwardCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  private boolean StopEjInLim;

//Link command with subsistem//
//Unir comando con el subsitema//
  private EjectIntake AuxEjectIntakeZero;
  public EjectIntakeZeroForwardCom(EjectIntake AEjectIntakeZero){
    AuxEjectIntakeZero = AEjectIntakeZero;
    StopEjInLim = false; 
    addRequirements(AEjectIntakeZero);
  }

  @Override
  public void initialize() {
    AuxEjectIntakeZero.ResetEncoderEjectInatke();
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("LimitPressed", AuxEjectIntakeZero.LimitSwitchEjectIntakeForward());
    AuxEjectIntakeZero.EjectReturnIntake(1);
    StopEjInLim = AuxEjectIntakeZero.LimitSwitchEjectIntakeForward();
  }

  @Override
  public void end(boolean interrupted) {
    AuxEjectIntakeZero.EjectReturnIntake(0);
  }

  @Override
  public boolean isFinished() {
    return StopEjInLim;
  }
}
