import java.util.Scanner;

/*
Question 5:
Change Scanner's delimiter, and tokenize comma separated values entered by 
the keyboard.
*/

class commaDelimiter{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        input.useDelimiter(",");
        String s1 = "";
        while(input.hasNext()){
            s1 = input.next();
            System.out.println(s1);
        }
        input.close();
    }
}