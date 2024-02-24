package frc.robot;

import java.util.List;

import frc.robot.autonomous.AutoTaskDriveStraight;
import frc.robot.autonomous.AutoTaskHalt;
import frc.robot.autonomous.AutoTaskStartSequence;
import frc.robot.autonomous.AutoTaskTurn;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.autonomous.AutonomousTaskDispatcher;

public class FRC2024AutonomousDecisionMaker {
  private List<AutonomousTaskBase> m_TaskList;
  private AutonomousTaskDispatcher m_autoTaskDispatcher;

  private FRC2024Chassis m_Chassis;
  private Intake m_Intake;
  private Angling m_Angling;
  private Shooter m_Shooter;


  private AutoTaskStartSequence autoStartSeq = new AutoTaskStartSequence();
  private AutoTaskDriveStraight autoDriveStraight = new AutoTaskDriveStraight();
  private AutoTaskTurn autoTurn = new AutoTaskTurn();

  FRC2024AutonomousDecisionMaker(){
   // m_TaskList = List.of(new AutoTaskTickCount(25), new AutoTaskHalt());
    
   System.out.println("Initializing list");
   m_TaskList = List.of(
        autoStartSeq,
        autoDriveStraight,
        autoTurn,
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
    autoDriveStraight.setChassis(TheChassis);
    autoTurn.setChassis(TheChassis);
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
