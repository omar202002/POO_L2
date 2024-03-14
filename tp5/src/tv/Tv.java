package tv;

/**
 * class for television
 */

public class Tv {

   /** status of this Tv, <code>true</code> if on, <code>false</code> if off */
   private boolean on;
   /** the brand of this tv */
   private String brand;
   /** the current channel number */
   private int channel;
   /** current sound level, between 0 and <code>maxSound</code> */
   private int soundVolume;
   /** maximum possible sound level */
   private int maxSound;

   /**
    * Builds a Tv of unknown brand, initially it is off, ready for channel 5 and
    * sound volume is 3 for a max sound level of 10.
    */
   public Tv() {
      this.on = false;
      this.brand = "unknown"; //
      this.channel = 5; // les valeurs numériques devraient être
      this.soundVolume = 3; // définies dans des constantes
      this.maxSound = 10; //
   }

   /**
    * Builds a Tv of given brand, initially it is off, ready for channel 5 and
    * sound volume is 3 for a max sound level of 10.
    * 
    * @param brand this tv's brand
    */
   public Tv(String brand) {
      this.on = false;
      this.brand = brand;
      this.channel = 5; // les valeurs numériques devraient être
      this.soundVolume = 3; // définies dans des constantes
      this.maxSound = 10; //
   }

   /**
    * turn this tv on
    */
   public void on() {
      this.on = true;
   }

   /**
    * turn this tv off
    */
   public void off() {
      this.on = false;
   }

   /**
    * get this Tv's brand
    * 
    * @return this Tv's brand
    */
   public String getBrand() {
      return this.brand;
   }

   /**
    * change current CHANNEL if this Tv is on
    * 
    * @param channelNum the new current CHANNEL (&gt;0)
    * @return the CHANNEL before change
    */
   public int changeChannel(int channelNum) {
      int saveChannel = this.channel;
      if (this.on && channelNum > 0) {
         this.channel = channelNum;
      }
      return saveChannel;
   }

   /**
    * return the current channel
    * 
    * @return the current channel
    */
   public int currentChannel() {
      return this.channel;
   }

   /**
    * increase sound level if on, sound level can not be greater than max level
    */
   public void volumeUp() {
      if (this.on && this.soundVolume < this.maxSound) {
         this.soundVolume = this.soundVolume + 1; // ou this.soundVolume++
      }
   }

   /**
    * increase sound level if tv is on, sound level can not be negative
    */
   public void volumeDown() {
      if (this.on && this.soundVolume > 0) {
         this.soundVolume--; // equivaut a this.soundVolume = this.soundVolume - 1,
      }
   }

   /**
    * provide a string representation for this Tv object
    * 
    * @return a string representation for this Tv object
    */
   public String toString() {
      String result = "tv " + this.brand;
      if (this.on) {
         result = result + " is on, ";
      } else {
         result = result + " is off, ";
      }
      result = result + "channel : " + this.channel + " - sound volume : " + this.soundVolume;
      return result;
   }

}
