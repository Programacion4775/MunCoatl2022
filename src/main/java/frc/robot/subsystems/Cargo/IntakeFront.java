//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems.Cargo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFront extends SubsystemBase {
  private final CANSparkMax IntakeFrontMotor = new CANSparkMax(Constants.IntakeFrontM,MotorType.kBrushless);
  public IntakeFront() {}

  @Override
  public void periodic() {}
   
  //Velocity Class//
  //Clase de Velocidad//
  public void VelocityIntakeFront(double VIntakeFront){
    IntakeFrontMotor.set(VIntakeFront);
  }
  }
