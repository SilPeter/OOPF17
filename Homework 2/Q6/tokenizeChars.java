/*
Question 6:
Your job is to tokenize individual characters. Your code looks like:

Scanner in = ...
in.useDelimiter()

while(in.hasNext()){
	print the current token.
}

What delimiter should you use here?
input.useDelimiter("");
*/

import java.util.*;

public class tokenizeChars{
    public static void main (String args[]){
        Scanner input = new Scanner (System.in);
        input.useDelimiter("");
        String s1 = "";
        while(input.hasNext()){
            s1 = input.next();
            System.out.println(s1);
        }
        input.close();
        
    }
}