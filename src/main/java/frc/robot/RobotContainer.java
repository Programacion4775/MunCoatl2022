//LIBRARIES//
//LIBRERIAS//
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Parkour.TelescopicoCom;
import frc.robot.commands.TraccionCommands.TraccionAutoVertical;
import frc.robot.commands.TraccionCommands.TraccionCom;
import frc.robot.subsystems.Traccion;
import frc.robot.subsystems.Telescopico;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {

//COMMANDS AND SUBSYSTEMS DECLARATION//
//DECLARACION DE SUBSISTEMAS Y COMANDOS//
  
  //Traccion//
  private final Traccion r_Traccion = new Traccion();
  private final TraccionCom r_TraccionCom = new TraccionCom(r_Traccion);
  //Telescopico//
  private final Telescopico r_Telescopico = new Telescopico();
  private final TelescopicoCom r_TelescopicoCom = new TelescopicoCom(r_Telescopico); 

//DECLARACION DE CONTROLES//
  public static final XboxController Control0 = new XboxController(0);

//DECLARACION DE BOTONES//


  public RobotContainer() {

    configureButtonBindings();

//BUTTONS AND COMMANS ASIGNATION//
//ASIGNACION DE BOTONES A COMANDOS// 
    //Control 2//





//COMANDOS DE DEFAULT//
//DEFEAULT COMMANDS//
    r_Telescopico.setDefaultCommand(r_TelescopicoCom);
    r_Traccion.setDefaultCommand(r_TraccionCom);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return 
        new ParallelCommandGroup(new TraccionAutoVertical(r_Traccion, 50, 50),
        new WaitCommand(1)
    );
  }
  }
