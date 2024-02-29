package TravelPackage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PassengerTest {
	Passenger passenger;

	@Before
	public void setUp() throws Exception {
		passenger = new Passenger("Test Name", PassengerType.GOLD, 90.0);
	}

	@Test
	public final void testSetBalance() {
		int newBalance = 1;
		passenger.setBalance(newBalance);
		assertEquals(passenger.getBalance(), newBalance);
	}
	
	@Test
	public final void testSetName() {
		String newName = "New Name";
		passenger.setName(newName);
		assertEquals(passenger.getName(), newName);
		//		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testSetPassengerType() {
		PassangerType pType = PassengerType.PREMIUM;
		passenger.setPassengerType(pType);
		assertEquals(passenger.getPassengerType(), pType);
		//		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testGetName() {
		String newName = "New Name";
		passenger.setName(newName);
		assertEquals(passenger.getName(), newName);
	}
	
	@Test
	public final void testGetPassengerNumber() {
		passenger.getPassengerNumber()
	}
	
	@Test
	public final void testGetPassengerType() {
		PassangerType pType = PassengerType.PREMIUM;
		passenger.setPassengerType(pType);
		assertEquals(passenger.getPassengerType(), pType);
	}
	
	@Test
	public final void testGetBalance() {
		int newBalance = 1;
		passenger.setBalance(newBalance);
		assertEquals(passenger.getCapacity(), newBalance);
	}
	
	@Test
	public final void testGetregisteredActivities() {
		List<Activity> requiredactivity = new ArrayList<Activity>();
		Activity activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		requiredactivity.add(activity);
		activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		requiredactivity.add(activity);
		List<Activity> fetchedActivity = passenger.getregisteredActivities();
		assertEquals(requiredactivity, fetchedActivity);
	}
	
	@Test
	public final void testPrintDetails() {
		Activity activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		Destination testDestination = new Destination("Test Destination");
		activity.setAssociatedDestination(testDestination);
		
		activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		testDestination = new Destination("Test Destination1");
		activity.setAssociatedDestination(testDestination);
		passenger.registerActivity(activity);
		passenger.printDetails();
	}
	
	@Test
	public final void testRegisterActivity() {
		List<Activity> requiredactivity = new ArrayList<Activity>();
		Activity activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		requiredactivity.add(activity);
		activity = new Activity ("Test Activity", "Test Description", 78.0, 9);
		passenger.registerActivity(activity);
		requiredactivity.add(activity);
		List<Activity> fetchedActivity = passenger.getregisteredActivities();
		assertEquals(requiredactivity, fetchedActivity);
	}

}
