package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskTurn extends AutonomousTaskBase{
    private FRC2024Chassis m_chassis;
    private Timer m_timer = new Timer();
    
    private float forwardTime = 1.0f;

    public AutoTaskTurn(){
    }

    public void setChassis(FRC2024Chassis chassis){
        m_chassis = chassis;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_chassis.setTargRotation(0.25);;
        m_timer.start();
    }

    @Override
    public boolean CheckTask() {
        if(m_chassis == null){
            System.out.println("Chassis is null!");
        }
        else{
            System.out.println("Chassis is valid");
        }


        if(m_timer.hasElapsed(forwardTime)){
            m_chassis.setTargRotation(0.0);
            return true;
        } else{
            return false;
        }
    }
}