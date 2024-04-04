package api.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utilities {
	
	
	//Calling Properties file	
		public static ResourceBundle getURL(){
			
			ResourceBundle routes= ResourceBundle.getBundle("routes");  //Load the properties file
			return routes;
		}
		
		
		public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
					// Convert json file content to json string
					String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

					ObjectMapper mapper = new ObjectMapper();
					List<HashMap<String, String>> data = mapper.readValue(jsonContent,
							new TypeReference<List<HashMap<String, String>>>() {
							});

					return data;

				}
		
		public static  String setFilePath(String pathName) {
			
			String path= System.getProperty("user.dir") + pathName;
			
			return path;

		}

}
