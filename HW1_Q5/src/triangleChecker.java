/*
 * 
 * 
Write a program that reads three 2D points A, B, and C from the user. 
Next, calculate the length of each side of the triangle using the 
distance formula: sqrt((x2-x1)^2+(y2-y1)^2). Finally, determine if it's a 
real triangle. For a triangle to be real, the sum of any two sides needs 
to be greater than the third. Make sure your output has some real and at 
least one fake triangle.

 */
import java.awt.geom.Point2D;
import java.util.*;

public class triangleChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// distance formula
		// sqrt( (x2 - x1)^2 + (y2 - y1)^2 )
			
		double pointAx = 0, pointBx = 0, pointCx = 0;
		double pointAy = 0, pointBy = 0, pointCy = 0;
		double edgeAB = 0, edgeAC = 0, edgeBC = 0;
		// TODO Auto-generated method stub

		Point2D.Double pointA = new Point2D.Double(pointAx, pointAy);
		Point2D.Double pointB = new Point2D.Double(pointBx, pointBy);
		Point2D.Double pointC = new Point2D.Double(pointCx, pointCy);
		
		System.out.println("Insert x and y coordinates for point A: ");
		pointAx = input.nextDouble();
		pointAy = input.nextDouble();
		pointA.setLocation(pointAx, pointAy);
		System.out.println("Insert x and y coordinates for point B: ");
		pointBx = input.nextDouble();
		pointBy = input.nextDouble();
		pointB.setLocation(pointBx, pointBy);
		System.out.println("Insert x and y coordinates for point C: ");
		pointCx = input.nextDouble();
		pointCy = input.nextDouble();
		pointC.setLocation(pointCx, pointCy);
		
		edgeAB = pointA.distance(pointB);
		edgeAC = pointA.distance(pointC);
		edgeBC = pointB.distance(pointC);
		input.close();
	}

}
