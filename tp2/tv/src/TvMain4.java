
public class TvMain4 {

   public static void usage() {
      System.out.println("Usage : java TvMain3 <uneMarque>");
      System.out.println("  où  <uneMarque> correspond à la marque de la télé créée.");
      System.exit(0);
   }

   public static void main(String[] args) {
      String s ;
      if (args.length < 1) {
         s = "ParDeFo";
      }
      else{
      s=args[0];
      }
      Tv tv1 = new Tv(s);
      System.out.println(tv1.toString());
      System.out.println("--------------------------");
      tv1.on();
      tv1.changeChannel(7);
      tv1.volumeUp();
      System.out.println(tv1); // _tv1_ est remplacé par _tv1.toString()_ à la compilation
      
   }
}
