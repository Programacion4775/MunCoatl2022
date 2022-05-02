//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems.Hang;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Telescopico extends SubsystemBase {

  //Actuators declaration//
  //Declaracion de actuadores//
  private final CANSparkMax TelescopicoMotor = new CANSparkMax(Constants.TelescopicoM, MotorType.kBrushless);
  private final SparkMaxLimitSwitch TelescopicoLimit = TelescopicoMotor.getReverseLimitSwitch(Type.kNormallyOpen);
  private final RelativeEncoder TelescopicoEncoder = TelescopicoMotor.getEncoder();
  private PIDController TelescopicoPID = new PIDController(0.005, 0, 0);

  public Telescopico() {}

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
  }

//TELESCOPICO CONTROL//
 //MOTOR//
 //Motors velocity//
  public void VelocityTelescopico(double VTlescopico){
    TelescopicoMotor.set(VTlescopico);
  }
 //ENCODER//
 //Encoder position value//
 //Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoEncoder.getPosition();
  }  
  //Reset Encoder Value//
 //Resetear valor del Encoder//
  public void ResetEncoderTelescopicoR(){
    TelescopicoEncoder.setPosition(0);
  }
  //Limit Switch//
  public boolean LimitSwitchTelescopico(){
    return TelescopicoLimit.isPressed();
  }

//TELESCOPICO AUTO//
  //Reset PID value//
  //Resetear el valor de PID//
  public void PIDResetTelescopico(){
    TelescopicoPID.reset();
  }
  //Calculate PID OutPut//
  //Calcular la salida del PID//
  public double PIDCalculateOutPutTelescopico (double PIDCurrentPositionTelescopico, double PIDSetPoint){
    return TelescopicoPID.calculate(PIDCurrentPositionTelescopico, PIDSetPoint);
    //return PIDOutPutTelescopico;
  }
}