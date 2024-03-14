package vlille;

import vlille.util.BikeModel;

public class BikeMain {

   public static void main(String[] args) {
      Bike someBike = new Bike("biclou", BikeModel.ELECTRIC);
      System.out.println(someBike);
   }

}
