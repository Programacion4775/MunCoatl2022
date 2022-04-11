package frc.robot.subsystems.Hang;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CargoSensor extends SubsystemBase {
  double[] Red, Blue, Green, Yellow; 
  private ColorSensorV3 PullBallsCargoSensor = new ColorSensorV3(Constants.PBCargoSensor);
  private ColorSensorV3 UpBallsCargoSensor = new ColorSensorV3(Constants.UBCargoSensor);

  public void ColorIdentifier(final double[] r, final double[] g, final double[] b, final double[] y) {
    Red = r;
    Blue = b;
    Green = g;
    Yellow = y;
}

  public CargoSensor() {}

  @Override
  public void periodic() {
  }

  public Color GetColorPBCargo(){
    return PullBallsCargoSensor.getColor(); 
  }
}