public class LbMain {
  public static void main(String[] args) {
    LightBulb lb = new LightBulb(4,1200,"white");
    System.out.println(lb);

    System.out.println("+--------------------------------------------------------+");

    LightSwitch switch1  = new LightSwitch(lb);
    switch1.push();
    System.out.println(lb);
  }
}
