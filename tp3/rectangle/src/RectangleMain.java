
public class RectangleMain{
  public static void main(String[] args) {

    if (args.length<1) {
      System.out.println("error");
    }
    else if (args.length>0) {
      Rectangle r1 = new Rectangle(10,5);
      /*Rectangle r2 = new Rectangle(5,5);*/
      Double x1 = 0.0;
      Double x2 = 0.0;
      if (args.length==1) {
        /*Rectangle r2 = new Rectangle(Double.parseDouble(args[0]), Double.parseDouble(args[0]));*/
        x1=Double.parseDouble(args[0]);
        x2=Double.parseDouble(args[0]);
      }
      else if (args.length==2) {
        /*Rectangle r2= new Rectangle(Double.parseDouble(args[0]), Double.parseDouble(args[1]));*/
        x1=Double.parseDouble(args[0]);
        x2=Double.parseDouble(args[1]);
      }

      Rectangle r2 = new Rectangle(x1,x2);

      System.out.println(r1);

      System.out.println("+---------------------------------+");

      System.out.println(r2);

      System.out.println("+---------------------------------+");

      System.out.println("the area of r1 is: "+ r1.area());
      System.out.println("the area of r2 is: "+ r2.area());

      System.out.println("+---------------------------------+");

      if (r1.isSquare()) {
        System.out.println("r1 is a square");
      }
      else{
        System.out.println("r1 is not a square");
      }

      if (r2.isSquare()) {
        System.out.println("r2 is a square");
      }
      else{
        System.out.println("r2 is not a square");
      }

      System.out.println("+---------------------------------+");

      if (r1.equals(r2)) {
        System.out.println("r1 and r2 are the same");
      }
      else {
        System.out.println("r1 and r2 are not the same");
      }
    }

  }
}
