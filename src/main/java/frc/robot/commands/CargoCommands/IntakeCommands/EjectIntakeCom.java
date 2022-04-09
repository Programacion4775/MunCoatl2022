
package frc.robot.commands.CargoCommands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.EjectIntake;

public class EjectIntakeCom extends CommandBase {
  
//Variables declaration//
//Declaracion de variables//
double ERIntake = 0; 

//Link command with subsistem//
//Unir comando con el subsitema//
  private EjectIntake AuxEjectIntake;
  public EjectIntakeCom(EjectIntake AEjectIntake, double AERIntake){
    AuxEjectIntake = AEjectIntake;
    ERIntake = AERIntake; 
    addRequirements(AuxEjectIntake);
  }

  @Override
  public void initialize() {
    AuxEjectIntake.ResetEncoderEjectInatke();
  }

  @Override
  public void execute() {
    AuxEjectIntake.EjectReturnIntake(ERIntake);
  }

  @Override
  public void end(boolean interrupted) {
    AuxEjectIntake.EjectReturnIntake(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
