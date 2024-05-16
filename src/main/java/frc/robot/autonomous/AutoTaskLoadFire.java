package frc.robot.autonomous;
import frc.robot.*;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskLoadFire extends AutonomousTaskBase{
    private Intake m_Intake;
    private Shooter m_shooter;
    private Timer m_timer = new Timer();
    
    private float runTime = 3.5f;

    public AutoTaskLoadFire(){
        
    }
    
    public void setShooter(Shooter shooter){
        m_shooter = shooter;
    }

    public void setIntake(Intake Intake){
        m_Intake = Intake;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_Intake.suck(0.5);
        m_timer.start();
    }

    @Override
    public boolean CheckTask() {
        if(m_timer.hasElapsed(runTime)){
            m_Intake.suck(0.0);
            m_shooter.shoot(0.0);
            return true;
        } else{
            return false;
        }
    }
}