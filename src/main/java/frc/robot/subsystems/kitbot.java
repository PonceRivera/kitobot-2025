package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class KitBot extends SubsystemBase {

  private static final int kCanID_Neo1 = 14; // Este tiene el encoder
  private static final MotorType kMotorType = MotorType.kBrushed;

  private final SparkMax m_motorNeo;

  public KitBot() {
    m_motorNeo = new SparkMax(kCanID_Neo1, kMotorType);

    SparkMaxConfig config = new SparkMaxConfig();
    config
        .inverted(false)
        .idleMode(IdleMode.kBrake);

    m_motorNeo.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command dejaCoral() {
    return runOnce(() -> {
      m_motorNeo.set(0.5);
      Timer.delay(0.1);
      m_motorNeo.set(0);
    });
  }
}
