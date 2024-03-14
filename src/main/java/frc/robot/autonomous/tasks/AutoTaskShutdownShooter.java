package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.Shooter;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.huskylib.src.ReallyBasicPID;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskShutdownShooter extends AutonomousTaskBase{
    private Shooter m_shooter;

    public AutoTaskShutdownShooter(){
    }

    public void setShooter(Shooter shooter){
        m_shooter = shooter;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_shooter.set(0);
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
}