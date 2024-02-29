package travelPackage;


import java.util.ArrayList;
import java.util.List;

public class Activity{
    private String name;
    private String description;
    private double cost;
    private int capacity;
    
    // Can Update Later
    private Destination associatedDestination; 
    private List<Passenger> registeredPassenger;

    public Activity(){}

    public Activity(String name, String description, double cost, int capacity){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.associatedDestination = new Destination();
        this.registeredPassenger = new ArrayList<Passenger>();
    }

    public void setAssociatedDestination(Destination associatedDestination){
        this.associatedDestination = associatedDestination;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getCost(){
        return cost;
    }
    public int getCapacity(){
        return capacity;
    }
    public Destination getAssociatedDestination(){
        return associatedDestination;
    }
    public List<Passenger> getPassenger(){
        return registeredPassenger;
    }
    
    // Utility Functions

    public void passengerSignUp(Passenger passenger){
        if(this.registeredPassenger.contains(passenger)){
            System.out.println("Passenger Already Registered for this activity!");
        }
        else if(this.registeredPassenger.size() < capacity){
            if(passenger.getPassengerType() == PassengerType.STANDARD){
                if((passenger.getBalance() - this.cost) < 0){
                }else{
                    passenger.setBalance(passenger.getBalance() - this.cost);
                    this.registeredPassenger.add(passenger);
                    passenger.registerActivity(this);
                    System.out.println("Passenger " + passenger.getName() + " Successfully added to the Activity " + this.getName());
                }
            }else if(passenger.getPassengerType() == PassengerType.GOLD){
                if((passenger.getBalance() - (this.cost * 0.9)) < 0){
                    System.out.println("Not Enough Balance");
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
            System.out.println("Passenger count for this activity is exceeding!");
        }
    }


}