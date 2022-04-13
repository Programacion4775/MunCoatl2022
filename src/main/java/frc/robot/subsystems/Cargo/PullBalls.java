package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PullBalls extends SubsystemBase {
  private final CANSparkMax PullBallsMotor = new CANSparkMax(Constants.PullBallsM, MotorType.kBrushless);
  private final DigitalInput PBCargoSensor = new DigitalInput(Constants.PBCargoS);

  public PullBalls() {
    PullBallsMotor.setInverted(true);
  }

  @Override
  public void periodic() {
  }

  public void VelocityPullBalls(double Pull){
    PullBallsMotor.set(Pull);
  }
  public boolean GetPresencePB(){
    return !PBCargoSensor.get();
  }
}