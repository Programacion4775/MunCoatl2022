package frc.robot.subsystems.Cargo;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class UpBalls extends SubsystemBase {
  private final VictorSPX UpBallsMotor = new VictorSPX(Constants.UpBallsM);
  
  public UpBalls() {}

  @Override
  public void periodic() {
  }

  public void VelocityUpBalls (double Up){
    if(Up<=.2 && Up>=-.2){
      UpBallsMotor.set(ControlMode.PercentOutput, 0);
    }
    else{
      UpBallsMotor.set(ControlMode.PercentOutput, Up);
    }
  }

}

