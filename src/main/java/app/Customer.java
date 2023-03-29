package app;



public class Customer {  // creates customer class
	
	// sets variable types
	private Integer customer_id;
	private String first_name;
	private String last_name;
	
	public Customer( int c, String f, String l) {
		this.customer_id = c;
		this.first_name = f;
		this.last_name = l;
	}
	
	public Integer getCustomerID() {
		return this.customer_id;
	}

	public String getFirstName() {
		return this.first_name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	
}
