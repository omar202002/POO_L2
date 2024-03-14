package vlille;

/**
* class for the bike station
*/
public class BikeStation {

   /** array of slots for bikes in the station */
   private Bike[] bikes;
   /** name of the station */
   private String name;

   /**
    * Builds a bike station with a given name and the number of bikes it can contains
    *
    *@param name the name of the bike station
    *@param capacity the capacity of the bike station
    */
   public BikeStation(String name, int capacity) {
      this.name = name;
      this.bikes  = new Bike[capacity];
   }

   /**
    * the name of the bike station
    *
    *@return the name of the bike station
    */
   public String getName() {
      return this.name;
   }

   /**
    * the capacity of the bike station
    *
    *@return the capacity of the bike station
    */
   public int getCapacity() {
      return this.bikes.length;
   }

   /**
    * the number of bikes that are in the bike station
    *
    *@return the number of bikes that are in the bike station
    */
   public int getNumberOfBikes() {
      int result = 0;
      for (int i = 0;i<bikes.length ;i++ ) {
        if(bikes[i] != null){
          result += 1;
        }
      }
      return result;
   }

   /**
    * the first free slot of the bike station (first position is zero)
    *
    *@return the first free slot of the bike station
    */
   public int firstFreeSlot() {
      int i = 0;
      while (i < this.bikes.length) {
        if (this.bikes[i] == null) {
          return i;
        }
        else {
          i = i + 1;
        }
      }
      return -1;
   }

   /**
    * drop a bike in the station (first position is zero)
    *
    *@param bike the bike we want to drop
    *
    *@return a boolean that says if we managed to drop the bike
    */
   public boolean dropBike(Bike bike) {
      if (this.firstFreeSlot() == -1) {
        return false;
      }
      else {
        this.bikes[this.firstFreeSlot()] = bike;
        return true;
      }

   }

   /**
    *take a bike located at a certain position (first position is zero)
    *@exception BikeNotAvailableException if i is negative or bigger than the number of bikes and if this.bikes is not null
    *
    *@param i the bike we want to take's position
    *
    *@return the bike we want to take at the position i;
    */
   public Bike takeBike(int i) throws BikeNotAvailableException {
      if (i>=0 && i<=(this.getCapacity()-1) && (this.bikes[i] != null) ) {
        Bike result = this.bikes[i];
        this.bikes[i]=null;
        return result;
      }
      else {
        throw new BikeNotAvailableException("there is no bike found at that position");
      }
   }

}
