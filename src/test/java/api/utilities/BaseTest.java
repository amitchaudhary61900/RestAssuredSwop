package api.utilities;

import org.testng.annotations.BeforeClass;

import api.payload.User;

public class BaseTest extends Utilities{
	
	
	public User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		userPayload= new User();
		
		userPayload.setEmail("amit@ymirlabs.com");
		userPayload.setLoginType("google");
		userPayload.setUsername("Amit");
		userPayload.setFirebaseUserID("V9rouYoexWONHDnj42kWVhqJFAM2");
		userPayload.setProfilePicture("");
		
	}
	

}
