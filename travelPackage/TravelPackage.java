package travelPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Travel Package Class
 * @author Kushal Singhal
 * @version v1.0
 */
public class TravelPackage{

    /*
     * Important properties
     */
    private String name;
    private int capacity;
    
    /* 
    * These can be updated Later using Different utillity Functions
    */
    private List<Passenger> passengers;
    private List<Destination> itinerary;

    /*
     * All Constructors
     */

     /*
     * The default Constructor: It initialized default values to all properties of any Travel Package Object
     */
    public TravelPackage(){}

    /*
     * Parametrized Constructor for Creating any Travel Package object 
     */

    /**
     * Parametrized Constructor
     * @param name Name of Travel package
     * @param capacity The Total Passenger Capacity of Travel Package
     */

    public TravelPackage(String name, int capacity){
        this.name=name;
        this.capacity=capacity;
        this.itinerary = new ArrayList<Destination>();
        this.passengers = new ArrayList<Passenger>();
    }

    /*
     *  All Setters
     */

     /**
      * Add or Edit Name of Travel Package
      * @param name name of Travel Package
      */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Add or Edit Max Capacity of Travel Package
     * @param capacity Passenger Capacity of Travel package
     */
    public void setCapacity(int capacity){
        if(this.passengers!= null && this.passengers.size() > capacity){
            System.out.println("The current passenger count in this Package is greater than the capacity \n Can't Update!!!");
            return;
        }
        this.capacity = capacity;
    }
    
    /*
     * All Getters
     */

     /**
      * @return Name of Travel Package
      */
    public String getName(){
        return this.name;
    }
    /**
     * @return Maximum Passenger capacity of Package
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * @return List of Destination registered to this Travel Package
     */
    public List<Destination> getItinerary(){
        return this.itinerary;
    }

    /**
     * @return List of all the Passengers Registered to this Travel Package
     */
    public List<Passenger> getPassengers(){
        return this.passengers;
    }

    /*
     * Utility Functions
     */

     /**
      * Adding Destination to this Travel Package
      - it checks whether the Destination Already Exists or not
      * @param destination Destination to be added
      */
    public void addDestination(Destination destination) {
    	if(this.itinerary != null) {
    		if(this.itinerary.contains(destination)) {
    			System.out.println("This Destination Alredy Exists in this Package!!!");
    			return;
    		}
    		this.itinerary.add(destination);
            System.out.println("*****************************************************");
            System.out.println("Destination " + destination.getName() + " Successfully added to the Travel Package " + this.getName());
            System.out.println("*****************************************************");

    	}else {
    		System.out.println("Error while Adding !!!");
    	}
    }

    /**
     * Adding Passenger to Travel Package
     * - It checks wheter the passenger already registered or not
     * - and If the Capacity Exceeds or not
     * @param passenger Passenger to be registered
     */
    public void addPassenger(Passenger passenger) {
    	if(this.passengers != null) {
    		if(this.passengers.contains(passenger) && this.passengers.size() < capacity) {
    			System.out.println("This Passenger Already Registered in this Travel Package !!!");
    			return;
    		}else if( this.passengers.size() >= capacity){
    			System.out.println("This Passenger Capacity exceeds for this Package !!!");
                return;
            }
    		this.passengers.add(passenger);
            System.out.println("*****************************************************");
            System.out.println("Passenger " + passenger.getName() +" added to the Package " + this.getName());
            System.out.println("*****************************************************");
    	}else {
    		System.out.println("Error while Adding !!!");
    	}
    }

    /**
     * Print the Destination Data (along aith Activity Data of the Destination) Associated to this Travel Package
     */
    public void printItinerary(){
        System.out.println("Travel Package: " + this.name);
        if(itinerary == null || itinerary.size() == 0){
            System.out.println("No Itinerary Present in this Travel Package");
            return;
        }

        if(itinerary != null){
            int destinationNumber = 1;
            int activityNumber = 1;
            for(Destination destination: itinerary){
                System.out.println("Destination " + destinationNumber + " Name: " + destination.getName());
                if(destination.getActivities() != null || destination.getActivities().size() > 0){
                    for(Activity activity: destination.getActivities()){
                        System.out.println("\nActivity " + activityNumber + " Name: " + activity.getName());
                        System.out.println("Activity " + activityNumber + " Cost: " + activity.getCost());
                        System.out.println("Activity " + activityNumber + " Capacity: " + activity.getCapacity());
                        System.out.println("Activity " + activityNumber + " Description: " + activity.getDescription());
                        activityNumber++;
                    }
                    System.out.println();
                    activityNumber = 1;
                }else{
                    System.out.println("No Activity Present in this Activity!!!\n");
                }
                destinationNumber++;
            }
        }
    }

    /**
     * Print PAssenger Data who have registered to this Travel Package
     */
    public void printPassengerList(){
        System.out.println("Package Name: " + this.name);
        System.out.println("Passenger Capacity: " + this.capacity);
        System.out.println("Passenger Count: " + this.passengers.size());
        if(passengers == null || passengers.size() == 0 ){
            System.out.println("No Passenger Data for this Package !!!");
            return;
        }
        if(passengers != null){
            for(Passenger passenger: passengers){
                System.out.println("Passenger Name: " + passenger.getName());
                System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            }
        }
    }


}