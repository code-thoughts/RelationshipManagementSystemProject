import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Notifications {
	
	//on loading the table,check whether current date - date coming through is > 10days
	//if its true,make that row color red and call notifications class send through details,id,name... into database table
	//if its not true display row with normal color
	//on click of notification button,it will go to another JFrame and display the table list of notifications from the database table.
	
	//JFrame frame = new JFrame();
	//constructor
	Notifications( int idn,String namen,Date lsContn,long diffDays)
	{
		//insert notifications into notification table
		//and then show table
		
		PreparedStatement ps,ps2;
		ResultSet rs;
		String query = "INSERT INTO myPals_notifications(myp_id,myp_name,myp_lstcontacted,NumOfDaysSinceLastContact )VALUES(?,?,?,?)";
	
		try
		{
			//insert new notifications
			ps = Main.getConnection().prepareStatement(query);
			ps.setInt(1, idn);
			ps.setString(2,namen);
			ps.setDate(3, lsContn);
			ps.setLong(4, diffDays);
			
			
			ps.executeUpdate();
			
//			if(ps.executeUpdate() > 0)
//			{
//				 JOptionPane.showMessageDialog(null,"Notifications successfully saved!");
//			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		
	}

}
