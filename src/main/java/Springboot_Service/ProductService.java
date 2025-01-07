package Springboot_Service;

import java.util.List;
import java.util.Optional;

import Springboot_Model.Product;


public interface ProductService {
	
	
	  Product saveproduct(Product product);
	  
	  List<Product> savesproduct(Product[] newproduct);
		
		List<Product>  getallproduct();
		
		Product getproductbyID(long id);
		
		Product updateproduct(Product pro, long id);
		
		void deleteproduct(long id);
		
		 boolean existsById(long id);
	   
	    Optional<Product> findById(long id);

	    Product save(Product product);

		// List<Product> getSuggestions(String query);
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
