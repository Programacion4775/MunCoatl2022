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

//Motors velocity//
//Velocidad de motores//
  public void VelocityTelescopicos (double VTelescopico){
    TelescopicoRightFrontMotor.set(VTelescopico);
  }
  
//Encoder position value//
//Valor de posicion del encoder//
  public double EncoderTelescopicoR() {
    return TelescopicoRightFrontEncoder.getPosition();
  }  
}