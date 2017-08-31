
import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.entity.Job;
import com.metacube.enums.JobPriority;
import com.metacube.heap.Heap;
/**
 * Main class which drives all the functionality
 * @author Main class
 *
 */
public class Main {

	public static void main(String[] args) {

		boolean flag = true;
		Heap<Job> heap = new Heap<Job>();
		Scanner scan = new Scanner(System.in);
		
		//Loop until user exits
		while (flag) {

			System.out.println("1.Add Job");
			System.out.println("2.Exectute Jobs");
			System.out.println("3.Exit");

			int choice = 0;
			boolean breakFlag = false;
			//Loop until choose valid options
			while (!breakFlag) {
				try {
					choice = scan.nextInt();
					breakFlag = true;
				} catch (InputMismatchException e) {
					System.out.println("Enter a Integer !");
					scan.next();
				}
			}
			
			switch (choice) {
			
			case 1://User want to add a new job
				System.out.println("Enter desired job ");
				scan.nextLine();
				//Enter job in the form of string
				String job = scan.nextLine();

				while (job.trim().equals("")) {
					System.out.println("Empty String : Write Something");
					job = scan.nextLine();
				}

				System.out.println("Choose job priority !");
				System.out.println("1. Chairman");
				System.out.println("2. Professor");
				System.out.println("3. Graduate");
				System.out.println("4. Under Graduate");

				breakFlag = false;
				//Choose valid job priority
				while (!breakFlag) {
					try {

						choice = scan.nextInt();
						
						if(choice > 0 && choice < 5){
							breakFlag = true;
						}
						else{
							System.out.println("Choose from above options !");
						}
							
					} catch (InputMismatchException e) {
						System.out.println("Enter a Integer !");
						scan.next();
					}

				}
				//Assign job priority
				switch (choice) {

					case 1:
						heap.insert(new Job(job, JobPriority.CHAIRMAN));
						break;
					case 2:
						heap.insert(new Job(job, JobPriority.PROFESSOR));
						break;
					case 3:
						heap.insert(new Job(job, JobPriority.GRADUATE));
						break;
					case 4:
						heap.insert(new Job(job, JobPriority.UNDER_GRADUATE));
						break;
					default:
						System.out.println("Choose from aboe options !");
	
					}
				System.out.println("Job Successfully Added !");
					break;
					
			case 2://Execute Jobs
					if (!heap.isEmpty()) {
						System.out.println("**********Sequence of Job execution***************");
	
						while (!heap.isEmpty()) {
							System.out.println(heap.delete());
						}
					} else {
						System.out.println("Empty : No job present !");
					}
					break;
					
			case 3: //Exit 
					flag = false;
					break;
						
			default://User inputs invalid option
					System.out.println("Choose only from above options !");
			}
		}
		scan.close();
	}
}
