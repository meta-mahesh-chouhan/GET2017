package com.metacube.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.queue.Queue;
/**
 * Handles taking input from file 
 * @author Mahesh Chouhan
 *
 */
public class FileHandling {

	private static String collegeListFilePath = "collegelist.txt";
	private static String candidateListFilePath = "candidatelist.txt";

	/**
	 * Returns Queue of candidates after reading from file
	 */
	public static Queue<Candidate> readCandidateFile() {

		Queue<Candidate> queueOfCandidate = new Queue<Candidate>(8);
		try {
			List<String> fileData = Files.readAllLines(Paths.get(candidateListFilePath));

			for (String line : fileData) {

				String array[] = line.split(",");

				String choices[] = array[2].split("/");

				Queue<String> choicesQueue = new Queue<String>(5);
				for (int index = 0; index < choices.length; index++) {
					choicesQueue.enqueue(choices[index]);
				}

				queueOfCandidate.enqueue(new Candidate(array[0], Integer.parseInt(array[1]), choicesQueue));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Sort the Candidate Queue according to their rank
		queueOfCandidate.sort();

		return queueOfCandidate;

	}

	/**
	 * Returns list of college after reading from file
	 */
	public static List<College> readCollegeFile() {

		List<College> listOfColleges = new ArrayList<College>();

		try {
			List<String> fileData = Files.readAllLines(Paths.get(collegeListFilePath));

			for (String line : fileData) {
				String[] array = line.split(",");
				listOfColleges.add(new College(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(listOfColleges);

		return listOfColleges;
	}

}
