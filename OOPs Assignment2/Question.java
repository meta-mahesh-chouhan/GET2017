import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Question class to read questions from question file and take answers from
 * user.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Question implements Comparable<Question> {
	String str;

	Scanner scan = new Scanner(System.in);

	public Question() {

	}

	public Question(String str) {
		this.str = str;
	}

	/**
	 * To read questions from Questions File.
	 * 
	 * @param filePath
	 *            has the file from which we have to read data
	 * @return the 2D array of strings which contains the content of the file
	 * 
	 */
	public String[][] read(String filePath) {
		String[][] questions = new String[5][];
		int index = 0;
		try {
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String str = "";
			// Read File Line By Line
			while ((str = br.readLine()) != null) {
				questions[index++] = str.split(",");
			}
			br.close();
			return questions;
		} catch (Exception e) {
			return questions;
		}
	}

	/**
	 * To get answers from user and store in a Report-B.
	 * 
	 * @param participant
	 *            will give the index of the participant
	 * @param question
	 *            will take the 2D array of question
	 */
	public void getInput(int participant, String question[][]) {

		for (int index = 0; index < question.length; index++) {
			for (int jindex = 0; jindex < question[index].length; jindex++) {
				System.out.println(question[index][jindex]);
			}

			if ("(Type) Single Select".equals(question[index][1])) {
				int answer = 0;
				// Checks if input number is between 1 and 5.
				do {
					try {
						System.out.println("Input a number between 1 and 5");
						answer = scan.nextInt();
					} catch (InputMismatchException e) {
						scan.nextLine();
					}
				} while (answer != 1 && answer != 2 && answer != 3
						&& answer != 4 && answer != 5);

				write("Participant" + " " + participant + "," + answer,
						"E:/Report-B.txt");
				scan.nextLine();

			} else if ("(Type) Multi Select".equals(question[index][1])) {

				System.out.println("Separate Multiple answers by /");
				String answer = scan.nextLine();
				String options[] = answer.split("/");
				for (String string : options) {
					// Check answer is from the available options or not
					if (!"Service Quality".equalsIgnoreCase(string)
							&& !"Communication".equalsIgnoreCase(string)
							&& !"Delivery Process".equalsIgnoreCase(string)) {
						System.out
								.println("Enter input from the given options and use / between two choices ");
						answer = scan.nextLine();
					}
				}
				write("," + answer, "E:/Report-B.txt");
			} else if ("(Type)Text".equals(question[index][1])) {

				String answer = scan.nextLine();
				write("," + answer, "E:/Report-B.txt");

			} else if ("(Type) Number".equals(question[index][1])) {

				long answer = 0;
				do {
					try {
						answer = scan.nextLong();
						scan.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Input a number");

					}
				} while (String.valueOf(answer).length() != 10);

				write("," + answer, "E:/Report-B.txt");
			}
		}
		write("-1", "E:/Report-B.txt");
	}

	/**
	 * Writes to file specified by given filePath
	 * 
	 * @param text
	 *            is the content that need to be printed in file
	 * @param filePath
	 *            is the file which we need to add content
	 * 
	 */
	public void write(String text, String filePath) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath), true));
			if (text.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(text);
			}
			bw.close();
		} catch (Exception e) {
		}
	}

	@Override
	public int compareTo(Question o) {

		return str.compareTo(o.str);
	}

}