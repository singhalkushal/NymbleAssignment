package travelPackage;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * The Main Application 
 * @author Kushal Singhal
 * @version v1.0
 */
public class TravelPackageMain{

    /*
     * Important properties for this Main Application
     */
    public static List<TravelPackage> allTravelPackage;
    static List<Destination> allDestinations;
    static List<Activity> allActivities;
    public static List<Passenger> allPassengers;

    static Scanner sc = new Scanner(System.in);

    /**
     * Main Function of the Application
     * @param args Arguments from CLI
     */
    public static void main(String[] args){
        System.out.println("**** Welcome to Travel Nymble ****");
        allTravelPackage = new ArrayList<TravelPackage>();
        allDestinations = new ArrayList<Destination>();
        allActivities = new ArrayList<Activity>();
        allPassengers = new ArrayList<Passenger>();
        mainPannel();
    }

    /**
     * Main Panel Of Our Application
     */
    public static void mainPannel(){
        Integer option;
        while(true){
            System.out.print("\n*********** Main Panel ***********\n");
            System.out.println("1. Admin Panel");
            System.out.println("2. Passenger Panel");
            System.out.println("3. Exit");
            System.out.print("Please Enter a Number:");
            option = sc.nextInt();
            System.out.print("\n*********************************\n");
            switch(option){
                case 1 :
                    adminPannel();
                    break;
                case 2:
                    passengerPannel();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Please enter a correct input!!!\n");
                }
        }
    }

    /**
     * Function to Display all Tasks related to ADMIN
     */
    public static void adminPannel(){
        System.out.println("\n*** Welcome to Admin Pannel *** ");
        
        Integer option;
        while(true){
            System.out.print("\n*********** Admin Panel **********\n");
            System.out.println("1. Destination Panel");
            System.out.println("2. Activity Panel");
            System.out.println("3. Travel Package Panel");
            System.out.println("4. Back to Main Panel");
            System.out.print("Please Enter a Number:");
            option = sc.nextInt();
            System.out.print("\n*********************************\n");
            switch(option){
                case 1 :
                    destinationPannel();
                    break;
                case 2:
                    activityPannel();
                    break;
                case 3:
                    travelPackagePannel();
                    break;
                case 4:
                    mainPannel();
                    break;
                default:
                    System.out.println("Please enter a correct input!!!\n");
                }
        }
    }

    /**
     * Function to Display all Tasks related to Travel Package
     */
    public static void travelPackagePannel(){
        System.out.println("\n*** Welcome to Travel Package Pannel *** ");
        Integer option;
        while(true){
            System.out.println("\n*** Travel Package Pannel *** \n");
            System.out.println("1. Add Travel Package");
			System.out.println("2. Add Destinantion to Travel Package");
			System.out.println("3. Print Itinerary");
			System.out.println("4. Print Passenger List");
            System.out.println("5. Back to Previous Screen");
            System.out.print("Please Enter a Number:");
            option = sc.nextInt();
            System.out.print("\n*********************************\n");
            switch(option){
                case 1:
                    addTravelPackage();
                    break;
                case 2 :
                    travelPackageAllotment();
                    break;
                case 3 :
                    if(allTravelPackage == null || allTravelPackage.size() == 0){
                        System.out.println("No Travel Package Present!!!\nCreate a Package First!!!");
                        break;
                    }
                    System.out.println("Please select the Travel Package");
                    for (int i = 0; i < allTravelPackage.size(); i++) {
                        System.out.println((i+1) + ". " + allTravelPackage.get(i).getName());
                    }
                    option = sc.nextInt();
                    allTravelPackage.get(option - 1 ).printItinerary();;
                    break;
                case 4 :
                    if(allTravelPackage == null || allTravelPackage.size() == 0){
                        System.out.println("No Travel Package Present!!!\nCreate a Package First!!!");
                        break;
                    }
                    System.out.println("Please select the Travel Package");
                    for (int i = 0; i < allTravelPackage.size(); i++) {
                        System.out.println((i+1) + ". " + allTravelPackage.get(i).getName());
                    }
                    option = sc.nextInt();
                    allTravelPackage.get(option - 1 ).printPassengerList();
                    break;
                case 5:
                    adminPannel();
                    break;
                default:
                    System.out.println("Please enter a correct input!!!\n");
                }
            }
            
        } 

