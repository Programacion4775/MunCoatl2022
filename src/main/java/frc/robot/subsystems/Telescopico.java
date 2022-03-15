//LIBRARIES//
//LIBRERIAS//
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Telescopico extends SubsystemBase {

  //Actuators declaration//
  //Declaracion de actuadores//
  private final TalonFX TelescopicoRightBackMotor = new TalonFX(30);
  private final TalonFX TelescopicoLeftBackMotor = new TalonFX(31);
  private final TalonFX TelescopicoRightFrontMotor = new TalonFX(32);
  private final TalonFX TelescopicoLeftFrontMotor = new TalonFX(33);
  //private PIDController PIDTelescopico = new PIDController(0.001, 0, 0);

  public Telescopico() {
    TelescopicoLeftFrontMotor.setInverted(true);
    TelescopicoLeftBackMotor.setInverted(true);

    TelescopicoLeftFrontMotor.follow(TelescopicoRightFrontMotor);
    TelescopicoLeftBackMotor.follow(TelescopicoRightFrontMotor);
    TelescopicoRightBackMotor.follow(TelescopicoRightFrontMotor);

    TelescopicoRightFrontMotor.setNeutralMode(NeutralMode.Brake);
    TelescopicoRightBackMotor.setNeutralMode(NeutralMode.Brake);
    TelescopicoLeftFrontMotor.setNeutralMode(NeutralMode.Brake);
    TelescopicoLeftBackMotor.setNeutralMode(NeutralMode.Brake);

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
    TelescopicoRightFrontMotor.set(ControlMode.PercentOutput, VTelescopico);
  }

  //Limit Switch//
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
  }
  
  //Encoder position value//
  //Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoRightFrontMotor.getSensorCollection().getIntegratedSensorPosition();
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