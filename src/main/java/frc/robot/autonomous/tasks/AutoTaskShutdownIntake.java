package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.Intake;
import frc.robot.Shooter;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.huskylib.src.ReallyBasicPID;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskShutdownIntake extends AutonomousTaskBase{
    private Intake m_intake;

    public AutoTaskShutdownIntake(){
    }

    public void setIntake(Intake intake){
        m_intake = intake;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        m_intake.suck(0);
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
}