import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Survey class which drives all the function
 * 
 * @author Mahesh Chouhan
 *
 */
public class Survey {

	/**
	 * Main function
	 */
	public static void main(String args[]) {

		Question obj = new Question();
		Scanner scan = new Scanner(System.in);

		String question[][] = {};
		System.out
				.println("Enter number of users to participate in survey :- ");
		int noOfUsers = scan.nextInt();
		// Read all the question from TXT file
		question = obj.read("E:/Questions.txt");

		// Take inputs from all user
		for (int index = 0; index < noOfUsers; index++) {
			obj.getInput(index + 1, question);
		}
		String response[][] = obj.read("E:/Report-B.txt");

		int percentage[] = new int[6];

		for (int index = 0; index < noOfUsers; index++) {
			percentage[Integer.parseInt(response[index][1])] += 1;
		}

		// Find the percentage of the result
		for (int index = 1; index < 6; index++) {
			if (percentage[index] != 0) {

				percentage[index] = (int) ((percentage[index] / (float) noOfUsers) * 100);
				obj.write(index + " - " + percentage[index] + "%",
						"E:/Report-A.txt");
				obj.write("-1", "E:/Report-A.txt");
			} else {
				obj.write(index + " - " + percentage[index] + "%",
						"E:/Report-A.txt");
				obj.write("-1", "E:/Report-A.txt");
			}
		}

		/**
		 * for part B problem in which we have to sort the given question
		 * 
		 */
		question = obj.read("E:/Questions.txt");
		List<Question> list = new ArrayList<Question>();
		for (int index = 0; index < question.length; index++) {
			list.add(new Question(question[index][0]));
		}

		Collections.sort(list);
		Iterator<Question> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().str);
		}
	}
}