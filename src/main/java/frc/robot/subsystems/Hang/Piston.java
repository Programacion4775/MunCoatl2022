package frc.robot.subsystems.Hang;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Piston extends SubsystemBase {


  //Actuators declaration//
  //Declaracion de actuadores//
  public static Solenoid Piston = new Solenoid(PneumaticsModuleType.REVPH, Constants.PistonT);

  public Piston() {}

  @Override
  public void periodic() {
  }

  public boolean OpenClosePiston(boolean OpClPiston){
    Piston.set(OpClPiston);
    return OpClPiston; 
  }
}
