package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public final class Constants {

  // ID´s MOTORS ASIGNATION//
  // ASIGNACION DE ID A MOTORES//
  // Traccion//
  public final static int TraccionBackLeft = 31;
  public final static int TraccionBackRight = 30;
  public final static int TraccionFrontLeft = 33;
  public final static int TraccionFrontRight = 32;
  // Intake//
  public static final int Intake = 6;
  public static final int EjectIntakeMotor = 12;
  //PullBalls//
  public static final int PullBallsM = 11; 
  // UpBalls//
  public static final int UpBallsRM = 25;
  public static final int UpBallsLM = 27; 
  //Sensor//
  public static final I2C.Port PBCargoSensor = I2C.Port.kOnboard;
  public static final I2C.Port UBCargoSensor = I2C.Port.kMXP;
  // Shooter//
  public final static int Shooter = 2;
  // Telescopico//
  public final static int TelescopicoRightBack = 5;
  public final static int TelescopicoLeftBack = 1;
  public final static int TelescopicoRightFront = 13;
  public final static int TelescopicoLeftFront = 7;
  // Pistons// 
  public final static int PistonT = 1; 
}