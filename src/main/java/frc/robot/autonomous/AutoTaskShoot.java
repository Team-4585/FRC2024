package frc.robot.autonomous;
import frc.robot.*;

import frc.robot.FRC2024Chassis;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskShoot extends AutonomousTaskBase{
    private Shooter m_shooter;

    public AutoTaskShoot(){
        
    }
    public void setShooter(Shooter shooter){
        m_shooter = shooter;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_shooter.shoot(1);
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
}







//TaskInitialize() {
    //Casual_mental_breakdown }
    