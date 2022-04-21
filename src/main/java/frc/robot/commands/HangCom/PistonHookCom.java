package frc.robot.commands.HangCom;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hang.PistonHooks;

public class PistonHookCom extends CommandBase {
  PistonHooks AuxPistonHooks;

  public PistonHookCom(PistonHooks APistonHooks) {
    AuxPistonHooks = APistonHooks; 
    addRequirements(AuxPistonHooks);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    AuxPistonHooks.OpenClosePistonHoo(true);
  }

  @Override
  public void end(boolean interrupted) {
    AuxPistonHooks.OpenClosePistonHoo(false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
