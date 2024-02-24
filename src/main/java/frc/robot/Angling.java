package frc.robot;

import frc.robot.huskylib.src.*;


public class Angling extends RoboDevice{
  private BasicPID m_angleMotor;

  private double angle;

  public Angling(){
    super("Angling Sub System");
    m_angleMotor = new BasicPID(WiringConnections.SHOOTER_ANGLE_CONTROLLER_ID);
  }

  public void Initialize(){
    m_angleMotor = new BasicPID(WiringConnections.SHOOTER_ANGLE_CONTROLLER_ID);
  }

  public void move(double speed){
    angle = angle - speed / 5;
    m_angleMotor.setRotations(angle);
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
