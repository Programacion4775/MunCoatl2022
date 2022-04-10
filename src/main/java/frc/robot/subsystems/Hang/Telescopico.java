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
  private final CANSparkMax TelescopicoRightBackMotor = new CANSparkMax(Constants.TelescopicoRightBack, MotorType.kBrushless);
  private final CANSparkMax TelescopicoLeftBackMotor = new CANSparkMax(Constants.TelescopicoLeftBack, MotorType.kBrushless);
  private final CANSparkMax TelescopicoRightFrontMotor = new CANSparkMax(Constants.TelescopicoRightFront, MotorType.kBrushless);
  private final CANSparkMax TelescopicoLeftFrontMotor = new CANSparkMax(Constants.TelescopicoLeftFront, MotorType.kBrushless);
  private final SparkMaxLimitSwitch TelescopicoRightLimit = TelescopicoRightFrontMotor.getReverseLimitSwitch(Type.kNormallyOpen);
  private final SparkMaxLimitSwitch TelescopicoLeftLimit = TelescopicoLeftFrontMotor.getReverseLimitSwitch(Type.kNormallyOpen);
  private final RelativeEncoder TelescopicoRightFrontEncoder = TelescopicoRightFrontMotor.getEncoder();
  private PIDController TelescopicoPID = new PIDController(0.05, 0, 0);

  public Telescopico() {
    TelescopicoLeftFrontMotor.follow(TelescopicoRightFrontMotor, true);
    TelescopicoRightBackMotor.follow(TelescopicoRightFrontMotor, false);
    TelescopicoLeftBackMotor.follow(TelescopicoRightFrontMotor, true);
  }

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
    TelescopicoRightFrontMotor.set(VTlescopico);
  }
 //ENCODER//
 //Encoder position value//
 //Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoRightFrontEncoder.getPosition();
  }  
  //Reset Encoder Value//
 //Resetear valor del Encoder//
  public void ResetEncoderTelescopicoR(){
    TelescopicoRightFrontEncoder.setPosition(0);
  }
  //Limit Switch//
  public boolean LimitSwitchTelescopicoRight(){
    return TelescopicoRightLimit.isPressed();
  }
  public boolean LimitSwitchTelescopicoLeft(){
    return TelescopicoLeftLimit.isPressed();
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
    double PIDOutPutTelescopico = PIDCalculateOutPutTelescopico(PIDCurrentPositionTelescopico, PIDSetPoint);
    return PIDOutPutTelescopico;
  }
}