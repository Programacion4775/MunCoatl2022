package frc.robot.subsystems.Cargo;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class UpBalls extends SubsystemBase {
  private final CANSparkMax UpBallsMotor = new CANSparkMax(Constants.UpBallsRM, MotorType.kBrushless);
  
  public UpBalls() {}

  @Override
  public void periodic() {
  }

  public void VelocityUpBalls (double Up){
    if(Up<=.2 && Up>=-.2){
      UpBallsMotor.set(0);
    }
    else{
      UpBallsMotor.set(Up);
    }
  }
}

