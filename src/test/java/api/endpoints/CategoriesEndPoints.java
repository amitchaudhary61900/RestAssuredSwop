package api.endpoints;

import static io.restassured.RestAssured.given;

import api.utilities.Utilities;
import io.restassured.response.Response;

public class CategoriesEndPoints extends Utilities{
	
	
	public static Response getCategories(String accessToken) {

		Response response=given()
			.header("Authorization", "Bearer " + accessToken)

		.when()
			.get(Routes.getCategories_url);
		
		return response;

}

}
