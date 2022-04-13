//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems.Cargo;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private final VictorSPX IntakeFrontMotor = new VictorSPX(Constants.Intake);
  public Intake() {}

  @Override
  public void periodic() {
    IntakeFrontMotor.setNeutralMode(NeutralMode.Brake);
  }
   
  //Velocity Class//
  //Clase de Velocidad//
  public void VelocityIntakeFront(double VIntakeFront){
    IntakeFrontMotor.set(ControlMode.PercentOutput, VIntakeFront);
  }
  }
