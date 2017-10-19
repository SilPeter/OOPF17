
import java.lang.*;
import java.util.*;
import java.io.*;
/*
Write a command line calculator. Implement the (), +, -, /, *, and % 
functions. Make sure your calculator works with both integers and 
doubles. Here"s an example run:

javac Calculator 2 + 3
5

Separate all the arguments with a space to make your life easy.

If the user enters anything other than a number where a number belongs, 
throw a LookAtMrAlgebraOverHereException derived from the 
IlleglArgumentException. If the user enters an operation which isn"t 
supported, throw a IllegalOperationException derived from the 
IllegalArgumentException. If the user forgets to enter a number, throw 
a UserIsADumbassException also derived from IllegalArgumentException. 
Make sure you deal with these exceptions gracefully. Don"t pass them on 
to the JVM.

You should also catch and deal with ArithmeticException in case the 
user tries to divide by zero.

Make sure your calculator correctly deals with the order of operations. 
(Remember PEMDAS?). I think if you research how to turn the command 
line arguments into postfix notation, it"ll help. But I"m not 100% 
sure.
*/
public class calculator{
/*
progress?
change everything from a string to a arraylist of strings
doing this allows the arraylist to be changed as needed
after that, try to multiply and div using arrays by popping off and removing stuff from the array. remember to parseDouble the stuff because it is all strings

made progress with mult operator. need to fix array by removing said elements after being multiplied 
need to clean up array after performing the oepration on them

currently:
need to make cleanuparray to dispose of used elements and operators
*/
    public static void main(String args[]) {
        System.out.println("Assume ] is mult");
        ArrayList<String> top = new ArrayList<String>();

        for(int i = 0; i < args.length; i++){
            // puts everything into a string array
            // pass this later to break it apart
            top.add(i, args[i]);
            // System.out.println("top[" + i + "]" + top.get(i));
        }

        double result = 0, result2 = 0;
        result = multDiv(top);
        // result2 = addSub(top); to make
        System.out.println("final answer: " + result);
    } // end main

    public static double multDiv(ArrayList<String> input){
        // this function loops the other help functions to do the operation

        double merp = 0;
        
        for(int i = 0; i < input.size(); i++){
            if(multDivChecker(input, i)){
                // finds an operator and performs said operations
                // assigns to merp and removes the operator and left number
                // removes operator and assigns merp to current index - 1
                // i-- to compensate for cleaning up the array
                merp = operation(input, i);
                cleanUpArray(input, i);
                input.set(i-1, Double.toString(merp));
                i--;
            }
        }
        for(int i = 0; i < input.size(); i++){
            if(addSubChecker(input, i)){
                merp = operation(input, i);
                cleanUpArray(input, i);
                input.set(i - 1, Double.toString(merp));
                i--;
            }
        }
        return merp;
    }

    public static boolean addSubChecker(ArrayList<String> input, int index){
        if(input.get(index).equals("+") || input.get(index).equals("-")){
            return true;
        }
        return false;
    }
    public static boolean multDivChecker(ArrayList<String> input, int index){
        //checks for * and / and % operators
        // returns true if found
        // returns false if none found
        if(input.get(index).equals("]") || input.get(index).equals("/") || input.get(index).equals("%")){   
            return true;
        }
        return false;
        
    }
    public static double operation(ArrayList<String> input, int index) {
        // does the operation
        double left = 0, right = 0;
        left = Double.parseDouble(input.get(index - 1));
        right = Double.parseDouble(input.get(index + 1));
        String operation = input.get(index);
        // System.out.println("left is: " + left + " and right is: " + right + " and operation is: " + operation);
        if(input.get(index).equals("]")){
            
            // System.out.println("Returning: " + left * right);
            return left * right;
        }
        if(input.get(index).equals("/")){
            return divide(left, right);
        }
        if(input.get(index).equals("%")){          
            return left % right;
        }
        if(input.get(index).equals("+")){
            return left + right;
        }
        if(input.get(index).equals("-")){
            return left - right;
        }
        return -99; 
    }

    public static double divide(double l, double r) throws UserIsADumbassException{
        if(r == 0){
            throw new UserIsADumbassException("division by zero");
        } else {
            return l / r;
        }
    }
    public static void cleanUpArray(ArrayList<String> input, int index){
        
        // System.out.println("input[" + index + "] " + input.get(index) + "\n");
        input.remove(index);
        input.remove(index-1);
        
    }

    public static int numberOfOperations(ArrayList<String> input){
        int returnMe = 0;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).equals("+")){
                returnMe++;
            }
            if(input.get(i).equals("-")){
                returnMe++;
            }
            if(input.get(i).equals("]")){
                returnMe++;
            }
            if(input.get(i).equals("/")){
                returnMe++;
            }
            if(input.get(i).equals("%")){
                returnMe++;
            }
        }

        return returnMe;
    }

} // end calculator class













// https://stackoverflow.com/questions/1754315/how-to-create-custom-exceptions-in-java

class UserIsADumbassException extends IllegalArgumentException{
    
    public UserIsADumbassException(String message){
        // division by zero
        System.out.println(message);
        
    }
}

class LookAtMrAlgebraOverHereExeption extends IllegalArgumentException{


}