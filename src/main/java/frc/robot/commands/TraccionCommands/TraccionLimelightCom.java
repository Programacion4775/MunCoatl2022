package frc.robot.commands.TraccionCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Traccion;

public class TraccionLimelightCom extends CommandBase {

//Variables declaration//
//Declaracion de variables//
  double LimelightError = 0; 
  boolean LimelightFlag = false;

//Link command with subsistem//
//Unir comando con el subsitema//
 @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
 private Traccion AuxTraccionLimelight; 
  public TraccionLimelightCom(Traccion ATraccionLimelight) {
    AuxTraccionLimelight = ATraccionLimelight;
    addRequirements(AuxTraccionLimelight);
  }

  @Override
  public void initialize() {
    AuxTraccionLimelight.PIDResetTraccionLimelight();
    LimelightFlag = false;
  }

  @Override
  public void execute() {
    LimelightError = RobotContainer.r_Limelight.GetX();
    AuxTraccionLimelight.PIDCalculateOutputTraccionLimelight(LimelightError); 
    SmartDashboard.putNumber("Error", LimelightError);
    SmartDashboard.putNumber("tx", RobotContainer.r_Limelight.GetX());
    SmartDashboard.putNumber("ty", RobotContainer.r_Limelight.GetY());
    SmartDashboard.putNumber("tv", RobotContainer.r_Limelight.GetTV());
    if (RobotContainer.r_Limelight.GetTV() == 0){
      AuxTraccionLimelight.Follow(0);
      LimelightFlag = true; 
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return LimelightFlag;
  }
}
