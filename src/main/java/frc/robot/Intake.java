package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.huskylib.src.RoboDevice;


public class Intake extends RoboDevice{
  private CANSparkMax m_intakeMotor;

  public Intake(){
    super("Intake Sub System");

    m_intakeMotor = new CANSparkMax(WiringConnections.INTAKE_CONTROLLER_ID, MotorType.kBrushless);
  }

  public void Initialize(){
    m_intakeMotor = new CANSparkMax(WiringConnections.INTAKE_CONTROLLER_ID, MotorType.kBrushless);
  }

  /**
   * Makes the intake move (in or out)
   * @param speed the speed and direction to move
   */
  public void suck(double speed) {
    m_intakeMotor.set(speed);
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
