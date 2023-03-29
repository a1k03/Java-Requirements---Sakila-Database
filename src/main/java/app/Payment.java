package app;

public class Payment implements Comparable<Payment> {  // comparable is used to compare lists
	
	private int customerId;
	private double amount;
	public Payment(int customerId, double amount) {
		super();
		this.customerId = customerId;
		this.amount = amount;
	}
	
	
	public int getCustomerID() {
		return customerId;
	}
	
	public double getAmount() {
		return amount;
	}


	@Override
	public int compareTo(Payment o) {   // makes sure 10 items are outputted
		if(this.amount>o.amount) {
			return -1;
		}else if(this.amount<o.amount) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return customerId+", $"+amount;
	}
	
	
}
