import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Question class to read questions from question file and take answers from
 * user.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Question implements Comparable<Question> {
	String str;
	String[] userAnswers;
	String[] displayAnswers;
	Scanner scan = new Scanner(System.in);

	public Question() {

	}

	public Question(String[] strArray) {
		String line = "";

		for (int i = 0; i < strArray.length - 1; i++) {
			line = line + strArray[i] + ",";
		}

		str = line + strArray[strArray.length - 1];
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
		userAnswers = new String[question.length];
		displayAnswers = new String[question.length];
		int row = 0;
		for (int index = 0; index < question.length; index++) {
			for (int jindex = 0; jindex < question[index].length; jindex++) {
				System.out.println(question[index][jindex]);
			}

	

			if ("(Type) Single Select".equals(question[index][1])) {
				int answer = 0;
				// Checks if input number is between 1 and 5.
				do {
					try {
					
						answer = scan.nextInt();
						
						if(answer != 1 && answer != 2 && answer != 3&& answer != 4 && answer != 5)
							System.out.println("Enter a number btweeen 1 and 5");
						else
							break;
						
					} catch (InputMismatchException e) {
						System.out.println("Enter a number btweeen 1 and 5");
						scan.nextLine();
					}
				} while (answer != 1 && answer != 2 && answer != 3
						&& answer != 4 && answer != 5);

				userAnswers[row++] = "" + answer;
				
				scan.nextLine();

			} else if ("(Type) Multi Select".equals(question[index][1])) {

				System.out.println("Separate Multiple answers by /");
				String answer = scan.nextLine().trim();
				String options[];
				 options = answer.split("/");
				 
				 //Set is used so that duplicate multiple answers are not stored.
				 Set<String> mySet=new HashSet<String>();
				label:while(true){
				
				for (String string : options) {
					// Check answer is from the available options or not
					while (!"Service Quality".equalsIgnoreCase(string.trim())
							&& !"Communication".equalsIgnoreCase(string.trim())
							&& !"Delivery Process".equalsIgnoreCase(string.trim())) {
						System.out
								.println("Enter input from the given options and use / between two choices ");
						answer = scan.nextLine();
						 options = answer.split("/");
					
						continue label;
					}
				
					mySet.add(string.trim());
				}
				break;
				}
				 String answerString="";
				 for(String s:mySet){
					 answerString=answerString+s+"/";
				 }

				userAnswers[row++] =answerString.substring(0, answerString.length()-1);
	
				
			} else if ("(Type)Text".equals(question[index][1])) {

				String answer = scan.nextLine();
				while(answer.trim().isEmpty())  {
					System.out.println("Feedback is blank : Enter Something");
					answer=scan.nextLine();
				}

				userAnswers[row++] = "" + answer;
			
			} else if ("(Type) Number".equals(question[index][1])) {

				long answer = 0;
				do {
					try {

						answer = scan.nextLong();

						if (String.valueOf(answer).length() != 10)
							System.out.println("Enter a 10 digit Number");
						scan.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Input a 10 digit number");
						scan.nextLine();

					}
				} while (String.valueOf(answer).length() != 10);

				userAnswers[row++] = "" + answer;
				
			}
		}

		System.out
				.println("*************Answers submitted by Participant*******************");
		for (int i = 0; i < displayAnswers.length; i++) {
			System.out.println(question[i][0]+userAnswers[i]);
		}
		System.out.println();

		writeReportB(participant);
	}

	public void writeReportB(int participant) {
		write("Participant " + participant + ",", "D:/Report-B.txt");
		for (int i = 0; i < userAnswers.length; i++) {
			write(userAnswers[i] + ",", "D:/Report-B.txt");
		}
		write("-1", "D:/Report-B.txt");
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