package io;

import java.util.Scanner;

/**
 * tool class for inputs (String or int)
 *
 * @author <a href="mailto:routier@univ-lille.fr">Jean-Christophe Routier</a>
 */
public class Input {

   private static Scanner scanner = new Scanner(System.in);

   /**
    * reads a string from standard input
    * 
    * @return the read string
    */
   public static String readString() {
      return Input.scanner.next();
   }

   /**
    * reads an int from standard input
    * 
    * @return the read int
    * @exception java.io.IOException if input does not correspond to an int
    */
   public static int readInt() throws java.io.IOException {
      try {
         return Input.scanner.nextInt();
      } catch (Exception e) {
         Input.scanner.skip(".*");
         throw new java.io.IOException();
      }
   }

}// Input
