package travelPackage;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage{

    private String name;
    private int capacity;
    
    private List<Passenger> passengers;
    private List<Destination> itinerary;

    // Constructors
    public TravelPackage(){}

    public TravelPackage(String name, int capacity){
        this.name=name;
        this.capacity=capacity;
        this.itinerary = new ArrayList<Destination>();
        this.passengers = new ArrayList<Passenger>();
    }

    //setters
    public void setName(String name){
        this.name=name;
    }
    public void setCapacity(int capacity){
        if(this.passengers!= null && this.passengers.size() > capacity){
            System.out.println("The current passenger count in this Package is greater than the capacity \n Can't Update!!!");
            return;
        }
        this.capacity = capacity;
    }
    
    // Getters
    public String getName(){
        return this.name;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public List<Destination> getItinerary(){
        return this.itinerary;
    }
    public List<Passenger> getPassengers(){
        return this.passengers;
    }

    // Utility Functions
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
    public void printItinerary(){
        System.out.println("Travel Package: " + this.name);
        if(itinerary == null || itinerary.size() == 0){
            System.out.println("No Itinerary Present in this Travel Pacakge");
            return;
        }

        if(itinerary != null){
            int destinationNumber = 1;
            int activityNumber = 1;
            for(Destination destination: itinerary){
                System.out.println("Destination " + destinationNumber + " Name: " + destination.getName());
                for(Activity activity: destination.getActivities()){
                    System.out.println("Activity " + activityNumber + " Name: " + activity.getName());
                    System.out.println("Activity " + activityNumber + " Cost: " + activity.getCost());
                    System.out.println("Activity " + activityNumber + " Capacity: " + activity.getCapacity());
                    System.out.println("Activity " + activityNumber + " Description: " + activity.getDescription());
                    activityNumber++;
                }
                activityNumber = 1;
                destinationNumber++;
            }
        }
    }

    public void printPassengerList(){
        System.out.println("Package Name: " + this.name);
        System.out.println("Passenger Capacity: " + this.capacity);
        System.out.println("Passenger Count: " + this.passengers.size());
        if(passengers == null || passengers.size() == 0 ){
            System.out.println("No Passenger Data for this Pacakge !!!");
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