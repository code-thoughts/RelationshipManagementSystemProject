import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AcknowledgedNotification {

	//constructor
	AcknowledgedNotification(int idEditFriend)//the mypID
	{
		PreparedStatement ps;
		ResultSet rs;
		String query = "DELETE FROM myPals_notifications WHERE  myp_id=? ";
		
		try
		{
			ps = Main.getConnection().prepareStatement(query);
			ps.setInt(1, idEditFriend);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Notification acknowledged!");
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
		
		
	}
	
}
