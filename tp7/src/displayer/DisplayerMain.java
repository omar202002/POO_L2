package displayer;

public class DisplayerMain {

   private static final int SCREEN_WIDTH = 5;
   private static String msg = "Timoleon";    // default message value
   private static int nbTics = 10;         // number of tics

   private static void handleArgs(String[] args) {
      if (args.length > 0) {
         msg = args[0];
      }
      if (args.length > 1) {
         try {
            nbTics = Integer.parseInt(args[1]);
         } catch (NumberFormatException e) {
            System.out.println("mauvais format, nb tics pris en compte = " + DisplayerMain.nbTics);
         }
      }

   }

   public static void main(String[] args) {

      DisplayerMain.handleArgs(args);

      DisplayerController c = new DisplayerController(new LedDisplayer(SCREEN_WIDTH));

      c.tryIt(msg, nbTics);

      //DisplayerController c = new DisplayerController(new UpperCaseDisplayer(SCREEN_WIDTH));

      //DisplayerController c = new DisplayerController(new DisplayerWithLatency(SCREEN_WIDTH,3));

      /*DisplayerController c = new DisplayerController(new SpeedDisplayer(5,3,2));
      c.tryIt("Abcd",8);*/
      //c.tryIt(msg, nbTics);


      System.out.println("\n*********************************\n");
      c.changeDisplayer(new UpperCaseDisplayer(SCREEN_WIDTH));
      c.tryIt(msg, nbTics);
      


      System.out.println("\n*********************************\n");
      c.changeDisplayer(new DisplayerWithLatency(SCREEN_WIDTH, 3));
      c.tryIt(msg, nbTics);



      System.out.println("\n*********************************\n");
      c.changeDisplayer(new SpeedDisplayer(SCREEN_WIDTH, 3, 2));
      c.tryIt(msg, nbTics);



      System.out.println("\n*********************************\n");
      c.changeDisplayer(new LeftRightDisplayer(SCREEN_WIDTH));
      c.tryIt(msg, nbTics);

   }

}
