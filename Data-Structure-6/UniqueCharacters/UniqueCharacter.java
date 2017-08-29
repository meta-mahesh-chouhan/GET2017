package UniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacter {

	// Act as cache storage for input string and number of its unique characters
	private Map<String, Integer> map;

	public UniqueCharacter() {
		setMap(new HashMap<String, Integer>());
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	/**
	 * Returns number of unique characters in the string
	 * @param string
	 * @return Number of unique characters
	 */
	public int getNumberOfUniqueCharacters(String string) {
		int result = 0;
		//If cache already contains String,then get number of unique characters from cache
		if (map.containsKey(string)) {
			System.out.println("Getting Value from Cache for string : "+string);
			result = map.get(string);
		} else {
			//If cache does not contain string,calculate number of unique characters and store it in cache
			Set<Character> set = new HashSet<Character>();

			for (int index = 0; index < string.length(); index++) {
				//Storing characters other ' '
				if (string.charAt(index) != ' ')
					set.add(string.charAt(index));
			}
			
			map.put(string, set.size());
			result = set.size();
		}
		return result;
	}

	/**
	 * Main function which drives all the functionality
	 * @param args
	 */
	public static void main(String[] args) {
		
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		System.out.println(uniqueCharacter.getNumberOfUniqueCharacters("Udit Saxena"));
		System.out.println(uniqueCharacter.getNumberOfUniqueCharacters("Aakansha"));
		System.out.println(uniqueCharacter.getNumberOfUniqueCharacters("Aakansha"));

	}

}
