// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Driver;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.kitbot;

//import frc.robot.subsystems.elevador;
//import frc.robot.subsystems.taker;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

 private final Driver m_traccion = new driver();
 private final dejacoral m_kitbot = new eja_coral();


private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
      
  private final Joystick m_driverController2 =
      new Joystick(OperatorConstants.kDriverControllerPort);

   //   private final CommandJoystick m_driverController3 =
   //   new CommandJoystick(OperatorConstants.kDriverControllerPort2);
        

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    CameraServer.startAutomaticCapture();

    // xbox  m_traccion.setDefaultCommand( 
     // new RunCommand(() -> m_traccion.arcadeDrive(
     //   0.7*m_driverController.getLeftX(),0.7*m_driverController.getLeftY()), m_traccion));

      // m_traccion.setDefaultCommand( 
      //new RunCommand(() -> m_traccion.arcadeDrive(m_driverController2.getZ()*(m_driverController2.getRawAxis(3)-1
      //), m_driverController2.getY()*(m_driverController2.getRawAxis(3)-1)), m_traccion));

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

   

   new Trigger(m_driverController2.button(1,Robot.m_loop))
   .onTrue(m_Dejacoral.Deja_Coral());   


   //new Trigger(m_driverController3.button(1))
   //.onTrue(m_Dejacoral.Deja_Coral());   
   
   //new Trigger(m_driverController.button(2))
   //.onTrue(m_shooter.Shoot_Note());

 //  new Trigger(m_driverController.button(3))
 // .onTrue(m_shooter.Shoot_STOP());

  //new Trigger(m_driverController.button(3))
  //.onTrue(m_taker.tomar());
  //new Trigger(m_driverController.button(4))
  //.onTrue(m_taker.soltar());
  //new Trigger(m_driverController.button(6))
  //.onTrue(m_taker.stop());
  // new Trigger(m_driverController.button(5))
  //.onTrue(m_elevador.bajar_gancho());
//new Trigger(m_driverController.button(6))
 // .onTrue(m_elevador.subir_gancho());
}
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}



