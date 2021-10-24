import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClearNotificationTable {
	
	//constructor
	ClearNotificationTable() 
	{
		PreparedStatement ps;
		ResultSet rs;
		
		String queryTrunc = "TRUNCATE myPals_notifications";
		try
		{
			//clear out the table first
			ps = Main.getConnection().prepareStatement(queryTrunc);
			ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
//		
		
		
	}

}
