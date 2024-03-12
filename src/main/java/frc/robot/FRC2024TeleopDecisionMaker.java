package frc.robot;

public class FRC2024TeleopDecisionMaker {
  private FRC2024Joystick m_TheJoystick = new FRC2024Joystick();
  private FRC2024WeaponsJoystick m_TheWeaponsJoystick = new FRC2024WeaponsJoystick();

  private FRC2024Chassis m_Chassis;
  private Intake m_Intake;
  //private Angling m_Angling;
  private Shooter m_Shooter;



  FRC2024TeleopDecisionMaker(){

  }

  public void initialize(){
  }

  public void doDecisions(){
      m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue() * Math.abs(m_TheJoystick.getForwardBackwardValue()));
      m_Chassis.setTargRotation(((m_TheJoystick.getTwistValue() / 3) * Math.abs(m_TheJoystick.getTwistValue()) * Math.abs(m_TheJoystick.getTwistValue())) / 2);

      if (m_TheWeaponsJoystick.getPOV() == 0) {
        m_Intake.suck(1);
      } else if (m_TheWeaponsJoystick.getPOV() == 180) {
        m_Intake.suck(-1);
      } else {
        m_Intake.suck(0);
      }

      if (m_TheWeaponsJoystick.triggerPushed()) {
        m_Shooter.shoot(1);
      } else {
        m_Shooter.shoot(0);
      }
  }

  public void setChassis(FRC2024Chassis TheChassis){
    m_Chassis = TheChassis;
  }

  public void setIntakeSubSystem(Intake IntakeSys){
    m_Intake = IntakeSys;
  }

  public void setShooterSubSystem(Shooter ShooterSys){
    m_Shooter = ShooterSys;
  }
}
