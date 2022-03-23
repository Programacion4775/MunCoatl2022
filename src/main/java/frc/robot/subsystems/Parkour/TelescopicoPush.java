package frc.robot.subsystems.Parkour;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TelescopicoPush extends SubsystemBase {
  private final CANSparkMax TelescopicoPushRightMotor = new CANSparkMax(Constants.TelescopicoPushRight, MotorType.kBrushless);
  private final CANSparkMax TelescopicoPushLeftMotor = new CANSparkMax(Constants.TelescopicoPushLeft, MotorType.kBrushless);
  private final RelativeEncoder TelescopicoPushEncoder = TelescopicoPushRightMotor.getEncoder();
  private PIDController TelescopicoPushPID = new PIDController(0, 0, 0);

  public TelescopicoPush() {
    TelescopicoPushLeftMotor.setInverted(true);
    TelescopicoPushLeftMotor.follow(TelescopicoPushRightMotor);
  }

  @Override
  public void periodic() {
  }

//TELESCOPICO CONTROL//
 //MOTOR//
 //Motors velocity//
 //Velocidad de motores//
  public void VelocityTelescopicoPush(double VTelescopicoPush){
    TelescopicoPushRightMotor.set(VTelescopicoPush);
  }
//ENCODER//
 //Encoder position value//
 //Valor de posicion del encoder//
 public double EncoderTelescopicoPush() {
  return TelescopicoPushEncoder.getPosition();
}  

//TELESCOPICO AUTO//
  //Reset PID value//
  //Resetear el valor de PID//
  public void PIDResetTelescopico(){
    TelescopicoPushPID.reset();
  }
  //Calculate PID OutPut//
  //Calcular la salida del PID//
  public double PIDCalculateOutPutTelescopicoPush (double PIDCurrentPositionTelescopicoPush, double PIDSetPointPush){
    double PIDOutPutTelescopicoPush = PIDCalculateOutPutTelescopicoPush(PIDCurrentPositionTelescopicoPush, PIDSetPointPush);
    return PIDOutPutTelescopicoPush;
  }
}
