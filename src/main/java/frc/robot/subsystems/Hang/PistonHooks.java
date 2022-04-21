package frc.robot.subsystems.Hang;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PistonHooks extends SubsystemBase {
  private final Solenoid PistonHookR = new Solenoid(PneumaticsModuleType.REVPH, Constants.PistonHR);
  private final Solenoid PistonHookL = new Solenoid(PneumaticsModuleType.REVPH, Constants.PistonHL);

  public PistonHooks() {}

  @Override
  public void periodic() {
  }

  public boolean OpenClosePistonHoo(boolean OCPistonHoo){
    PistonHookR.set(OCPistonHoo);
    PistonHookL.set(OCPistonHoo);
    return OCPistonHoo;
  }
}
