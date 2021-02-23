package com.epam.parking;

import java.util.*;

public class App {
	Map<String,ArrayList<Vehicle>> parkingData = new HashMap<>();
	Map<String,String> parkingLedger = new HashMap();
	
	
	public static void main(String[] args) {
				
		        Scanner input = new Scanner(System.in);
		        
		        int menu;
		        App app=new App();
		        while(true) {
		        	try {
		            System.out.println("WELCOME TO PARKING MANAGEMENT");
		            System.out.println("1: Create a Parking Area");
		            System.out.println("2: Park Vehicle");
		            System.out.println("3: Unpark Vehicle");
		            System.out.println("4: Print all Slots Report");
		            System.out.println("5: Exit");

		            System.out.print("Enter your choice: ");
		            
		            menu = input.nextInt();	

		            System.out.println();

		            switch (menu) {
		                case 1: {
		                    AddNewParking apv =new AddNewParking();
		                    apv.createNewParking(app);
		                    break;
		                }
		                case 2: {
		                	ParkVehicle pv = new ParkVehicle();
		                   pv.execute(app);
		                    break;
		                }
		                case 3: {
		                	UnparkVehicle upv = new UnparkVehicle(app);
		                	upv.getVehicleNumberToUnpark();
		                	
		                    break;
		                }

		                case 4: {
		                   System.out.println(app.parkingLedger); 
		                    break;
		                }
		                
		                case 5:{
		                	
		                	break;
		                }
		                
		                default: {
		                  System.out.println("Please Choose Correct Option");
		                    
		                }
		            }
		        	  }catch(InputMismatchException e) {
			            	System.out.println("Invalid Input");
			            	continue;
		            
		        	}
		        	
		        	}
		        
		                  
		        
		    }
		
}

