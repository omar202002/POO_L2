package io;


/**
 * tool class for inputs (String or int)
 *
 * @author <a href="mailto:routier@univ-lille.fr">Jean-Christophe Routier</a>
 */
public class InputMain {

   // example of use util class Input
   public static void main(String[] args) {
      // example for String input
      System.out.print(" enter  a String : ? ");
      String userString = Input.readString();
      
      // example for int input   
      System.out.println("enter an int => " + userString);
      int userInt;
      try {
         System.out.print(" give an int : ? ");
         userInt = Input.readInt();
         System.out.println("read int => " + userInt);
      } catch (java.io.IOException e) {
         // "exception... : input does not correspond to an integer
         // here we _arbitrarily choose_ to provide 0 as default value
         userInt = 0;
         System.out.println("corrected value  => " + userInt);
      }
      System.out.println(" value  (read or corrected) => " + userInt);

   }
}// Input
