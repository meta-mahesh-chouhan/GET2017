package Entity;

import Enums.ProductType;

/**
 * Blueprint for Product entity
 * 
 * @author Mahesh Chouhan 
 *
 */
public class Product implements BaseEntity {

	private int code;
	private double price;
	private String name;
	private ProductType type;
	private int quantity;

	public Product() {

	}

	public Product(int code, String name, double price, ProductType type,
			int quantity) {
		this.code = code;
		this.price = price;
		this.name = name;
		this.type = type;
		this.setQuantity(quantity);

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return code + "\t\t" + name + "\t\t" + price + "\t\t" + type + "\t\t"
				+ quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
