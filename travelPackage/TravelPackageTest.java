package TravelPackage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TravelPackageTest {
	TravelPackage travelPackage; 
	
	@Before
	public void setUp() throws Exception {
		String testName = "Test Name";
		int testCapacity = 5;
		travelPackage = new TravelPackage(testName,testCapacity); 
	}

	@Test
	public final void testSetName() {
		String newName = "New Name";
		travelPackage.setName(newName);
		assertEquals(travelPackage.getName(), newName);
	}
	
	@Test
	public final void testSetCapacity() {
		int newCapacity = 6;
		travelPackage.setCapacity(newCapacity);
		assertEquals(travelPackage.getCapacity(), newCapacity);
	}
	
	@Test
	public final void testGetName() {
		String newName = "New Name";
		travelPackage.setName(newName);
		assertEquals(travelPackage.getName(), newName);
	}
	
	@Test
	public final void testGetCapacity() {
		int newCapacity = 6;
		travelPackage.setCapacity(newCapacity);
		assertEquals(travelPackage.getCapacity(), newCapacity);
	}

	@Test
	public final void testGetItinerary() {
		List<Destination> requiredDestination = new ArrayList<Destination> ();
		Destination testDestination = new Destination ("Test Destination Name");
		travelPackage.addDestination(testDestination);
		requiredDestination.add(testDestination);
		testDestination = new Destination ("Test Destination Name2");
		travelPackage.addDestination(testDestination);
		requiredDestination.add(testDestination);
		List<Destination> fetchedDestination = travelPackage.getItinerary();
		assertEqual(fetchedDestination,testDestination);
	}
	
	@Test
	public final void testGetPassengers() {
		List<Passenger> requiredPassenger = new ArrayList<Passenger>();
		Passenger passenger = new Passenger("Test Name", PassengerType.GOLD, 90.0);
		travelPackage.addPassenger(passenger);
		requiredPassenger.add(passenger);
		passenger = new Passenger("Test Name2", PassengerType.PREMIUM, 10.0);
		travelPackage.addPassenger(passenger);
		requiredPassenger.add(passenger);
		List<Passenger> fetchedPassengers = travelPackage.getPassengers();
		assetEqual(fetchedPassengers,requiredPassenger);
	}
	
	@Test
	public final void testAddDestination() {
		List<Destination> requiredDestination = new ArrayList<Destination> ();
		Destination testDestination = new Destination ("Test Destination Name");
		travelPackage.addDestination(testDestination);
		requiredDestination.add(testDestination);
		testDestination = new Destination ("Test Destination Name2");
		travelPackage.addDestination(testDestination);
		requiredDestination.add(testDestination);
		List<Destination> fetchedDestination = travelPackage.getItinerary();
		assertEqual(fetchedDestination,testDestination);
	}
	
	@Test
	public final void testAddPassenger() {
		List<Passenger> requiredPassenger = new ArrayList<Passenger>();
		Passenger passenger = new Passenger("Test Name", PassengerType.GOLD, 90.0);
		travelPackage.addPassenger(passenger);
		requiredPassenger.add(passenger);
		passenger = new Passenger("Test Name2", PassengerType.PREMIUM, 10.0);
		travelPackage.addPassenger(passenger);
		requiredPassenger.add(passenger);
		List<Passenger> fetchedPassengers = travelPackage.getPassengers();
		assetEqual(fetchedPassengers,requiredPassenger);
	}
	
	@Test
	public final void testPrintItinerary() {
		Destination testDestination = new Destination ("Test Destination Name");
		Activity activity = new Activity("Test Activity Name", "Test Activity Description", 78.4, 8 );
		testDestination.addActivity(activity);
		activity = new Activity("Test Activity Name2", "Test Activity Description2", 90.1, 4 );
		testDestination.addActivity(activity);
		travelPackage.addDestination(testDestination);

		testDestination = new Destination ("Test Destination Name2");
		activity = new Activity("Test Activity Name", "Test Activity Description", 78.4, 8 );
		testDestination.addActivity(activity);
		activity = new Activity("Test Activity Name2", "Test Activity Description2", 90.1, 4 );
		testDestination.addActivity(activity);
		travelPackage.addDestination(testDestination);
		
		travelPackage.printItinerary();
		// assertEqual(fetchedDestination,testDestination);
	}
	
	@Test
	public final void testPrintPassengerList() {
		Passenger passenger = new Passenger("Test Name", PassengerType.GOLD, 90.0);
		travelPackage.addPassenger(passenger);
		passenger = new Passenger("Test Name2", PassengerType.PREMIUM, 10.0);
		travelPackage.addPassenger(passenger);
		travelPackage.printPassengerList();
	}


}
