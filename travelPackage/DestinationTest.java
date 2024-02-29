package TravelPackage;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DestinationTest {
	Destination testDestination;

	@Before
	public void setUp() throws Exception {
		testDestination = new Destination ("Test Destination Name");
	}

	@Test
	public final void testSetName() {
		String newName = "Name 2";
		testDestination.setName(newName);
		assertEquals(testDestination.getName(), newName);
	}
	
	@Test
	public final void testGetName() {
		String newName = "Name 2";
		testDestination.setName(newName);
		assertEquals(testDestination.getName(), newName);
		// fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testGetActivities() {
		List<Activity> Listactivity = new ArrayList<Activity>();
		Listactivity.add(new Activity("Test Activity Name", "Test Activity Description", 90, 78 ));
		testDestination.addActivity(Listactivity.get(0));
		List<Activity> listActivity = testDestination.getActivities(); 
		assertEquals(listActivity, Listactivity);
		
	}
	
	@Test
	public final void testAddActivity() {
		// List<Activity> Listactivity ={new Activity("Test Activity Name", "Test Activity Description", 90, 80 )};
		List<Activity> Listactivity = new ArrayList<Activity>();
		Listactivity.add(new Activity("Test Activity Name", "Test Activity Description", 90, 78 ));
		testDestination.addActivity(Listactivity.get(0));
		testDestination.addActivity(Listactivity.get(0));
		List<Activity> listActivity = testDestination.getActivities(); 
		assertEquals(listActivity, Listactivity);
	}

}
