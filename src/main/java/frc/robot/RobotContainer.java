//LIBRARIES//
//LIBRERIAS//
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CargoCommands.CargoSensorCom;
import frc.robot.commands.CargoCommands.Balls.PullBallsCom;
import frc.robot.commands.CargoCommands.Balls.ShootPullBallsCom;
import frc.robot.commands.CargoCommands.Balls.UpBallsCom;
import frc.robot.commands.CargoCommands.IntakeCommands.EjectIntakeZeroForwardCom;
import frc.robot.commands.CargoCommands.IntakeCommands.EjectIntakeZeroReverseCom;
import frc.robot.commands.CargoCommands.IntakeCommands.IntakeCom;
import frc.robot.commands.CargoCommands.ShooterCommands.ShooterComVels;
import frc.robot.commands.HangCom.PistonCom;
import frc.robot.commands.HangCom.TelescopicoCommands.TelescopicoAutoCom;
import frc.robot.commands.HangCom.TelescopicoCommands.TelescopicoAutoZeroCom;
import frc.robot.commands.HangCom.TelescopicoCommands.TelescopicoCom;
import frc.robot.commands.TraccionCommands.TraccionAutoVertical;
import frc.robot.commands.TraccionCommands.TraccionCom;
import frc.robot.commands.TraccionCommands.TraccionLimelightCom;
import frc.robot.subsystems.Traccion;
import frc.robot.subsystems.Cargo.EjectIntake;
import frc.robot.subsystems.Cargo.Intake;
import frc.robot.subsystems.Cargo.PullBalls;
import frc.robot.subsystems.Cargo.Shooter;
import frc.robot.subsystems.Cargo.UpBalls;
import frc.robot.subsystems.Hang.CargoSensor;
import frc.robot.subsystems.Hang.Piston;
import frc.robot.subsystems.Hang.Telescopico;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {

// COMMANDS AND SUBSYSTEMS DECLARATION//
// DECLARACION DE SUBSISTEMAS Y COMANDOS//
  // Traccion//
  private final Traccion r_Traccion = new Traccion();
  private final TraccionCom r_TraccionCom = new TraccionCom(r_Traccion);
  private final TraccionLimelightCom r_TraccionLimelightCom = new TraccionLimelightCom (r_Traccion);
  // Intake//
  private final Intake r_Intake = new Intake();
  private final IntakeCom r_IntakeCom = new IntakeCom(r_Intake);
  private final EjectIntake r_EjectIntake = new EjectIntake();
  //PullBalls//
  private final PullBalls r_PullBalls = new PullBalls();
  private final PullBallsCom r_PullBallsCom = new PullBallsCom(r_PullBalls);
  // UpBalls//
  private final UpBalls r_UpBalls = new UpBalls();
  private final UpBallsCom r_UpBallsCom = new UpBallsCom(r_UpBalls);
  //Sensor//
  private final CargoSensor r_CargoSensor = new CargoSensor(); 
  // Shooter//
  public static final Shooter r_Shooter = new Shooter();
  public static final ShooterComVels r_ShooterRobotInitCom = new ShooterComVels(r_Shooter, .63);
  // Telescopico//
  private final Telescopico r_Telescopico = new Telescopico();
  private final TelescopicoCom r_TelescopicoCom = new TelescopicoCom(r_Telescopico);
  // Piston//
  private final Piston r_Piston = new Piston(); 
  // Limelight//
  public static final Limelight r_Limelight = new Limelight();

// DECLARACION DE CONTROLES//
  public static final XboxController Control0 = new XboxController(0); // Control 0//
  public static final XboxController Control1 = new XboxController(1); // Control 1//
  public static final XboxController Control2 = new XboxController(2); // Control 2//

// DECLARACION DE BOTONES//
  // Control 0//
  public JoystickButton ButtonA_0 = new JoystickButton(Control0, 1);
  public JoystickButton ButtonB_0 = new JoystickButton(Control0, 2);
  public JoystickButton ButtonX_0 = new JoystickButton(Control0, 3);
  public JoystickButton ButtonY_0 = new JoystickButton(Control0, 4);
  public JoystickButton BumperL_0 = new JoystickButton(Control0, 5);
  public JoystickButton BumperR_0 = new JoystickButton(Control0, 6);
  // Control 1//
  public JoystickButton ButtonA_1 = new JoystickButton(Control1, 1);
  public JoystickButton ButtonB_1 = new JoystickButton(Control1, 2);
  public JoystickButton ButtonX_1 = new JoystickButton(Control1, 3);
  public JoystickButton ButtonY_1 = new JoystickButton(Control1, 4);
  public JoystickButton BumperL_1 = new JoystickButton(Control1, 5);
  public JoystickButton BumperR_1 = new JoystickButton(Control1, 6);
  public JoystickButton Button7_1 = new JoystickButton(Control1, 7);
  public JoystickButton Button8_1 = new JoystickButton(Control1, 8);
  // Control2//
  public JoystickButton DriverS1 = new JoystickButton(Control2, 1);
  public JoystickButton DriverS8 = new JoystickButton(Control2, 8);
  public JoystickButton DriverS9 = new JoystickButton(Control2, 9);
  public JoystickButton DriverS10 = new JoystickButton(Control2, 10);

  public RobotContainer() {

    configureButtonBindings();

  // BUTTONS AND COMMANS ASIGNATION//
  // ASIGNACION DE BOTONES A COMANDOS//
    // Control 0//
    /*ButtonY_0.whenPressed(
      new SequentialCommandGroup(
        new TelescopicoAutoZeroCom(r_Telescopico),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, true),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, false),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoZeroCom(r_Telescopico),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, true),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, false),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoZeroCom(r_Telescopico),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, true),
        new TelescopicoAutoCom(r_Telescopico, 10),
        new PistonCom(r_Piston, false),
        new TelescopicoAutoCom(r_Telescopico, -10),
        new TelescopicoAutoZeroCom(r_Telescopico)
        ));*/
    ButtonX_0.toggleWhenActive(r_TraccionLimelightCom);
    // Control 1//
    ButtonA_1.whenHeld(new ShootPullBallsCom(r_PullBalls, r_UpBalls, 1));
    ButtonB_1.whenHeld(new )
    BumperR_1.whenHeld(new EjectIntakeZeroForwardCom(r_EjectIntake));
    BumperL_1.whenHeld(new EjectIntakeZeroReverseCom(r_EjectIntake));
    ButtonB_1.toggleWhenActive(new CargoSensorCom(r_CargoSensor));
    // Control 2//

    // COMANDOS DE DEFAULT//
    // DEFEAULT COMMANDS//
    r_Traccion.setDefaultCommand(r_TraccionCom);
    r_Intake.setDefaultCommand(r_IntakeCom);
    r_PullBalls.setDefaultCommand(r_PullBallsCom);
    r_UpBalls.setDefaultCommand(r_UpBallsCom);
    r_Telescopico.setDefaultCommand(r_TelescopicoCom);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return ShootTaxi();
  }

    public Command ShootTaxi() {
      return new ParallelCommandGroup( 
        new ShooterComVels(r_Shooter, .63),
        new SequentialCommandGroup(
          new WaitCommand(3)),
          new IntakeCom(r_Intake),
          new IntakeCom(r_Intake),
          new PullUpBalls(r_PullBalls, r_UpBalls, 1),
        new SequentialCommandGroup(
          new WaitCommand(6),
          new ParallelDeadlineGroup(new TraccionAutoVertical(r_Traccion, -45812*2.5, -45812*2.5),
          new WaitCommand(1)
          )));
  }

  public Command TopRed3C() {
    return
    new SequentialCommandGroup(
      new ParallelRaceGroup(
        new TraccionAutoVertical(r_Traccion, -128442, -128442),
        new ShooterComVels(r_Shooter, .5)),       
        new IntakeCom(r_Intake), 
        new PullUpBalls(r_PullBalls, r_UpBalls, 1));
  }
}