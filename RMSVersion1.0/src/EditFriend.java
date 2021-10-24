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


public class EditFriend implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel addHeadingLabel = new JLabel("Edit pal details!");
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
	JLabel picLabel = new JLabel("Thats your friend:");
	JLabel editPic = new JLabel("sup you all:");
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
	byte[] image;
	byte[] rawBytes = null;
	JButton SaveFriendDetailsButton = new JButton("Save");
	JButton SelectfileButton = new JButton("Select File");
	
	int idEditFriend;
	String namen;
	String nickNamen;
	String profn;
	String reln;
	String likesn;
	String dlikesn;
	String mainPOfCn;
	String lofFshpn;
	String arOFn;
	String reForAnFn;
	String resultn;
	String pTypen;
	String lsContn;
	String birthDn;
	String doYohpthmn;
	String s;
	File selectedFile;
	String path;
	
	Connection connection;
	Statement statement;
	ImageIcon format;
	ImageIcon images;
	Image img;
	JDateChooser dateC= new JDateChooser();
	JDateChooser lstContDay = new JDateChooser();
	java.sql.Date firstDate;
	java.sql.Date lstContDate;
	Date chosenDate;
	ImageIcon newPic;
	//InputStream is;
	File newSFile;
	//Date firstDate = new Date();
	
	
	
	EditFriend(int rID)
	{
		idEditFriend = rID;
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
		selPhotoLabel.setBounds(690,270,299,25);
		selPhotoLabel.setForeground(Color.decode("#aed6f1"));
		picLabel.setBounds(795,360,300,250);
		
		
		fIDTextField.setBounds(230,100,300,25);
		fIDTextField.setBorder(null);
		fIDTextField.setText(""+ idEditFriend);
		fIDTextField.setBackground(Color.decode("#ecf0f1"));
		fIDTextField.setEditable(false);
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
		
		lstContDay.setBounds(795,155,300,25);
		lstContDay.setBorder(null);
		lstContDay.setBackground(Color.decode("#ecf0f1"));
		
//		fIDTextField.setBorder(null);
//		fIDTextField.setBackground(Color.LIGHT_GRAY);
//		fBirthDayTextField.setBounds(795,185,300,25);
//		fBirthDayTextField.setBorder(null);
//		fBirthDayTextField.setBackground(Color.decode("#ecf0f1"));
		
		dateC.setBounds(795,185,300,25);
		
		fDUHelpthemTextField.setBounds(795,215,300,25);
		fDUHelpthemTextField.setSize(300,50);
		fDUHelpthemTextField.setBorder(null);
		fDUHelpthemTextField.setBackground(Color.decode("#ecf0f1"));
		
		SelectfileButton.setBounds(795, 270, 300, 25);
		SelectfileButton.addActionListener(this);
		
		SaveFriendDetailsButton.setBounds(585,600,150,25);
		SaveFriendDetailsButton.setBackground(Color.decode("#ecf0f1"));
		SaveFriendDetailsButton.setForeground(Color.decode("#154360"));
		SaveFriendDetailsButton.setBorderPainted(false);
		SaveFriendDetailsButton.addActionListener(this);
		
		
		
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
		frame.add(picLabel);
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
		frame.add(lstContDay);
		frame.add(SelectfileButton);
		frame.add(SaveFriendDetailsButton);
		//frame.add(editPic);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		frame.getContentPane().setBackground(Color.decode("#154360"));
		frame.setSize(1200, 670);
		frame.setLayout(null);
		frame.setVisible(true);

		//JOptionPane.showMessageDialog(null,namen);
		//get db details for id sent through
		PreparedStatement ps;
        ResultSet resultSet;
        String query = "SELECT * FROM myPals WHERE myp_id=?";
		try
		{ 
			
			ps = Main.getConnection().prepareStatement(query);
			ps.setInt(1,rID);
			resultSet = ps.executeQuery();
			
			if(resultSet.next())
			{
				//Only returning one result
				idEditFriend= resultSet.getInt("myp_id");
				namen = resultSet.getString("myp_name");
				nickNamen = resultSet.getString("myp_nickName");
				profn = resultSet.getString("myp_proffesion");
				reln = resultSet.getString("myp_religion");
				likesn = resultSet.getString("myp_likes");
				dlikesn = resultSet.getString("myp_dislikes");
				mainPOfCn = resultSet.getString("myp_mainPntOfConnection");
				lofFshpn = resultSet.getString("myp_lngthOfFriendship");
				arOFn = resultSet.getString("myp_argmntsOrFights");
				reForAnFn = resultSet.getString("myp_reasonforArgmntOrFights");
				resultn = resultSet.getString("myp_resolutions");
				pTypen = resultSet.getString("myp_personalityType");
				lsContn = resultSet.getString("myp_lastContacted");
				birthDn = resultSet.getString("myp_birthday");
				doYohpthmn = resultSet.getString("myp_doYouHelpThem");
			
				//JOptionPane.showMessageDialog(null,namen);
				//use a list in here to return images
				Blob b=(Blob) resultSet.getBlob(17);//2 means 2nd column data  
				image=b.getBytes(1,(int)b.length());//1 means first image  
				format = new ImageIcon(image); //this creates an ImageIcon from the bytes array collected from the image in the database.
		        img = format.getImage(); //this creates an Image, this would be used to carry out the resizing, as ImageIcon cannot be resized directly with this method.
		        Image myImg = img.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
		                
		        images = new ImageIcon(myImg);
		        picLabel.setIcon(images);
		        
		        
		        ///////////////////////////////////////////////
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        //////////////////////////////////////////////////
		        
		        //fields to be populated
		        fNameTextField.setText(namen);
		        fNicknamTextField.setText(nickNamen);
		        fProfTextField.setText(profn);
		        fRelTextField.setText(reln);
		        fLikesTextField.setText(likesn);
		        fDlikesTextField.setText(dlikesn);
		        fMainPntOfConnTextField.setText(mainPOfCn);
		        fLOfFriendshipTextField.setText(lofFshpn);
		        ArgOrFightsTextField.setText(arOFn);
		        fRforArgOrFightTextField.setText(reForAnFn);
		        fResolutionTextField.setText(resultn);
		        fPTypeTextField.setText(pTypen);
		        fLContactedTextField.setText(lsContn);
		        fBirthDayTextField.setText(birthDn);
		        fDUHelpthemTextField.setText(doYohpthmn);
		        //editPic.setLabelFor(picLabel);
		        
		                
				
			}
			else{
				
				JOptionPane.showMessageDialog(null,"No records,something is wrong!");
			}
			
		}
		catch (SQLException ex)
		{
			
			JOptionPane.showMessageDialog(null,"Connection Issuev"+ex);
		}
		
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==SelectfileButton)
		 {
//			 JFileChooser fileChooser = new JFileChooser();
//			 fileChooser.setCurrentDirectory(new File("."));
//			 //fileChooser.showSaveDialog(fileChooser);
//			 
//			 int response = fileChooser.showSaveDialog(null);
//			 
//			 if(response == JFileChooser.APPROVE_OPTION)
//			 {
//				File file = new File(); 
//				file =fileChooser.getSelectedFile();
//			 }
//			 else
//			 {
//				 //selection cancelled
//			 }
			 
			 
			 JFileChooser fileChooser = new JFileChooser();//get instance of fileChooser
			 fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));//show where/which directory to check
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png","jpeg");//filter the kind of file formats that can be uploaded
			 fileChooser.addChoosableFileFilter(filter);//get the file chosen
			 int result = fileChooser.showSaveDialog(null);//save the file
			 
			 if(result == JFileChooser.APPROVE_OPTION){
				 selectedFile = fileChooser.getSelectedFile();
	             path = selectedFile.getAbsolutePath();
//	             label.setIcon(ResizeImage(path));
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
		 
		 if(e.getSource()==SaveFriendDetailsButton)
		 {
			 //get the value of the dateChooser
			 
			 java.util.Date d = dateC.getDate();
			 if (d == null) {
			     JOptionPane.showMessageDialog(null,"No date specified!");
			 } else {
			     java.sql.Date sqldate = new java.sql.Date(d.getTime());
			     firstDate = sqldate;
			     // Do something with sqldate
			 }

			 /////////////////////////////////////////////lastContactDay
			 java.util.Date lstContd = lstContDay.getDate();
			 if (lstContd == null) {
			     JOptionPane.showMessageDialog(null,"No date specified!");
			 } else {
			     java.sql.Date sqldateLstCont = new java.sql.Date(lstContd.getTime());
			     lstContDate = sqldateLstCont;
			     // Do something with sqldate
			 }

			 
			 
			 	
			 //get what has been input and save it to the database after save as been clicked
			 PreparedStatement ps;
			 //ResultSet resultSet;
			 String queryO = "UPDATE myPals SET myp_name = ?,myp_nickName = ?,myp_proffesion = ?,myp_religion = ?,myp_likes = ?,myp_dislikes = ?,myp_mainPntOfConnection = ?,myp_lngthOfFriendship = ?,myp_argmntsOrFights = ?,myp_reasonforArgmntOrFights = ?,myp_resolutions = ?,myp_personalityType = ?,myp_lastContacted = ?,myp_birthday = ?,myp_doYouHelpThem = ?,myp_picture = ? WHERE myp_id = ?";
			 
			 //get what ever was filled into the fields
			 
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
		        String lcontI = fLContactedTextField.getText();
		       // String birthDI = fLContactedTextField.getText();
		        String dyhthemI = fDUHelpthemTextField.getText();
		        
		        
			 
			 try
			 {
				 ps = Main.getConnection().prepareStatement(queryO);
				 //InputStream is = new FileInputStream(new File(s));
				 File file = new File(path);
				 FileInputStream iss = new FileInputStream(file );
				 byte[] image = new byte[(int) file.length()];
				 iss.read(image);
				
				//JOptionPane.showMessageDialog(null, is);
				 //JOptionPane.showMessageDialog(null, firstDate);
				 
				 	
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
		            ps.setDate(13, lstContDate);
		            ps.setDate(14, firstDate);
		            ps.setString(15, dyhthemI);
		            ps.setBytes(16,image);
//		            ps.setBinaryStream(16, (InputStream)is, (int)(s.length()));
		            //ps.setBlob(16,is);
		            ps.setInt(17, idEditFriend);
		            
		            ps.executeUpdate();
		            
		            if(ps.executeUpdate() > 0)
		            {
		                //JOptionPane.showMessageDialog(null, "New User Add");
		                JOptionPane.showMessageDialog(null,"Details successfully updated!");
		                AcknowledgedNotification acknowledgedNotification = new AcknowledgedNotification(idEditFriend);
		                frame.dispose();
		                //delete updated row from notifications if its there after acknowledgement.
		                
		            }
		            else 
		            {
		            	JOptionPane.showMessageDialog(null,"Something went wrong on saving.");
		            }
		            
		            
			 }
			 catch (SQLException ex) {
		        	
		        	JOptionPane.showMessageDialog(null,"Connection Issue "+ ex);
		        } catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
		
	}
	
	
	

}
