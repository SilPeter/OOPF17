/*
palindrome
*/

import java.util.*;

public class isPalindrome{
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
            String s1 = input.next();
            System.out.println(palidromeChecker(s1));
        }        
        
        input.close();
    }

    public static boolean palidromeChecker(String word){
        int front = 0;
        int back = word.length() - 1;
        while (back > front) {
            if (word.charAt(front) != word.charAt(back)){
               
                return false;
            }
            front++;
            back--;
        }
     
        return true;
    }
}