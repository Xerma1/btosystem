package btosystem.p3;

public class Plane {
	
	// Instance variables
	private PlaneSeat[] seat; 
	private int numEmptySeat;
	
	// Constructor
	public Plane() {
		// Initialize seat array to size 12 and numEmptySeat to 12
		seat = new PlaneSeat[12];
		numEmptySeat = 12;
		// Give each seat their seatID that corresponds to their array index + 1
		for (int i = 0; i < 12; i++) {
			seat[i] = new PlaneSeat(i + 1);
		}
	}
	
	// Methods
	public PlaneSeat[] sortSeats() {
		// Make another copy of the array of seats
		PlaneSeat[] temp = new PlaneSeat[12];
		for (int i = 0; i < 12; i++) {
			temp[i] = seat[i];
		}
		
		// Do the sorting using bubble sort
		boolean sorted = false;
		do{
			//"count" variable that represents the number of swaps made; 0 means no swaps
			int count = 0;
			for (int i = 0; i < 11; i++) {
				if (temp[i].getCustomerID() > temp[i+1].getCustomerID()) {
					// swap by creating a temp PlaneSeat variable
					PlaneSeat temp_seat = new PlaneSeat();
					temp_seat = temp[i];
					temp[i] = temp[i+1];
					temp[i+1] = temp_seat;
					count++;
				}
			}
			if (count == 0) { // count == 0 means it is fully sorted cuz no more swaps possible
				sorted = true;
			}
		} while (sorted == false);
		
		return temp;
		
	}
	
	public void showNumEmptySeats() {
		// print numEmptySeat variable directly
		System.out.println("There are " + numEmptySeat + " empty seats.");
	}
	
	public void showEmptySeats() {
		System.out.println("The following seats are empty: ");
		// print out all seats that isOccupied method returns false
		for (int i = 0; i < 12; i++) {
			if (seat[i].isOccupied() == false) {
				System.out.println("Seat ID " + seat[i].getSeatID());
			}
		}	
	}
	
	public void showAssignedSeat(boolean bySeatID) {
		
		// Store the seats that have an assignment into a temporary array
		PlaneSeat[] temp1 = new PlaneSeat[12 - numEmptySeat];
		int index = 0;
		for (int i = 0; i < 12; i++) {
			if (seat[i].isOccupied() == true) {
				temp1[index] = seat[i];
				index++;
			}	
		}
		
		// if bySeatID is true, sort by seatID
		if (bySeatID == true) {
			//use a do-while loop to implement a bubble sort and compare seatIDs. while sorted == false
			boolean sorted = false;
			do{
				int count = 0;
				for (int i = 0; i < temp1.length - 1; i++) {
					//Push higher value between the two up the array
					if (temp1[i].getSeatID() > temp1[i+1].getSeatID()) {
						PlaneSeat plane_seat = new PlaneSeat();
						plane_seat = temp1[i];
						temp1[i] = temp1[i+1];
						temp1[i+1] = plane_seat;
						count++;
					}
				}
				if (count == 0) {
					sorted = true;
				}
			} while (sorted == false);	
		}
		
		// otherwise, sort by customerID
		else {
			//Another bubble sort but this time compares customerIDs
			boolean sorted = false;
			do{
				//count variable that represents the number of swaps made; 0 means no swaps
				int count = 0;
				for (int i = 0; i < temp1.length - 1; i++) {
					if (temp1[i].getCustomerID() > temp1[i+1].getCustomerID()) {
						PlaneSeat plane_seat = new PlaneSeat();
						plane_seat = temp1[i];
						temp1[i] = temp1[i+1];
						temp1[i+1] = plane_seat;
						count++;
					}
				}
				if (count == 0) {
					sorted = true;
				}
			} while (sorted == false);	
		}
		
		//print out the sorted list of assigned seats
		for (int i = 0; i < temp1.length; i++) {
			System.out.println("SeatID " + temp1[i].getSeatID() + " assigned to CustomerID " + temp1[i].getCustomerID() + " .");
		}
		
	}
	
	public void assignSeat(int seat_id, int cust_id){
		// Go through each seat and look for the desired seat_id.
		for (int i = 0; i < 12; i++) {
			//if seatID found and seat is empty, allocated the customer to the seat
			if (seat[i].getSeatID() == seat_id && seat[i].isOccupied() == false) {
				seat[i].assign(cust_id);
				System.out.println("Seat assigned!");
				//update the numEmptySeat after assignment
				numEmptySeat--;
				break;
			}
			// else if seatID found BUT seat is already occupied, return error message
			else if (seat[i].getSeatID() == seat_id && seat[i].isOccupied() == true){
				System.out.println("Seat already assigned to a customer");
			}	
		}
		
	}
	
	
	public void unAssignSeat(int seat_id) {
		// Go through each seat and look for the desired seat_id.
		for (int i = 0; i < 12; i++) {
			// if seatID found and seat is occupied, remove the customer from the seat
			if (seat[i].getSeatID() == seat_id && seat[i].isOccupied() == true) {
				seat[i].unAssign();
				System.out.println("Seat unassigned!");
				numEmptySeat++;
				break;
			}	
			// else if seatID found BUT the seat is already empty, return error message
			else if (seat[i].getSeatID() == seat_id && seat[i].isOccupied() == false){
				System.out.println("Seat is already empty");
			}	
		}
		
	}
	
}
