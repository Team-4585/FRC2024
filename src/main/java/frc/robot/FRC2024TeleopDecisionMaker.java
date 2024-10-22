package frc.robot;

import java.io.IOException;

import frc.robot.huskylib.src.*;

public class FRC2024TeleopDecisionMaker {
  private FRC2024Joystick m_TheJoystick = new FRC2024Joystick();
  private FRC2024WeaponsJoystick m_TheWeaponsJoystick = new FRC2024WeaponsJoystick();
  private HuskyHandTracker m_TheTracker;// = new HuskyHandTracker();

  private FRC2024Chassis m_Chassis;
  private Intake m_Intake;
  //private Angling m_Angling;
  private Shooter m_Shooter;



  FRC2024TeleopDecisionMaker() {
    m_TheTracker = new HuskyHandTracker();
  }

  public void initialize() {
    m_TheTracker = new HuskyHandTracker();
  }

  public void doDecisions(){

    // System.out.println("-- F/B: " + m_TheJoystick.getForwardBackwardValue() + 
    //                    "   S/S: " + m_TheJoystick.getSideToSideValue() + 
    //                    "   Rot: " + m_TheJoystick.getTwistValue());

    m_Chassis.setTargForwardBack(m_TheTracker.getPitch());
    m_Chassis.setTargRotation(m_TheTracker.getRoll());
    
      //m_Chassis.setTargForwardBack(m_TheJoystick.getForwardBackwardValue() * Math.abs(m_TheJoystick.getForwardBackwardValue()));
      //m_Chassis.setTargRotation(((m_TheJoystick.getTwistValue() / 3) * Math.abs(m_TheJoystick.getTwistValue()) * Math.abs(m_TheJoystick.getTwistValue())) / 2);

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

      //m_Angling.move(m_TheWeaponsJoystick.getForwardBackwardValue());
  }

  public void setChassis(FRC2024Chassis TheChassis){
    m_Chassis = TheChassis;
  }

  public void setIntakeSubSystem(Intake IntakeSys){
    m_Intake = IntakeSys;
  }

  public void setAnglingSubSystem(Angling AnglingSys){
    //m_Angling = AnglingSys;
  }

  public void setShooterSubSystem(Shooter ShooterSys){
    m_Shooter = ShooterSys;
  }


}
