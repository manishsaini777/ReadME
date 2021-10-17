package NimbusAssignment.NimbusAssignmnetProject;

import java.util.Random;

public class Functions {
	
	
	private final String LETTERS= "abcdefghijklmnopqrstuvwxyz";
	private final char[] ALPHANUMERIC = (LETTERS + LETTERS.toUpperCase()+ "1234567890").toCharArray();
	
	public StringBuilder generateRandomAlphanumeric(int length) {
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<length; i++) {
			
			result.append(ALPHANUMERIC[new Random().nextInt(ALPHANUMERIC.length)]);
			
		}
		
		return result;
		
		
	}
			
 
}
