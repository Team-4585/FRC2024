package frc.robot;

public class FRC2024TeleopDecisionMaker {
  private FRC2024Joystick m_TheJoystick = new FRC2024Joystick();
  private FRC2024WeaponsJoystick m_TheWeaponsJoystick = new FRC2024WeaponsJoystick();
  private FRC2024Controller m_TheController = new FRC2024Controller();
  private FRC2024WeaponsController m_TheWeaponsController = new FRC2024WeaponsController();

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
      m_Chassis.setTargRotation(((m_TheJoystick.getTwistValue() / 1) * Math.abs(m_TheJoystick.getTwistValue()) * Math.abs(m_TheJoystick.getTwistValue())) / 1);

      /*
      if (m_TheWeaponsJoystick.getPOV() == 0) {
        m_Intake.suck(1);
      } else if (m_TheWeaponsJoystick.getPOV() == 180) {
        m_Intake.suck(-1);
      } else {
        m_Intake.suck(0);
      }

      if (m_TheWeaponsJoystick.triggerPushed()) {
        m_Shooter.set(1);
      } else {
        m_Shooter.set(0);
      }
      */

      m_Intake.suck(m_TheWeaponsController.getLeftYValue() / 5);
      m_Shooter.set(m_TheWeaponsController.getRightTriggerValue() * 0.9 - m_TheWeaponsController.getLeftTriggerValue() * 0.45);

      if (m_TheWeaponsController.yButtonPushed()) {
        m_Intake.suck(1);
      }

      //System.out.println(m_Chassis.getLeftPosition());
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
