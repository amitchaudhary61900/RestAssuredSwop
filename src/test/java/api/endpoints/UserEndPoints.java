package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.annotations.DataProvider;

import api.payload.User;
import api.utilities.Utilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//created to perform CRUD


public class UserEndPoints extends Utilities{


	
	
	
 public static Response loginUser( User payload) {
	String post_url= getURL().getString("post_url");
	 
		Response response=given()
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
		//	.post(Routes.post_login_url);
			.post(post_url);     //Here, getting URL from routes.properties file
		
		return response;
		
	}
 
 public static String accessToken(User payload) {

		String accessToken=given()
			.contentType(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_login_url).jsonPath().getString("data.access_token");
		
			return accessToken;
	}
 
public static Response getUserDetails(String accessToken) {

				Response response=given()
					.header("Authorization", "Bearer " + accessToken)

				.when()
					.get(Routes.get_url);
				
				return response;

	}


public static Response updateUserDetails(String accessToken,String phone_number, String streetName, String ZipCode, String streetNumber, String city, String country, String lon, String lan, String file  ) {
		
	Response response= given()
			.header("Authorization", "Bearer " + accessToken)
			.multiPart("phone_number",phone_number)
			.multiPart("street_name",streetName)
			.multiPart("zip_code",ZipCode)
			.multiPart("street_number",streetNumber)
			.multiPart("city",city)
			.multiPart("country",country)
			.multiPart("longitude",lon)
			.multiPart("latitude",lan)
			.multiPart("file",file)
			.contentType("multipart/form-data")
			
		.when()	
			.put(Routes.put_url);
	
	return response;
			
}

public static Response setLang(String accessToken, User payload) {
			
				Response response=given()
					.header("Authorization", "Bearer " + accessToken)
					.contentType(ContentType.JSON)
					.body(payload)

				.when()
					.put(Routes.put_url_setLang);
				
				return response;

	}	
	
public static Response getFollowers(String accessToken, String userID) {
	
	Response response=given()
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("userID", userID)
		

	.when()
		.get(Routes.getFollowers_url);
	
	return response;

}

public static Response getFollowing(String accessToken, String userID) {
	
	Response response=given()
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("userID", userID)
		

	.when()
		.get(Routes.getFollowing_url);
	
	return response;

}

public static Response unfollowUser(String accessToken, String user_ID) {
	
	HashMap<String, String> data= new HashMap();
	
	data.put("userID", user_ID);
	
	Response response=given()
		.header("Authorization", "Bearer " + accessToken)
		.contentType(ContentType.JSON)
		.body(data)

	.when()
		.put(Routes.unfollow_user_url);
	
	return response;

}

public static Response followUser(String accessToken, String user_ID) {
	
	HashMap<String, String> data= new HashMap();
	
	data.put("userID", user_ID);
	
	Response response=given()
		.header("Authorization", "Bearer " + accessToken)
		.contentType(ContentType.JSON)
		.body(data)

	.when()
		.put(Routes.follow_user_url);
	
	return response;

}

public static Response bankIDverified(String accessToken, String userID) {
	
	Response response=given()
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("userID", userID)
		

	.when()
		.get(Routes.BankID_verified_url);
	
	return response;

}
	
}
