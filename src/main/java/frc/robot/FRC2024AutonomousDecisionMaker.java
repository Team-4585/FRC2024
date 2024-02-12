package frc.robot;

public class FRC2024AutonomousDecisionMaker {

  private FRC2024Chassis m_Chassis;
  private Intake m_Intake;
  private Angling m_Angling;
  private Shooter m_Shooter;


  FRC2024AutonomousDecisionMaker(){
  }

  public void initialize(){
  }

  public void doDecisions(){
  }

  public void setChassis(FRC2024Chassis TheChassis){
    m_Chassis = TheChassis;
  }

  public void setIntakeSubSystem(Intake IntakeSys){
    m_Intake = IntakeSys;
  }

  public void setAnglingSubSystem(Angling AnglingSys){
    m_Angling = AnglingSys;
  }

  public void setShooterSubSystem(Shooter ShooterSys){
    m_Shooter = ShooterSys;
  }


}
