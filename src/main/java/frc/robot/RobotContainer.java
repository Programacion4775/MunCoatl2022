//LIBRARIES//
//LIBRERIAS//
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CargoCommands.IntakeComBack;
import frc.robot.commands.CargoCommands.IntakeComFront;
import frc.robot.commands.CargoCommands.UpBIntakeCom;
import frc.robot.commands.CargoCommands.UpBallsAutoCom;
import frc.robot.commands.CargoCommands.UpBallsCom;
//import frc.robot.commands.ParkourCom.TelescopicoAutoCom;
//import frc.robot.commands.ParkourCom.TelescopicoAutoCom;
import frc.robot.commands.ParkourCom.TelescopicoCom;
//import frc.robot.commands.ParkourCom.TelescopicoPushAutoCom;
import frc.robot.commands.ParkourCom.TelescopicoPushCom;
import frc.robot.commands.ShooterCommands.ShooterComControl;
import frc.robot.commands.ShooterCommands.ShooterComVels;
import frc.robot.commands.TraccionCommands.TraccionAutoVertical;
import frc.robot.commands.TraccionCommands.TraccionCom;
import frc.robot.commands.TraccionCommands.TraccionLimelightCom;
import frc.robot.subsystems.Traccion;
import frc.robot.subsystems.Cargo.IntakeBack;
import frc.robot.subsystems.Cargo.IntakeFront;
import frc.robot.subsystems.Cargo.UpBalls;
import frc.robot.subsystems.Parkour.Telescopico;
import frc.robot.subsystems.Parkour.TelescopicoPush;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
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
  public static IntakeFront r_IntakeFront = new IntakeFront();
  public static IntakeBack r_IntakeBack = new IntakeBack();
  // UpBalls//
  private final UpBalls r_UpBalls = new UpBalls();
  //private final UpBallsCom r_UpBallsCom = new UpBallsCom(r_UpBalls);
  private final UpBIntakeCom r_UpBIntakeCom = new UpBIntakeCom(r_IntakeBack, r_IntakeFront, r_UpBalls);
  // Shooter//
  private final Shooter r_Shooter = new Shooter();
  private final ShooterComControl r_ShooterComControl = new ShooterComControl(r_Shooter);
  // Telescopico//
  private final Telescopico r_Telescopico = new Telescopico();
  private final TelescopicoCom r_TelescopicoCom = new TelescopicoCom(r_Telescopico);
  // TelescopicoPush//
  private final TelescopicoPush r_TelescopicoPush = new TelescopicoPush();
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
    //ButtonY_0.whenPressed(
      //new SequentialCommandGroup(
        //new TelescopicoAutoCom(r_Telescopico, 45));
        /*new TelescopicoPushAutoCom(r_TelescopicoPush, 200),
        new TelescopicoAutoCom(r_Telescopico, 200)));*/
    ButtonX_0.toggleWhenActive(r_TraccionLimelightCom);
    BumperR_0.whenHeld(new TelescopicoPushCom(r_TelescopicoPush, -1));
    BumperL_0.whenHeld(new TelescopicoPushCom(r_TelescopicoPush, 1));
    BumperR_0.whenReleased(new TelescopicoPushCom(r_TelescopicoPush, 0));
    BumperL_0.whenReleased(new TelescopicoPushCom(r_TelescopicoPush, 0));
    // Control 1//
    ButtonA_1.whenHeld(new IntakeComFront(r_IntakeFront, 1));
    ButtonB_1.whenHeld(new IntakeComBack(r_IntakeBack, 1));
    ButtonX_1.whenHeld(new IntakeComFront(r_IntakeFront, -1));
    ButtonY_1.whenHeld(new IntakeComBack(r_IntakeBack, -1));
    BumperL_1.toggleWhenActive(new ShooterComVels(r_Shooter, .3)); // Shooter velocity 1 - Velocidad 1 shooter//
    BumperR_1.toggleWhenActive(new ShooterComVels(r_Shooter, .5)); // Shooter velocity 2 - Velocidad 2 shooter//
    // Control 2//

    // COMANDOS DE DEFAULT//
    // DEFEAULT COMMANDS//
    r_Traccion.setDefaultCommand(r_TraccionCom);
    //r_UpBalls.setDefaultCommand(r_UpBallsCom);
    r_Shooter.setDefaultCommand(r_ShooterComControl);
    r_Telescopico.setDefaultCommand(r_TelescopicoCom);
    r_UpBalls.setDefaultCommand(r_UpBIntakeCom);
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
    return Fwd();
  }

  public Command Red(){
    return
      new SequentialCommandGroup(
        new WaitCommand(2),
        new TraccionAutoVertical(r_Traccion, -128442, -128442),
        new ParallelCommandGroup(
          new ShooterComVels(r_Shooter, .5),       
          new SequentialCommandGroup(
           new WaitCommand(2),   
           new ParallelDeadlineGroup(
              new WaitCommand(5), 
              new IntakeComBack(r_IntakeBack, 1), 
              new UpBallsAutoCom(r_UpBalls, 1)))),
          new WaitCommand(2),
          new TraccionAutoVertical(r_Traccion, 13975, -13975),
          new WaitCommand(2),
          new TraccionAutoVertical(r_Traccion, 138077, 138077),
          new ParallelDeadlineGroup(
            new WaitCommand(5), 
            new IntakeComBack(r_IntakeBack, 1), 
            new UpBallsAutoCom(r_UpBalls, 1)),
          new TraccionAutoVertical(r_Traccion, -56355, 56355),//900
          new TraccionAutoVertical(r_Traccion, -247447, -247447),
          new TraccionAutoVertical(r_Traccion, 247447, 247447),
          new ParallelCommandGroup(
            new ShooterComVels(r_Shooter, .5),       
            new SequentialCommandGroup(
              new WaitCommand(2),   
              new ParallelDeadlineGroup(
                new WaitCommand(5), 
                new UpBallsAutoCom(r_UpBalls, 1)))));
    }
 /*public Command Blue(){
    return
      new SequentialCommandGroup(
        new WaitCommand(2),
        new TraccionAutoVertical(r_Traccion, -128442, -128442),
        new ParallelCommandGroup(
          new ShooterComVels(r_Shooter, 1),       
          new SequentialCommandGroup(
            new WaitCommand(2),   
            new ParallelDeadlineGroup(
              new WaitCommand(5), 
              new IntakeComBack(r_IntakeBack, 1), 
              new UpBallsAutoCom(r_UpBalls, 1)))),
          new WaitCommand(2),
          new TraccionAutoVertical(r_Traccion, 13975, -13975),
          new WaitCommand(2),
          new TraccionAutoVertical(r_Traccion, 138077, 138077),
          new ParallelDeadlineGroup(
            new WaitCommand(5), 
            new IntakeComBack(r_IntakeBack, 1), 
            new UpBallsAutoCom(r_UpBalls, 1)),
          new TraccionAutoVertical(r_Traccion, -56355, 56355),//900
          new TraccionAutoVertical(r_Traccion, -247447, -247447),
          new TraccionAutoVertical(r_Traccion, 247447, 247447),
          new ParallelCommandGroup(
            new ShooterComVels(r_Shooter, 1),       
            new SequentialCommandGroup(
              new WaitCommand(2),   
              new ParallelDeadlineGroup(
                new WaitCommand(5), 
                new UpBallsAutoCom(r_UpBalls, 1)))));
      }*/
  

  public Command Fwd() {
    return new TraccionAutoVertical(r_Traccion, 45812, 45812);
  }

  public Command LowerHUB() {
    return new ParallelCommandGroup( 
      new ShooterComVels(r_Shooter, .25),//.22 abajo decirle a brau probar con burros mty
      new SequentialCommandGroup(new WaitCommand(3)),
      new IntakeComFront(r_IntakeFront, -1),
      new UpBallsAutoCom(r_UpBalls, 1),
      new SequentialCommandGroup(
        new WaitCommand(5),
        new ParallelDeadlineGroup(new TraccionAutoVertical(r_Traccion, 45812*2.5, 45812*2.5),//casi 3 vueltas de llanta, si pasa x, si no subir 
        new WaitCommand(1)
        )
    )
    );
  }
}