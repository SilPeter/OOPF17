/*
Feed a file that contains numbers into your program using command line 
redirection. Have your program read & print the file on the screen.
*/

import java.util.*;
import java.io.*;

public class CMDRedirection{
	public static void main(String[] args){
		File file = new File(args[0]);
		
		try {
			Scanner input = new Scanner(file);
			
			while(input.hasNextLine()){
				double numbers = input.nextDouble();
				System.out.println(numbers);
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}