/*
Feed a file that contains numbers into your program using command line 
redirection. Have your program read & print the file on the screen.
*/

import java.util.*;

public class cmdredirection{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);

		while(input.hasNext()){
			System.out.print(input.next());
		}
		// cmd redirection
		// cmdredirectioni < input.txt > output.txt
		// reads input from input.txt and redirects to output.txt
	}
}