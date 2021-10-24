# RelationshipManagementSystemProject
<b>Just a simple first java project - learning java</b>

This simple desktop application, a personal project aimed more at improving personal relations and communication between people, through a series of questions and answers.
This is my first project as I am teaching myself java, and have followed it up with a different frontend in version2 using Springboot and Thmymeleaf. 

<b>Pages</b>

    • Login Page
    • Welcome Page
    • Add New Pal Page
    • Notifications Page
    • Activity List Page
    • Add a new activity Page
    • Deleted Friends List Page
    • Edit Pals Details Page
    • Deletion feedback form 

<b>Description of Pages</b>

<b>Login Page</b> – User types in userid and password, authentication is with the use of details from RMS users table in the database, if details are incorrect ,label on the login form will appear in red to say “incorrect credentials”.

<b>Welcome Page</b> – After a successful login, user lands on this page, with table showing a list of friends, and some details about them, as well as buttons to click on to make  use of other services that the application has to offer. If there are any contacts that you have not contacted for more than two weeks, or have any activities pending, both your notifications and activities buttons foreground will change to green respectively.

<b>Add New Pal Page</b> – Allows you to add details of a new friend/person to your social group,as well as adding a picture which is all inserted into the database table my pals after saving.
A JOptionPane will pop up to inform of success of the save.

<b>Notifications Page</b> – Allows you to view table list of contacts that you have not been in contact with for more than to weeks. This page also has an acknowledge button. This button when pressed, prompts user to select the row the contact is on to acknowledge the notification and then takes user to edit pals details page for user to change the last contacted date, this action after saving changes leads to the deletion of notification in the notification table. 

<b>Activity List Page</b> – Shows a table list of activities that are awaiting you. Above the table are also two buttons add activity and remove activity respectively.

<b>Add a new activity Page</b> – Displays a form for user to fill in details of activity as well as a JcomboBox with a list of your friends to choose from for the activity, which is populated by the my pals database table with just the name.

<b>Deleted Friends List Page</b> – Shows a list of friends /friends details that you have deleted. This list with amongst other things, contact information and reason for deleting the details or friend is more for learning, reflection and even reconciliation of should you wish.

<b>Edit Pals Details Page</b> – This page allows your to edit your friend or person’s details.

<b>Deletion feedback form</b> – This form is to be filled in so you can keep track of the people you deleted and the reason or reasons you deleted them or their details.

<b>Software Requirements</b>

    • Operating System: Linux Ubuntu LTS 18.04
    • User Interface: Java Swing.
    • Programming Language: JDBC, Core Java, SQL
    • IDE: Eclipse
    • Database: Mysql database
    • Server: Apache web server
	
