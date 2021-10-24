import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddActivity implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel activityHeadingLabel = new JLabel("Add a new Activity!");
	
	JLabel nameOfActivityLabel = new JLabel("Name of activity:");
	JLabel actPartnerLabel = new JLabel("Activity Partner:");
	JLabel actDateLabel = new JLabel("Date of activity:");
	JLabel notesOnActivityLabel = new JLabel("Notes on activity:");
	
	JTextField nameOfActivityTextField = new JTextField();
	JTextField actPartnerTextField = new JTextField();
	JDateChooser actDateChooser = new JDateChooser();
	JTextArea actNotesOnActivityTextArea = new JTextArea();
	//JTextField lastIntTextField = new JTextField();
	
	JButton saveActivityButton = new JButton("Save");
	JComboBox friendComboBox = new JComboBox();
	//use model when getting data from database
	//DefaultComboBoxModel friendComboBox=new DefaultComboBoxModel();
	int myPalID;
	String myPalName;
	String seltdValueNew;
	
	
	java.sql.Date actDate;
	
	
	//constructor
	AddActivity()
	{
		//add

		activityHeadingLabel.setBounds(145,10,300,25);
		activityHeadingLabel.setFont(new Font(null,Font.BOLD,20));
		activityHeadingLabel.setForeground(Color.decode("#eaf2f8"));
		
		nameOfActivityLabel.setBounds(40, 60, 200, 25);
		nameOfActivityLabel.setFont(new Font(null,Font.PLAIN,15));
		nameOfActivityLabel.setForeground(Color.decode("#aed6f1"));
		actPartnerLabel.setBounds(50,100,300,25);
		actPartnerLabel.setFont(new Font(null,Font.PLAIN,15));
		actPartnerLabel.setForeground(Color.decode("#aed6f1"));
		actDateLabel.setBounds(50,140,300,25);
		actDateLabel.setFont(new Font(null,Font.PLAIN,15));
		actDateLabel.setForeground(Color.decode("#aed6f1"));
		notesOnActivityLabel.setBounds(40,180,300,25);
		notesOnActivityLabel.setFont(new Font(null,Font.PLAIN,15));
		notesOnActivityLabel.setForeground(Color.decode("#aed6f1"));
		
		
		nameOfActivityTextField.setBounds(190,60,250,25);
		nameOfActivityTextField.setBorder(null);
		nameOfActivityTextField.setBackground(Color.decode("#ecf0f1"));
		comboLoad();
		friendComboBox.setBounds(190,100,250,25);
		friendComboBox.setBorder(null);
		friendComboBox.setBackground(Color.decode("#ecf0f1"));
		
		actDateChooser.setBounds(190,140,250,25);
		
		actNotesOnActivityTextArea.setBounds(190,180,250,100);
		actNotesOnActivityTextArea.setBorder(null);
		actNotesOnActivityTextArea.setBackground(Color.decode("#ecf0f1"));

		
		saveActivityButton.setBounds(190,300,100,25);
//		saveActivityButton.setBackground(Color.decode("#ecf0f1"));
		saveActivityButton.setForeground(Color.decode("#154360"));
//		saveActivityButton.setBorderPainted(false);
		saveActivityButton.addActionListener(this);
		
		frame.add(activityHeadingLabel);
		
		frame.add(nameOfActivityLabel);
		frame.add(actPartnerLabel);
		frame.add(actDateLabel);
		frame.add(notesOnActivityLabel);

		frame.add(nameOfActivityTextField);
		frame.add(friendComboBox);
		frame.add(actPartnerTextField);
		frame.add(actDateChooser);
		frame.add(actNotesOnActivityTextArea);

		frame.add(saveActivityButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		frame.setSize(500, 450);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==saveActivityButton) 
		{
			//getting the datechooser selected date
			 java.util.Date actD = actDateChooser.getDate();
			 if (actD == null) {
			     JOptionPane.showMessageDialog(null,"No date specified!");
			 } else {
			     java.sql.Date sqldate = new java.sql.Date(actD.getTime());
			     actDate = sqldate;
			     // Do something with sqldate
			 }
			 
//			 	String actName = rs.getString("nameOfAct");
//				String actPart = rs.getString("actPartner");
//				Date actDate = rs.getDate("date");
//				String actNotes = rs.getString("actNotes");
			 	String actHead = nameOfActivityTextField.getText();
			 	String actNotesn =actNotesOnActivityTextArea.getText();
			 
			 String seltdValue = String.valueOf(friendComboBox.getSelectedItem());
			//get the selected name and then get the id to insert
			 getMyPID(seltdValue);
			 //insert values into database table
			 //JOptionPane.showMessageDialog(null,"Mypal id." + myPalID);
			PreparedStatement ps;
			ResultSet rs;
			String query = "INSERT INTO myPals_activities(myp_id,nameOfAct,actPartner,date,actNotes)VALUES(?,?,?,?,?)";
			
			//you have and error in your sql syntax,the manual that corresponds to your MariaDB server version for the right syntax to use near '?' at line 1
			try
			{
				ps = Main.getConnection().prepareStatement(query);
				ps.setInt(1,myPalID);
				ps.setString(2, actHead);
				ps.setString(3,seltdValue);
				ps.setDate(4,actDate);
				ps.setString(5,actNotesn);
				
				 
	            if(ps.executeUpdate() > 0)
	            {
	                //JOptionPane.showMessageDialog(null, "New User Add");
	                JOptionPane.showMessageDialog(null,"Details successfully saved!");
	                frame.dispose();
	            }
	            else 
	            {
	            	JOptionPane.showMessageDialog(null,"Something went wrong on saving.");
	            }
	            
				
			}
			catch(SQLException e2) {
				JOptionPane.showMessageDialog(null,"this is the exception: "+ e2);
				}
			
			
			
			
			
			
			
		}
		
	}
	
	public void  comboLoad()
	{
		//initComponents();
		//populate JCombobox
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT myp_id,myp_name FROM myPals";
		try
		{ 
			ps = Main.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			
			while(rs.next()){
				int fid = rs.getInt(1);
				String fname = rs.getString(2);
				
				friendComboBox.addItem(fname);
				}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"this is the exception: "+ e);
			}
		 
	}
	
	//get mypID
	public void getMyPID(String seltdValue)
	{
		PreparedStatement ps;
		//ResultSet rs;
		
		//get the selected name and then get the id to insert
		//String querymyPID = "SELECT myp_id,myp_name FROM myPals WHERE myp_name = ?";
		
		
		try
		{
//			ps = Main.getConnection().prepareStatement(querymyPID);
//			ps.setString(1, seltdValueO);//the one the is used in search
//			rs = ps.executeQuery(querymyPID);
			
			ps = Main.getConnection().prepareStatement("SELECT myp_id,myp_name FROM myPals WHERE myp_name = ?");
			ps.setString(1, seltdValue);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				myPalID = rs.getInt("myp_id");
				seltdValueNew=rs.getNString("myp_name");
				
				//JOptionPane.showMessageDialog(null,"Mypal id." + myPalID);
				
				
			}
			 else 
	            {
	            	JOptionPane.showMessageDialog(null,"Something went wrong on saving.");
	            }
	            
			
			
			 
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"this is the exception: "+ e);
			}
		
		
	}

}
