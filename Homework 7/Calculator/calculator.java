
import java.lang.*;
import java.util.*;
import java.io.*;

public class calculator{
/*
https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html#parseDouble-java.lang.String-
https://docs.oracle.com/javase/tutorial/essential/exceptions/

progress 
parenthesis check
    roll through arraylist and match ( with ) counters
    assuming there it is entered properly ( first then )
parenthesis operation. assuming a single set of parenthesis
    roll through the arraylist and find indexes for first ( and ) to match
    pass the indexes to another function to do the operation
*/
    public static void main(String args[]) {
        System.out.println("Assume ] is mult");
        ArrayList<String> top = new ArrayList<String>();

        for(int i = 0; i < args.length; i++){            
            top.add(i, args[i]);
            // System.out.print("top[" + i + "]" + top.get(i) + " ");
        }
        double result = 0;
        try{
            if(top.size() == 1){
                try{    
                    // handles single input
                    result = Double.parseDouble(top.get(0));
                    System.out.println("Answer: " + result);
                }
                catch(NumberFormatException e){
                    System.out.print("Input error");
                    e.printStackTrace();
                }
            } else if(topChecker(top)){
                // handles input > 1
                result = hitMe(top);
                System.out.println("Answer: " + result);
            }
        }
        catch (IllegalOperationException e){
            e.printStackTrace();
        }
    } // end main

    public static boolean topChecker(ArrayList<String> input) throws IllegalOperationException{
        // before doing operations on the arraylist, checks for order
        // expected input should be number, operation, number operation, etc
        // if even index, it should be a number
        // if odd index, it should be an operator
        for(int i = 0; i < input.size(); i+=2){
            // this for loop checks for numbers
            if(i % 2 == 0){
                // this tests for successful parsing which means its a double
                try{
                    double d = Double.parseDouble(input.get(i));
                    
                } 
                catch(NumberFormatException e){
                    e.printStackTrace();
                    return false;
                } // end try catch
            } // end if
        } // end for
        for(int i = 1; i < input.size(); i+=2){
            // this for loop checks for operators
            if(i % 2 == 1 && input.get(i).equals("/") || input.get(i).equals("+") || input.get(i).equals("-") || input.get(i).equals("]") || input.get(i).equals("%")){
            } else {
                throw new IllegalOperationException("Illegal operation entered");
            }
        }
        return true;
    }
    
    
    public static double hitMe(ArrayList<String> input){
        // this function starts the calculations after being checked by topChecker method
        // it loops through the ] % and / checks first then checks + - operators
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
            } // end if else     
        } // end for
        for(int i = 0; i < input.size(); i++){
            if(addSubChecker(input, i)){
                // same as above but + -
                merp = operation(input, i);
                cleanUpArray(input,i);
                input.set(i-1, Double.toString(merp));
                i--;
            } // end if else     
        } // end for    
    return merp;
    }
    public static double operation(ArrayList<String> input, int index) throws LookAtMrAlgebraOverHereException{
        // does the operation
        if(numberCheck(input, index)){
            double left = Double.parseDouble(input.get(index - 1));
            double right = Double.parseDouble(input.get(index + 1));
            switch(input.get(index)){
                case "]":
                    return left * right;

                case "/":
                    try{
                        return divide(left, right);
                    } 
                    catch(ArithmeticException e){
                        System.out.println("Division by zero");
                        e.printStackTrace();
                    }

                case "%":
                    return left % right;

                case "+":
                    return left + right;

                case "-":
                    return left - right;

                default: 
                    System.out.println("what went so wrong you got here? _1_");
            }
        } // end if number check method
        // impossible to get to default and here with all the checks in place beforehand
        System.out.println("what went so wrong you got here? _2_");
        return -999;

    }
    public static void cleanUpArray(ArrayList<String> input, int index){
        // cleans up the arraylist after operation by removing left and current value
        input.remove(index);
        input.remove(index-1);
    }

    /*
    all checking functions are here except topChecker which runs before anything else runs
    to confirm there are numbers and operators in the right places
    */
    public static boolean numberCheck(ArrayList<String> input, int index){
        // returns true if numbers are ok(doubles)
        // false if numbers gets an exception
        double l = 0; double r = 0;
        try{
            l = Double.parseDouble(input.get(index - 1));
            r = Double.parseDouble(input.get(index + 1));
        }
        catch (LookAtMrAlgebraOverHereException e){
            System.out.println("numberCheck"); // this should be unreachable because of checks above preventing errors
            return false;
        }
        return true;
    }
    public static boolean addSubChecker(ArrayList<String> input, int index){
        // checks + - operators
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
    /*
    all operator functions are here
    */
    public static double divide(double l, double r) throws ArithmeticException{
        if(r == 0){
            throw new ArithmeticException("Division by zero");
        } else {
            return l / r;
        }
    }

    /*
    parenthesis checking and everything parenthesis here
    */
    public static boolean parenthesisCheck(ArrayList<String> input){
        // this function checks the amount of parenthesis in the arraylist
        // if they have equal openings and closings it is ok
        int openP = 0; int closeP = 0;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).equals("(")){
                openP++;
            }
            if(input.get(i).equals(")")){
                closeP++;
            }
        }
        // return true if openparenthesis and closeparenthesis matches
        return (openP == closeP);
    }

    public static void parenthesisOp(ArrayList<String> input, int index){
        // after checking function above for parenthesis, it does the operations inside parenthesis
        int index1 = 0;
        int index2 = 0;
        if(!parenthesisCheck(input)){
            throw new UserIsADumbassException("Parenthesis check failed");
        }
        for(int i = 0; i < input.size(); i++){
            // this loop gets the indexes of the first ( and ) encountered
            // assume ( and ) are placed properly and no checks are put in
            if(input.get(i).equals("(")){
                index1 = i;
            }
            if(input.get(i).equals(")")){
                index2 = i;
            }
        }
        // need to get length between the ( and ) 
        // pass the length onto operation and make a new argument to accept length
        for(int i = 0; i < index2; i++){
            operation(input, index1);
        }
        
    }

} // end calculator class

// https://stackoverflow.com/questions/1754315/how-to-create-custom-exceptions-in-java
// https://docs.oracle.com/javase/tutorial/essential/exceptions/
class UserIsADumbassException extends IllegalArgumentException{
    // user forgets to enter a number
    public UserIsADumbassException(String message){
        super(message);
    }
}
// https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html#parseDouble-java.lang.String-
class LookAtMrAlgebraOverHereException extends IllegalArgumentException{
    // user enters anything but a number where a number is suppose to go

    public LookAtMrAlgebraOverHereException(String message){
        super(message);
        
    }
}

class IllegalOperationException extends IllegalArgumentException{
    // user enters an operation that isn't supported
    public IllegalOperationException(String message){
        super(message);
    }
}

/*

If the user enters anything other than a number where a number belongs, 
throw a LookAtMrAlgebraOverHereException derived from the 
IlleglArgumentException. 

If the user enters an operation which isn't 
supported, throw a IllegalOperationException derived from the 
IllegalArgumentException. 

If the user forgets to enter a number, throw 
a UserIsADumbassException also derived from IllegalArgumentException. 
Make sure you deal with these exceptions gracefully. Don't pass them on 
to the JVM.

You should also catch and deal with ArithmeticException in case the 
user tries to divide by zero.

*/