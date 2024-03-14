package vlille;

import vlille.util.BikeModel;

public class BikeStationMain {
  public static void main(String[] args) {
    BikeStation station = new BikeStation("Timoleon",10);

    Bike b1 = new Bike("b001",BikeModel.CLASSIC);
    Bike b2 = new Bike("b002",BikeModel.ELECTRIC);

    station.dropBike(b1);
    station.dropBike(b2);

    if (args.length != 1 ) {
      System.out.println("Erreur: un et un seul argument doit obligatoirement être passé en paramètre");
    }

    int i=Integer.parseInt(args[0]);

    try {
      System.out.println(station.takeBike(i));
    }
    catch (BikeNotAvailableException e) {
      System.out.println("argument trop grand");
    }

  }
}
