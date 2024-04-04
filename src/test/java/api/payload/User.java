package api.payload;


//POJO: Plain old java object    JSON: Java script object notation

public class User {

    	
    String email;
    String loginType;
	String username;
	String firebaseUserID;
	String profilePicture;
	String  lang;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirebaseUserID() {
		return firebaseUserID;
	}
	public void setFirebaseUserID(String firebaseUserID) {
		this.firebaseUserID = firebaseUserID;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public void setlang(String lang) {
		this.lang = lang;
	}
	public String getlang() {
		return lang;
	}
	
	
}
