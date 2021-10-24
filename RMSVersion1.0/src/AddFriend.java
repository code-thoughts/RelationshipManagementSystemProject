import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.*;
import com.mysql.cj.jdbc.Blob;
//import com.sun.java.util.jar.pack.Package.File;
import com.toedter.calendar.JDateChooser;
//import java.sql.Date;
public class AddFriend  implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel addHeadingLabel = new JLabel("Add a new pal!");
	JLabel addIdLabel = new JLabel("FriendId:");
	JLabel addNameLabel =  new JLabel("Name:");
	JLabel addNickNameLabel = new JLabel("Nickname:");
	JLabel addProfLabel =  new JLabel("Proffession:");
	JLabel addRelLable = new JLabel("Religion:");
	JLabel addLikesLabel = new JLabel("Likes:");
	JLabel addDlikesLabel = new JLabel("Dislikes:");
	JLabel addMainPntOfConnetionLabel =  new JLabel("Main point of connection:");
	JLabel addLOfFriendshipLabel = new JLabel("Length of friendship:");
	JLabel addArgOrFightsLabel = new JLabel("Any arguments or fights:");
	JLabel addRforArgOrFightLabel = new JLabel("Reasons for the arguments of fights:");
	JLabel addResultionLabel = new JLabel("Resolution:");
	JLabel addPTypeLabel = new JLabel("Personality type:");
	JLabel addLContactedLabel = new JLabel("Last contacted:");
	JLabel addBirthDayLabel = new JLabel("Birthday:");
	JLabel addDUHelpthemLabel =  new JLabel("Do you help them?:");
	JLabel addPicture = new JLabel("Add a picture");
	JLabel selPhotoLabel = new JLabel("Select Photo:");
	
	JTextField fIDTextField = new JTextField();
	JTextField fNameTextField = new JTextField();
	JTextField fNicknamTextField =  new JTextField();
	JTextField fProfTextField = new JTextField();
	JTextField fRelTextField = new JTextField();
	JTextArea fLikesTextField = new JTextArea();
	JTextArea fDlikesTextField = new JTextArea();
	JTextArea fMainPntOfConnTextField =  new JTextArea();
	JTextField fLOfFriendshipTextField = new JTextField();
	JTextField ArgOrFightsTextField =  new JTextField();
	JTextArea fRforArgOrFightTextField = new JTextArea();
	JTextArea fResolutionTextField = new JTextArea();
	JTextArea fPTypeTextField = new JTextArea();
	JTextField fLContactedTextField = new JTextField();
	JTextField fBirthDayTextField =  new JTextField();
	JTextArea fDUHelpthemTextField =  new JTextArea();	
	
	JFileChooser fileChooser = new JFileChooser();
	JButton SaveNewFriendDetailsButton = new JButton("Save");
	JButton SelectfileButton = new JButton("Select File");
	JDateChooser dateC= new JDateChooser();
	JDateChooser lstContd = new JDateChooser();
	Date chosenDate;
	java.sql.Date firstDate;
	java.sql.Date lastContd;
	File selectedFile;
	String path;
	File newSFile;
	String s;
	
	AddFriend()
	{
		addHeadingLabel.setBounds(555, 20, 200, 25);
		addHeadingLabel.setFont(new Font(null,Font.BOLD,20));
		addHeadingLabel.setForeground(Color.decode("#eaf2f8"));
		addIdLabel.setBounds(150,100,200,25);
		addIdLabel.setFont(new Font(null,Font.BOLD,12));
		addIdLabel.setForeground(Color.decode("#aed6f1"));
		addNameLabel.setBounds(168,130,200,25);
		addNameLabel.setForeground(Color.decode("#aed6f1"));
		addNickNameLabel.setBounds(140,160,200,25);
		addNickNameLabel.setForeground(Color.decode("#aed6f1"));
		addProfLabel.setBounds(130,190,200,25);
		addProfLabel.setForeground(Color.decode("#aed6f1"));
		addRelLable.setBounds(150,220,200,25);
		addRelLable.setForeground(Color.decode("#aed6f1"));
		addLikesLabel.setBounds(170,240,200,25);
		addLikesLabel.setForeground(Color.decode("#aed6f1"));
		addDlikesLabel.setBounds(150,295,200,25);
		addDlikesLabel.setForeground(Color.decode("#aed6f1"));
		addMainPntOfConnetionLabel.setBounds(30,350,200,25);
		addMainPntOfConnetionLabel.setForeground(Color.decode("#aed6f1"));
		addLOfFriendshipLabel.setBounds(60,415,200,25);
		addLOfFriendshipLabel.setForeground(Color.decode("#aed6f1"));
		addArgOrFightsLabel.setBounds(35,445,200,25);
		addArgOrFightsLabel.setForeground(Color.decode("#aed6f1"));
		addRforArgOrFightLabel.setBounds(0,465,200,25);
		addRforArgOrFightLabel.setForeground(Color.decode("#aed6f1"));
		addResultionLabel.setBounds(130,520,200,25);
		addResultionLabel.setForeground(Color.decode("#aed6f1"));
		addPTypeLabel.setBounds(660,100,200,25);
		addPTypeLabel.setForeground(Color.decode("#aed6f1"));
		addLContactedLabel.setBounds(669,155,200,25);
		addLContactedLabel.setForeground(Color.decode("#aed6f1"));
		addBirthDayLabel.setBounds(715,185,200,25);
		addBirthDayLabel.setForeground(Color.decode("#aed6f1"));
		addDUHelpthemLabel.setBounds(650,215,299,25);
		addDUHelpthemLabel.setForeground(Color.decode("#aed6f1"));
		//addPicture.setBounds(660, 235, 200, 25);
		addPicture.setForeground(Color.decode("#aed6f1"));
		selPhotoLabel.setBounds(690,270,299,25);
		selPhotoLabel.setForeground(Color.decode("#aed6f1"));
		
		
		fIDTextField.setBounds(230,100,300,25);
		fIDTextField.setBorder(null);
		fIDTextField.setBackground(Color.decode("#ecf0f1"));
		fNameTextField.setBounds(230,130,300,25);
		fNameTextField.setBorder(null);
		fNameTextField.setBackground(Color.decode("#ecf0f1"));
		fNicknamTextField.setBounds(230,160,300,25);
		fNicknamTextField.setBorder(null);
		fNicknamTextField.setBackground(Color.decode("#ecf0f1"));
		fProfTextField.setBounds(230,190,300,25);
		fProfTextField.setBorder(null);
		fProfTextField.setBackground(Color.decode("#ecf0f1"));
		fRelTextField.setBounds(230,220,300,25);
		fRelTextField.setBorder(null);
		fRelTextField.setBackground(Color.decode("#ecf0f1"));
		fLikesTextField.setBounds(230,250,300,25);
		fLikesTextField.setSize(300, 50);
		fLikesTextField.setBorder(null);
		fLikesTextField.setBackground(Color.decode("#ecf0f1"));
		fDlikesTextField.setBounds(230,305,300,25);
		fDlikesTextField.setSize(300, 50);
		fDlikesTextField.setBorder(null);
		fDlikesTextField.setBackground(Color.decode("#ecf0f1"));
		fMainPntOfConnTextField.setBounds(230,360,300,25);
		fMainPntOfConnTextField.setSize(300, 50);
		fMainPntOfConnTextField.setBorder(null);
		fMainPntOfConnTextField.setBackground(Color.decode("#ecf0f1"));
		fLOfFriendshipTextField.setBounds(230,415,300,25);
		fLOfFriendshipTextField.setBorder(null);
		fLOfFriendshipTextField.setBackground(Color.decode("#ecf0f1"));
		ArgOrFightsTextField.setBounds(230,445,300,25);
		ArgOrFightsTextField.setBorder(null);
		ArgOrFightsTextField.setBackground(Color.decode("#ecf0f1"));
		fRforArgOrFightTextField.setBounds(230,475,300,25);
		fRforArgOrFightTextField.setSize(300, 50);
		fRforArgOrFightTextField.setBorder(null);
		fRforArgOrFightTextField.setBackground(Color.decode("#ecf0f1"));
		fResolutionTextField.setBounds(230,530,300,25);
		fResolutionTextField.setSize(300,50);
		fResolutionTextField.setBorder(null);
		fResolutionTextField.setBackground(Color.decode("#ecf0f1"));
		fPTypeTextField.setBounds(795, 100, 300, 25);
		fPTypeTextField.setSize(300,50);
		fPTypeTextField.setBorder(null);
		fPTypeTextField.setBackground(Color.decode("#ecf0f1"));
		lstContd.setBounds(795,155,300,25);
		lstContd.setBorder(null);
		lstContd.setBackground(Color.decode("#ecf0f1"));
		
//		fIDTextField.setBorder(null);
//		fIDTextField.setBackground(Color.LIGHT_GRAY);
//		fBirthDayTextField.setBounds(795,185,300,25);
//		fBirthDayTextField.setBorder(null);
//		fBirthDayTextField.setBackground(Color.decode("#ecf0f1"));
		
		////////////////////////////////////////////fileChooser
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//		int result = fileChooser.showOpenDialog(this);
//		if (result == JFileChooser.APPROVE_OPTION) {
//		    File selectedFile = fileChooser.getSelectedFile();
//		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//		}
		
		
		
		
		//////////////////////////////////////////////
		
		dateC.setBounds(795,185,300,25);
		
		fDUHelpthemTextField.setBounds(795,215,300,25);
		fDUHelpthemTextField.setSize(300,50);
		fDUHelpthemTextField.setBorder(null);
		fDUHelpthemTextField.setBackground(Color.decode("#ecf0f1"));
		
		SelectfileButton.setBounds(795, 270, 300, 25);
		SelectfileButton.addActionListener(this);
		
		fileChooser.setBounds(795, 235, 200, 25);
		//JFileChooser fileChooser = new JFileChooser(".");
		
	    fileChooser.setControlButtonsAreShown(false);
		SaveNewFriendDetailsButton.setBounds(585,600,150,25);
		SaveNewFriendDetailsButton.setBackground(Color.decode("#ecf0f1"));
		SaveNewFriendDetailsButton.setForeground(Color.decode("#154360"));
		SaveNewFriendDetailsButton.setBorderPainted(false);
		SaveNewFriendDetailsButton.addActionListener(this);
		
//		
		//addHeadingLabel.
		
		//panel.add(addHeadingLabel);
		//frame.add(panel);
		frame.add(addIdLabel);
		frame.add(addHeadingLabel);
		frame.add(addNickNameLabel);
		frame.add(addProfLabel);
		frame.add(addRelLable);
		frame.add(addNameLabel);
		frame.add(addLikesLabel);
		frame.add(addDlikesLabel);
		frame.add(addMainPntOfConnetionLabel);
		frame.add(addLOfFriendshipLabel);
		frame.add(addArgOrFightsLabel);
		frame.add(addRforArgOrFightLabel);
		frame.add(addResultionLabel);
		frame.add(addPTypeLabel);
		frame.add(addLContactedLabel);
		frame.add(addBirthDayLabel);
		frame.add(addDUHelpthemLabel);
		frame.add(selPhotoLabel);
		frame.add(addPicture);
		frame.add(fNameTextField);
		frame.add(fNicknamTextField);
		frame.add(fProfTextField);
		frame.add(fRelTextField);
		frame.add(fIDTextField);
		frame.add(fLikesTextField);
		frame.add(fDlikesTextField);
		frame.add(fMainPntOfConnTextField);
    	frame.add(fLOfFriendshipTextField);
		frame.add(ArgOrFightsTextField);
		frame.add(fRforArgOrFightTextField);
		frame.add(fResolutionTextField);
		frame.add(fPTypeTextField);
		frame.add(fLContactedTextField);
		frame.add(fBirthDayTextField);
		frame.add(fDUHelpthemTextField);
		frame.add(dateC);
		frame.add(lstContd);
		frame.add(SelectfileButton);
		frame.add(SaveNewFriendDetailsButton);
		frame.add(fileChooser);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		frame.setSize(1200, 670);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==SelectfileButton)
		 {
			 
			 JFileChooser fileChooser = new JFileChooser();//get instance of fileChooser
			 fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));//show where/which directory to check
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png","jpeg");//filter the kind of file formats that can be uploaded
			 fileChooser.addChoosableFileFilter(filter);//get the file chosen
			 int result = fileChooser.showSaveDialog(null);//save the file
			 
			 if(result == JFileChooser.APPROVE_OPTION){
				 selectedFile = fileChooser.getSelectedFile();
	             path = selectedFile.getAbsolutePath();
             //label.setIcon(ResizeImage(path));
	             s = path;
	             //newPic = new ImageIcon(path);
	             newSFile = new File(s);
	             //JOptionPane.showMessageDialog(null,s);
	              }
	         else if(result == JFileChooser.CANCEL_OPTION){
	             //System.out.println("No Data");
	        	 JOptionPane.showMessageDialog(null,"No data");
	         }

			 
			 
		 }

		
		
		if(e.getSource()== SaveNewFriendDetailsButton)
		{
			
			//get file chooser stuff
			java.util.Date d = dateC.getDate();
			 if (d == null) {
			     JOptionPane.showMessageDialog(null,"No date specified!");
			 } else {
			     java.sql.Date sqldate = new java.sql.Date(d.getTime());
			     firstDate = sqldate;
			     // Do something with sqldate
			 }
			
			 /////////////////////////////////////////////lsContacted day
			//get file chooser stuff
				java.util.Date lContDay = lstContd.getDate();
				 if (lContDay == null) {
				     JOptionPane.showMessageDialog(null,"No date specified!");
				 } else {
				     java.sql.Date sqldateCont = new java.sql.Date(lContDay.getTime());
				     lastContd = sqldateCont;
				     // Do something with sqldate
				 }
			 
			
			
			PreparedStatement ps;
	        ResultSet rs;
	        
	       // String query = "INSERT INTO `the_app_users`(`u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`) VALUES (?,?,?,?,?,?)";
	        
	       // String fname = jTextField_FN.getText();
	        
	        String nameI = fNameTextField.getText();
	        String nicknI = fNicknamTextField.getText();
	        String profI = fProfTextField.getText();
	        String relI = fRelTextField.getText();
	        String likesI = fLikesTextField.getText();
	        String dlikesI = fDlikesTextField.getText();
	        String mnpOCI = fMainPntOfConnTextField.getText();
	        String loFI = fLOfFriendshipTextField.getText();
	        String aOrfI = ArgOrFightsTextField.getText();
	        String reAorFI = fRforArgOrFightTextField.getText();
	        String resolI = fResolutionTextField.getText(); 
	        String ptypeI = fPTypeTextField.getText();
	        //String lcontI = fLContactedTextField.getText();
	        //Date birthDI = fLContactedTextField.getText();
	        //Date chosenDate = dateC.getDate();
	        String dyhthemI = fDUHelpthemTextField.getText();
	        
	        
	        String query = "INSERT INTO myPals(myp_name,myp_nickName,myp_proffesion,myp_religion,myp_likes,myp_dislikes,myp_mainPntOfConnection,myp_lngthOfFriendship,myp_argmntsOrFights,myp_reasonforArgmntOrFights,myp_resolutions,myp_personalityType,myp_lastContacted,myp_birthday,myp_doYouHelpThem,myp_picture) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        
	        try {
	            ps = Main.getConnection().prepareStatement(query);
	            File file = new File(path);
				 FileInputStream iss = new FileInputStream(file );
				 byte[] image = new byte[(int) file.length()];
				 iss.read(image);

	            
	            ps.setString(1,nameI);
	            ps.setString(2, nicknI);
	            ps.setString(3, profI);
	            ps.setString(4, relI);
	            ps.setString(5, likesI);
	            ps.setString(6, dlikesI);
	            ps.setString(7, mnpOCI);
	            ps.setString(8, loFI);
	            ps.setString(9, aOrfI);
	            ps.setString(10, reAorFI);
	            ps.setString(11, resolI);
	            ps.setString(12, ptypeI);
	            ps.setDate(13, lastContd);
	            ps.setDate(14, firstDate);
	            ps.setString(15, dyhthemI);
	            ps.setBytes(16,image);
	            
	            
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
	            
	            
	           
	            
	        } catch (SQLException ex) {
	        	
	        	JOptionPane.showMessageDialog(null,"Connection Issue "+ ex);
	        	
	        }
	        catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			
		}
		
	}
}
	



