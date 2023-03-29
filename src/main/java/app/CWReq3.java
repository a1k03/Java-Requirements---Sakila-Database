package app;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.BaseQuery;

public class CWReq3 extends BaseQuery{

	public CWReq3(String configFilePath) throws FileNotFoundException {
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
	

	
public ArrayList<Payment> getActual() throws SQLException {  
	
	
	ArrayList<Integer> customerIds = new ArrayList<>();  
	ArrayList<Payment> paymentList =getPayments();
	
	
	for(Payment p:paymentList) {
		
		if(!customerIds.contains(p.getCustomerID())) {  /*this loop checks if there is already a present customerID or not, if current 
		customer ID (that is coming from paymentList loop) is not present in customerIDs arraylist then it adds the current value, but if the current
		customerID is already present then it skips, so at the end of the outer loop we will get the unique IDs, meaning no duplicate values*/
			customerIds.add(p.getCustomerID());
		}
		
		
	}
	
	ArrayList<Payment> uniquePayments = new ArrayList<>();
	/* starts the loop of unique customer ids and uses paymentList loop as inner loop, checking in every iteration if
	 * paymentList customerID matches with outer loop -> customerIds arraylist. It adds the amount in the total variable for current id
	 * so in the end we will get unique ids and their total payments*/
	double total;
	for(int id:customerIds) {
		total = 0;
		for(Payment p:paymentList) {
		if(p.getCustomerID()==id) {
			total+=p.getAmount();
		}
		}
		//this is for formatting the decimal points up to 2 digits
		total = Double.parseDouble(String.format("%.2f", total));
		
		//adding unique data in this arraylist
		uniquePayments.add(new Payment(id,total));
	}
	//this method helps us to sort the arraylist using our built in method compareTo in the payment class
	Collections.sort(uniquePayments);
	
	//adds top 10 values of uniquePayment ArrayList into top10CusbyRev Arraylist
	ArrayList<Payment> top10CusbyRev =  new ArrayList<>();

	for(int i=0;i<10;i++) {
		top10CusbyRev.add(uniquePayments.get(i));  // loops through 10 items of the list
	}
	
	//return top10CusbyRev
	return top10CusbyRev;
}

	




private ArrayList<Payment> getPayments() throws SQLException {
	
	
	ArrayList<Payment> paymentList = new ArrayList<>();
	ResultSet rs = this.getResultSet("Select * from payment");
	int count = 0;
	while(rs.next()) {
		count++;
		Payment payment = new Payment(rs.getInt("customer_id"),rs.getDouble("amount"));
		paymentList.add(payment);
	}
	return paymentList;
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
	 * want to fetch the custtomer names to make the output human-friendly.
	 * You are allowed to write additional helper methods.
	 * ----------------------------------------------------------------------
	 */
	
	public void printOutput() throws SQLException{
		
		
		ArrayList<Payment> top10CusbyRev = getActual();
		
		System.out.println("CustomerID    Revenue")
;		for(int i=0;i<top10CusbyRev.size();i++) {
			System.out.println(String.format("%-14s$%-6s",top10CusbyRev.get(i).getCustomerID(),top10CusbyRev.get(i).getAmount()));
			// .format is used to format the output in a human friendly way
		}
//		
	}
}
