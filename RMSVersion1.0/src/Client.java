import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021080811L;

	private int Id;
    private String Name;
    private String Nickname;
    private String Proffession;
    private String Religion;
    private String Likes;
    private String Dislikes;
    private String MainPointOfConnection;
    private String LengthOfFriendship;
    private String ArgumentsOrFights;
    private String ReasonsforArgumentsOrFights;
    private String Resolution;
    private String PersonalityType;
    private String LastContacted;
    private String Birthday;
    private String Doyouhelpthem;
    private String Picture;
    
    public Client() {
        super();
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getNickname() {
        return Nickname;
    }
    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }
    public String getProffession() {
        return Proffession;
    }
    public void setProffession(String Proffession) {
        this.Proffession = Proffession;
    }
    public String getReligion() {
        return Religion;
    }
    public void setReligion(String Religion) {
        this.Religion = Religion;
    }
    public String getLikes() {
        return Likes;
    }
    public void setLikes(String Likes) {
        this.Likes = Likes;
    } 
    public String getDislikes() {
        return Dislikes;
    }
    public void setDislikes(String Dislikes) {
        this.Dislikes = Dislikes;
    }  
    
    public String getMainPointOfConnection() {
        return MainPointOfConnection;
    }
    public void setMainPointOfConnection(String MainPointOfConnection) {
        this.MainPointOfConnection = MainPointOfConnection;
    }    
    
    public String getLengthOfFriendship() {
        return LengthOfFriendship;
    }
    public void setLengthOfFriendship(String LengthOfFriendship) {
        this.LengthOfFriendship = LengthOfFriendship;
    }    
    
    public String getArgumentsOrFights() {
        return ArgumentsOrFights;
    }
    public void setArgumentsOrFights(String ArgumentsOrFights) {
        this.ArgumentsOrFights = ArgumentsOrFights;
    }    
    
    public String getReasonsforArgumentsOrFights() {
        return ReasonsforArgumentsOrFights;
    }
    public void setReasonsforArgumentsOrFights(String ReasonsforArgumentsOrFights) {
        this.ReasonsforArgumentsOrFights = ReasonsforArgumentsOrFights;
    }    
    
    public String getResolution() {
        return Resolution;
    }
    public void setResolution(String Resolution) {
        this.Resolution = Resolution;
    }    
    
    public String getPersonalityType() {
        return PersonalityType;
    }
    public void setPersonalityType(String PersonalityType) {
        this.PersonalityType = PersonalityType;
    }    
    
    public String getLastContacted() {
        return LastContacted;
    }
    public void setLastContacted(String LastContacted) {
        this.LastContacted = LastContacted;
    }    
    
    public String getBirthday() {
        return Birthday;
    }
    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }    
    
    public String getDoyouhelpthem() {
        return Doyouhelpthem;
    }
    public void setDoyouhelpthem(String Doyouhelpthem) {
        this.Doyouhelpthem = Doyouhelpthem;
    }    
    
    public String getPicture() {
        return Picture;
    }
    public void setPicture(String Picture) {
        this.Picture = Picture;
    }    
}
