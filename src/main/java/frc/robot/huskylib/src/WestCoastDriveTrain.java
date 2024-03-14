package frc.robot.huskylib.src;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class WestCoastDriveTrain extends RoboDevice{

  private double m_targSpeed = 0.0;
  private double m_targRotationSpeed = 0.0;
  private double m_currentSpeed = 0.0;
  private double m_currentRotationSpeed = 0.0;
  private double m_currentLeftRotations = 0.0;
  private double m_currentRightRotations = 0.0;

  private final double m_GEAR_RATIO = 10.7;

  private CANSparkMax m_leftMasterController;
  private CANSparkMax m_leftSlaveController;
  private CANSparkMax m_rightMasterController;
  private CANSparkMax m_rightSlaveController;

  private RelativeEncoder m_leftEncoder;
  private RelativeEncoder m_rightEncoder;


  public WestCoastDriveTrain(int leftMasterID, int leftSlaveID, int rightMasterID, int rightSlaveID){
    super("WestCoastDriveTrain");

    m_leftMasterController = new CANSparkMax(leftMasterID, MotorType.kBrushless);
    m_leftSlaveController = new CANSparkMax(leftSlaveID, MotorType.kBrushless);
    m_rightMasterController = new CANSparkMax(rightMasterID, MotorType.kBrushless);
    m_rightSlaveController = new CANSparkMax(rightSlaveID, MotorType.kBrushless);

    m_leftEncoder = m_leftMasterController.getEncoder();
    m_rightEncoder = m_rightMasterController.getEncoder();

    m_leftSlaveController.follow(m_leftMasterController);
    m_rightSlaveController.follow(m_rightMasterController);
  }

  public void Initialize(){
  }

  public void setTargSpeed(double targSpeed){
    m_targSpeed = targSpeed;
  }

  public void setTargRotationSpeed(double targRotationSpeed){
    m_targRotationSpeed = targRotationSpeed;
  }

  public double getTargSpeed(){
    return m_targSpeed;
  }

  public double getTargRotationSpeed(){
    return m_targRotationSpeed;
  }

  public double getCurrentSpeed(){
    return m_currentSpeed;
  }

  public double getCurrentRotationSpeed(){
    return m_currentRotationSpeed;
  }

  public double getCurrentLeftPosition() {
    return m_currentLeftRotations;
  }

  public double getCurrentRightPosition() {
    return m_currentRightRotations;
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

    m_currentLeftRotations = m_leftEncoder.getPosition() / m_GEAR_RATIO;
    m_currentRightRotations = m_rightEncoder.getPosition() / m_GEAR_RATIO;
  }

  @Override
  public void doActions() {
    super.doActions();

    m_leftMasterController.set(m_targSpeed + m_targRotationSpeed);
    m_rightMasterController.set(m_targRotationSpeed - m_targSpeed);

    // if(m_currentSpeed < m_targSpeed){
    //   m_currentSpeed += 0.01;
    // }
    // else if (m_currentSpeed > m_targSpeed) {
    //   m_currentSpeed -= 0.01;
    // }

    // if(m_currentRotationSpeed < m_targRotationSpeed){
    //   m_currentRotationSpeed += 0.01;
    // }
    // else if (m_currentRotationSpeed > m_targRotationSpeed) {
    //   m_currentRotationSpeed -= 0.01;
    // }

    if(debugModeOn()){
      System.out.println(getDeviceName() + "-- speed: " + m_currentSpeed + "  rotation: " + m_currentRotationSpeed);
    }

  }

}
