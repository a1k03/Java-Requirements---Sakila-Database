package testapp;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Actor;
import app.CWReq2;
import app.Film;
import junit.framework.TestCase;

public class TestCWReq2 extends TestCase {
	
	private CWReq2 r;

	public TestCWReq2(String testName) throws FileNotFoundException {
		super(testName);
		r = new CWReq2("src/test/java/testapp/DBconfiguration1.json");
	}
	
    @Override
    protected void setUp() throws Exception {
    	System.out.println("\n\n\n\n");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println("Running tests in " + this.getClass().getName() + "...");
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    	r.openconn();
    }
    
    @Override
    protected void tearDown() throws Exception {
    	r.closeconn();
    	System.out.println("Finished tests in " + this.getClass().getName());
    	System.out.println("-------------------------------------------------------\n\n");
    }
    
	/* -------------------------------------------------------------
	 * TODO: getExpected() to be completed as part of the coursework.
	 * --------------------------------------------------------------
	 */
	/* ---------------------------------------------------------------------
	 * The getExpected() method returns yours requirements's expected results.
	 * These results can be obtained by writing complex SQL queries 
	 * and using the ResultSet API to obtain the expected results. Unlike 
	 * the requirement code, where you talk to the database multiple times 
	 * to get tables into memory and compute over them, the expected results 
	 * can be obtained by running SQL queries which have advanced SQL 
	 * primitives in it such as SUM, COUNT, ORDER BY, GROUP BY, etc.
	 * In this instance, the return type is a String, you are free to choose
	 * other return types depending on the requirement. You are allowed to 
	 * write additional helper methods.
	 * ---------------------------------------------------------------------
	 */
    
    private Integer getExpected() throws SQLException{
    	
    	ArrayList<Integer> most_frequent_renting_customer = new ArrayList<Integer>();  // creates an array list of the most frequent renting customer
    	
    
    	Integer customerID = null;  // sets current customer id to have no value
    	
    	ResultSet rs = r.getResultSet("select customer_id, count(*) as total_no_of_rentals from rental\n"
    			+ "group by customer_id order by total_no_of_rentals desc limit 1");  /* complex query which counts the occurence
    			 																	of the customer id that appears the most in the rental table */

    	while(rs.next()) {
    		customerID = rs.getInt("customer_id");  // sets customer id variable to be equal to the field customer_id in the rental table
    		most_frequent_renting_customer.add(customerID);  // adds this customer id to the most_frequent_renting_customer list
    	}
    	
    	return customerID;  // returns the customer id
    }
	
	/* -------------------------------------------------------------
	 * TODO: testAndOutput() to be modified, if required, as part 
	 * of the coursework.
	 * --------------------------------------------------------------
	 */
	/* ---------------------------------------------------------------------
	 * The testAndOutput() method does two things:
	 *    1. Invokes the method which prints output from the requirement 
	 *    	 code on to the console in a human-friendly format.
	 *    2. Compares the expected result with the actual result.
	 *    
	 * This method may need to be modified if you are using a type which 
	 * is other than a string for returning your expected and actual results.
	 * ---------------------------------------------------------------------
	 */
    /**
     *  Output Results and Test Sample Requirement
     * @throws FileNotFoundException 
     * @throws SQLException 
     */
    
    public void testAndOutput() throws FileNotFoundException, SQLException
    {
  
    	r.printOutput();
    	
    	String expected = String.valueOf(getExpected());  // retrieves the value of the getExpected function in a string format
    	String actual = r.getActual().split("-")[0]; // splits string to retrieve first index position of key set
    	
    	assertEquals(expected, actual);
    }
    
}
