package travelPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Destination Class
 * @author Kushal Singhal
 * @version v1.0
 */

public class Destination{
    
    /*
     * Important properties 
     */
    private String name;

    /* 
    * This can be updated Later using Different utillity Functions
    */
    private List<Activity> activities;

    /*
     * All Constructors
     */

     /*
     * The default Constructor: It initialized default values to all properties of any Destination Object
     */
    public Destination(){}

    /*
     * Parametrized Constructor for Creating any Destination object 
     */

     /**
      * Parametrized Constructor
      * @param name name of Destination
      */

    public Destination(String name){
        this.name = name;
        this.activities = new ArrayList<Activity>();
    }

    /*
     * All Setters
     */
    
    /**
     * Add or Update Name of Destination
     * @param name Destination name
     */
    public void setName(String name){
        this.name=name;
    }
    
    /*
     * All Getters
     */

     /**
      * @return Destination Name
      */
    public String getName(){
        return this.name;
    }

    /**
     * @return Activities Associated and Registered to this Activity
     */
    public List<Activity> getActivities(){
        return this.activities;
    }
    
    
    /*
     * Utility Function
     */

     /**
      * Adding an activity to this destination
      * (Using this function instead of Setter, as adding a List of Activities is a Bulky task)
      * @param activity the Activity that can be added to this Destination
      */
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