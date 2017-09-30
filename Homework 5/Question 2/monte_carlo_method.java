import java.util.*;
// used http://mathfaculty.fullerton.edu/mathews/n2003/montecarlopimod.html as a reference for some things
public class monte_carlo_method{

    public static void main(String args[]){
        
        final int dots = Integer.MAX_VALUE; // can't use 4b because out of range for 32bit int
        double radius = 5; // circle's radius. assume radius 5
        
        double x = 0; // x and y coordinates of the dot in graph
        double y = 0;
        int dotsInCircle = 0; // dots inside the circle
        
        for(int i = 0; i < dots; i++){
            x = Math.random() * 5;
            y = Math.random() * 5;

            if(Math.pow(x,2) + Math.pow(y,2) < Math.pow(radius,2)){
				dotsInCircle++;
            }
            
        }
        int dotsOutCircle = dots - dotsInCircle;

        System.out.println(dotsInCircle + " dots are inside the circle");
        System.out.println(dotsOutCircle + " dots are outside the circle");
        System.out.println(dotsInCircle + dotsOutCircle + " were generated.");

        System.out.println("Pi is " + ((double)dotsInCircle/dots)*4);
    }

}

/*
Question 2: Let's say that you draw a square around the top right 
quadrant of a circle. If the circle has a radius r, then the square that 
covers the top right quadrant of the circle will cover an area r^2.

The area of a circle is Pi*r^2. Given that we're dealing with only the top 
right quadrant, the area will be (Pi*r^2)/4. The ratio of the area of 
the top right quadrant of the circle to the square that covers it would 
be...?

Generate 4 billion random dots that fall within that square. Figure out 
how many of them fall within the circle, and how many fall outside of it. 
That ratio should be the same as what you computed in the last step. From 
there, you should be able to figure out what Pi is. Calculate and print 
this value.

Btw, this is known as the monte carlo method.
*/