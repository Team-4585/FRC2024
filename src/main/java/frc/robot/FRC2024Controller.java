package frc.robot;

import frc.robot.huskylib.devices.HuskyJoystick;
import frc.robot.huskylib.devices.HuskyXbox;

public class FRC2024Controller extends HuskyXbox{
  private static final int FRC2024_CONTROLLER_PORT = 2;
 
  private static final int TRIGGER_BUTTON = 0;

  private static final double STICK_DEAD_ZONE = 0.2;
  private static final double FB_LIVE_ZONE = 1.0 - STICK_DEAD_ZONE;

  private static final double TRIGGER_DEAD_ZONE = 0.1;
  private static final double TRIGGER_LIVE_ZONE = 1.0 - TRIGGER_DEAD_ZONE;


  public FRC2024Controller(){
      super(FRC2024_CONTROLLER_PORT);
  }


  public double getLeftXValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_LEFT_X);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
                                          // raw joystick reading.
      }
    }
        
    //if(RawVal != 0.0){
    //  System.out.println("FBRawVal -> " + RawVal + "    FBRetVal -> " + RetVal);
    //}

    return RetVal;
  }

  public double getLeftYValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_LEFT_Y);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= STICK_DEAD_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal < 0.0){
        RetVal = -RetVal;                 // Fix the sign
      }
    }

    //if(RawVal != 0.0){
    //  System.out.println("SSRawVal -> " + RawVal + "    SSRetVal -> " + RetVal);
    //}

    return RetVal;
  }


  public double getRightXValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_RIGHT_X);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
                                          // raw joystick reading.
      }
    }
        
    //if(RawVal != 0.0){
    //  System.out.println("FBRawVal -> " + RawVal + "    FBRetVal -> " + RetVal);
    //}

    return RetVal;
  }

  public double getRightYValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_RIGHT_Y);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= STICK_DEAD_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal < 0.0){
        RetVal = -RetVal;                 // Fix the sign
      }
    }

    //if(RawVal != 0.0){
    //  System.out.println("SSRawVal -> " + RawVal + "    SSRetVal -> " + RetVal);
    //}

    return RetVal;
  }


  public double getLeftTriggerValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_LEFT_TRIGGER);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= FB_LIVE_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal > 0.0){
        RetVal = -RetVal;                 // Fix the sign, note that we're reversing the sign from the
                                          // raw joystick reading.
      }
    }
        
    //if(RawVal != 0.0){
    //  System.out.println("FBRawVal -> " + RawVal + "    FBRetVal -> " + RetVal);
    //}

    return RetVal;
  }

  public double getRightTriggerValue(){
    double RetVal = 0.0;
    double RawVal = getAxisValue(HuskyXbox.AXIS_RIGHT_TRIGGER);
    double RawMagVal = Math.abs(RawVal);  // work with positive numbers

    if(RawMagVal > STICK_DEAD_ZONE){
      RetVal = RawMagVal - STICK_DEAD_ZONE;  // distance past dead zone
      RetVal /= STICK_DEAD_ZONE;             // scale to full range of live zone
      RetVal = RetVal * RetVal;           // square it to make the line a curve rather than straight
      if(RawVal < 0.0){
        RetVal = -RetVal;                 // Fix the sign
      }
    }

    //if(RawVal != 0.0){
    //  System.out.println("SSRawVal -> " + RawVal + "    SSRetVal -> " + RetVal);
    //}

    return RetVal;
  }


  public Boolean triggerPushed(){
    return isButtonPushed(TRIGGER_BUTTON);
  }

  public Boolean triggerPressEvent(){
    return buttonPressEvent(TRIGGER_BUTTON);
  }
    
  public Boolean triggerReleaseEvent(){
    return buttonReleaseEvent(TRIGGER_BUTTON);
  }
}
