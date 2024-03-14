
package displayer;

public class DisplayerController {

   private LedDisplayer displayer;

   /** 
    * @param displayer the controlled displayer
    */
   public DisplayerController(LedDisplayer displayer) {
      this.displayer = displayer;
   }

   /** change the controlled displayer
    * @param displayer the new displayer
    */
   public void changeDisplayer(LedDisplayer displayer) {
      this.displayer = displayer;
   }

   /** use the displayer with given message for nbTics steps
    * @param message displaid message
    * @param nbTics number of shifts ("time" of run)
    */
   public void tryIt(String message, int nbTics) {
      this.displayer.setMessage(message);
      for (int i = 0; i < nbTics; i++) {
         this.displayer.shift();
         try {
            Thread.sleep(500);
         } catch (Exception e) { }
         System.out.println("|" + displayer.textOnScreen() + "|");
      }
   }

}
