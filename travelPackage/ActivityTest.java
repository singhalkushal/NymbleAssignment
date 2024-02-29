package TravelPackage;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActivityTest {
	public Activity activity;
	public Destination testDestination;
	public List<Passenger> testPassengers;

	@BeforeEach
	void setUp() throws Exception {
		double testCost = 90;
		int testCapacity = 2;
		activity = new Activity("Test Activity Name", "Test Activity Description", testCost, testCapacity );
	}

	@Test
	final void testSetAssociatedDestination() {
		testDestination = new Destination("Test Destination");
		activity.setAssociatedDestination(testDestination);
		assertEquals(activity.getAssociatedDestination().getName() , testDestination.getName());
	}
	
	@Test
	final void testSetName() {
		String newName = "Name 2";
		activity.setName(newName);
		assertEquals(activity.getName(), newName);
	}
	
	@Test
	final void testSetDescription() {
		String newDesc = "Desc2";
		activity.setName(newDesc);
		assertEquals(activity.getDescription(), newDesc);
	}
	
	@Test
	final void testSetCost() {
		double newCost = 80.9;
		activity.setCost(newCost);
		assertEquals(activity.getCost(), newCost);
	}
	
	@Test
	final void testSetCapacity() {
		int newCapacity = 1;
		activity.setCapacity(newCapacity);
		assertEquals(activity.getCapacity(), newCapacity);
	}
	
	@Test
	final void testGetName() {
		String newName = "Name 2";
		activity.setName(newName);
		assertEquals(activity.getName(), newName);
	}
	
	@Test
	final void testGetDescription() {
		String newDesc = "Desc2";
		activity.setName(newDesc);
		assertEquals(activity.getDescription(), newDesc);
	}
	
	@Test
	final void testGetCost() {
		// fail("Not yet implemented"); // TODO
		double newCost = 80.9;
		activity.setCost(newCost);
		assertEquals(activity.getCost(), newCost);
	}
	
	@Test
	final void testGetCapacity() {
		int newCapacity = 1;
		activity.setCapacity(newCapacity);
		assertEquals(activity.getCapacity(), newCapacity);
		// fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void testGetAssociatedDestination() {
		testDestination = new Destination("Test Destination");
		activity.setAssociatedDestination(testDestination);
		assertEquals(activity.getAssociatedDestination().getName() , testDestination.getName());
		// fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetPassenger() {
		// fail("Not yet implemented"); // TODO
		testPassengers.add( new Passenger("Test Name", PassengerType.STANDARD, 80));
		activity.passengerSignUp(testPassengers);
		List<Passenger> listPassenger = activity.getPassenger();
		assertEquals(listPassenger, testPassengers);
	}
	
	@Test
	final void testPassengerSignUp() {
		testPassengers.add( new Passenger("Test Name", PassengerType.STANDARD, 8));
		testPassengers.add( new Passenger("Test Name2", PassengerType.STANDARD, 90));
		activity.passengerSignUp(testPassengers.get(0));
		activity.passengerSignUp(testPassengers.get(0));
		activity.passengerSignUp(testPassengers.get(1));
		List<Passenger> listPassenger = activity.getPassenger();
		assertEquals(listPassenger, testPassengers);
	}

}
