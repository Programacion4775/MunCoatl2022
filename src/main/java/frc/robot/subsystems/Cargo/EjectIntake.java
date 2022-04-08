package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EjectIntake extends SubsystemBase {
  private final CANSparkMax EjectIntakeMotor = new CANSparkMax(Constants.EjectIntakeMotor, MotorType.kBrushless);

  public EjectIntake() {}

  @Override
  public void periodic() {
  }

  public void EjectReturnIntake(double ERIntake){
    EjectIntakeMotor.set(ERIntake);
  }
}
