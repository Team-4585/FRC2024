package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.huskylib.src.RoboDevice;


public class Shooter extends RoboDevice{
  private CANSparkMax m_shooterLeftMotor;
  private CANSparkMax m_shooterRightMotor;

  public Shooter(){
    super("Shooter Sub System");
  }

  public void Initialize(){
    m_shooterLeftMotor = new CANSparkMax(WiringConnections.SHOOTER_LEFT_CONTROLLER_ID, MotorType.kBrushless);
    m_shooterRightMotor = new CANSparkMax(WiringConnections.SHOOTER_RIGHT_CONTROLLER_ID, MotorType.kBrushless);
  }

  public void shoot(double speed) {
    m_shooterLeftMotor.set(speed);
    m_shooterRightMotor.set(-speed);
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

  }

  @Override
  public void doActions() {
    super.doActions();
  }

}
