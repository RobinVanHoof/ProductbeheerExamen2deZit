package productbeheer;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import jsonparser.JSONFactory;

public class ProductbeheerSearchResource extends ServerResource {
	
	@Get("txt")
	public String getSearchQuotes(String searchTerm) {
		searchTerm = getAttribute("searchTerm");
		JSONFactory factory = new JSONFactory();
		return factory.getProduct(searchTerm);
	}
}
