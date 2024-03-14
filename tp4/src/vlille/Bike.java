package vlille;
import vlille.util.BikeModel;

/**
 * A class to model bike that are rent in a bike station.
 *
 * @author JC
 *
 */
public class Bike {

   public static final float RENTAL_PRICE = 100;

   private String id;
   private BikeModel model;

   public Bike(String id, BikeModel model) {
      this.id = id;
      this.model = model;
   }

   /**
    * @return the reference
    */
   public String getId() {
      return this.id;
   }

   /**
    * @return the model
    */
   public BikeModel getModel() {
      return this.model;
   }

   public boolean equals(Object o) {
      if (o instanceof Bike) {
         Bike other = (Bike) o;
         return this.id.equals(other.id);
      } else {
         return false;
      }
   }

   public String toString() {
      return "bike id: " + this.id + ", model : " + this.model;
   }
}
