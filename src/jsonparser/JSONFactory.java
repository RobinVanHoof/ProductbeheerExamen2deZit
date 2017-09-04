package jsonparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFactory {
	private static final String FILENAME = "C:/Users/Robin/Documents/2TI/Module 2/Webtechnology 3/WorkspaceWebtech3/Productbeheer/producten.json";
	
	
	public static String getProduct(String naamproduct) {
		JSONObject gevondenProduct = new JSONObject();
		
		try{
			FileReader reader = new FileReader(FILENAME);
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray)parser.parse(reader);
			
			for (Object med : array){
				JSONObject product = (JSONObject)med;
				
				if(((String)product.get("Naam")).equalsIgnoreCase(naamproduct)){
					
					gevondenProduct = product;
					
					/*String naam = (String)product.get("Naam");
					String producent = (String)product.get("Producent");
					String prijs = (String)product.get("Prijs");
					
					gevondenProduct += "Naam: " + naam + "</br>";
					gevondenProduct += "Producent: " + producent + "</br>";
					gevondenProduct += "Prijs: " + prijs + "</br>";*/
					
					
					
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println("ERROR in getProduct van JSONFACTORY: " + e.getMessage());
		}
		
		return gevondenProduct.toJSONString();
		
	}
	
	public static String getProducts(){
		String producten = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(FILENAME));
			while((line=br.readLine())!=null){
				producten+=line + "\n";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR in getProducts van JSONFACTORY: " + e.getMessage());
		}
		
		return producten;

	}
}
