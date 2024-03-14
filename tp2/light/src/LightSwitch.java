/**
*class for the lightbulb's switch
*/
public class LightSwitch {
  /**the lightbulb that is connected to the switch*/
  private LightBulb lightbulb;

  /**
  *Builds a switch for a lightbulb
  *
  *@param lightbulb
  */
  public LightSwitch(LightBulb lightbulb){
    this.lightbulb = lightbulb;
  }

  /**
  *returns the lightbulb
  *
  *@return the lightbulb that is connected to the switch
  */
  public LightBulb getLightBulb(){
    return this.lightbulb;
  }

  /**
  *turn off or turn on the lightbulb depending on it's state(on or off)
  */
  public void push(){
    if (this.lightbulb.isOn()) {
      this.lightbulb.turnOff();
    }
    else {
      this.lightbulb.turnOn();
    }
  }
}
