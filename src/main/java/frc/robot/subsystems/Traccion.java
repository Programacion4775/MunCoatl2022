package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
//import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Traccion extends SubsystemBase {

  //Actuators declaration//
  //Declaracion de actuadores//
  private final TalonFX TraccionBackLeftMotor = new TalonFX(Constants.TraccionBackLeft);
  private final TalonFX TraccionBackRightMotor = new TalonFX(Constants.TraccionBackRight);
  private final TalonFX TraccionFrontLeftMotor = new TalonFX(Constants.TraccionFrontLeft);
  private final TalonFX TraccionFrontRightMotor = new TalonFX(Constants.TraccionFrontRight);
  private final PIDController TraccionLimelightPID = new PIDController(.02, 0, 0);
  
  public Traccion() {
    TraccionBackLeftMotor.setInverted(true);
    TraccionFrontLeftMotor.setInverted(true);
    TraccionBackLeftMotor.setNeutralMode(NeutralMode.Brake);
    TraccionBackRightMotor.setNeutralMode(NeutralMode.Brake);
    TraccionFrontLeftMotor.setNeutralMode(NeutralMode.Brake);
    TraccionFrontRightMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {}

  public void VelocityTraccion (double x,double y,double z){
    //Ajustar el eje del control//
    if(x<=.2 && x>=-.2 && y<=.2 && y>=-.2 && z<=.2 && z>=-.2){
     TraccionFrontRightMotor.set(ControlMode.PercentOutput, 0);
     TraccionFrontLeftMotor.set(ControlMode.PercentOutput, 0);
     TraccionBackRightMotor.set(ControlMode.PercentOutput, 0);
     TraccionBackLeftMotor.set(ControlMode.PercentOutput, 0);
    }
    else{
    TraccionFrontRightMotor.set(ControlMode.PercentOutput, y+x+z);
    TraccionFrontLeftMotor.set(ControlMode.PercentOutput, y+x-z);
    TraccionBackRightMotor.set(ControlMode.PercentOutput, y-x+z);
    TraccionBackLeftMotor.set(ControlMode.PercentOutput, y-x-z);
   }
  }

  public void diferentialVel(double vlR, double vlL){
    TraccionFrontRightMotor.set(ControlMode.PercentOutput, vlR);
    TraccionFrontLeftMotor.set(ControlMode.PercentOutput, vlL);
    TraccionBackRightMotor.set(ControlMode.PercentOutput, vlR);
    TraccionBackLeftMotor.set(ControlMode.PercentOutput, vlL);
  }
  public void LateralVelocity(double vR, double vL){
    TraccionFrontRightMotor.set(ControlMode.PercentOutput, vL);
    TraccionFrontLeftMotor.set(ControlMode.PercentOutput, vR);
    TraccionBackRightMotor.set(ControlMode.PercentOutput, vR);
    TraccionBackLeftMotor.set(ControlMode.PercentOutput, vL);
  }
  public void Follow (double fx){
    TraccionFrontRightMotor.set(ControlMode.PercentOutput, fx);
    TraccionFrontLeftMotor.set(ControlMode.PercentOutput, -fx);
    TraccionBackRightMotor.set(ControlMode.PercentOutput, fx);
    TraccionBackLeftMotor.set(ControlMode.PercentOutput, -fx);
}
  
  public double EncoderRightBackTraccion(){
    return TraccionBackRightMotor.getSensorCollection().getIntegratedSensorPosition();
  }
  public double EncoderLeftBackTraccion(){
    return TraccionBackLeftMotor.getSensorCollection().getIntegratedSensorPosition();
  }
  public void PIDResetTraccionLimelight(){
    TraccionLimelightPID.reset();
  }
  public void PIDCalculateOutputTraccionLimelight(double PIDSetPointTarget){
    Follow(TraccionLimelightPID.calculate(0, PIDSetPointTarget));
  }
  public double PIDMotorOutputTraccionLimelight(double PIDSetPointTarget){
    return TraccionLimelightPID.calculate(0,PIDSetPointTarget);
  }
}