import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListDeletedFriends {
	
	//lists the people that you have deleted in a table
	//constructor
	
	JFrame frame = new JFrame("RMSVersion1.0");
	JLabel HeadingLabel =  new JLabel("         Deleted people list!           ");
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable table = new JTable(defaultTableModel);
	int flag;
	
	ListDeletedFriends()
	{
		HeadingLabel.setBounds(200,50,300,25);
		HeadingLabel.setFont(new Font(null,Font.BOLD,20));
		HeadingLabel.setForeground(Color.decode("#eaf2f8"));
		
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setFillsViewportHeight(true);
		
		
		
		
		frame.add(HeadingLabel);
		frame.add(table);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		
		//very very important to remember with flowLayout or just the table getting data from database
		//the table column headings should be put like so in frame add section,but why???as the table might have no column headings.
		frame.add(new JScrollPane(table));
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("MypID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Reason");
		defaultTableModel.addColumn("Contact Info");
		defaultTableModel.addColumn("Delete Date");
	
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(950, 500);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		//load the table database table data
		
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM myPals_deleted";
		try
		{
			ps = Main.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			
			while(rs.next())
			{
				int id = rs.getInt("del_id");
				int mypID = rs.getInt("myp_id");
				String name = rs.getString("name");
				String reason = rs.getString("reason");
				String contInfo = rs.getString("contactInfo");
				Date date = rs.getDate("delDate");
				
				defaultTableModel.addRow(new Object[]{id,mypID,name,reason,contInfo,date});
				
				flag = 1;
				
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(null,"No details found");
			}
			
		}
		catch (SQLException throwables) {
			// TODO Auto-generated catch block
			throwables.printStackTrace();
		}
		
		
		
	}
	
	
	

}
