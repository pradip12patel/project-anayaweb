package Springboot_Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Springboot_Model.Product;
import Springboot_Model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	List<Product> findByNameContainingIgnoreCase(String name);
	
}