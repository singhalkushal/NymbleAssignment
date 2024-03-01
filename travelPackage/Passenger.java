package travelPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Passenger Class
 * @author Kushal Singhal
 * @version v1.0
 */
public class Passenger{
	
	/*
     * Important properties
     */
    private String name; 
    private static int passengerNumbertemp = 0000; // This will help in creating Unique passengerNumber
    private int passengerNumber; 
    private PassengerType passengerType;
    private double balance;
    
   /* 
    * This can be updated Later using Different utillity Functions
    */
    private List<Activity> registeredActivities;
    
    
    /*
     * All Constructors
     */

     /*
     * The default Constructor: It initialized default values to all properties of any Passenger Object
     */
    public Passenger(){}

     /*
     * Parametrized Constructor for Creating any Passenger object 
     */

    /**
     * Parametrized Constructor
     * @param name Name of Passenger
     * @param passengerType Membership type of Passenger
     * @param balance Balance Associated with the passenger
     */
    public Passenger(String name, PassengerType passengerType, double balance){
        this.name = name;
        Passenger.passengerNumbertemp = Passenger.passengerNumbertemp + 1;
        this.passengerNumber = Passenger.passengerNumbertemp;
        setPassengerType(passengerType);
        this.registeredActivities = new ArrayList<Activity>();
    }

    /*
     * All Setters
     */

    /**
     * Add or Edit Balance
     * @param balance balance Associated with a Passenger
     */
    public void setBalance(double balance) {
        if(this.passengerType != null && this.passengerType == PassengerType.PREMIUM){
            System.out.println("This is a Premium Customer!. No Need to Update the Balance");
        }
    	this.balance = balance;
    }

    /**
     * Add or Edit name of Passenger
     * @param name Name of Passenger
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Adding or Editing Passenger Type
     * @param passengerType the Membership type for passenger
     */
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
    
    /*
     * All getters
     */

    /**
     * @return Name of Passenger
    */
    public String getName(){
        return this.name;
    }

    /**
     * @return Passenger Number
    */
    public int getPassengerNumber(){
        return this.passengerNumber;
    }

    /**
     * @return Passenger Membership type
     */
    public PassengerType getPassengerType() {
        return this.passengerType;
    }

    /**
     * @return Balance of passenger
     */
    public double getBalance() {
        if(this.passengerType != null && this.passengerType == PassengerType.PREMIUM){
            System.out.println("This is a Premium Customer!. No Balance Info is Available");
        }
    	return this.balance;
    }

    /**
     * @return Activities this Passengers has registered to
     */
    public List<Activity> getregisteredActivities(){
    	return this.registeredActivities;
    }

    /*
     * Utility Functions
     */

    /**
     * Print Detials of the Passenger along with Activities associated with the Passenger
     */
    public void printDetails(){
        System.out.println("Passenger Name: " + this.name);
        System.out.println("Passenger Number: " + this.passengerNumber);
        System.out.println("Passenger Balance: " + (this.passengerType == PassengerType.PREMIUM ? "Not Applicable" : this.balance));
        if(this.registeredActivities != null || this.registeredActivities.size() > 0){
            for(Activity activity: registeredActivities){
                System.out.println("Destination for the activity: " + activity.getAssociatedDestination());
                System.out.println("Price of the activity: " + activity.getCost());
            }
        }else{
            System.out.println("No Activity Data Available!!!");
        }
    }

    /**
     * Registering to an Activity
     * @param activity Activity to register
     */
    public void registerActivity(Activity activity){
        activity.passengerSignUp(this);
        if(activity.getPassenger().contains(this)){
            this.registeredActivities.add(activity);
        }else{
            System.out.println("Error Occured !!!");
        }
    }    

   
}
