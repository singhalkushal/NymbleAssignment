package travelPackage;

import java.util.ArrayList;
import java.util.List;

public class Destination{
    private String name;
    private List<Activity> activities;

    // Constructors
    public Destination(){}

    public Destination(String name){
        this.name = name;
        this.activities = new ArrayList<Activity>();
    }
    
    // Set name while editing
    public void setName(String name){
        this.name=name;
    }
    
    // Getters
    public String getName(){
        return this.name;
    }
    public List<Activity> getActivities(){
        return this.activities;
    }
    
    
    // Utility Function
    public void addActivity(Activity activity){
        if(this.activities != null && !this.activities.contains(activity)){
            this.activities.add(activity);
            activity.setAssociatedDestination(this);
            System.out.println("*****************************************************");
			System.out.println("Activity " + activity.getName() + " Successfully added to the Destination" + this.getName());
            System.out.println("*****************************************************");

        }else if(this.activities == null){
            System.out.println("Error while adding");
        }else{
            System.out.println("Destination already contains this activity!");
        }
    }
}