//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems.Parkour;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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
  private final RelativeEncoder TelescopicoRightFrontEncoder = TelescopicoRightFrontMotor.getEncoder();
  private PIDController TelescopicoPID = new PIDController(0, 0, 0);

  public Telescopico() {
    TelescopicoLeftFrontMotor.setInverted(true);
    TelescopicoRightFrontMotor.setInverted(true);
    
    TelescopicoLeftFrontMotor.follow(TelescopicoRightFrontMotor);
    TelescopicoLeftBackMotor.follow(TelescopicoRightFrontMotor);
    TelescopicoRightBackMotor.follow(TelescopicoRightFrontMotor);
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
 //Velocidad de motores//
  public void VelocityTelescopicos (double VTelescopico){
    TelescopicoRightFrontMotor.set(VTelescopico);
  }
 //ENCODER//
 //Encoder position value//
 //Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoRightFrontEncoder.getPosition();
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