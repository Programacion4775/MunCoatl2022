package frc.robot.subsystems.Hang;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PistonTel extends SubsystemBase {


  //Actuators declaration//
  //Declaracion de actuadores//
  public static Solenoid PistonTel = new Solenoid(PneumaticsModuleType.REVPH, Constants.PistonT);

  public PistonTel() {}

  @Override
  public void periodic() {
  }

  public boolean OpenClosePistonTel(boolean OpClPistonTel){
    PistonTel.set(OpClPistonTel);
    return OpClPistonTel; 
  }
}
