import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class IDandPasswords {
	PreparedStatement ps;
    ResultSet rs;
   
    String query = "SELECT ID, NAME, ADDRESS FROM PERSON";
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	/*
	 *Establish a connection to the database 
	 * Get the passwords and usernames and store them
	 * display the details in the logininfo hashmap
	 * 
	 * 
	 * 
	 * */
	
	IDandPasswords()
	{
		/*
		 * have a loop that returns the username and passwords in keyvalue form
		 * 
		 * */
		logininfo.put("Bro","pizza");
		logininfo.put("Brometheus","PASSWORD");
		logininfo.put("BroCode","abc123");
	}
	
	protected HashMap getLoginInfo()
	{
		return logininfo;
	}

}
