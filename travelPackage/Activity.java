package travelPackage;


import java.util.ArrayList;
import java.util.List;

/**
 * Activity Class
 * @author Kushal Singhal
 * @version v1.0
 */

public class Activity{

    /**
     * Important Properties of any Activity Object
     */
    private String name;
    private String description;
    private double cost;
    private int capacity;
    
    /*
     * These can be updated Later using Different utillity Functions
     */
    private Destination associatedDestination; 
    private List<Passenger> registeredPassenger;

    /*
     * All Constructors
     */

    /*
     * The default Constructor: It initialized default values to all properties of any Activity Object
     */
   
    public Activity(){}

    /*
     * Parametrized Constructor for Creating any Activity object 
     */

     /**
      * Parametrized Construtor
      * @param name Activity Name
      * @param description Activity Description
      * @param cost Activity Cost
      * @param capacity Maximum Passenger Capacity of Activity
      */
    public Activity(String name, String description, double cost, int capacity){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.associatedDestination = new Destination();
        this.registeredPassenger = new ArrayList<Passenger>();
    }

    /*
     * All Setters
     */

     /**
      * Adding Destination for an Activity
      * @param associatedDestination the Destination we need to Associate with this Activity
      */
    public void setAssociatedDestination(Destination associatedDestination){
        this.associatedDestination = associatedDestination;
    }
    /**
     * Add or Update Name of Activity
     * @param name Activity name
     */
    
    public void setName(String name){
        this.name = name;
    }

    /**
     * Add or update Description of an Activity
     * @param description Description of Activity
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Adding or Updating price of Activity
     * @param cost Price of Activity
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    /**
     * Adding or Updating Passenger Capacity of Activity
     * @param capacity Maximum Number of Passengers
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    

    /*
     * All Getters
     */

     /**
      * @return Activity name
      */
    public String getName(){
        return name;
    }

    /**
     * @return Activity Description
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return Activity Registration Cost
     */
    public double getCost(){
        return cost;
    }

    /**
     * @return Maximum Passenger capacity of Activity
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * @return Destination associated with this Activity
     */
    public Destination getAssociatedDestination(){
        return associatedDestination;
    }

    /**
     * @return The List of all registered Passenger in the Activity
     */
    public List<Passenger> getPassenger(){
        return registeredPassenger;
    }
    
    /*
     * Utility Functions/Methods
     */
    
    /**
     * passengerSignUp helps in registering the Passenger to an Activity 
     * - It checks whether the passenger is already registered or not 
     * - if not It checkes whether the Activity is full or not
     * - at last it checked whether the passenger is Eligible to Sign up by Pssenger Balance and Passenger Type Membership
     * 
     * @param passenger the passenger who need to register in the activity
     */

    public void passengerSignUp(Passenger passenger){
        if(this.registeredPassenger.contains(passenger)){
            System.out.println("Passenger Already Registered for this activity!");
        }
        else if(this.registeredPassenger.size() < capacity){
            if(passenger.getPassengerType() == PassengerType.STANDARD){
                if((passenger.getBalance() - this.cost) < 0){
                    System.out.println("Not Enough Balance!!!");
                }else{
                    passenger.setBalance(passenger.getBalance() - this.cost);
                    this.registeredPassenger.add(passenger);
                    passenger.registerActivity(this);
                    System.out.println("Passenger " + passenger.getName() + " Successfully added to the Activity " + this.getName());
                }
            }else if(passenger.getPassengerType() == PassengerType.GOLD){ // Passenger with Gold Membership get a Discount of 10 percent
                if((passenger.getBalance() - (this.cost * 0.9)) < 0){
                    System.out.println("Not Enough Balance!!!");
                }else{
                    passenger.setBalance(passenger.getBalance() - (this.cost * 0.9));
                    this.registeredPassenger.add(passenger);
                    passenger.registerActivity(this);
                    System.out.println("Passenger " + passenger.getName() + " Successfully added to the Activity " + this.getName());
                }
            }else{
                this.registeredPassenger.add(passenger);
                passenger.registerActivity(this);
                System.out.println("Passenger " + passenger.getName() + " Successfully added to the Activity " + this.getName());

            }
        }else{
            System.out.println("Passenger count for this activity is exceeding!!!");
        }
    }


}