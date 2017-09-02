/*
 * 
 * 
Write a program that prompts the user to enter the center coordinates and 
radiuses of two circles. Determine whether the circles are separate from 
each other, touching each other, overlapping each other, or completely 
within one another. Test each case and show the output.

 */
import javafx.scene.shape.*;
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Circle.html
import java.util.*;
public class Circles {

	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		double distance = 0;
		double radius1 = 0, radius2 = 0;
		double center1X = 0, center1Y = 0, center2X = 0, center2Y = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the x and y coordinates of circle 1: ");
		center1X = input.nextDouble(); center1Y = input.nextDouble();
		System.out.println("Enter the radius of circle 1: ");
		radius1 = input.nextDouble();
		
		System.out.println("Enter the x and y coordinates of circle 2: ");
		center2X = input.nextDouble(); center2Y = input.nextDouble();
		System.out.println("Enter the radius of circle 2: ");
		radius2 = input.nextDouble();
		
		circle1.setCenterX(center1X); circle1.setCenterY(center1Y);
		circle1.setRadius(radius1);
		circle2.setCenterX(center2X); circle2.setCenterY(center2Y);	
		circle2.setRadius(radius2);	
		
		distance = Math.sqrt(Math.pow((center2X - center1X), 2) 
				+ Math.pow((center2Y - center1Y), 2));
		
		if (distance > radius1 + radius2){
			System.out.println("Circles don't overlap.");
		} else if (distance <= radius1 - radius2 || distance <= radius2 - radius1){
			System.out.println("Circles completely overlap each other.");
		} else {
			System.out.println("Circles overlaps.");
		}
		input.close();
	}

}
