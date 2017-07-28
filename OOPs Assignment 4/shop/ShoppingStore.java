package shop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Shopping Store class contains all the products available in the
 * store.Products in store are read form ProductList.csv file.
 * 
 * @author Mahesh Chouhan
 *
 */
public class ShoppingStore {

	private String productFilePath = "D:/ProductList.csv";



	private Product[] store;
	private int totalProductsInStore;

	/**
	 * Check whether given product is present in store or not.
	 * 
	 * @param productId
	 * @return true if product is present in store otherwise false.
	 */
	public boolean checkProductId(int productId) {

		for (int i = 0; i < store.length; i++) {
			if (productId == store[i].getProductId())
				return true;
		}

		return false;
	}

	/**
	 * Returns the name of product corresponding to given productId.
	 * 
	 * @param id
	 * @return Product Name
	 */
	public String getProductName(int id) {

		for (int i = 0; i < store.length; i++) {

			if (store[i].getProductId() == id)
				return store[i].getProductName();
		}
		return null;
	}

	/**
	 * Gets total number of Products
	 */
	public int getTotalProuctsInStore() {
		return this.totalProductsInStore;
	}

	/**
	 * Sets total number of Products
	 */
	public void setTotalProductsInStore() {
		int count = 0;

		try {
			 FileReader fileReader1 = new FileReader(productFilePath);
			 BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			while (bufferedReader1.readLine() != null)
				count++;
			
			bufferedReader1.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		totalProductsInStore = count;

	}

	/**
	 * Gets product store.
	 */
	public Product[] getStore() {
		return this.store;
	}

	/**
	 * Displays the products from store.
	 */
	public void displayProducts() {

		try {
			 FileReader fileReader2 = new FileReader(productFilePath);
			 BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			String line = "";
			setTotalProductsInStore();
			store = new Product[totalProductsInStore];

			System.out.println("=============================== PRODUCT LIST ===============================\n");
			System.out.println("Product Code \t\t\t Product Name \t\t\t Product Price");
			System.out.println("--------------------------------------------------------------------------------");
			int index = 0;
			while ((line = bufferedReader2.readLine()) != null
					&& index < totalProductsInStore) {
				String[] tokens = line.split(",");
				store[index] = new Product(Integer.parseInt(tokens[0]));

				store[index].setProductName(tokens[1]);
				store[index].setProductPrice(Double.parseDouble(tokens[2]));

				System.out.println(tokens[0] + "\t\t\t" + tokens[1] + "\t\t\t" + tokens[2]);
				index++;

			}
			bufferedReader2.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("-------------------------------------------------------------------------------\n");
	}

	public void setStore() {

		try {
			 FileReader fileReader3 = new FileReader(productFilePath);
			 BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
			String line = "";
			setTotalProductsInStore();
			store = new Product[totalProductsInStore];
			int index = 0;
			while ((line = bufferedReader3.readLine()) != null
					&& index < totalProductsInStore) {
				String[] tokens = line.split(",");
				store[index] = new Product(Integer.parseInt(tokens[0]));

				store[index].setProductName(tokens[1]);
				store[index].setProductPrice(Double.parseDouble(tokens[2]));

				index++;

			}
			bufferedReader3.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
