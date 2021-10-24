import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO {

    private static Connection con;
    
    public ClientDAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost/RMS_db";
            String dbClass = "com.mysql.cj.jdbc.Driver";
          

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "admin1", "=@!#254star");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
	
}
    
    public ArrayList<Client> searchClient(String key){
        ArrayList<Client> result = new ArrayList<Client>();
        String sql = "SELECT * FROM myPals";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setString(1, "%" + key + "%");
            //ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            //int idn = resultSet.getInt("myp_id");
//			String namen = resultSet.getString("myp_name");
//			String nickNamen = resultSet.getString("myp_nickName");
//			String profn = resultSet.getString("myp_proffesion");
//			String reln = resultSet.getString("myp_religion");
//			String likesn = resultSet.getString("myp_likes");
//			String dlikesn = resultSet.getString("myp_dislikes");
//			String mainPOfCn = resultSet.getString("myp_mainPntOfConnection");
//			String lofFshpn = resultSet.getString("myp_lngthOfFriendship");
//			String arOFn = resultSet.getString("myp_argmntsOrFights");
//			String reForAnFn = resultSet.getString("myp_reasonforArgmntOrFights");
//			String resultn = resultSet.getString("myp_resolutions");
//			String pTypen = resultSet.getString("myp_personalityType");
//			String lsContn = resultSet.getString("myp_lastContacted");
//			String birthDn = resultSet.getString("myp_birthday");
//			String doYohpthmn = resultSet.getString("myp_doYouHelpThem");
//			
            
            while(rs.next()){
                Client client = new Client();
                client.setId(rs.getInt("myp_id"));
                client.setName(rs.getString("myp_name"));
                client.setNickname(rs.getString("myp_nickName"));
                client.setProffession(rs.getString("myp_proffesion"));
                client.setReligion(rs.getString("myp_religion"));
                client.setLikes(rs.getString("myp_likes"));
                client.setDislikes(rs.getString("myp_dislikes"));
                client.setMainPointOfConnection(rs.getString("myp_mainPntOfConnection"));
                client.setLengthOfFriendship(rs.getString("myp_lngthOfFriendship"));
                client.setArgumentsOrFights(rs.getString("myp_argmntsOrFights"));
                client.setReasonsforArgumentsOrFights(rs.getString("myp_reasonforArgmntOrFights"));
                client.setResolution(rs.getString("myp_resolutions"));
                client.setPersonalityType(rs.getString("myp_personalityType"));
                client.setLastContacted(rs.getString("myp_lastContacted"));
                client.setBirthday(rs.getString("myp_birthday"));
                client.setDoyouhelpthem(rs.getString("myp_doYouHelpThem"));
                client.setPicture(rs.getString("myp_picture"));
//                client.setLikes(rs.getString("myp_likes"));
//                client.setLikes(rs.getString("myp_likes"));
                result.add(client);
            }
        }catch(Exception e){
            e.printStackTrace();
        }    
        return result;
    }   
    
    
}    