        /**
          * Function to Display all Tasks related to Destination
        */
        public static void destinationPannel(){
        System.out.println("\n*** Welcome to Destination Pannel *** ");
        Integer option;
        while(true){
            System.out.println("\n*** Destination Pannel *** \n");
            System.out.println("1. Add Destination");
            System.out.println("2. Add Destination to Travel Package");
            System.out.println("3. Back to Admin Panel");
            System.out.print("Please Enter a Number:");
            option = sc.nextInt();
            System.out.print("\n*********************************\n");
            switch(option){
                case 1 :
                addDestination();
                    break;
                case 2:
                    travelPackageAllotment();
                    break;
                case 3:
                    adminPannel();
                    break;
                    default:
                    System.out.println("Please enter a correct input!!! \n");
            }
        }

    }
    /**
     * Function to Display all Tasks related to Activity
     */
    public static void activityPannel(){
        
        System.out.println("\n*** Welcome to Activity Pannel *** ");
        Integer option;
        while(true){
            System.out.println("\n*** Activity Pannel ***\n");
            System.out.println("1. Add Activity");
            System.out.println("2. Add Activity to Destination");
            System.out.println("3. Vacant Activities");
            System.out.println("4. Back to Admin Panel");
            System.out.print("Please Enter a Number:");
            option = sc.nextInt();
            System.out.print("\n*********************************\n");
            switch(option){
                case 1 :
                addActivity();
                break;
                case 2:
                destinationAllotment();
                break;
                case 3:
                vacantActivity();
                break;
                case 4:
                adminPannel();
                break;
                default:
                System.out.println("Please enter a correct input!!!\n");
            }
        }
    }
	
    /**
     * Function to Display all Tasks related to Passenger
     */
	public static void passengerPannel(){
        System.out.println("\n*** Welcome to Passenger Pannel *** ");
		
		Integer option;
		while(true){
            System.out.println("\n*** Passenger Pannel *** \n");
            System.out.println("1. Add Passenger");
			System.out.println("2. Add Passenger to a Travel Package");
			System.out.println("3. Add Passenger to a Activity");
			System.out.println("4. Back to Main Panel");
            System.out.print("Please Enter a Number:");
			option = sc.nextInt();
            System.out.print("\n*********************************\n");
			switch(option){
                case 1 :
					addPassenger();
					break;
				case 2:
					addPassengerToPackage();
					break;
				case 3:
					addPassengerToActivity();
					break;
				case 4:
					mainPannel();
					break;
				default:
                System.out.println("Please enter a correct input!!! \n");
			}
		}
	}

