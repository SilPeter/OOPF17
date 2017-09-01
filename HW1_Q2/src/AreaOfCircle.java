/*
 * 
 In a loop, read radiuses from a user. Calculate the area of a circle using 
the formula PI*r^2. Use the pow function, and the PI constant in the Math 
class. Pick your data types wisely. Exit when the user presses ^d. Show 
your output.
 * 
 */

import java.util.*;

public class AreaOfCircle {
	public static void main(String args[]){
		String radius = "";
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter radius: ");
		radius = input.nextLine();
		while(Double.parseDouble(radius) >= 0){	
			System.out.println("inside while");
			double area = Math.PI * Math.pow(Double.parseDouble(radius), 2);
			System.out.println("The area of circle with radius " + radius + " is " + area);
			radius = input.nextLine();
			
			if(radius.equals("^d"))
				break;
		}
		System.out.println("closing");
		input.close();
	}
}
