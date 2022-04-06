package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;

public class Shooter extends SubsystemBase {
  private final CANSparkMax ShooterMotor = new CANSparkMax(Constants.Shooter,MotorType.kBrushless);
  private final RelativeEncoder ShooterEncoder = ShooterMotor.getEncoder();
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
  
}
