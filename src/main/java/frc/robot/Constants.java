package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public final class Constants {

  // ID´s MOTORS ASIGNATION//
  // ASIGNACION DE ID A MOTORES//
  // Traccion//
  public final static int TraccionBackLeft = 1;
  public final static int TraccionBackRight = 2;
  public final static int TraccionFrontLeft = 3;
  public final static int TraccionFrontRight = 4;
  // Intake//
  public static final int Intake = 5;
  public static final int EjectIntakeMotor = 6;
  public static final int EjectIntakeDigital = 2; 
  //PullBalls//
  public static final int PullBallsM = 7; 
  // UpBalls//
  public static final int UpBallsM = 8;
  //PresenceSensor//
  public static final int PBCargoS = 1;
  public static final int UBCargoS = 0; 
  //ColorSensor//
  public static final I2C.Port ShootingSensor = I2C.Port.kOnboard; 
  // Shooter//
  public final static int Shooter = 9;
  // Telescopico//
  public final static int TelescopicoM = 10; 
  public final static int PistonT = 8; 
  //Hooks//
  public final static int PistonHR = 9;
  public final static int PistonHL = 10;
}