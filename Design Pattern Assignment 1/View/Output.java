package View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Controller.ProductController;
import Entity.Cart;
import Entity.EntityFactory;
import Entity.Product;
import Enums.EntityName;

/**
 * Handles all the task related to displaying output to user.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Output {

	private static Output output;
	private static FileWriter fileWriter;
	private static BufferedWriter out;
	static public String filePath = "Report.txt";

	private Output() {
		try {
			fileWriter = new FileWriter(filePath);
		} catch (IOException e) {
			System.out.println(e);
		}
		out = new BufferedWriter(fileWriter);

	}

	/**
	 * Ensures that only Single Instance is created
	 * 
	 * @return Output object
	 */
	public static Output getInstance() {

		if (output == null) {

			synchronized (Output.class) {
				if (output == null) {
					output = new Output();
				}
			}

		}
		return output;
	}

	/**
	 * Display products in store
	 */
	public void displayProductsInStroe() {
		List<Product> listOfProducts = ProductController.getInstance().getProdcutsInStore();
		Iterator<Product> iterator = listOfProducts.iterator();

		System.out.println();
		System.out.println("#########################################################################################################################");
		System.out.println("                                                   PRODUCTS IN STORE                                                     ");
		System.out.println("##########################################################################################################################");
		System.out.println();
		System.out.println("Product Id\t\tName\t\tPrice\t\tType\t\tAvaliable Quantity");
		System.out.println("__________________________________________________________________________________________________________________________");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("_______________________________________________________________________________________________________________________\n\n");
		
	}
	
	/**
	 * Generate bill for order.
	 */
	public void printBill(){
		if(!((Cart)EntityFactory.getEntityFromFactory(EntityName.Cart)).getListOfProductsInCart().isEmpty()){
		try {
			out.write("#######################################################################################################################");
			out.newLine();
			out.write("                                                     YOUR ORDER"                                               );
			out.newLine();
			out.write("#####################################################################################################################\n\n");
			out.newLine();
			out.newLine();
			out.write("PURCHASED PRODUCTS:\n");
			out.newLine();
			Iterator<Product> iterator = Cart.getInstance().getListOfProductsInCart().iterator();
			Product product;
			double subTotal,total = 0;
			out.newLine();
			out.write("Product Id\t\tName\t\tPrice\t\tType\t\tQuantity\t\tSubTotal");
			out.newLine();
			out.write("__________________________________________________________________________________________________________________________");
			out.newLine();
				while (iterator.hasNext()) {
					product = iterator.next();
					out.write(product.toString());
					subTotal = product.getPrice() * product.getQuantity();
					total += subTotal;
					out.write("\t" + product.getPrice() * product.getQuantity());
					out.newLine();
				}

			out.write("__________________________________________________________________________________________________________________________");
			out.newLine();
			out.write("                                       TOTAL : " + total);
			out.newLine();
			out.write("_________________________________________________________________________________________________________");
			out.newLine();
			out.write("\n\nTHANK YOU FOR SHOPPING !");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("****************************************************BILL GENERATED*************************************************");
		}
		else{
			System.out.println("\nEMPTY CART\n");
		}

	}
	
	/**
	 * Display cart to user.
	 */
	public void viewCart(){
		
		if(!((Cart)EntityFactory.getEntityFromFactory(EntityName.Cart)).getListOfProductsInCart().isEmpty()){
		System.out.println("#######################################################################################################################");
		System.out.println("                                                    PRODUCTS IN YOUR CART"                                               );
		System.out.println("#####################################################################################################################\n\n");
		Iterator<Product> iterator = Cart.getInstance().getListOfProductsInCart().iterator();
		Product product;
		System.out.println("Product Id\t\tName\t\tPrice\t\tType\t\tQuantity\t\tSubTotal");
		System.out.println("________________________________________________________________________________________________________________");
			double subTotal, total = 0;
			while (iterator.hasNext()) {
				product = iterator.next();

				System.out.print(product);
				subTotal = product.getPrice() * product.getQuantity();
				total += subTotal;
				System.out.print("\t\t" + subTotal);
				System.out.println();
			}
		System.out.println("________________________________________________________________________________________________________________");
		System.out.println("                                    TOTAL : " + total);
		System.out.println("_________________________________________________________________________________________________________________\n\n");
		
		
	}
	else{
		System.out.println("\nEMPTY CART\n");
	}
		
	}
	
}


