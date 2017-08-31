import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Concordance class to return concordance string
 * @author Mahesh Chouhan
 *
 */
public class Concordance {

	/**
	 * Returns concordance string
	 * @param arrayOfStrings
	 */
	public String printConcordance(String[] arrayOfStrings) {

		String result = "{";
		Map<Character, List<Integer>> hashMap = new HashMap<Character, List<Integer>>();

		Character key;
		int count = 0;
		//Loop for every string in arrayOfStrings
		for (String string : arrayOfStrings) {

			//Loop for every character in array string
			for (int index = 0; index < string.length(); index++) {
				
				//Character is used as key
				key = string.charAt(index);
				
				//Create a list of index values
				List<Integer> listOfIndex = new ArrayList<Integer>();
				
				//If key already exists then get listOfIndex for that key
				if (hashMap.containsKey(key)) {
					listOfIndex = hashMap.get(key);
				}
				//Add new indexes to listOfIndex
				listOfIndex.add(index + count);
				
				//Store listOfIndex at given key
				hashMap.put(key, listOfIndex);

			}
			
			count += string.length();

		}

		//Create result string
		for (java.util.Map.Entry<Character, List<Integer>> entry : hashMap.entrySet()) {
			result += entry.getKey() + "=" + entry.getValue() + ",";
		}
		result = result.substring(0, result.length() - 1) + "}";
		
		return result;
	}

}
