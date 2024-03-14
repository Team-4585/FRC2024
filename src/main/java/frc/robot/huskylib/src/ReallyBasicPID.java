package frc.robot.huskylib.src;

public class ReallyBasicPID {
    private double prevError;

    private double kp;
    private double ki;
    private double kd;
    private double dt;

    public ReallyBasicPID(double kp, double ki, double kd, double dt) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.dt = dt;
    }

    public double calculatePID(double target, double measuredOutput){
        double error;
        double integral;
        double derivative;

        error = target - measuredOutput;
        integral = error * dt;
        derivative = (error - prevError) / dt;
        prevError = error;

        return (kp * error) + (ki * integral) + (kd * derivative);
    }
}
