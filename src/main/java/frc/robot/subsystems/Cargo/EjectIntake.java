package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EjectIntake extends SubsystemBase {
  private final CANSparkMax EjectIntakeMotor = new CANSparkMax(Constants.EjectIntakeMotor, MotorType.kBrushless);
  private RelativeEncoder EjectIntakeEncoder = EjectIntakeMotor.getEncoder();
  private SparkMaxLimitSwitch EjectIntakeLimitSwitchF = EjectIntakeMotor.getForwardLimitSwitch(Type.kNormallyOpen);
  private SparkMaxLimitSwitch EjectIntakeLimitSwitchR = EjectIntakeMotor.getReverseLimitSwitch(Type.kNormallyOpen);

  public EjectIntake() {}

  @Override
  public void periodic() {
  }

  public void EjectReturnIntake(double ERIntake){
    EjectIntakeMotor.set(ERIntake);
  }
  public double EncoderEjectIntake(){
    return EjectIntakeEncoder.getPosition();
  }
  public void ResetEncoderEjectInatke(){
    EjectIntakeEncoder.setPosition(0);
  }
    //Limit Switch//
    public boolean LimitSwitchEjectIntakeForward(){
      return EjectIntakeLimitSwitchF.isPressed();
    }
    public boolean LimitSwitchEjectIntakeReverse(){
      return EjectIntakeLimitSwitchR.isPressed();
    }
}
