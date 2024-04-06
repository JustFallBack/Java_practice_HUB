/*
 * File: Reverse.java
 * Description: This program displays the arguments of an application in reverse order and also reverses the characters of each argument.
 * Info: The length of a string s can be obtained using s.length() and the character at a specific index i can be retrieved using s.charAt(i).
 */

public class Reverse {

	public static void main(String[] args) {

		try {
			
			// Check if no argument is provided.
			if(args.length == 0) {
				throw new IllegalArgumentException("Error : no argument provided. At least one argument is required.");
			}
		
			for(int i = args.length; i > 0; i--) {

				// Check if argument is an empty string.
                if(args[i-1].trim().isEmpty()) { 
                    throw new IllegalArgumentException("Error: empty string argument found.");
                }

				System.out.print(args[i-1]+" : ");
				for(int j = args[i-1].length(); j > 0; j--) {
					System.out.print(args[i-1].charAt(j-1));
				}
				System.out.println();
			}
		}

		// Catch exception if no argument is provided.
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}