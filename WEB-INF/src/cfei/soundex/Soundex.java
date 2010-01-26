/**
 * Soundex.java
 * Description: This class provides an implementation of the Soundex Algorithm.
 * @see http://en.wikipedia.org/wiki/Soundex
 * @author Christopher Fei
 */
package cfei.soundex;

public class Soundex {
	
	/*
	 * Here we map each letter to a predefined numerical value for the Soundex algorithm.
	 */
	public static final int[] SOUNDEX_MAP = {
	    //A  B  C  D  E  F  G  H  I  J  K  L  M
	      0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5,
	    //N  O  P  W  R  S  T  U  V  W  X  Y  Z
	      5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2
	  };

	/**
	 * Description: This method is an implementation of the Soundex algorithm
	 * @see http://en.wikipedia.org/wiki/Soundex
	 * @param input is a String given by the user to be transformed into the Soundex result
	 * @return a String that is the result of the Soundex algorithm given our input
	 */
	public static String soundex(String input){
		input = input.trim().toUpperCase();
		StringBuffer result = new StringBuffer();
		int current, prev = 0;

		for(int i = 0; i < input.length(); i++) {
			//Compensates for the ASCII value of each letter so we can access array values in the map
			current = input.charAt(i)-'A'; 
			if(i==0) {
				/*
				 * Here we add the first letter of the input to the result string, as per the algorith.
				 */
				result.append(input.charAt(0));
				prev = SOUNDEX_MAP[input.charAt(0)-'A'];
			}
			else if(SOUNDEX_MAP[current]!=prev && SOUNDEX_MAP[current]!=0) {
				/*
				 * Here we check if the current value is different from the previous because we collapse
				 * identical values together, according to the algorithm.
				 */
				result.append(SOUNDEX_MAP[current]);
				prev = SOUNDEX_MAP[current];
			}	
		}
		/*
		 * If the input string is sufficiently short, we pad the result string with zeroes.
		 */
		if(result.length() < 4) {
			result.append("000");
		}
		// Return the first four characters of the result string
		return result.substring(0,4);
	}
}
