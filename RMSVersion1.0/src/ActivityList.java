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

public class ActivityList implements ActionListener{
	
	JFrame frame = new JFrame("RMSVersion1.0");
	JLabel HeadingLabel =  new JLabel("  Your current list of activities.          ");
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable table = new JTable(defaultTableModel);
	JButton addActivityButton = new JButton("Add Activity"); 
	JButton rmActivityButton = new JButton("Remove Activity");
	JLabel inBetweenSpaceLabel =  new JLabel();
	int flag;
	
	ActivityList(){
		
		//show table list of notifications
				HeadingLabel.setBounds(200,50,300,25);
				HeadingLabel.setFont(new Font(null,Font.BOLD,20));
				HeadingLabel.setForeground(Color.decode("#eaf2f8"));
				
				inBetweenSpaceLabel.setText("                      ");
				
				table.setPreferredScrollableViewportSize(new Dimension(800,400));
				table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
				table.setFillsViewportHeight(true);
				
				addActivityButton.setFocusable(false);
//				addActivityButton.setBackground(Color.decode("#2471a3"));
				addActivityButton.setForeground(Color.decode("#212f3c"));
//				addActivityButton.setBorderPainted(false);
				addActivityButton.addActionListener(this);
				
				
				
				rmActivityButton.setFocusable(false);
//				addActivityButton.setBackground(Color.decode("#2471a3"));
				rmActivityButton.setForeground(Color.decode("#212f3c"));
//				addActivityButton.setBorderPainted(false);
				rmActivityButton.addActionListener(this);
				
				
				frame.add(HeadingLabel);
				frame.add(inBetweenSpaceLabel);
				frame.add(addActivityButton);
				frame.add(rmActivityButton);
				frame.add(table);
				frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
				frame.getContentPane().setBackground(Color.decode("#154360"));
				
				//very very important to remember with flowLayout or just the table getting data from database
				//the table column headings should be put like so in frame add section,but why???as the table might have no column headings.
				frame.add(new JScrollPane(table));
				defaultTableModel.addColumn("ID");
				defaultTableModel.addColumn("MypID");
				defaultTableModel.addColumn("Name of activity");
				defaultTableModel.addColumn("Activity partner");
				defaultTableModel.addColumn("Date");
				defaultTableModel.addColumn("Activity notes");
			
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(950, 500);
				frame.setLayout(new FlowLayout());
				frame.setVisible(true);
				
				//load the table database table data
				
				PreparedStatement ps;
				ResultSet rs;
				
				String query = "SELECT * FROM myPals_activities";
				try
				{
					ps = Main.getConnection().prepareStatement(query);
					rs = ps.executeQuery(query);
					
					while(rs.next())
					{
						int id = rs.getInt("act_id");
						int mypID = rs.getInt("myp_id");
						String actName = rs.getString("nameOfAct");
						String actPart = rs.getString("actPartner");
						Date actDate = rs.getDate("date");
						String actNotes = rs.getString("actNotes");
						
						
						
						defaultTableModel.addRow(new Object[]{id,mypID,actName,actPart,actDate,actNotes});
						
						flag = 1;
						
					}
					
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null,"No current activities.");
					}
					
				}
				catch (SQLException throwables) {
					// TODO Auto-generated catch block
					throwables.printStackTrace();
				}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== addActivityButton) 
		{
			//add an activity
			//call activity add function
			AddActivity addActivity = new AddActivity();
			
			
		}
		if(e.getSource()==rmActivityButton)
		{
			//call remove activity class
		}
		
	}

}
