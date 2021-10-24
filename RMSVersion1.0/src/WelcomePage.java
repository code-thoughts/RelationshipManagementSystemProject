import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.SwingUtilities;
import java.time.Duration;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

//import com.sun.java.util.jar.pack.Package.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class WelcomePage  implements ActionListener{
	 //private ArrayList<JButton> listEdit, listDelete;
	JFrame frame = new JFrame("RMSVersion1.0");
	JLabel welcomeLabel = new JLabel();
	JLabel smallWelcomeLabel = new JLabel();
	JLabel spaceRow2 = new JLabel();
	//JLabel logOutLabel = new JLabel("logout");
	JButton logOutButton = new JButton("logout");
	JButton addFriendButton = new JButton("Add Friend");
	JButton notificationButton = new JButton("Notifications");
	JButton observationsButton = new JButton("Observations");
	JButton deletedFriendsButton = new JButton("Deleted Friends");
	JButton editFriendDetailsButton = new JButton("Edit Friend Details");
	JButton deleteFriendDetailsButton = new JButton("Delete Friend Details");
	JButton activitiesButton = new JButton("Activities");
	ImageIcon icon = new ImageIcon("images/pink.png");
	JLabel label = new JLabel();
	JLabel labelpic = new JLabel();
	JLabel inBetweenSpaceLabel = new JLabel();
	JLabel rowSpaceLabel =  new JLabel();
	JLabel picLabel = new JLabel();
	JLabel photo = new JLabel();
	JLabel rPic = new JLabel();
	byte[] image;
	byte[] bK;
	Image img;
	ImageIcon images;
	ImageIcon format;
	FileOutputStream fs = null;
	//TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	JTable table = new JTable(defaultTableModel);
	ArrayList<Image> TableList = new ArrayList<>();
	ImageIcon iconAll = new ImageIcon("images/pink.png");
	Connection connection;
	Statement statement;
	//JScrollPane scrollPane = new JScrollPane();
	int flag=0;
	int idn;
	
	LocalDate localDateToDay = LocalDate.now();

	
	Date resultSetDate;

	/*Constructor*/
	WelcomePage(String userID)
	{
		welcomeLabel.setBounds(13, 0,200, 35);
		welcomeLabel.setFont(new Font(null,Font.BOLD,25));
		welcomeLabel.setForeground(Color.decode("#E6E6FA"));
		welcomeLabel.setText("Hi "+userID+"...                                                         ");
		smallWelcomeLabel.setText("     Congratulations on starting your journey to becoming a better friend!");
		smallWelcomeLabel.setFont(new Font(null,Font.ITALIC,15));
		smallWelcomeLabel.setForeground(Color.decode("#CCCCFF"));
		spaceRow2.setText("                                                                                                                                                                                                                                                                                                                                                                                  ");
		rowSpaceLabel.setText("                                                                                                                                                                                                                                                                                                                                                                              ");
		inBetweenSpaceLabel.setText("                                   ");
		
//		logOutLabel.setBounds(593,100, 200, 35);
//		logOutLabel.setFont(new Font(null,Font.PLAIN,25));
		
		//-------------------------------------------------------
		
		addFriendButton.setBounds(13, 100, 150, 35);
//		addFriendButton.setBackground(Color.decode("#B4B4B4"));
		addFriendButton.setForeground(Color.decode("#5959AB"));
		addFriendButton.setBorderPainted(false);
		addFriendButton.setFocusable(false);
		addFriendButton.addActionListener(this);
		
		notificationButton.setBounds(13, 140, 150, 35);
//		notificationButton.setBackground(Color.decode("#B4B4B4"));
		notificationButton.setForeground(Color.decode("#5959AB"));
		notificationButton.setBorderPainted(false);
		notificationButton.setFocusable(false);
		notificationButton.addActionListener(this);
		
//		activitiesButton.setBackground(Color.decode("#B4B4B4"));
		activitiesButton.setForeground(Color.decode("#5959AB"));
		activitiesButton.setBorderPainted(false);
		activitiesButton.setFocusable(false);
		activitiesButton.addActionListener(this);
		
		observationsButton.setBounds(13, 180, 150, 35);
//		observationsButton.setBackground(Color.decode("#B4B4B4"));
		observationsButton.setForeground(Color.decode("#5959AB"));
		observationsButton.setBorderPainted(false);
		observationsButton.setFocusable(false);
		observationsButton.addActionListener(this);
		
		editFriendDetailsButton.setFocusable(false);
//		editFriendDetailsButton.setBackground(Color.decode("#B4B4B4"));
		editFriendDetailsButton.setForeground(Color.decode("#5959AB"));
		editFriendDetailsButton.setBorderPainted(false);
		editFriendDetailsButton.addActionListener(this);
		
		logOutButton.setBounds(686, 6, 100, 35);
		logOutButton.setFocusable(false);
//		logOutButton.setBackground(Color.decode("#2471a3"));
		logOutButton.setForeground(Color.decode("#5959AB"));
		logOutButton.setBorderPainted(false);
		logOutButton.addActionListener(this);
		
		deletedFriendsButton.setFocusable(false);
//		deletedFriendsButton.setBackground(Color.decode("#B4B4B4"));
		deletedFriendsButton.setForeground(Color.decode("#5959AB"));
		deletedFriendsButton.setBorderPainted(false);
		deletedFriendsButton.addActionListener(this);
		
		deleteFriendDetailsButton.setFocusable(false);
//		deleteFriendDetailsButton.setBackground(Color.decode("#B4B4B4"));
		deleteFriendDetailsButton.setForeground(Color.decode("#5959AB"));
		deleteFriendDetailsButton.setBorderPainted(false);
		deleteFriendDetailsButton.addActionListener(this);
		
		
		//-----------------------------------------------------------
		
		table.setPreferredScrollableViewportSize(new Dimension(1200,500));
		//table.getTableHeader().setBackground(Color.decode("#696B9E"));
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setBackground(Color.decode("#f8f4ff"));//good color combo
		//table.setBackground(Color.decode("#ecf0f1"));
		//table.setForeground(Color.black);
		//table.setFont(new Font(null,Font.BOLD,13));
		//loginHeading.setFont(new Font(null,Font.BOLD,30));
		table.setFillsViewportHeight(true);
		
		
//		JTable table = new JTable(defaultTableModel)
//		{
//			 public Class getColumnClass(int column)
//            {
//                return getValueAt(0, column).getClass();
//            }
//			
//			
//		};
		
		////////////////notification button
		
		//date1=localDate;
		//date2=dbdate;
//		public int getDifferenceDays(Date d1, Date d2) {
//		    int daysdiff = 0;
//		    long diff = d2.getTime() - d1.getTime();
//		    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
//		    daysdiff = (int) diffDays;
//		    return daysdiff;
//		}
		
		//int daysdiff = 0;
		//long diff =
//		long difference = localDate.getTime()-localDate.plusDays(-10).getTime())/86400000;
//         Math.abs(difference);

		//long difference = localDate. - twoDaysBefore;
		
//		Period period = Period.between(localDate, twoDaysBefore);
//	    int diff = Math.abs(period.getDays());
//		
		//////////////////////////////////////
		frame.setUndecorated(false);
		//Below code "changes" the color of the frame titlebar somewhat
		//frame.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		
		frame.add(welcomeLabel);
		frame.add(smallWelcomeLabel);
		frame.add(rowSpaceLabel);
		frame.add(addFriendButton);
		frame.add(notificationButton);
		frame.add(activitiesButton);
		frame.add(observationsButton);
		frame.add(deletedFriendsButton);
		frame.add(editFriendDetailsButton);
		frame.add(deleteFriendDetailsButton);
		frame.add(inBetweenSpaceLabel);
		frame.add(logOutButton);
		frame.add(spaceRow2);
//		frame.add(label);
//		frame.setUndecorated(true);
//		int x =7 ;
//		frame.getRootPane().setWindowDecorationStyle(x);
		frame.getContentPane().setBackground(Color.decode("#AAAAFF"));
		//frame.getRootPane().setBackground(Color.BLACK);
		frame.getGlassPane().setBackground(Color.BLUE);
		frame.add(new JScrollPane(table));
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Nickname");
		defaultTableModel.addColumn("Proffession");
		defaultTableModel.addColumn("Religion");
		defaultTableModel.addColumn("Likes");
		defaultTableModel.addColumn("Dislikes");
		defaultTableModel.addColumn("MainPointOfConnection");
		defaultTableModel.addColumn("LengthOfFriendship");
		defaultTableModel.addColumn("ArgumentsOrFights");
		defaultTableModel.addColumn("ReasonsforArgumentsOrFights");
		defaultTableModel.addColumn("Resolution");
		defaultTableModel.addColumn("PersonalityType");
		defaultTableModel.addColumn("LastContacted");
		defaultTableModel.addColumn("Birthday");
		defaultTableModel.addColumn("Doyouhelpthem");
		defaultTableModel.addColumn("Picture");
//		defaultTableModel.addColumn("edit");
//		defaultTableModel.addColumn("delete");
		table.setBounds(593, 100, 300, 35);
		table.getColumn("Picture").setCellRenderer(new LabelRenderer());
		//class icon
		//table.getColumnModel().getColumn(16).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
		//tabel.ge
		//frame.add(logOutLabel);
//		table.setMaxWidth(60);
//		table.setMinWidth(60);
//		------------------------------------------------------
//		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
//		table.getColumn("edit").setCellRenderer(buttonRenderer);
//		------------------------------------------------------
		//table.getColumn("edit").setCellEditor(new ButtonEditor(new JButton()));
		//table.getColumn("delete").setCellRenderer(buttonRenderer);
//		---------------------------------------------------------------
//		TableCellRenderer buttonRenderer2 = new JTableButtonRenderer2();
//		table.getColumn("delete").setCellRenderer(buttonRenderer2);
//		---------------------------------------------------------------
//		table.addMouseListener(new JTableButtonMouseListener(table));
		
		 
		//table.addRowSelectionInterval(4, 4);
//		table.getRowHeight("300");
//		TableColumn column = table.getColumn("Picture");
//		column.setMinWidth("200");
//		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("images/Stella3.png").getImage());
		//table.getColumn("edit").setCellRenderer(new TableCellRenderer());
		
		//frame.setLayout(null);
        frame.setLayout(new FlowLayout());
		frame.setSize(1300, 720);
		
		frame.setVisible(true);
		
		//JOptionPane.showInputDialog(userID);
		/*the table functions here*/
		
	
		
		//JOptionPane.showMessageDialog(null,diff);
		
		//before display clear up notifications table
		
		ClearNotificationTable clearNotficationTable = new ClearNotificationTable();
		
		PreparedStatement ps;
		ResultSet resultSet;
		
		String query = "SELECT * FROM myPals";
		
		try {
			//String userID2 = userID;
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/RMS_db", "admin", "=@!#254Stella");
//			statement = connection.createStatement();
			ps = Main.getConnection().prepareStatement(query);
			resultSet = ps.executeQuery(query);
			
			
//			byte b[];
//		    Blob blob;
			
			image = new byte[1024];
		   
		   
			while(resultSet.next())
			{
				
				
				//i++;
				int i = 1;
				idn = resultSet.getInt("myp_id");
				String namen = resultSet.getString("myp_name");
				String nickNamen = resultSet.getString("myp_nickName");
				String profn = resultSet.getString("myp_proffesion");
				String reln = resultSet.getString("myp_religion");
				String likesn = resultSet.getString("myp_likes");
				String dlikesn = resultSet.getString("myp_dislikes");
				String mainPOfCn = resultSet.getString("myp_mainPntOfConnection");
				String lofFshpn = resultSet.getString("myp_lngthOfFriendship");
				String arOFn = resultSet.getString("myp_argmntsOrFights");
				String reForAnFn = resultSet.getString("myp_reasonforArgmntOrFights");
				String resultn = resultSet.getString("myp_resolutions");
				String pTypen = resultSet.getString("myp_personalityType");
				java.sql.Date lsContn = resultSet.getDate("myp_lastContacted");
				Date birthDn = resultSet.getDate("myp_birthday");
				String doYohpthmn = resultSet.getString("myp_doYouHelpThem");
			
				
				
				//JOptionPane.showMessageDialog(null,birthDn);
				//use a list in here to return images
				Blob b=(Blob) resultSet.getBlob(17);//2 means 2nd column data  
				image=b.getBytes(1,(int)b.length());//1 means first image  

				//it means that the image is holding a byte,new pic for that row
				//image= resultSet.getBytes("myp_picture"); //This creates an array of bytes to collect Image from database, usually when a file is uploaded in the database,it is saved as an array of bytes which can be compiled back to its normal form when downloaded.
				format = new ImageIcon(image); //this creates an ImageIcon from the bytes array collected from the image in the database.
		        img = format.getImage(); //this creates an Image, this would be used to carry out the resizing, as ImageIcon cannot be resized directly with this method.
		        Image myImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		                
		        images = new ImageIcon(myImg);
		        picLabel.setIcon(images);


		        LocalDate dateDB = lsContn.toLocalDate();
				long diffDays = Duration.between(dateDB.atStartOfDay(), localDateToDay.atStartOfDay()).toDays();

				
		                if(diffDays > 10 )
		                {
		                	defaultTableModel.addRow(new Object[]{idn, namen, nickNamen, profn, reln, likesn, dlikesn, mainPOfCn, lofFshpn, arOFn, reForAnFn, resultn, pTypen, lsContn, birthDn, doYohpthmn, picLabel});
							picLabel=new JLabel();
							//notificationButton.setBackground(Color.decode("#00FF7F"));
							notificationButton.setForeground(Color.decode("#3cd070"));
							//call notification method here
							Notifications notifications = new Notifications(idn,namen,lsContn,diffDays);
		                }
		                else
		                {
		                    flag = 1;
		                	defaultTableModel.addRow(new Object[]{idn, namen, nickNamen, profn, reln, likesn, dlikesn, mainPOfCn, lofFshpn, arOFn, reForAnFn, resultn, pTypen, lsContn, birthDn, doYohpthmn, picLabel});
							picLabel=new JLabel();
		                }

					
					

			}
			if(flag == 0)
			{
			 JOptionPane.showMessageDialog(null,"No details found");	
			}
				
				
				
		} catch (SQLException throwables) {
			// TODO Auto-generated catch block
			throwables.printStackTrace();
		}
		

		
		
	}

	//after table constructor
	class LabelRenderer implements TableCellRenderer
	{

//		public Component getTableCellRendererComponent(JTable table, Object arg1, boolean arg2, boolean arg3, int arg4,
//				int arg5)
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
		{
			
			TableColumn tc = table.getColumn("Picture");
			tc.setMinWidth(100);
			tc.setMaxWidth(100);
			table.setRowHeight(100);
			
			return (Component)value;
		}
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addFriendButton)
		{
			AddFriend addFriend = new AddFriend();
			
		}
		if(e.getSource()==logOutButton)
		{
			//logout of the system
			LoginPage loginPage = new LoginPage();
			frame.dispose();
		}
		if(e.getSource()==observationsButton)
		{
			//go to the frame that has the observation details to view
			Observations observations = new Observations();
		}
		if(e.getSource()==deleteFriendDetailsButton)
		{
				int i = table.getSelectedRow();
				
				 if(i>=0)
				 {
					 
					 int rID = (int) defaultTableModel.getValueAt(i, 0);
					 String rName = (String) defaultTableModel.getValueAt(i, 1);
					 
					 
					 PreparedStatement ps;
					 //ResultSet rs;
					 String queryString = "DELETE FROM myPals WHERE myp_id=?";
					 
					 try
					 	{
						 	ps = Main.getConnection().prepareStatement(queryString);
						 	ps.setInt(1, rID);

						 	//**************need to findout why the use of these statements like this
					        ps.executeUpdate();
					        JOptionPane.showMessageDialog(null,"Deletion successful!");
					 	}
					 catch(SQLException ex)
					 	{
						  JOptionPane.showMessageDialog(null, ex);
					 	}
					 
					 DeleteFriendDetails deleteFriendDetails = new DeleteFriendDetails(rID,rName);
					 
				 }
				 else 
				 {
					 JOptionPane.showMessageDialog(null,"No row selected!"); 
				 }
			//Select a row first to be deleted-Joptionpane notification
			//Send remove the row from the table and also delete from the database table
			//actually no need for separate delete frame
			//DeleteFriendDetails deleteFriendDetails = new DeleteFriendDetails();
//			int i = table.getSelectedRow();
//			
//			
		}
		
		//if the button clicked is edit friends details
		if(e.getSource()==editFriendDetailsButton) 
		{
			
			//get the row that is selected
			//get the details of each column
			//place them in their fields
			//allow for editing
			//update database.
			
			int i = table.getSelectedRow();
			if(i>0)
			{
				//true because a row has been selected
				int rID = (int) defaultTableModel.getValueAt(i, 0);
//				 String rName = (String) defaultTableModel.getValueAt(i, 1);
//				 String rnName = (String) defaultTableModel.getValueAt(i, 2);
//				 String rProf = (String) defaultTableModel.getValueAt(i, 3);
//				 String rRel = (String) defaultTableModel.getValueAt(i, 4);
//				 String rLikes = (String) defaultTableModel.getValueAt(i, 5);
//				 String rDlikes = (String) defaultTableModel.getValueAt(i, 6);
//				 String rMPC = (String) defaultTableModel.getValueAt(i, 7);
//				 String rLofF = (String) defaultTableModel.getValueAt(i, 8);
//				 String rAorF = (String) defaultTableModel.getValueAt(i, 9);
//				 String rReas = (String) defaultTableModel.getValueAt(i, 10);
//				 String rResol = (String) defaultTableModel.getValueAt(i, 11);
//				 String rPers = (String) defaultTableModel.getValueAt(i, 12);
//				 String rlastC = (String) defaultTableModel.getValueAt(i, 13);
//				 String rBirth = (String) defaultTableModel.getValueAt(i, 14);
//				 String rDoUhthem = (String) defaultTableModel.getValueAt(i, 15);
				 //rPic =  (JLabel) defaultTableModel.getValueAt(i, 16);
				 
				 //JOptionPane.showMessageDialog(null,rDoUhthem);
				 EditFriend editFriend = new EditFriend(rID);
				 table.repaint();	 
				
			}
			else
			{
				
				//please select a row
				
				JOptionPane.showMessageDialog(null,"No row selected!");
				
			}
			
			
		}
		
		if(e.getSource()==deletedFriendsButton)
		{
			ListDeletedFriends lsDelFriends = new ListDeletedFriends();
		}
		if(e.getSource()==notificationButton)
		{
			NotificationList notificationList = new NotificationList();
		}
		if(e.getSource()==activitiesButton)
		{
			ActivityList activityList = new ActivityList();
		}
		

		
	}
	
	
}






 




 


