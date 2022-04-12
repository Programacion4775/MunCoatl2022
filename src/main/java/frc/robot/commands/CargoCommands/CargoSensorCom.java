/*package frc.robot.commands.CargoCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hang.CargoSensor;

public class CargoSensorCom extends CommandBase {

  private CargoSensor auxCargoSensor; 
  public CargoSensorCom(CargoSensor aCargoSensorCom) {

    auxCargoSensor = aCargoSensorCom;
    addRequirements(auxCargoSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("valorCargosensor", auxCargoSensor.GetColorPBCargo().green);
    SmartDashboard.putNumber("valorCargoazulsensor", auxCargoSensor.GetColorPBCargo().blue);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}*/
