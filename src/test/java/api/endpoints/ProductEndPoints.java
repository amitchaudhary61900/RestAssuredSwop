package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import api.utilities.Utilities;
import io.restassured.response.Response;

public class ProductEndPoints extends Utilities {
	
	static int i=100;
		
	
	public static Response addProduct(String accessToken,String coverImage, String productImage01, String productImage02, String title, String price, 
						String description,String quality, String age, String category, String street_name, String zip_code, String street_number,String city, String country, String longitude, String latitude,
						String subcategory, String preferedSubCategories0, String preferedSubCategories1 , String swopDescription ) {
			
			File coverImage1= new File(setFilePath(coverImage));  
			File productImage011= new File(setFilePath(productImage01)); 
			File productImage021= new File(setFilePath(productImage02)); 
			
		Response response= null;
				
		try{
			response=given()
					.header("Authorization", "Bearer " + accessToken)
					.multiPart("cover", coverImage1)
					.multiPart("images", productImage011)
					.multiPart("images", productImage021)
					.multiPart("title",title )
					.multiPart("price",price )
					.multiPart("description",description )
					.multiPart("quality",quality )
					.multiPart("age",age )
					.multiPart("category",category )
					.multiPart("street_name",street_name )
					.multiPart("zip_code",zip_code )
					.multiPart("street_number", street_number)
					.multiPart("city",city )
					.multiPart("country",country )
					.multiPart("longitude",longitude )
					.multiPart("latitude",latitude )
					.multiPart("subcategory",subcategory )
					.multiPart("preferedSubCategories[0]",preferedSubCategories0 )
					.multiPart("preferedSubCategories[1]",preferedSubCategories1 )
					.multiPart("swopDescription",swopDescription )
					.contentType("multipart/form-data")


				.when()
					.post(Routes.addProduct_url);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}



}
