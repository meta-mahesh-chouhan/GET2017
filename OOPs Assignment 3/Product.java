
public class Product {
	private int productId;
	private int quantity;
	private String productName;
	private double productPrice;
	
	
	Product(int id){
		productId=id;
	}
	public int getProductId() {
		return productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	
}
