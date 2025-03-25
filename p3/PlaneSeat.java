package plane.p3;

public class PlaneSeat {
	//Instance variables
		private int seatID;
		private boolean assigned;
		private int customerID;
		
		//constructors
		public PlaneSeat(int seat_id) {
			seatID = seat_id;
		}
		
		public PlaneSeat() {
			
		}
		
		// Methods
		public int getSeatID() {
			return seatID;
		}
		
		public int getCustomerID() {
			return customerID;
		}
		
		public boolean isOccupied() {
			return assigned;
		}
		
		public void assign(int cust_id) {
			customerID = cust_id;
			assigned = true;
		}
		
		public void unAssign() {
			customerID = 0;
			assigned = false;
		}

}
