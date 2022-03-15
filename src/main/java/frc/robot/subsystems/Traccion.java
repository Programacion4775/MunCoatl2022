package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Traccion extends SubsystemBase {
  private final CANSparkMax TraccionBackLeftMotor = new CANSparkMax(Constants.TraccionBackLeft, MotorType.kBrushless);
  private final CANSparkMax TraccionBackRightMotor = new CANSparkMax(Constants.TraccionBackRight, MotorType.kBrushless);
  private final CANSparkMax TraccionFrontLeftMotor = new CANSparkMax(Constants.TraccionFrontLeft, MotorType.kBrushless);
  private final CANSparkMax TraccionFrontRightMotor = new CANSparkMax(Constants.TraccionFrontRight, MotorType.kBrushless);
  private final RelativeEncoder TraccionBackLeftEncoder = TraccionBackLeftMotor.getEncoder();
  private final RelativeEncoder TraccionBackRightEncoder = TraccionBackRightMotor.getEncoder();

  //private PIDController PIDFrontRightTraccion = new PIDController(0.05, 0, 0);
  //private PIDController PIDFrontLeftTraccion = new PIDController(0.05, 0, 0);
  
  public Traccion() {
    TraccionFrontLeftMotor.setInverted(true);
    TraccionBackLeftMotor.setInverted(true);
  }

  @Override
  public void periodic() {}

  public void VelocityTraccion (double x,double y,double z){
    //Ajustar el eje del control//
    if(x<=.2 && x>=-.2 && y<=.2 && y>=-.2 && z<=.2 && z>=-.2){
     TraccionFrontRightMotor.set(0);
     TraccionFrontLeftMotor.set(0);
     TraccionBackRightMotor.set(0);
     TraccionBackLeftMotor.set(0);
    }
    else{
    TraccionFrontRightMotor.set(y-x+z);
    TraccionFrontLeftMotor.set(y+x-z);
    TraccionBackRightMotor.set(y+x+z);
    TraccionBackLeftMotor.set(y-x-z);
   }
  }

  public void diferentialVel(double vR, double vL){
    TraccionFrontRightMotor.set(vR);
    TraccionFrontLeftMotor.set(vL);
    TraccionBackRightMotor.set(vR);
    TraccionBackLeftMotor.set(vL);
  }
  public void LateralVelocity(double vR, double vL){
    TraccionFrontRightMotor.set(vL);
    TraccionFrontLeftMotor.set(vR);
    TraccionBackRightMotor.set(vR);
    TraccionBackLeftMotor.set(vL);
  }
  
  public double EncoderRightBackTraccion(){
    return TraccionBackRightEncoder.getPosition();
  }
  public double EncoderLeftBackTraccion(){
    return TraccionBackLeftEncoder.getPosition();
  }
  public void EncodersReset(){
    TraccionBackRightEncoder.setPosition(0);
    TraccionBackLeftEncoder.setPosition(0);
  }
}