package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeBack extends SubsystemBase {
  private CANSparkMax IntakeBackMotor = new CANSparkMax(Constants.IntakeBackM, MotorType.kBrushless);
  
  public IntakeBack() {}
  
  @Override
  public void periodic() {}
  
  //Clasede velocidad//
   public void VelocityIntakeBack(double VIntakeBack){
     IntakeBackMotor.set(VIntakeBack);
    }
  }
