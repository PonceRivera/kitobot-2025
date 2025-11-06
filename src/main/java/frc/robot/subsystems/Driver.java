package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;




public class Driver extends SubsystemBase {

  private static final int kCanID_neo1 = 1; 
  private static final int kCanID_neo2 = 2;
 private static final int kCanID_neo3 = 3;
  private static final int kCanID_neo4 = 4;
  private static final MotorType kMotorType_neo = MotorType.kBrushless;
  private final SparkMax m_motor_neo1 = new SparkMax(kCanID_neo1, kMotorType_neo); 
  SparkClosedLoopController maxPid = m_motor_neo1.getClosedLoopController();  

  private final SparkMax m_motor_neo2 = new SparkMax(kCanID_neo2, kMotorType_neo); 
  private final SparkMax m_motor_neo3 = new SparkMax(kCanID_neo3, kMotorType_neo); 
  private final SparkMax m_motor_neo4 = new SparkMax(kCanID_neo4, kMotorType_neo); 



  DifferentialDrive traccion = new DifferentialDrive(m_motor_neo1,m_motor_neo3);
  //DifferentialDrive traccion = new DifferentialDrive(a,c);


  public Driver() {

    SparkMaxConfig config = new SparkMaxConfig();
    SparkMaxConfig config2 = new SparkMaxConfig();
    SparkMaxConfig config3 = new SparkMaxConfig();
    

    config
    .inverted(true)
    .idleMode(IdleMode.kBrake);
    config.encoder
    .positionConversionFactor(1000)
    .velocityConversionFactor(1000);
    config.closedLoop
    .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
    .pid(1.0, 0.0, 0.0); 

    config2
    .inverted(false)
    .idleMode(IdleMode.kBrake);
    
    config3
    .inverted(false)
    .idleMode(IdleMode.kBrake);
    

    config2.follow(kCanID_neo1);
    config3.follow(kCanID_neo3);

    m_motor_neo1.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_motor_neo2.configure(config2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_motor_neo3.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_motor_neo4.configure(config3, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    traccion.setSafetyEnabled(false);
}
}

