package app;

public class Rental {  // declaring rental class 
	private Integer inventory_id;
	private Integer rental_id;
	private Integer customer_id;
	

	
	public Rental(Integer rental_id, Integer inventory_id, Integer customer_id ) {  // passing these parameters to use in the getactual and getexpected
		this.rental_id = rental_id;
		this.inventory_id = inventory_id;
		this.customer_id = customer_id;
	}

	// created three extra functions to retrieve data from the rental table

	public Integer getCustomerID() {  
		return this.customer_id;
	}
	
	public Integer getRentalID() {
		return this.rental_id;
	}
	
	public Integer getInventoryID() {
		return this.inventory_id;
	}
	
	
}
