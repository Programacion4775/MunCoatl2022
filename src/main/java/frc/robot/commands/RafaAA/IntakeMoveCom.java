/*package frc.robot.commands.RafaAA;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cargo.EjectIntake;
import frc.robot.subsystems.Cargo.Intake;
import frc.robot.subsystems.Cargo.PullBalls;
import frc.robot.subsystems.Hang.CargoSensor;


public class IntakeMoveCom extends CommandBase {
  private Intake AuxIntakeIM; 
  private EjectIntake AuxEjectIntakeIM;
  private PullBalls AuxPullBallsIM;  
  private CargoSensor AuxCargoSensorIM;
  public IntakeMoveCom(Intake AIntakeIM, EjectIntake AEjectIntakeIM, PullBalls APullBallsIM, CargoSensor ACargoSensorIM){
    AuxIntakeIM = AIntakeIM;
    AuxEjectIntakeIM = AEjectIntakeIM;
    AuxPullBallsIM = APullBallsIM;
    AuxCargoSensorIM = ACargoSensorIM;
    addRequirements(AuxCargoSensorIM);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(AuxCargoSensorIM == RedCargo || AuxCargoSensorIM == BlueCargo)
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
*/