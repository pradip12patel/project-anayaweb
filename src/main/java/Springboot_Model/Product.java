package Springboot_Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Produts_table")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produt_id")
	private long id;
	
	@Column(name = "name")
	 private String name;
	
	@Column(name = "description")
	    private String description;
	
	@Column(name = "originalPrice")
	    private double originalPrice;
	
	@Column(name = "discountedPrice")
	    private double discountedPrice;
	
	@Column(name = "discountPercentage")
	    private int discountPercentage;
	
	


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getOriginalPrice() {
			return originalPrice;
		}

		public void setOriginalPrice(double originalPrice) {
			this.originalPrice = originalPrice;
		}

		public double getDiscountedPrice() {
			return discountedPrice;
		}

		public void setDiscountedPrice(double discountedPrice) {
			this.discountedPrice = discountedPrice;
		}

		public int getDiscountPercentage() {
			return discountPercentage;
		}

		public void setDiscountPercentage(int discountPercentage) {
			this.discountPercentage = discountPercentage;
		}
		
		

		@Column(name = "Present")
		private Boolean inStock;


		public Boolean getInStock() {
			return inStock;
		}

		public void setInStock(Boolean inStock) {
			this.inStock = inStock;
		} 

	 
		
	    
	    
	    
	    

}

