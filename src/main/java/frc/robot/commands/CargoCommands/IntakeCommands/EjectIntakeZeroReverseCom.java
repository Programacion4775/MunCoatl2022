
package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.EjectIntake;

public class EjectIntakeZeroReverseCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  private boolean StopEjInLimR;

//Link command with subsistem//
//Unir comando con el subsitema//
  private EjectIntake AuxEjectIntakeZeroR;
  public EjectIntakeZeroReverseCom(EjectIntake AEjectIntakeZeroR){
    AuxEjectIntakeZeroR = AEjectIntakeZeroR;
    StopEjInLimR = false; 
    addRequirements(AEjectIntakeZeroR);
  }

  @Override
  public void initialize() {
    StopEjInLimR = false;
    AuxEjectIntakeZeroR.ResetEncoderEjectInatke();
  }

  @Override
  public void execute() {
    AuxEjectIntakeZeroR.EjectReturnIntake(-.25);
    StopEjInLimR = AuxEjectIntakeZeroR.LimitSwitchEjectIntakeReverse();
  }

  @Override
  public void end(boolean interrupted) {
    AuxEjectIntakeZeroR.EjectReturnIntake(0);
  }

  @Override
  public boolean isFinished() {
    return StopEjInLimR;
  }
}
