package vlille;

import static org.junit.Assert.*;

import org.junit.Test;

import vlille.util.BikeModel;

public class BikeStationTest {

   @Test
   public void stateIsCorrectAtCreation() {
      BikeStation station = new BikeStation("timoleon", 5);
      assertEquals("timoleon", station.getName());
      assertEquals(5, station.getCapacity());
      // no bike at creation
      assertEquals(0, station.getNumberOfBikes());
   }

   @Test
   public void firstFreeSlotWhenOneSlotIsFree() throws BikeNotAvailableException {
      BikeStation station = new BikeStation("none", 5);
      // no bike slot 0 is first slot
      assertEquals(0, station.firstFreeSlot());
      station.dropBike(new Bike("ref1", BikeModel.CLASSIC));
      station.dropBike(new Bike("ref2", BikeModel.CLASSIC));
      // two bikes added, first free slot is 2
      assertEquals(2, station.firstFreeSlot());
      // remove first bike
      station.takeBike(0);
      // first free slot is now 0
      assertEquals(0, station.firstFreeSlot());
   }

   @Test
   public void firstFreeSlotReturnsMinusOneWhenNoFreeSlots() {
      BikeStation station = new BikeStation("none", 5);
      // fill the station
      for (int i = 0; i < station.getCapacity(); i++) {
         station.dropBike(new Bike("ref", BikeModel.CLASSIC));
      }
      // no more free slots
      assertEquals(-1, station.firstFreeSlot());
   }

   @Test
   public void dropBikeReturnsTrueWhenFreeSlot() {
      BikeStation station = new BikeStation("none", 2);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      // check that bike can be droped
      assertTrue(station.dropBike(b1));
      // there is 1 more bike
      assertEquals(1, station.getNumberOfBikes());
      // similar with second bike
      assertTrue(station.dropBike(b1));
      assertEquals(2, station.getNumberOfBikes());
   }

   @Test
   public void dropBikeReturnsFalseWhenNoFreeSlot() {
      BikeStation station = new BikeStation("none", 2);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      // two first bikes can be dropped
      assertTrue(station.dropBike(b1));
      assertEquals(1, station.getNumberOfBikes());
      assertTrue(station.dropBike(b1));
      assertEquals(2, station.getNumberOfBikes());
      // already two added bikes, can not drop a third one
      assertFalse(station.dropBike(b1));
      assertEquals(2, station.getNumberOfBikes());
   }

   @Test
   public void dropBikeUseFirstFreeSlot() {
      BikeStation station = new BikeStation("none", 2);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      // first free slot is 0
      assertEquals(0, station.firstFreeSlot());
      // use first free slot (0)
      station.dropBike(b1);
      // first free slot has been used, then it has become 1
      assertEquals(1, station.firstFreeSlot());
      // use first free slot (1)
      station.dropBike(b1);
      // and now it is -1 since station is full
      assertEquals(-1, station.firstFreeSlot());
   }

   @Test
   public void takeBikeIsOkWhenBikeAvailable() throws BikeNotAvailableException {
      BikeStation station = new BikeStation("none", 5);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      station.dropBike(b1);
      assertEquals(1, station.getNumberOfBikes());
      // taken bike, at slot 0, is b1
      assertSame(b1, station.takeBike(0));
      assertEquals(0, station.getNumberOfBikes());
   }

   @Test(expected = BikeNotAvailableException.class)
   public void takeBikeThrowsExceptionWhenNoBike() throws BikeNotAvailableException {
      BikeStation station = new BikeStation("none", 5);
      station.takeBike(0);
   }

   @Test(expected = BikeNotAvailableException.class)
   public void takeBikeThrowsExceptionWhenIndexNegative() throws BikeNotAvailableException {
      BikeStation station = new BikeStation("none", 5);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      station.dropBike(b1);
      station.takeBike(-1);
   }

   @Test(expected = BikeNotAvailableException.class)
   public void takeBikeThrowsExceptionWhenIndexTooBig() throws BikeNotAvailableException {
      BikeStation station = new BikeStation("none", 5);
      Bike b1 = new Bike("ref", BikeModel.CLASSIC);
      station.dropBike(b1);
      // index too big
      station.takeBike(10);
   }

   // ---Pour permettre l'exécution des test----------------------
   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(vlille.BikeStationTest.class);
   }

}
