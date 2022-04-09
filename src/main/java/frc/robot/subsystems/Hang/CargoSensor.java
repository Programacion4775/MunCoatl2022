package frc.robot.subsystems.Hang;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CargoSensor extends SubsystemBase {
  private ColorSensorV3 PullBallsCargoSensor = new ColorSensorV3(Constants.PBCargoSensor);
  private ColorSensorV3 UpBallsCargoSensor = new ColorSensorV3(Constants.UBCargoSensor);

  public CargoSensor() {}

  @Override
  public void periodic() {
  }

  public Color GetColorPBCargo(){
    return PullBallsCargoSensor.getColor();
  }
  public Color GetColorUBCargo(){
    return UpBallsCargoSensor.getColor();
  }

  public double IRFeo(){
    return PullBallsCargoSensor.getIR();
  }

  
}
