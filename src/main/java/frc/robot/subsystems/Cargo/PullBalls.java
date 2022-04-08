package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PullBalls extends SubsystemBase {
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
}
