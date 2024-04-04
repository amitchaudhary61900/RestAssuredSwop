package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import api.endpoints.CategoriesEndPoints;
import api.endpoints.UserEndPoints;
import api.utilities.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CategoriesTest extends BaseTest {

	
	
	@Test(priority=1)
	public void getCategories() {
		
		Response response= CategoriesEndPoints.getCategories(UserEndPoints.accessToken(userPayload));
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);

		 // Get the JSON response body as a string
        String responseBody = response.getBody().asString();
        
        // Create a JsonPath object
        JsonPath jsonPath = new JsonPath(responseBody);

        // Get the size of the 'data' array
        int dataSize = jsonPath.getList("data").size();

        // Print or assert the count
        System.out.println("Count of data: " + dataSize);

        // Example assertion
        assertEquals(dataSize, 15); // Assert the count is as expected
		
        

	}
	
	@Test(priority=2)
	public void printNameOfCategories() {
		
		Response response= CategoriesEndPoints.getCategories(UserEndPoints.accessToken(userPayload));
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);

		 // Get the JSON response body as a string
        String responseBody = response.getBody().asString();
        
        // Create a JsonPath object
        JsonPath jsonPath = new JsonPath(responseBody);
        
     // Get the size of the 'data' array
        int dataSize = jsonPath.getList("data").size();
        System.out.println("-----------------All the categories names are listed below: -----------------------");

       
      for(int i=0; i< dataSize; i++) {
    	  
          String CategoryName= jsonPath.get("data[" + i + "].name");
          System.out.println(CategoryName);
    	  
      }
	}
      
      
      
      
}
