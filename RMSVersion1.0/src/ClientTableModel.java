import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClientTableModel extends DefaultTableModel implements TableModel {
	 ArrayList<Client> listClient;
	 ArrayList<Client> listEdit;
	 ArrayList<Client> listDelete;
	  /**
	 * 
	 */
	private static final long serialVersionUID = 2021080831L;
	private String[] columnNames = {"Id", "Name", "Nickname", "Proffession", "Religion", "Likes", "Dislikes", "MainPointOfConnection","LengthOfFriendship","ArgumentsOrFights","ReasonsforArgumentsOrFights","Resolution","PersonalityType","LastContacted","Birthday","Doyouhelpthem","Picture","Edit","Del"};
      private final Class<?>[] columnTypes = new Class<?>[] {Integer.class, String.class, String.class, String.class, 
              String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, JButton.class,  JButton.class};

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public int getColumnCount() {
		 return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return listClient.size();
    
	}

//	private int Id;
//    private String Name;
//    private String Nickname;
//    private String Proffession;
//    private String Religion;
//    private String Likes;
//    private String Dislikes;
//    private String MainPointOfConnection;
//    private String LengthOfFriendship;
//    private String ArgumentsOrFights;
//    private String ReasonsforArgumentsOrFights;
//    private String Resolution;
//    private String PersonalityType;
//    private String LastContacted;
//    private String Birthday;
//    private String Doyouhelpthem;
//    private String Picture;
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
	     /*Adding components*/
        switch (columnIndex) {
            case 0: 
                return listClient.get(rowIndex).getId();
            case 1: 
                return listClient.get(rowIndex).getName();
            case 2: 
                return listClient.get(rowIndex).getNickname();
            case 3: 
                return listClient.get(rowIndex).getProffession();
            case 4: 
                return listClient.get(rowIndex).getReligion();
            case 5:  
                return listClient.get(rowIndex).getLikes();
            case 6: 
            	return listClient.get(rowIndex).getDislikes();
            case 7: 
            	return listClient.get(rowIndex).getMainPointOfConnection();
            case 8:  
            	return listClient.get(rowIndex).getLengthOfFriendship();
            case 9: 
            	return listClient.get(rowIndex).getArgumentsOrFights();
            case 10: 
            	return listClient.get(rowIndex).getArgumentsOrFights();
            case 11: 
            	return listClient.get(rowIndex).getResolution();
            case 12: 
            	return listClient.get(rowIndex).getPersonalityType();
            case 13: 
            	return listClient.get(rowIndex).getLastContacted();
            case 14: 
            	return listClient.get(rowIndex).getBirthday();
            case 15: 
            	return listClient.get(rowIndex).getDoyouhelpthem();
            case 16: 
            	return listClient.get(rowIndex).getPicture();
            case 17: 
			return listEdit.get(rowIndex);
            case 18: 
			return listDelete.get(rowIndex);                    
            default: return "Error";
        }
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
