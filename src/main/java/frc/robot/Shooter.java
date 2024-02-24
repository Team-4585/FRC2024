package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.huskylib.src.RoboDevice;


public class Shooter extends RoboDevice{
  private CANSparkMax m_shooterMotor;

  public Shooter(){
    super("Shooter Sub System");


    m_shooterMotor = new CANSparkMax(WiringConnections.SHOOTER_CONTROLLER_ID, MotorType.kBrushless);
  }

  public void Initialize(){
    m_shooterMotor = new CANSparkMax(WiringConnections.SHOOTER_CONTROLLER_ID, MotorType.kBrushless);
  }

  public void shoot(double speed) {
    m_shooterMotor.set(speed);
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
