package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PullBalls extends SubsystemBase {
  private ColorSensorV3 PullBallsCargoSensor = new ColorSensorV3(Constants.PBCargoSensor);
  private final CANSparkMax PullBallsMotor = new CANSparkMax(Constants.PullBallsM, MotorType.kBrushless);

  public PullBalls() {
    PullBallsMotor.setInverted(true);
  }

  @Override
  public void periodic() {
  }

  public void VelocityPullBalls(double Pull){
    PullBallsMotor.set(Pull);
  }
  public Color GetColorPBCargo(){
    return PullBallsCargoSensor.getColor();
  }
  public static DriverStation.Alliance Alliance(){
    return DriverStation.getAlliance(); 
  }
  public boolean PresencePBCargo(boolean PresencePBC){
    return PresencePBC;
  }
  
}