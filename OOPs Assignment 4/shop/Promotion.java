package shop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Promotion Class handles product and order level promotions.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Promotion{
	
	private double discount;
	private static String productPromoFilePath = "D:/ProductPromo.csv";
	private String orderPromoFilePath = "D:/OrderPromo.csv";
	private static FileReader fileReader;
	private static BufferedReader  bufferedReader;
	
	static{
		 try {
			fileReader = new FileReader(productPromoFilePath);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		 setBufferedReader(new BufferedReader(fileReader));

	}
	public Promotion(){
		
	}
	public Promotion(String type){
	}
	public Promotion(String type,double discount){
		this.discount=discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount=discount;
	}
	
	/**
	 * Display all available Product promotions.
	 */
	public void displayProductPromotion() {

		ShoppingStore myStore=new ShoppingStore();
		myStore.setStore();
		try {
			 fileReader = new FileReader(productPromoFilePath);
			 bufferedReader = new BufferedReader(fileReader);
			String line = "";

			System.out
					.println("===============================PRODUCT PROMOTION LIST ===============================\n");

			while ((line = bufferedReader.readLine()) != null) {

				String[] stringArray = line.split(",");
				StringTokenizer tokens = new StringTokenizer(stringArray[2],
						";");
				if (stringArray[0].equals("ProductFixedAmountPromotion")) {
					System.out.print("Promotion : Rs." + stringArray[1]
							+ " OFF on ");
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer
								.parseInt(tokens.nextToken());
						System.out.print(myStore.getProductName(productId) + " [Code:"+ productId + "],");
					}
					System.out.println();

				} else if (stringArray[0]
						.equals("ProductFixedPercentPromotion")) {
					System.out.print("Promotion : " + stringArray[1]
							+ " % OFF on ");
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer
								.parseInt(tokens.nextToken());
						System.out.print(myStore.getProductName(productId) + " [Code:"+ productId + "],");
					}
					System.out.println();
				}

			}
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out
				.println("-------------------------------------------------------------------------------\n");
	}



	/**
	 * Display all available promotions along with applicable promotions on the products.
	 * Also display discount for each promotion. 
	 * 
	 * @param productsInOrder
	 * @return totalDiscount from each promotion.
	 */
	public double displayProductPromotion(Product[] productsInOrder,ShoppingStore myStore) {
		double totalProductDiscount = 0;
		try {
			 fileReader = new FileReader(productPromoFilePath);
			 bufferedReader = new BufferedReader(fileReader);
			String line = "";

			while ((line = bufferedReader.readLine()) != null) {

				String[] stringArray = line.split(",");
				StringTokenizer tokens = new StringTokenizer(stringArray[2],";");
				HashMap<Integer, Promotion> hashMap=null;
				if (stringArray[0].equals("ProductFixedAmountPromotion")) {
					System.out.print("Promotion : Rs." + stringArray[1]
							+ " OFF on ");
					 hashMap= new HashMap<Integer, Promotion>();
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer
								.parseInt(tokens.nextToken());
						System.out.print(myStore.getProductName(productId) + " [Code:"+ productId + "],");
						hashMap.put(productId, new Promotion(stringArray[0],
								Double.parseDouble(stringArray[1])));
					}
					System.out.println();

					
				} else if (stringArray[0]
						.equals("ProductFixedPercentPromotion")) {
					System.out.print("Promotion : " + stringArray[1]
							+ " % OFF on ");
					hashMap = new HashMap<Integer, Promotion>();
					while (tokens.hasMoreTokens()) {
						Integer productId = Integer
								.parseInt(tokens.nextToken());
						System.out.print(myStore.getProductName(productId) + " [Code:"+ productId + "],");
						hashMap.put(productId, new Promotion(stringArray[0],
								Double.parseDouble(stringArray[1])));
					}
					System.out.println();

				}
				/*
				 * Discount form each promotion
				 */
				double discount = 0;
				for (int i = 0; i < productsInOrder.length; i++) {
					if (hashMap.containsKey(productsInOrder[i]
							.getProductId())) {
						discount += (hashMap.get(
								productsInOrder[i].getProductId()).getDiscount() * productsInOrder[i]
								.getQuantity());
					}
				}
				System.out.println("Discount : Rs." + discount+"\n\n");
				totalProductDiscount += discount;

			}
			
	
		} catch (IOException e) {
			System.out.println(e);
		}

		return totalProductDiscount;
	}
	
	/**
	 * Display all available order promotions.
	 */
	public void displayOrderPromotion() {

		try {
			 fileReader = new FileReader(orderPromoFilePath);
			 bufferedReader = new BufferedReader(fileReader);
			String line = "";

			System.out
					.println("===============================ORDER PROMOTION LIST ===============================\n");

			while ((line = bufferedReader.readLine()) != null) {

				String[] stringArray = line.split(",");

				if (stringArray[0].equals("OrderFixedAmountPromotion")) {
					System.out.print("Rs." + stringArray[1]
							+ " on Order above " + stringArray[2]);

					System.out.println();

				} else if (stringArray[0].equals("OrderFixedPercentPromotion")) {
					System.out.print(stringArray[1] + " % OFF on Order above "
							+ stringArray[2]);

					System.out.println();
				}

			}
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out
				.println("-------------------------------------------------------------------------------\n");
	}

	/**
	 * Calculate the maximum order level discount.
	 * 
	 * @param orderPrice
	 * @return Order level discount
	 */
	public String[] calculateOrderPromotion(double orderPrice) {
		double maxDiscount = 0;
		String returnString[]=new String[2];

		try {
			fileReader = new FileReader(orderPromoFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";

			String promotion = "";
			while ((line = bufferedReader.readLine()) != null) {

				String[] stringArray = line.split(",");
				double discount = 0;
				if (orderPrice >= Double.parseDouble(stringArray[2])
						&& stringArray[0].equals("OrderFixedAmountPromotion")) {
					discount = Double.parseDouble(stringArray[1]);
				} else if (orderPrice >= Double.parseDouble(stringArray[2])
						&& stringArray[0].equals("OrderFixedPercentPromotion")) {
					discount = (Double.parseDouble(stringArray[1]) * orderPrice) / 100.00;
				}

				if (discount > maxDiscount
						&& stringArray[0].equals("OrderFixedAmountPromotion")) {
					maxDiscount = discount;
					promotion = "Rs. " + stringArray[1] + "OFF on order above "+ stringArray[2];
				} else if (discount > maxDiscount
						&& stringArray[0].equals("OrderFixedPercentPromotion")) {
					maxDiscount = discount;
					promotion = stringArray[1] + "% OFF on order above "+ stringArray[2];
				}

			}


			System.out.println("Promotion : " + promotion);
			returnString[0]=promotion.toString();
			System.out.println("Discount : Rs." + maxDiscount+"\n\n");
			returnString[1]=maxDiscount+"";
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}


		return returnString;
	}
	public static BufferedReader getBufferedReader() {
		return bufferedReader;
	}
	public static void setBufferedReader(BufferedReader bufferedReader) {
		Promotion.bufferedReader = bufferedReader;
	}

}