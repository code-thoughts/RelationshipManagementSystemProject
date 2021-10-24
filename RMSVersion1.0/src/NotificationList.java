import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotificationList implements ActionListener {
	
	JFrame frame = new JFrame("RMSVersion1.0");
	JLabel HeadingLabel =  new JLabel("  Its been more than two weeks get intouch with your friends!!!          ");
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable table = new JTable(defaultTableModel);
	JButton AcknowledgeNoteButton = new JButton("Acknowledge"); 
	int flag;
	
	NotificationList()
	{
		//show table list of notifications
		HeadingLabel.setBounds(200,50,300,25);
		HeadingLabel.setFont(new Font(null,Font.BOLD,20));
		HeadingLabel.setForeground(Color.decode("#eaf2f8"));
		
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setFillsViewportHeight(true);
		
		AcknowledgeNoteButton.setFocusable(false);
		AcknowledgeNoteButton.setBackground(Color.decode("#2471a3"));
		AcknowledgeNoteButton.setForeground(Color.decode("#212f3c"));
		AcknowledgeNoteButton.setBorderPainted(false);
		AcknowledgeNoteButton.addActionListener(this);
		
		
		
		frame.add(HeadingLabel);
		frame.add(AcknowledgeNoteButton);
		frame.add(table);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		
		//very very important to remember with flowLayout or just the table getting data from database
		//the table column headings should be put like so in frame add section,but why???as the table might have no column headings.
		frame.add(new JScrollPane(table));
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("MypID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Last Contacted");
		defaultTableModel.addColumn("Number of days since last contact");
		
	
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(950, 500);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		//load the table database table data
		
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM myPals_notifications";
		try
		{
			ps = Main.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			
			while(rs.next())
			{
				int id = rs.getInt("not_id");
				int mypID = rs.getInt("myp_id");
				String name = rs.getString("myp_name");
				Date lsContd = rs.getDate("myp_lstcontacted");
				int numOfDays = rs.getInt("NumOfDaysSinceLastContact");
				
				
				defaultTableModel.addRow(new Object[]{id,mypID,name,lsContd,numOfDays});
				
				flag = 1;
				
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(null,"Keeping up with your contacts Good!");
			}
			
		}
		catch (SQLException throwables) {
			// TODO Auto-generated catch block
			throwables.printStackTrace();
		}

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==AcknowledgeNoteButton)
		{
			int i = table.getSelectedRow();
			
			if(i>=0)
			{
				 int rID = (int) defaultTableModel.getValueAt(i, 0);
				 int mypID = (int) defaultTableModel.getValueAt(i, 1);
				 EditFriend editFriend = new EditFriend(mypID);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please select a row");
			}
			
		}
		
	}
	

}
