package shop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * Handles writing order to Report file.
 * @author Mahesh Chouhan
 *
 */
public class Record {

	static public String filePath = "D:/Report.txt";
	private String productPromoFilePath = "D:/ProductPromo.csv";
	private static FileWriter fileWriter;
	private static BufferedWriter out;
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	
	static{
		try {
			fileWriter=new FileWriter(filePath);
		} catch (IOException e) {
		System.out.println(e);
		}
		out= new BufferedWriter(fileWriter);
		
	}
	/**
	 * Prints User order to Report File.
	 * 
	 * @param filePath
	 * @param myStore
	 */
	public void recordFile(Order order, ShoppingStore myStore) {
		double totalProductDiscount = 0;

		try {
			fileWriter = new FileWriter(filePath);
			 out = new BufferedWriter(fileWriter);

			out.write("###################################################################");
			out.newLine();
			out.write("                          YOUR ORDER");
			out.newLine();
			out.write("###################################################################");
			out.newLine();
			out.newLine();

			out.write("PURCHASED PRODUCTS: ");
			out.newLine();
			out.newLine();
			double subTotal = 0;
			Product[] productsInOrder = order.getProductsInOrder();
			for (int i = 0; i < order.getNoOfProductsInOrder(); i++) {
				out.write("Product : " + productsInOrder[i].getProductId()
						+ " - " + productsInOrder[i].getProductName());
				out.newLine();
				;

				out.write("Cost : Rs"
						+ (productsInOrder[i].getProductPrice() * productsInOrder[i]
								.getQuantity()) + " ("
						+ productsInOrder[i].getQuantity() + " X "
						+ productsInOrder[i].getProductPrice() + ")");
				subTotal += (productsInOrder[i].getProductPrice() * productsInOrder[i]
						.getQuantity());
				out.newLine();

			}
			out.newLine();
			out.newLine();
			out.write("APPLIED PROMOTIONS/DISCOUNTS : ");
			out.newLine();
			out.newLine();

			 fileReader = new FileReader(productPromoFilePath);
			 bufferedReader = new BufferedReader(fileReader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {

				String[] stringArray = line.split(",");
				StringTokenizer tokens = new StringTokenizer(stringArray[2],
						";");
				HashMap<Integer, Promotion> hashMap = null;
				if (stringArray[0].equals("ProductFixedAmountPromotion")) {
					out.write("Promotion : Rs." + stringArray[1] + " OFF on ");
					hashMap = new HashMap<Integer, Promotion>();
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer.parseInt(tokens.nextToken());
						out.write(myStore.getProductName(productId) + " [Code:"+ productId + "],");
						hashMap.put(productId, new Promotion(stringArray[0],
								Double.parseDouble(stringArray[1])));
					}

					out.newLine();

				} else if (stringArray[0]
						.equals("ProductFixedPercentPromotion")) {
					out.write("Promotion : " + stringArray[1] + " % OFF on ");
					hashMap = new HashMap<Integer, Promotion>();
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer.parseInt(tokens.nextToken());
						out.write(myStore.getProductName(productId) + " [Code:"+ productId + "],");
						hashMap.put(productId, new Promotion(stringArray[0],
								Double.parseDouble(stringArray[1])));
					}
					out.newLine();

				}
				double discount = 0;
				for (int i = 0; i < productsInOrder.length; i++) {
					if (hashMap.containsKey(productsInOrder[i].getProductId())) {
						discount += (hashMap.get(productsInOrder[i].getProductId()).getDiscount() * productsInOrder[i].getQuantity());
					}
				}
				out.write("Discount : Rs." + discount);
				out.newLine();
				totalProductDiscount += discount;
				out.newLine();

			}

			out.write("Promotion : " + order.getAppliedOrderPromotion());
			out.newLine();
			out.write("Discount : Rs." + order.getOrderDiscount() + "\n\n");
			out.newLine();
			out.newLine();

			out.write("SubTotal : Rs." + subTotal);
			out.newLine();
			out.write("Product Level Discounts : Rs." + totalProductDiscount);
			out.newLine();
			out.write("Order Level Discounts : Rs." + order.getOrderDiscount());
			out.newLine();
			out.write("Total Discounts : Rs."+ (order.getOrderDiscount() + totalProductDiscount));
			out.newLine();
			out.write("Total : Rs."+ (subTotal - (order.getOrderDiscount() + totalProductDiscount)));
			out.newLine();
			out.newLine();
			out.write("THANK YOU FOR SHOPPING !");
			out.flush();

		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
