package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TelescopicoPush extends SubsystemBase {
  private final TalonSRX TelescopicoPushRightMotor = new TalonSRX(Constants.TelescopicoPushRight);
  private final TalonSRX TelescopicoPushLeftMotor = new TalonSRX(Constants.TelescopicoPushLeft);

  public TelescopicoPush() {
    TelescopicoPushLeftMotor.setInverted(true);
    TelescopicoPushLeftMotor.follow(TelescopicoPushRightMotor);
  }

  @Override
  public void periodic() {
  }

  public void VelocityTelescopicoPush(double VTelescopicoPush){
    TelescopicoPushRightMotor.set(ControlMode.PercentOutput, VTelescopicoPush);
  }
}
