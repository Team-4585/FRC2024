package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.Intake;
import frc.robot.Shooter;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.huskylib.src.ReallyBasicPID;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskShoot extends AutonomousTaskBase{
    private Intake m_intake;
    private Timer m_timer;

    private double shootTime = 1; // Seconds
    private double cooldownTime = 1; // Seconds

    public AutoTaskShoot(){
        m_timer = new Timer();
    }

    public void setIntake(Intake intake){
        m_intake = intake;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_intake.suck(0.5);
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public boolean CheckTask() {
        if(m_timer.hasElapsed(shootTime + cooldownTime)){
            return true;
        } else if (m_timer.hasElapsed(shootTime)) {
            m_intake.suck(0);
            return false;
        } else {
            return false;
        }
    }
}