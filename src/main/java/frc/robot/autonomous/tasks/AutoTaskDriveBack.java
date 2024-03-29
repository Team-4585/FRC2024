package frc.robot.autonomous.tasks;

import frc.robot.FRC2024Chassis;
import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.huskylib.src.ReallyBasicPID;
import frc.robot.FRC2024Chassis;
import edu.wpi.first.wpilibj.Timer;

public class AutoTaskDriveBack extends AutonomousTaskBase{
    private FRC2024Chassis m_chassis;
    private ReallyBasicPID m_PID;
    
    private double initialPosition = 0.0;
    private float targetRotations = -3.0f;
    private double rotationsRemaining = targetRotations;
    private double acceptableError = 0.12;
    private double maxSpeed = 0.75;

    public AutoTaskDriveBack(double kp, double ki, double kd, double dt){
        m_PID = new ReallyBasicPID(kp, ki, kd, dt);
    }

    public void setChassis(FRC2024Chassis chassis){
        m_chassis = chassis;
    }

    @Override
    public void TaskInitialize() {
        // TODO Auto-generated method stub
        initialPosition = m_chassis.getLeftPosition();
        System.out.println("Back");
    }

    @Override
    public boolean CheckTask() {
        rotationsRemaining = initialPosition + targetRotations - m_chassis.getLeftPosition();

        double speed = Math.max(-maxSpeed, Math.min(maxSpeed, m_PID.calculatePID(targetRotations, targetRotations - rotationsRemaining)));
        m_chassis.setTargForwardBack(speed);

        //System.out.println(rotationsRemaining);

        if(Math.abs(rotationsRemaining) <= acceptableError){
            m_chassis.setTargForwardBack(0.0);
            return true;
        } else{
            return false;
        }
    }
}