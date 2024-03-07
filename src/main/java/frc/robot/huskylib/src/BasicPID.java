package frc.robot.huskylib.src;

import frc.robot.huskylib.src.RoboDevice;


import com.ctre.phoenix.motorcontrol.ControlMode.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.opencv.core.Mat;

/**
 * A PID-controlled SPARK MAX that allows rotational target control for motors
 */
public class BasicPID extends RoboDevice{
  
  private CANSparkMax m_motor;
  private RelativeEncoder m_encoder;
  private SparkMaxPIDController m_pidController;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  public double rotations;
  private double m_currentPosition = 0.0;

  /**
   * Constructs a new SPARK MAX motor controller with the specified CAN ID.
   * Confirm that the motor controller's CAN ID is the same as the int passed here using REV Hardware Client
   * @param CANPort the CAN ID of the the SPARK MAX
   */
  private int CANDeviceID;

  public BasicPID(int CANPort){
    super("BasicPID Sub System");
    CANDeviceID = CANPort;

    //Setting up devices
    m_motor = new CANSparkMax(CANPort, MotorType.kBrushless);
    m_encoder = m_motor.getEncoder();
    m_motor.restoreFactoryDefaults();

    m_pidController = m_motor.getPIDController();
    m_pidController.setFeedbackDevice(m_encoder);

    //Setting up PID values
    kP = 0.45; // 0.05 before comp.
    kI = 0;
    kD = 0.1;
    kIz = 0;
    kFF = 0;
    kMaxOutput = 1;
    kMinOutput = -1;
    
    
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);
    
  }

  public void Initialize(){
  }

  @Override
  public void doGatherInfo(){
    super.doGatherInfo();
    m_currentPosition = m_encoder.getPosition();
  }

  @Override
  public void doActions(){
    super.doActions();
    
     
    //Magic line of code that gets it going!
    m_pidController.setReference(rotations, CANSparkMax.ControlType.kPosition);
  }

  /**
   * Gets the position of the motor, in rotations (I think)
   * @return the current position of the motor
   */
  public double getPosition(){
    return m_currentPosition;
  }

  //Setters
  //Attach a call to this method to an action on the joystick
  /**
   * Sets the target for the motor to rotate to
   * @param percentoutput the position to rotate to and hold
   */
  public void setRotations(double percentoutput){
    rotations = percentoutput;
  }

  /**
   * Sets the proportional value of the PID logic
   * @param kP the proportional tune
   */
  public void setPValue(double kP){ 
    m_pidController.setP(kP);
  }

  /**
   * Sets the integral value of the PID logic
   * @param kI the integral tune
   */
  public void setIValue(double kI){ 
    m_pidController.setI(kI);
  }

  /**
   * Sets the derivative value of the PID logic
   * @param kD the derivative tune
   */
  public void setDValue(double kD){
    m_pidController.setD(kD);
  }

  /**
   * Sets the (insert) value of the PID logic
   * @param kIz - I don't know - Will W.
   */
  public void setIZValue(double kIz){ 
    m_pidController.setIZone(kIz);
  }
    
  /**
   * Sets the (insert) value of the PID logic
   * @param kFF - I don't know - Will W.
   */
  public void setFFValue(double kFF){ 
    m_pidController.setFF(kFF); 
  }
  
  /**
   * Sets the minimum and maximum values of the motor
   * Useful for things like arms that you don't want to touch into the ground
   * @param min the minimum rotational value of the motor
   * @param max the maximum rotational value of the motor
   */
  public void setOutputRangeValues(double min, double max){ 
    m_pidController.setOutputRange(min, max); 
    kMinOutput = min; kMaxOutput = max;
  }

  /**
   * Yes, slavery exists
   * Causes a different BasicPID motor to do exactly what the master motor does
   * Useful for multiple motors driving the same shaft, preventing fighting between them, causing things to overheat
   * @param slaveMotor the motor that will follow this motor
   */
  public void setSlave(BasicPID slaveMotor){
    slaveMotor.m_motor.follow(m_motor, true);
  }
}