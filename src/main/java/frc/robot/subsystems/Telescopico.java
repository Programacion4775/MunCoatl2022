//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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
  //private PIDController PIDTelescopico = new PIDController(0.001, 0, 0);

  public Telescopico() {
    TelescopicoLeftFrontMotor.setInverted(true);
    TelescopicoLeftBackMotor.setInverted(true);

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

   //Motors velocity//
  //Velocidad de motores//
  public void VelocityTelescipicoS (double VTelescopico){
    TelescopicoRightFrontMotor.set(VTelescopico);
  }

 /* //Limit Switch//
  public boolean LimitTelesopicoR(){
    boolean LimitPressedTelescopicoR = false;
    if(TelescopicoRightFrontMotor.isRevLimitSwitchClosed()==1){
      LimitPressedTelescopicoR = true;
      //RobotContainer.r_PistonsHook.OpenCloseHooks(false);
    }
    return LimitPressedTelescopicoR;
  }

    public boolean LimitTelesopicoL(){
      boolean LimitPressedTelescopicoL = false;
      if(TelescopicoLeftFrontMotor.isRevLimitSwitchClosed()==1){
        LimitPressedTelescopicoL = true;
        //RobotContainer.r_PistonsHook.OpenCloseHooks(false);
      }
    return LimitPressedTelescopicoL;
  }*/
  
  //Encoder position value//
  //Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoRightFrontEncoder.getPosition();
  }


  
  //PID values//
  //Valores de PID//
  /*
  public void PIDResetTelescopico(){
    PIDTelescopico.reset();
  }
  public double CalculateOutputTelescopico(double PIDCurrentPositionTelescopico, double PIDSetPointTelescopico){
    double PIDOutputTelescopico = PIDTelescopico.calculate(PIDCurrentPositionTelescopico, PIDSetPointTelescopico);
    return PIDOutputTelescopico;
  }*/
  
}