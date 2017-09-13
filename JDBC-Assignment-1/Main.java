import java.util.List;
import java.util.Scanner;

import com.metacube.entity.Title;
import com.metacube.helper.DBHelper;
/**
 * Main class to drive all the functionality
 * @author Mahesh Chouhan
 *
 */
public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean breakFlag = false;
	
		DBHelper dbHelper = DBHelper.getInstance();

		while (!breakFlag) {
			System.out.println("**********************************");
			System.out.println("1. Get Titles By Name ");
			System.out.println("2. Is Book Issued ");
			System.out.println("3. Delete Books ");
			System.out.println("4. Exit");
			System.out.println("**********************************");
			int choice;
			//Input choice from user
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer !");
				scan.next();
			}

			choice = scan.nextInt();

			switch (choice) {

			case 1:// Get Title Name by given author name
				System.out.println("Enter Author Name");

				String authorName = scan.nextLine();
				while ((authorName = scan.nextLine().trim()).equals("")) {
					System.out.println("Empty String : Write Something !");
				}
				List<Title> list = dbHelper.getTitlesByAuthorName(authorName);

				if (!list.isEmpty()) {
					for (Title title : list) {
						System.out.println(title.getName());
					}
				} else {
					System.out.println("No Books Present");
				}
				break;

			case 2://Check whether given book is issued or not
				System.out.println("Enter Book Name");
				String bookName = scan.nextLine();
				while ((bookName = scan.nextLine().trim()).equals("")) {
					System.out.println("Empty String : Write Something !");
				}
				System.out.println(dbHelper.isBookIssued(bookName));
				break;

			case 3:// Delete books which have not been issued in last one year
				System.out.println("Number of Rows deleted : "+ dbHelper.deleteBooks());
				break;
			case 4://Exit
				breakFlag = true;
				break;
			default://Enter correct choice
				System.out.println("Enter correct Choice");
			}

		}
		
		scan.close();
	}
}
