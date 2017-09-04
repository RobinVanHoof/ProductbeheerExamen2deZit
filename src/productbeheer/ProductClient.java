package productbeheer;

import org.json.JSONObject;
import org.restlet.resource.ClientResource;

public class ProductClient {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ClientResource resource = new ClientResource("http://localhost:8080/Productbeheer/producten");
			JSONObject product1 = new JSONObject();
			product1.put("Naam", "product1");
			product1.put("Producent", "producent1");
			product1.put("Prijs", "20");
			resource.post(product1.toString());
			System.out.println(resource.getResponseEntity().getText());
			
			JSONObject product2 = new JSONObject();
			product2.put("Naam", "product2");
			product2.put("Producent", "producent2");
			product2.put("Prijs", "100");
			resource.post(product2.toString());
			System.out.println(resource.getResponseEntity().getText());
			
			ClientResource resource2 = new ClientResource("http://localhost:8080/Productbeheer/producten/product1");
			System.out.println(resource2.get().getText());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR in PRODUCTCLIENT: " + e.getMessage());
		}
	}
}
