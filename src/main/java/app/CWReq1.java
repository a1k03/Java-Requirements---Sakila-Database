package app;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.BaseQuery;

public class CWReq1 extends BaseQuery{

	public CWReq1(String configFilePath) throws FileNotFoundException {
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
	
	public int getActual() throws SQLException {
		ArrayList<Actor> actors = new ArrayList<Actor>();  // creating an array list of actors
		ArrayList<Actor> total_actors = new ArrayList<Actor>();  // creating array list of total actors
		
		Actor a;  // creating object a for actor class
		
		Integer actorID;  // declaring actor id as an integer
		String firstName, lastName;  // declaring both first names and last names as string

		
		ResultSet rs = this.getResultSet("Select * from actor");  // sql query bringing all data from actor table in database
		
		//iterate over the ResultSet to create an ArrayList of Actor objects
		while(rs.next()) {
			actorID = rs.getInt("actor_id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");

			a = new Actor(actorID, firstName, lastName);
			actors.add(a);  // adds fields to the list of actorsS
		}
		
		for(Actor b: actors) {
			total_actors.add(b);
			}  // adds object b to total actors list
		
		
		return total_actors.size();  // returns total size of the total_actors list
	
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
		System.out.println("The total number of actors is "+getActual());  // display result 
		}
	}


