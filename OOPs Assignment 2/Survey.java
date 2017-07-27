import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Survey class which drives all the function.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Survey {


	
	/**
	 * Clears the content of file specified by filePath.
	 * 
	 * @param filePath
	 */
	public static void clearRecord(String filePath) {
		try {
			PrintWriter printWriter = new PrintWriter(filePath);
			printWriter.print("");
			printWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}

	/**
	 * Sorts the questions of the Question file and updates the file.
	 */
	public static void sorting() {

		Question obj = new Question();
		String question[][] = obj.read("D:/Questions.txt");
		List<Question> list = new ArrayList<Question>();
		for (int index = 0; index < question.length; index++) {
			list.add(new Question(question[index]));
		}

		Collections.sort(list);
		Iterator<Question> itr = list.iterator();

		clearRecord("D:/Questions.txt");
		try {
			PrintWriter printWriter = new PrintWriter("D:/Questions.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
			while (itr.hasNext()) {

				bufferedWriter.append(itr.next().str);
				bufferedWriter.newLine();
				bufferedWriter.flush();

			}

				bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
		
		}

	}

	/**
	 * Main function
	 */
	public static void main(String args[]) {

		Question obj = new Question();
		Scanner scan = new Scanner(System.in);
		/*
		 * To sort the questions file.
		 */
		sorting();
		
		
		
		
		String question[][] = {};
		System.out.print("Enter number of users to participate in survey :- ");
		int noOfUsers = 0;		
		while(true){
			try{
				
				noOfUsers=scan.nextInt();
				if(noOfUsers<=0)
					System.out.println("Enter a positive number");
				else
					break;
			}catch(InputMismatchException e){
				System.out.println("Enter a Number:");
				scan.nextLine();
			}
		}
		// Read all the question from TXT file
		question = obj.read("D:/Questions.txt");

		clearRecord("D:/Report-A.txt");
		clearRecord("D:/Report-B.txt");
		// Take inputs from all user
		for (int index = 0; index < noOfUsers; index++) {
			System.out.println();
			System.out.println("************Survey for Particpant "
					+ (index + 1) + " begins******************\n");
			obj.getInput(index + 1, question);
			System.out.println("***************Survey for Particpant "
					+ (index + 1) + " Completed********************\n");
		}
		String response[][] = obj.read("D:/Report-B.txt");

		int percentage[] = new int[6];

		for (int index = 0; index < noOfUsers; index++) {
			percentage[Integer.parseInt(response[index][1])] += 1;
		}

		// Find the percentage of the result
		for (int index = 1; index < 6; index++) {
			if (percentage[index] != 0) {

				percentage[index] = (int) ((percentage[index] / (float) noOfUsers) * 100);
				obj.write(index + " - " + percentage[index] + "%",
						"D:/Report-A.txt");
				obj.write("-1", "D:/Report-A.txt");
			} else {
				obj.write(index + " - " + percentage[index] + "%",
						"D:/Report-A.txt");
				obj.write("-1", "D:/Report-A.txt");
			}
		}

	scan.close();
	}
}