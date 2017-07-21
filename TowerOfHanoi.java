import java.util.ArrayList;
import java.util.List;

/**
 * TowerOfHanoi class provides the movements needed to move N number of disks
 * from Source Rod A to Destination Rod B using an auxiliary Rod C.Algorithm for
 * Tower of Hanoi consists of three parts: 
 * 1. Move (n-1) disks from source to auxiliary rod. 
 * 2. Move last disk from source to destination rod.
 * 3. Move (n-1) disks from auxiliary to destination rod.
 * 
 */
public class TowerOfHanoi {

	List<String> movementList = new ArrayList<String>();

	int totalNumberOfDisk;

	/**
	 * Returns a list of movements to move disks from rod A to rod B using
	 * auxiliary rod C.
	 * 
	 * @param source
	 *            rod
	 * @param destination
	 *            rod
	 * @param temp
	 *            - auxiliary rod
	 * @param numOfDisk
	 *            - Number of current disk
	 * @return List representing movements of rods
	 */
	List<String> towerOfHanoi(String source, String destination, String temp,
			int numOfDisk) {

		/* Base Condition: When only one disk is present , move it directly from source rod to
		 destination rod.*/
		if (numOfDisk == 1) {

			movementList.add("Move Disk " + (totalNumberOfDisk - numOfDisk + 1)
					+ " from " + source + " to " + destination);
			return movementList;
		}

		
		// Recursive calls : Move (n-1) disks from source rod to auxiliary rod.
		towerOfHanoi(source, temp, destination, numOfDisk - 1);
		movementList.add("Move Disk " + (totalNumberOfDisk - numOfDisk + 1)
				+ " from " + source + " to " + destination);

		// Recursive calls : Move (n-1) disks from auxiliary rod to destination rod.
		towerOfHanoi(temp, destination, source, numOfDisk - 1);

		return movementList;
	}

	/**
	 * It is a utility function to set value of global variable
	 * totalNumberOfDisk ,check for valid number of disk number and make call to
	 * towerOfHanoi() function.
	 * 
	 * @param source
	 *            rod
	 * @param destination
	 *            rod
	 * @param temp
	 *            - auxiliary rod
	 * @param numOfDisk
	 * @return List representing movements of rods
	 */
	List<String> towerOfHanoiUtil(String source, String destination,
			String temp, int numOfDisk) {

		totalNumberOfDisk = numOfDisk;

		// Check for valid number of disks.
		if (numOfDisk <= 0) {
			movementList.add("No disk present");
			return movementList;
		}

		towerOfHanoi(source, destination, temp, numOfDisk);

		return movementList;
	}

}
