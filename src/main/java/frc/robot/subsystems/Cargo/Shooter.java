package frc.robot.subsystems.Cargo;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.util.Color;

public class Shooter extends SubsystemBase {
  private static final CANSparkMax ShooterMotor = new CANSparkMax(Constants.Shooter,MotorType.kBrushless);
  private final RelativeEncoder ShooterEncoder = ShooterMotor.getEncoder();
  private static final ColorSensorV3 ChangeShooting = new ColorSensorV3(Constants.ShootingSensor);
  private PIDController PIDShooter = new PIDController(0.005, 0, 0);

  public Shooter() {}

  @Override
  public void periodic() {}

  public double VelocityShooter(double VShooter) {
    ShooterMotor.set(VShooter);
    return VShooter;
  }
  public double VelocityEncoderShooter(){
    return ShooterEncoder.getVelocity();
  }
  public void PIDResetShooter(){
    PIDShooter.reset();
  }
  public double PIDCalculateOutputShooter (double PIDCurrentVelocityShooter, double PIDSetPointShooter){
    double PIDOutputShooter = PIDShooter.calculate(PIDCurrentVelocityShooter, PIDSetPointShooter);
    return PIDOutputShooter;
  }
  public static Color GetColor(){
    return ChangeShooting.getColor();
  }
  public static double RedAlliance(){
    double Red = .63;  
    if((GetColor().red>50) && (GetColor().red>60)){
      Red = .3; 
    }
      ShooterMotor.set(Red);
      return Red; 
  }
  public static double BlueAlliance(){
    double Blue = .63; 
    if((GetColor().red>50) && (GetColor().red>60)){
      Blue = .3; 
    }
    ShooterMotor.set(Blue);
    return Blue;
  }

  /*public double AllianceVals (boolean alli){
    double Power = .63;
    if (alli) {
      //blue 
      if((GetColor().red>50) && (GetColor().red>60)){
        Power = .3; 
      }
    } 
    else {
      //red
      if((GetColor().blue>50) && (GetColor().blue>60)){
        Power = .3; 
      }
    }
    ShooterMotor.set(Power);
    return Power;
  }*/
}
