/*
    String class reimplementation
*/
import java.util.*;

class MyString{
    // private String string;
    private char[] characters;
    private int valueOf = 0;
    public MyString(char[] chars){
        /* java8api     string = new String(chars);
            String(char[] value)
            Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.
        */
        
        characters = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            characters[i] = chars[i];
        }
    }

    public char charAt(int index){
        if(index < 0 || index > characters.length || characters.length < 0){
            throw new IndexOutOfBoundsException("charAt index out of bounds");
        }
        return characters[index];
    }

    public int length(){
        return characters.length;
    }

    public MyString substring(int begin, int end){
        int position = 0;
        char[] my_charsubstr = new char[end - begin];

        for(int i = begin; i < end; i++){
            my_charsubstr[position] = characters[i];
            position++;
        }
        
        MyString my_substr = new MyString(my_charsubstr);
        return my_substr;
    }

    public MyString toLowerCase(){
        // https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toLowerCase-char-
        char[] return_me = new char[characters.length];
        for(int i = 0; i < characters.length; i++){
            return_me[i] = Character.toLowerCase(characters[i]);
        }   
        MyString my_lowstr = new MyString(return_me);
        return my_lowstr;
    }
    
    public MyString toUpperCase(){
        char[] return_me = new char[characters.length];
        for(int i = 0; i < characters.length; i++){
            return_me[i] = Character.toUpperCase(characters[i]);
        }   
        MyString my_upperstr = new MyString(return_me);
        return my_upperstr;
    }

    public boolean equals(MyString s){
        // compares character by character instead of hashcode
        if(s.length() == characters.length){
            for(int i = 0; i < characters.length; i++){
                if(s.charAt(i) != characters[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public MyString getMyString(){
        MyString my_char = new MyString(characters);
        return my_char;
    }

    public String toString(){
        String my_str = new String();
        for(int i = 0; i < characters.length; i++){
            my_str += characters[i];
        }
        return my_str;
    }

    public static MyString valueOf(int i){
        // turns an integer into MyString
        // http://javadevnotes.com/java-integer-to-string-examples
        // https://stackoverflow.com/questions/4105331/how-do-i-convert-from-int-to-string
        int numb = i;
        int int_length = 0;
        while(numb != 0){
            numb = numb / 10;
            int_length++;
        }
        numb = i;
        int[] intarr = new int[int_length];
        for(int n = 0; n < int_length; n++){ 
            intarr[n] = numb % 10;
            numb = numb / 10;
        }
        numb = i;    
        char[] my_char = new char[int_length];        
        for(int n = 0; n < int_length; n++){
            // https://www.tutorialspoint.com/java/lang/character_fordigit.htm
            my_char[n] = Character.forDigit(intarr[n], 10);
        }
        for(int n = 0; n < int_length / 2; n++){
            char temp = my_char[n];
            my_char[n] = my_char[my_char.length - n - 1];
            my_char[my_char.length - n - 1] = temp;
        }

        MyString my_intstr = new MyString(my_char);
        return my_intstr;
    }
}


public class StringClass{
    
    public static void main(String args[]){

        char [] charArray = {'h', 'e', 'l', 'l', 'o'};
        char [] charArray_2 = {'c', 'i', 's', 'c', '3', '1', '5', '0'};
        char [] charArray_3 = {'c', 'i', 's', 'c', '3', '1', '5', '0'};
        char[] charArray_4 = {'H', 'E', 'L', 'L', 'O'};
        MyString s1 = new MyString(charArray);
        MyString s2 = new MyString(charArray_2);
        MyString s3 = new MyString(charArray_3);
        MyString s4 = new MyString(charArray_4);

        // getMyString testing
        System.out.println("s1 is: " + s1.getMyString());
        System.out.println("s2 is: " + s2.getMyString());
        System.out.println("s3 is: " + s3.getMyString());        

        // testing charAt bounds
        System.out.println("s1 character at position 3 is " + s1.charAt(3));
        System.out.println("s2 character at position 3 is " + s2.charAt(3));
        //System.out.println("s3 character at position 100 is " + s1.charAt(100));
        // throwing oob error

        // testing lengths
        System.out.println("Length of s1 is " + s1.length());
        System.out.println("Length of s1 is " + s2.length());
        System.out.println("Length of s1 is " + s3.length());

        // testing substring
        System.out.println(s1.substring(0, 5));
        System.out.println(s2.substring(4, 8));

        // testing upper and lower
        System.out.println("Upper case " + s4.getMyString() + " is " + s4.toLowerCase());
        System.out.println("Lower case " + s3.getMyString() + " is " + s3.toUpperCase());

        // testing equals
        System.out.println(s3.equals(s2));
        System.out.println(s1.equals(s2));
        
        // testing int values
        System.out.println("Testing values: " + s1.valueOf(1234567890));
        
        }

}
