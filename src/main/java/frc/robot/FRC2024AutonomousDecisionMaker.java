package frc.robot;

import java.util.List;
import frc.robot.*;

import frc.robot.autonomous.*;

public class FRC2024AutonomousDecisionMaker {
  private List<AutonomousTaskBase> m_TaskList;
  private AutonomousTaskDispatcher m_autoTaskDispatcher;

  private FRC2024Chassis m_Chassis;
  private Intake m_Intake;
  private Angling m_Angling;
  private Shooter m_Shooter;


  private AutoTaskStartSequence autoStartSeq = new AutoTaskStartSequence();
  private AutoTaskShoot autoShoot = new AutoTaskShoot();
  private AutoTaskLoadFire autoLoadFire = new AutoTaskLoadFire();

  //private AutoTaskDriveStraight autoDriveStraight = new AutoTaskDriveStraight();
  //private AutoTaskTurn autoTurn = new AutoTaskTurn();

  public FRC2024AutonomousDecisionMaker(){
   // m_TaskList = List.of(new AutoTaskTickCount(25), new AutoTaskHalt());
    
   System.out.println("Initializing list");
   m_TaskList = List.of(
        autoStartSeq,
        autoShoot,
        autoLoadFire,
        new AutoTaskHalt()
    );

    m_autoTaskDispatcher = new AutonomousTaskDispatcher(m_TaskList);

  }

  public void initialize(){
    m_autoTaskDispatcher.resetAuto();
  }

  public void doDecisions(){
    m_autoTaskDispatcher.RunAutoTask();
    System.out.println("Entering autonomous decisions");
  }

  public void setChassis(FRC2024Chassis TheChassis){
    m_Chassis = TheChassis;
    //autoDriveStraight.setChassis(TheChassis);
    //autoTurn.setChassis(TheChassis);
  }

  public void setIntakeSubSystem(Intake IntakeSys){
    m_Intake = IntakeSys;
    autoLoadFire.setIntake(m_Intake);
  }

  public void setAnglingSubSystem(Angling AnglingSys){
    m_Angling = AnglingSys;
  }

  public void setShooterSubSystem(Shooter ShooterSys){
    m_Shooter = ShooterSys;
    autoShoot.setShooter(m_Shooter);
    autoLoadFire.setShooter(m_Shooter);
  }


}
