package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.Shooter;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.huskylib.src.ReallyBasicPID;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskSpoolShooter extends AutonomousTaskBase{
    private Shooter m_shooter;
    private Timer m_timer;

    private double spoolTime = 1; // Seconds

    public AutoTaskSpoolShooter(){
        m_timer = new Timer();
    }

    public void setShooter(Shooter shooter){
        m_shooter = shooter;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_shooter.set(0.75);
        m_timer.reset();
        m_timer.start();
    }
 
    @Override
    public boolean CheckTask() {
        
        System.out.println("Shooter time: " + m_timer.get());
        if(m_timer.hasElapsed(spoolTime)){
            System.out.println("SHOOOTER DONE");
            //m_shooter.set(0);
            return true;
        } else{
            return false;
        }
    }
}