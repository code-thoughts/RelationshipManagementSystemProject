import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class DeleteFriendDetails  implements ActionListener{

	JFrame frame = new JFrame();
	JLabel delFriendHeadingLabel = new JLabel("Deletion feedback form!");
	JLabel myPalIDLabel = new JLabel("My pal id:");
	JLabel nameLabel = new JLabel("Name:");
	JLabel reasonLabel = new JLabel("Reason:");
	JLabel lastIntLabel = new JLabel("Contact info:");
	JLabel delDateLabel = new JLabel("Date:");
	
	JTextField myPalIDTextField = new JTextField();
	JTextField nameTextField = new JTextField();
	JTextArea reasonTextArea = new JTextArea();
	JTextField lastIntTextField = new JTextField();
	
	JButton delButton = new JButton("Save");
	int myPalID;
	String myPalName;
	JDateChooser delDateChooser = new JDateChooser();
	Date delDate;
	
	
	DeleteFriendDetails(int rID,String rName)
	{
		//JOptionPane.showMessageDialog(null,"Please click on table row first");
		
		//Changed last interaction to contact info.
		//Added a date chooser.
		
		myPalID = rID;
		myPalName = rName;
		delFriendHeadingLabel.setBounds(115,10,300,25);
		delFriendHeadingLabel.setFont(new Font(null,Font.BOLD,20));
		delFriendHeadingLabel.setForeground(Color.decode("#eaf2f8"));
		myPalIDLabel.setBounds(50, 60, 200, 25);
		myPalIDLabel.setFont(new Font(null,Font.PLAIN,15));
		myPalIDLabel.setForeground(Color.decode("#aed6f1"));
		nameLabel.setBounds(70,90,300,25);
		nameLabel.setFont(new Font(null,Font.PLAIN,15));
		nameLabel.setForeground(Color.decode("#aed6f1"));
		reasonLabel.setBounds(62,120,300,25);
		reasonLabel.setFont(new Font(null,Font.PLAIN,15));
		reasonLabel.setForeground(Color.decode("#aed6f1"));
		lastIntLabel.setBounds(30,220,300,25);
		lastIntLabel.setFont(new Font(null,Font.PLAIN,15));
		lastIntLabel.setForeground(Color.decode("#aed6f1"));
		delDateLabel.setBounds(80,250,300,25);
		delDateLabel.setFont(new Font(null,Font.PLAIN,15));
		delDateLabel.setForeground(Color.decode("#aed6f1"));
		
		
		myPalIDTextField.setBounds(130,60,250,25);
		myPalIDTextField.setBorder(null);
		myPalIDTextField.setBackground(Color.decode("#ecf0f1"));
		myPalIDTextField.setText("" + rID);
		myPalIDTextField.setEditable(false);
		nameTextField.setBounds(130,90,250,25);
		nameTextField.setBorder(null);
		nameTextField.setBackground(Color.decode("#ecf0f1"));
		nameTextField.setText(rName);
		nameTextField.setEditable(false);
		reasonTextArea.setBounds(130,120,250,25);
		reasonTextArea.setBorder(null);
		reasonTextArea.setBackground(Color.decode("#ecf0f1"));
		reasonTextArea.setSize(250, 95);
		lastIntTextField.setBounds(130,220,250,25);
		lastIntTextField.setBorder(null);
		lastIntTextField.setBackground(Color.decode("#ecf0f1"));
		delDateChooser.setBounds(130,250,250,25);
		
		
		delButton.setBounds(200,300,100,25);
		delButton.setBackground(Color.decode("#ecf0f1"));
		delButton.setForeground(Color.decode("#154360"));
		delButton.setBorderPainted(false);
		delButton.addActionListener(this);
		
		frame.add(delFriendHeadingLabel);
		frame.add(nameLabel);
		frame.add(myPalIDLabel);
		frame.add(reasonLabel);
		frame.add(lastIntLabel);
		frame.add(delDateLabel);
		frame.add(myPalIDTextField);
		frame.add(nameTextField);
		frame.add(reasonTextArea);
		frame.add(lastIntTextField);
		frame.add(delDateChooser);
		frame.add(delButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		frame.setSize(500, 450);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==delButton)
		{
			 java.util.Date d = delDateChooser.getDate();
			 if (d == null) {
			     JOptionPane.showMessageDialog(null,"No date specified!");
			 } else {
			     java.sql.Date sqldate = new java.sql.Date(d.getTime());
			     delDate = sqldate;
			     // Do something with sqldate
			 }
			//Get the id that was sent through to constructor
			//insert into the deletpal table
			PreparedStatement ps;
			ResultSet rs;
			
			//What to insert into the database
			int myPalIDnow = myPalID;
			String nameN = myPalName;
			String reasonN = reasonTextArea.getText();
			String lastInN = lastIntTextField.getText();//also contact info field,need to change this
			
			String query ="INSERT INTO myPals_deleted(myp_id,name,reason,contactInfo,delDate)VALUES(?,?,?,?,?)";
			try
			{
				
				ps = Main.getConnection().prepareStatement(query);
				ps.setInt(1,myPalIDnow);
				ps.setString(2, nameN);
				ps.setString(3, reasonN);
				ps.setString(4, lastInN);
				ps.setDate(5, delDate);
				
				if(ps.executeUpdate() > 0)
	            {
	                //JOptionPane.showMessageDialog(null, "New User Add");
	                JOptionPane.showMessageDialog(null,"Feedback successfully saved!");
	                frame.dispose();
	            }
	            
			}
			catch(SQLException ex)
			{
			
				JOptionPane.showMessageDialog(null,"Connection Issue" + ex);
			}
			
			
		}
	}
	
	
}
