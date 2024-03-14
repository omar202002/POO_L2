/**
*class for the lightbulb
*/

public class LightBulb {
  /** the electric output the lightbulb consumes */
  private int watt;
  /** the light output the lightbulb consumes */
  private int lumens;
  /** the color of the lightbulb when it's turned on */
  private String color;
  /** the state of the lightbulb(On or Off) */
  private  boolean state;

  /**
  *Builds a lightbulb with a given electric and light output, it's color when turned on and it's state that is initially Off
  *
  *@param watt the electric output of the lightbulb
  *@param lumens the light output of the lightbulb
  *@param color the color of the lightbulb when turned on
  */
  public LightBulb(int watt, int lumens, String color){
    this.watt = watt;
    this.lumens = lumens;
    this.color = color;
    this.state = false;
  }

  /**
  *the electric output of the lightbulb
  *
  *@return the electric output of the lightbulb
  */
  public int getWatt(){
    return this.watt;
  }

  /**
  *the light output of the lightbulb
  *
  *@return the light output of the lightbulb
  */
  public int getLumen(){
    return this.lumens;
  }

  /**
  *the color of the lightbulb
  *
  *@return the color of the lightbulb
  */
  public String getColor(){
    return this.color;
  }

  /**
  *turn on the lightbulb
  */
  public void turnOn(){
    this.state = true;
  }

  /**
  *turn off the lightbulb
  */
  public void turnOff(){
    this.state = false;
  }

  /**
  *the state of the lightbulb(On or Off)
  *
  *@return the state of the lightbulb
  */
  public boolean isOn(){
    return this.state == true;
  }

  /**
  *provide a string representation of this LightBulb object
  *
  *@return a string representation of this LightBulb object
  */
  public String toString(){
    String result = "The lightbulb has an electric output of "+ this.watt + " Watts " + ",a light output of " + this.lumens + " Lumens and it is ";
    if (this.state == true) {
      result = result + "on";
    }
    else {
      result = result + "off";
    }
    return result;
  }
}
