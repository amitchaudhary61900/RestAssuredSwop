package api.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.CategoriesEndPoints;
import api.endpoints.ProductEndPoints;
import api.endpoints.UserEndPoints;
import api.utilities.BaseTest;
import io.restassured.response.Response;

public class ProductTest extends BaseTest{
	
	String productID= null;
	
	@Test(priority=1, dataProvider="getData")
	public void addProduct(HashMap<String, String> input) {
	
		Response response= CategoriesEndPoints.getCategories(UserEndPoints.accessToken(userPayload));
		
		int i=1;
		String category=response.jsonPath().getString("data["+i+"].id");
		String subcategory=response.jsonPath().getString("data["+i+"].subCategories[0].id");

		//System.out.println(category + subcategory);
		Response addProductResponse=ProductEndPoints.addProduct(UserEndPoints.accessToken(userPayload), input.get("cover"), input.get("images01"), input.get("images02"), input.get("title"), 
				input.get("price"), input.get("description"), input.get("quality"), input.get("age"), category, input.get("Product_street_name"),
				input.get("zip_code"), input.get("street_number"), input.get("Product_city"), input.get("Product_country"), input.get("longitude"), input.get("latitude"),
				subcategory, input.get("preferedSubCategories0"), input.get("preferedSubCategories1"), input.get("swopDescription"));
		
		AssertJUnit.assertEquals(addProductResponse.getStatusCode(), 201);
		
			//Set the productID
		productID=addProductResponse.jsonPath().get("data.productID");
		System.out.println(productID);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//resources//data.json");		
		return new Object[][] { {data.get(0)} };
	}

}
