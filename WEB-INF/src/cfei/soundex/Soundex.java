package cfei.soundex;

public class Soundex {
	
	public static final int[] SOUNDEX_MAP = {
	    //A  B  C  D  E  F  G  H  I  J  K  L  M
	      0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5,
	    //N  O  P  W  R  S  T  U  V  W  X  Y  Z
	      5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2
	  };

	public static String soundex(String input){
		input = input.trim().toUpperCase();
		StringBuffer result = new StringBuffer();
		int current, prev = 0;

		for(int i = 0; i < input.length(); i++) {
			current = input.charAt(i)-'A';
			if(i==0) {
				result.append(input.charAt(0));
				prev = SOUNDEX_MAP[input.charAt(0)-'A'];
			}
			else if(SOUNDEX_MAP[current]!=prev && SOUNDEX_MAP[current]!=0) {
				result.append(SOUNDEX_MAP[current]);
				prev = SOUNDEX_MAP[current];
			}	
		}
		if(result.length() < 4) {
			result.append("000");
		}
		return result.substring(0,4);
	}
}
