import java.sql.Connection;
import java.sql.DriverManager;



public class Main {

	public static void main(String[] args) {
		
		LoginPage loginPage = new LoginPage();
		//WelcomePage welcomePage = new WelcomePage(null);
		
		//IDandPasswords idandPasswords = new IDandPasswords();
		
		//LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}
	
	 public static Connection getConnection(){
	     
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/RMS_db", "admin", "=@!#254Stella");
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	        
	        return con;
	    }

}
