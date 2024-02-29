package travelPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passenger{
	
	// Mandatory Variables
    private String name; 
    private static int passengerNumbertemp = 0000; // Will help in creating passengerNumber
    private int passengerNumber; // Will Update while Creating Object
    private PassengerType passengerType;
    private double balance;
    
    // Can Update Later
    private List<Activity> registeredActivities;
    
    
    // Constructors
    public Passenger(){}

    public Passenger(String name, PassengerType passengerType, double balance){
        this.name = name;
        Passenger.passengerNumbertemp = Passenger.passengerNumbertemp + 1;
        this.passengerNumber = Passenger.passengerNumbertemp;
        setPassengerType(passengerType);
        this.registeredActivities = new ArrayList<Activity>();
    }

    // Setters
    public void setBalance(double balance) {
        if(this.passengerType != null && this.passengerType == PassengerType.PREMIUM){
            System.out.println("This is a Premium Customer!. No Need to Update the Balance");
        }
    	this.balance = balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    	if(passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD){
            System.out.print("Please Enter Balace of the Membership Again :");
            Scanner sc = new Scanner(System.in);
            this.balance = sc.nextDouble();
            sc.close();
        }else{
            System.out.println("Premium Customer!. Balance Info is not saved!");
            this.balance = 0;
        }
    }
    
    // Getter
    public String getName(){
        return this.name;
    }
    public int getPassengerNumber(){
        return this.passengerNumber;
    }
    public PassengerType getPassengerType() {
        return this.passengerType;
    }
    public double getBalance() {
        if(this.passengerType != null && this.passengerType == PassengerType.PREMIUM){
            System.out.println("This is a Premium Customer!. No Balance Info is Available");
        }
    	return this.balance;
    }
    public List<Activity> getregisteredActivities(){
    	return this.registeredActivities;
    }

    
    // Utility Function
    public void printDetails(){
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
        System.out.println("Passenger Balance: " + (this.passengerType == PassengerType.PREMIUM ? "Not Applicable" : this.balance));
        for(Activity activity: registeredActivities){
            System.out.println("Destination for the activity: " + activity.getAssociatedDestination());
            System.out.println("Price of the activity: " + activity.getCost());
        }
    }

    public void registerActivity(Activity activity){
        this.registeredActivities.add(activity);
    }    

   
}
