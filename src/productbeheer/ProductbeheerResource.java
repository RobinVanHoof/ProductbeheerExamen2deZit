package productbeheer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import jsonparser.JSONFactory;

public class ProductbeheerResource extends ServerResource {
	
	private static final String FILENAME = "C:/Users/Robin/Documents/2TI/Module 2/Webtechnology 3/WorkspaceWebtech3/Productbeheer/producten.json";

	@Get("txt")
	public String getProducten() {
		JSONFactory factory = new JSONFactory();
		return factory.getProducts();
	}
	
	@Post("txt")
	public void addProduct(String json) throws JSONException {
		JSONObject product = new JSONObject(json);
		JSONArray array = new JSONArray();
		JSONParser parser = new JSONParser();
		try {
			array = (JSONArray) parser.parse(new FileReader(FILENAME));
			array.add(product);
			
		} 			
		catch (Exception e) {
		// TODO: handle exception
		System.out.println("ERROR in Productenresource: " + e.getMessage());
		}
				
		try {
			File file=new File(FILENAME);
			FileWriter fw=new FileWriter(file,false);
			BufferedWriter bf=new BufferedWriter(fw);
			PrintWriter pr=new PrintWriter(bf);
			pr.print(array.toString());
			pr.close();
		} catch (Exception e) {
			System.out.println("ERROR in Productenresource: " + e.getMessage());
		}
	}
}