    /**
     * Function to Add a Passenger to a Package
     * @see {@linkplain TravelPackage.addPassenger()} method used
     */
	public static void addPassengerToPackage(){
		if((allPassengers != null || allPassengers.size() != 0) && (allTravelPackage != null || allTravelPackage.size() != 0)){
            if(allPassengers == null || allPassengers.size() == 0){
                System.out.println("\nNo Passengers Present !!! \nPlease add Passengers First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            if(allTravelPackage == null || allTravelPackage.size() == 0){
                System.out.println("\nNo Travel Packages Present !!! \nPlease add Travel Packages First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
			System.out.println("Please select the Passenger:");
			for (int i = 0; i < allPassengers.size(); i++) {
                System.out.println((i + 1) + ". " + allPassengers.get(i).getName());
			}
			int option;
			option = sc.nextInt();
			Passenger passenger = allPassengers.get(option - 1);
			System.out.println("Please select the Travel Package:");
			for (int i = 0; i < allTravelPackage.size(); i++) {
				System.out.println((i + 1) + ". " + allTravelPackage.get(i).getName());
			}
			option = sc.nextInt();
			allTravelPackage.get(option - 1 ).addPassenger(passenger);
		}else{
			System.out.println("Data Incomplete !!!");
		}
	}

    /**
     * Function to Register a Passenger to Activity
     * @see {@linkplain Activity.passengerSignUp()} method used
     */
	public static void addPassengerToActivity(){
        if((allPassengers != null || allPassengers.size() != 0) && (allActivities != null || allActivities.size() != 0)){
            if(allPassengers == null || allPassengers.size() == 0){
                System.out.println("\nNo Passengers Present !!! \nPlease add Passengers First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            if(allActivities == null || allActivities.size() == 0){
                System.out.println("\nNo Activities Present !!! \nPlease add Activities First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            System.out.println("Please select the Passenger:");
			for (int i = 0; i < allPassengers.size(); i++) {
                System.out.println((i + 1) + ". " + allPassengers.get(i).getName());
			}
			int option;
			option = sc.nextInt();
			Passenger passenger = allPassengers.get(option - 1);
			System.out.println("Please select the Activity:");
			for (int i = 0; i < allActivities.size(); i++) {
                System.out.println((i + 1) + ". " + allActivities.get(i).getName());
			}
			option = sc.nextInt();
			allActivities.get(option - 1).passengerSignUp(passenger);;
			
		}else{
			System.out.println("Data Incomplete !!!");
		}
	}

    /**
     * Adding Destination to A Travel Package
     * @see {@linkplain TravelPackage.addDestination()} method used
     */
	public static void travelPackageAllotment(){
        if((allDestinations != null || allDestinations.size() != 0) && (allTravelPackage != null || allTravelPackage.size() != 0) ){
            if(allDestinations == null || allDestinations.size() == 0){
                System.out.println("\nNo Destinations Present !!! \nPlease add Destinations First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            if(allTravelPackage == null || allTravelPackage.size() == 0){
                System.out.println("\nNo Travel Packages Present !!! \nPlease add Travel Packages First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            System.out.println("Please select the Destination");
			for (int i = 0; i < allDestinations.size(); i++) {
                System.out.println((i + 1) + ". " + allDestinations.get(i).getName());
			}
			int option;
            System.out.print("Destination Number : ");
			option = sc.nextInt();
			Destination destination = allDestinations.get(option - 1 );
			System.out.println("\n\nPlease select the Travel Package");
			for (int i = 0; i < allTravelPackage.size(); i++) {
                System.out.println((i + 1) + ". " + allTravelPackage.get(i).getName());
			}
            System.out.print("Package Number : ");
			option = sc.nextInt();
			allTravelPackage.get( option - 1 ).addDestination(destination);
			
		}else{
			System.out.println("Data Incomplete !!!");
		}
	}

    /**
     * Adding Destination to an Activity
     * @see {@linkplain Destination.addActivity()} method used 
     */
	public static void destinationAllotment(){
        if((allActivities != null || allActivities.size() != 0) && (allDestinations != null || allDestinations.size() != 0)){
            if(allActivities == null || allActivities.size() == 0){
                System.out.println("\nNo Activities Present !!! \nPlease add Activities First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            if(allDestinations == null || allDestinations.size() == 0){
                System.out.println("\nNo Destinations Present !!! \nPlease add Destinations First!!!\n");
                System.out.print("\n*********************************\n");
                return;
            }
            System.out.println("Please select the Activity");
			for (int i = 0; i < allActivities.size(); i++) {
                System.out.println((i + 1) + ". " + allActivities.get(i).getName());
			}
			int option;
			option = sc.nextInt();
			Activity activity = allActivities.get(option - 1);
			System.out.println("Please select the Destination");
			for (int i = 0; i < allDestinations.size(); i++) {
				System.out.println((i + 1) + ". " + allDestinations.get(i).getName());
			}
			option = sc.nextInt();
			allDestinations.get(option - 1).addActivity(activity);
	
		}else{
			System.out.println("Data Incomplete !!!");
		}

	}

    /**
     * Function to Display All Activities that has not reached the Passenger Limit
     */
    public static void vacantActivity(){
        for(Activity activity : allActivities){
            if(activity.getPassenger().size() < activity.getCapacity()){
                System.out.println("Activity Name: " + activity.getName());
                System.out.println("Activity Cost: " + activity.getCost());
                System.out.println("Activity Capacity: " + activity.getCapacity());
                System.out.println("Activity Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Adding Passenger To the Main Application DataBase
     * 
     */
    public static void addPassenger(){
        System.out.println("\n*** Please Enter Passenger Information ***");
        System.out.print("Enter Name : ");
        String name = sc.next();
        System.out.print("Enter Passenger Type : ");
        String passengerType = sc.next();
        double balance;
        if(!passengerType.toUpperCase().equalsIgnoreCase(PassengerType.PREMIUM.name())){
            System.out.print("Enter Current Balance : ");
            balance = sc.nextInt();
        }else {
        	balance = 0;
        }
        PassengerType pType; 
        if(passengerType.toUpperCase().equalsIgnoreCase(PassengerType.STANDARD.name())){
            pType = PassengerType.STANDARD;
        }else if(passengerType.toUpperCase().equalsIgnoreCase(PassengerType.GOLD.name())){
            pType = PassengerType.GOLD;
        }else{
            pType = PassengerType.PREMIUM;
        }
        Passenger passenger = new Passenger(name, pType,((passengerType.toUpperCase().equalsIgnoreCase(PassengerType.PREMIUM.name())) ? 0.0 : balance) );
        allPassengers.add(passenger);
        System.out.println("\nPassenger " + name + " Added Successfully !!!");
    }

    /**
     * Adding Destination To the Main Application DataBase
     * 
     */
    public static void addDestination(){
        System.out.println("\n*** Please Enter Destination Information ***");
        System.out.print("Enter Name : ");
        String name = sc.next();
        Destination destination = new Destination(name);
        allDestinations.add(destination);
        System.out.println("\nDestination " + name + " Added Successfully !!!");
    }

    /**
     * Adding Travel Package To the Main Application DataBase
     * 
     */
    public static void addTravelPackage(){
        System.out.println("\n*** Please Enter Travel Package Information ***");
        System.out.print("Enter Name : ");
        String name = sc.next();
        System.out.print("Enter capacity : ");
        int capacity = sc.nextInt();
        TravelPackage travelPackage = new TravelPackage(name, capacity);
        allTravelPackage.add(travelPackage);
        System.out.println("\nTravel Package " + name + " Added Successfully !!!\n");
    }

    /**
     * Adding Activity To the Main Application DataBase
     * 
     */
    public static  void addActivity(){
        System.out.println("\n*** Please Enter Activity Information ***");
        System.out.print("Enter Name : ");
        String name = sc.next();
        System.out.print("Enter Description : ");
        String description = sc.next();
        System.out.print("Enter Cost : ");
        double cost = sc.nextDouble();
        System.out.print("Enter Capacity : ");
        int capacity = sc.nextInt();
        Activity activity = new Activity(name, description, cost, capacity);
        allActivities.add(activity);
        System.out.println("\nActivity " + name + " Added Successfully !!!");
    }

}