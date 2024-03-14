package frc.robot.autonomous.tasks;

import frc.robot.autonomous.AutonomousTaskBase;

// Dummy task to start off the task list that won't have any early initialization issues
public class AutoTaskStartSequence extends AutonomousTaskBase {
    public AutoTaskStartSequence(){      
    }

    @Override
    public void TaskInitialize() {
    }

    @Override
    public boolean CheckTask() {
        return true;
    }
    
}
