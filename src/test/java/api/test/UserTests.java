package api.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.BaseTest;
import io.restassured.response.Response;

public class UserTests extends BaseTest{
	
	
	String testUnfollow;
	
	

	@Test(priority=1)
	public void login() {
		
		Response response=UserEndPoints.loginUser(userPayload);
		//response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority=2)
	public void getUserDetails() {
		
		Response response = UserEndPoints.getUserDetails(UserEndPoints.accessToken(userPayload));
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3, dataProvider="getData")
	public void updateUserDetails( HashMap<String, String> input ) {
		
		Response response = UserEndPoints.updateUserDetails(UserEndPoints.accessToken(userPayload),
				input.get("phone_number"), input.get("street_name"), input.get("zipCode"),
				input.get("streetNumber"), input.get("city"), input.get("country"), input.get("lon"),
				input.get("lan"), input.get("file"));
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}	
	
	@Test(priority=4, dataProvider="getData")
	public void setLanguage( HashMap<String, String> input ) {
		User Payload= new User();
		Payload.setlang(input.get("setLang"));
		
		Response response = UserEndPoints.setLang(UserEndPoints.accessToken(userPayload),Payload );
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=5, dataProvider="getData")
	public void getFollowers( HashMap<String, String> input ) {
		
		Response response1 = UserEndPoints.getUserDetails(UserEndPoints.accessToken(userPayload));
		String userID=response1.jsonPath().getString("data.id");
		
		Response response = UserEndPoints.getFollowers(UserEndPoints.accessToken(userPayload), userID );
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=6, dataProvider="getData")
	public void getFollowing( HashMap<String, String> input ) {
		
		Response response1 = UserEndPoints.getUserDetails(UserEndPoints.accessToken(userPayload));
		String userID=response1.jsonPath().getString("data.id");
		
		Response response = UserEndPoints.getFollowing(UserEndPoints.accessToken(userPayload), userID );
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=7, dataProvider="getData")
	public void unfollowUser( HashMap<String, String> input ) {
		

		Response response0 = UserEndPoints.getUserDetails(UserEndPoints.accessToken(userPayload));
		String userID1=response0.jsonPath().getString("data.id");
		
		Response response1 = UserEndPoints.getFollowing(UserEndPoints.accessToken(userPayload), userID1);
		 testUnfollow=response1.jsonPath().getString("data.followings.id[0]");
		//System.out.println(userID);
		
		
		Response response = UserEndPoints.unfollowUser(UserEndPoints.accessToken(userPayload), testUnfollow );
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=8, dataProvider="getData")
	public void followUser( HashMap<String, String> input ) {
		
		Response response = UserEndPoints.followUser(UserEndPoints.accessToken(userPayload), testUnfollow );
		//response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}

	@Test(priority=9, dataProvider="getData")
	public void bankIDverified( HashMap<String, String> input ) {
		
		Response response1 = UserEndPoints.getUserDetails(UserEndPoints.accessToken(userPayload));
		String userID=response1.jsonPath().getString("data.id");
		
		Response response = UserEndPoints.bankIDverified(UserEndPoints.accessToken(userPayload), userID );
		//Get a headers for the GET
		System.out.println(response.getHeaders());

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//resources//data.json");		
		return new Object[][] { {data.get(0)} };
	}
	
}
