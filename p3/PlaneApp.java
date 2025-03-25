package btosystem.p3;

import java.util.Scanner;

public class PlaneApp { 
	
	public static void main(String[] args) {
		
		//create a Plane class object
		Plane aircraft = new Plane();
		
		System.out.println("(1) Show number of empty seats");
		System.out.println("(2) Show the list of empty seats");
		System.out.println("(3) Show the list of seat assignments by seat ID");
		System.out.println("(4) Show the list of seat assignments by customer ID");
		System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit ");
		
       //create scanner object
		Scanner sc = new Scanner(System.in);
		
		
		
		//do-while loop to keep looping while user input is not 7.
		int choice;
		do {
			// get user input and store in "choice" variable
			System.out.println("  Enter a number of your choice: ");
			choice = sc.nextInt();
			
			// switch statement to handle input choices
			switch (choice) {
				case 1: 
					aircraft.showNumEmptySeats();
					break;
					
				case 2:
					aircraft.showEmptySeats();
					break;
				
				case 3:
					aircraft.showAssignedSeat(true);
					break;
				case 4:
					aircraft.showAssignedSeat(false);
					break;
					
				case 5:
					int seat_id, cust_id;
					System.out.println("Assigning Seat pls hold ..");
					System.out.println("  Please enter SeatID: ");
					seat_id = sc.nextInt();
					System.out.println("  Please enter Customer ID: ");
					cust_id = sc.nextInt();
					aircraft.assignSeat(seat_id, cust_id);
					break;
					
				case 6:
					System.out.println("  Enter SeatID to unassign customer from: ");
					seat_id = sc.nextInt();
					aircraft.unAssignSeat(seat_id);
					break;
					
				case 7:
					System.out.println("Pwease come back soon ♡´･ᴗ･`♡ ");
					break;
					
				default:
					System.out.println("  Invalid choice. Please enter a number from 1 - 7.");
					break;
			}
			
		
		} while (choice < 7);
		
	}

}
