package app;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import db.BaseQuery;

public class CWReq2 extends BaseQuery{

	public CWReq2(String configFilePath) throws FileNotFoundException {
		super(configFilePath);
	}
	
	/* -------------------------------------------------------------
	 * TODO: getActual() to be completed as part of the coursework.
	 * --------------------------------------------------------------
	 */
	/* ---------------------------------------------------------------------
	 * The getActual() method returns yours requirement code's output.
	 * In this instance, the return type is a String, you are free to choose
	 * other return types depending on the requirement. You are allowed to 
	 * write additional helper methods.
	 * ---------------------------------------------------------------------
	 */
	
	public String getActual() throws SQLException {
		ArrayList<Rental> all_rentals = getAllRentals();  // creates an array list of all rentals 
		ArrayList<Customer> all_customers = getAllCustomers();  // creates an array list of all customers
		Integer c_customer_id, d_customer_id; // creates variables for the customer_id in both tables (customer and rental)
		Map<Customer, Integer> cm_map = new HashMap<Customer, Integer>();   // creates a hashmap which will display the customer as well as how much they have rented
		
		
		
		
		int total;  // sets variable 'total' as an integer type
		
	
		
		for (Customer c : all_customers) {  // for every customer in all_customers list
			total = 0;  // sets current total to 0
			int id = c.getCustomerID();  // sets new variable id to getCustomerID function which retrieves the customer id
		for (Rental d : all_rentals) { 
			 // nested for loop - for every customer (key) in the hash-map "cm_map" keyset 
				
			
			if(d.getCustomerID()==id) {  // checks if customer id in all_rentals list matches the variable id from the all_customers list
				total+=1;  // increments the total by one every time
			}
			

			
				}
		
		cm_map.put(c, total);		// adds customer id as well as their total value to the hashmap	
		}
		
		
		
		
		// Setting both variables to 0 so that they increment later 
		
		Integer highest_rented_customerID = 0; 
		Integer max_rent_count = 0; 
		
		
		for (Customer c : cm_map.keySet()) {  // for loop which loops through every customer in the hashmap
			if  ( cm_map.get(c) > max_rent_count ) {  // if the value of the amount of times the customer has rented is larger than the current max rent count variable
				max_rent_count = cm_map.get(c);    // set max rent count to current rent value in hashmap
				highest_rented_customerID = c.getCustomerID(); // set the highest rented customer id to getCustomerID which will retrieve the current customer id
				
			}
			
			
		}
		return (highest_rented_customerID +"-"+ max_rent_count);  // return the customer id with the highest amount of rentals
		
	}
		
	// Creating an array list of all customers
	
		private ArrayList<Customer> getAllCustomers() throws SQLException {
			ArrayList<Customer> all_customers = new ArrayList<Customer>();
		
			Customer c;  // using object c from customer class
		
			// setting variable types
			String first_name; 
			String last_name;
			Integer customer_id;
		
		ResultSet rs = this.getResultSet("Select * from customer");  // basic sql query retrieving all data from customer table
		
		while(rs.next()) {  // while loop which goes through the result set
			// sets variables to retrieve specified data from the table Customer
			first_name = rs.getString("first_name");
			last_name = rs.getString("last_name");
			customer_id = rs.getInt("customer_id");
			c = new Customer(customer_id, first_name, last_name);  // creates object c which takes in parameters in that order
			all_customers.add(c);  // adds this object to the list
		}
		
		return all_customers;  // returns the list of all customers
	}

		// creating an array list of all rentals
	private ArrayList<Rental> getAllRentals() throws SQLException {
		ArrayList<Rental> all_rentals = new ArrayList<Rental>(); // creates an array list of all rentals from rental table
		
		Rental r;  // creates rental object r
		
		// setting variable types
		Integer customer_id;
		Integer rental_id;
		Integer inventory_id;
		
		ResultSet rs = this.getResultSet("select * from rental");  // basic sql query which retrieves all data from the rental table
		
		while (rs.next()) { // looping through result set
			
			// setting these variables to be equal to the corresponding field data in the rental table
			customer_id = rs.getInt("customer_id");
			rental_id = rs.getInt("rental_id");
			inventory_id = rs.getInt("inventory_id");
			r = new Rental(  rental_id, inventory_id,customer_id);  // creates object r which takes in these parameters in this order
			all_rentals.add(r);  // adds r object to all_rentals list
		}
		return all_rentals;  // returns array list of all_rentals
	}

	/* -------------------------------------------------------------
	 * TODO: printOutput() to be completed as part of the coursework.
	 * --------------------------------------------------------------
	 */
	/* ----------------------------------------------------------------------
	 * The printOutput() method prints result of your requirement code 
	 * onto the console for the end-user to view. This method should
	 * rely on the requirement code results obtained through the getActual() 
	 * method, decorate it in a human friendly format and display the results 
	 * on the console. It is possible that this method may need to get additional 
	 * data to make the output human friendly. For example, if the requirement 
	 * code returns only the customer IDs, this method may additionally 
	 * want to fetch the customer names to make the output human-friendly.
	 * You are allowed to write additional helper methods.
	 * ----------------------------------------------------------------------
	 */
	
	public void printOutput() throws SQLException{
		String str = getActual();  // sets getActual method to a string type
		String most_frequent_customer_id = str.split("-")[0]; // divides string at the specified regex information and returns the first index position
		String maxCount = str.split("-")[1]; // gives value (second index position in key set)
		
		System.out.println("The customer who is the most frequent renter has the id : "+ most_frequent_customer_id);
		System.out.println("The number of times they have rented a film was :  " + maxCount);
		
		}
	}


