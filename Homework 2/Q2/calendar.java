/*

Write a program that displays a calendar on the screen. It asks the user 
the year, what day the first of January fell on, then displays every month 
from January to December. Make sure to get the leap years right. Your 
months should resemble the following format:

   February 2015      
Su Mo Tu We Th Fr Sa  
 1  2  3  4  5  6  7  
 8  9 10 11 12 13 14  
15 16 17 18 19 20 21  
22 23 24 25 26 27 28 

ask year
ask first day the first of jan flel on
then display jan - dec of the year
*/

// https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html
// https://www.ntu.edu.sg/home/ehchua/programming/java/DateTimeCalendar.html
// https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html#GregorianCalendar-int-int-int-
import java.util.*;
public class calendar{
    public static String monthNumberToString(int month){
        // to do switch statements
        String monthName = "";
        switch(month){
            case 0: monthName = "January"; break;
            case 1: monthName = "February"; break;
            case 2: monthName = "March"; break;
            case 3: monthName = "April"; break;
            case 4: monthName = "May"; break; 
            case 5: monthName = "June"; break;
            case 6: monthName = "July"; break;
            case 7: monthName = "August"; break;
            case 8: monthName = "September"; break;
            case 9: monthName = "October"; break;
            case 10: monthName = "November"; break;
            case 11: monthName = "December";
        }
        return monthName;
    }
    public static void header(int month, int year){
        // prints header for each month
        System.out.printf("%10s%8d\n", monthNumberToString(month), year);
        System.out.println("Su Mo Tu We Th Fr Sa");
    }
    public static void daysPrinter(int month, int year, int firstDayOfJan){
        // prints days formatted to align with header
        for(int i = 0; i < firstDayOfJan; i++){
            // space it out until first day
            System.out.print(" ");
        }

        for(int i = 1; i <= daysMaker(month); i++){
            // days
            System.out.print(i + " ");
            if(daysMaker(month) + i == 7){
                System.out.println("seven lines");
            }
        }
        System.out.println();
    }

    
    public static int daysMaker(int month){
        // determine the amount of days in a month
        // http://lifehacker.com/232828/macgyver-tip-use-your-knuckles-to-remember-each-months-days
        if (month % 2 == 1 && month > 0 && month != 2){
            return 31;
        }
        if (month % 2 == 0 && month > 0 && month != 2){
            return 30;
        }
        System.out.println("returning 1");
        return -1;
    }
    public static void twelveMonths(int firstDayOfJan, int year){
        // repeats printing 12x
        for(int i = 0; i < 12; i++){
            header(i, year);
            daysPrinter(i, year, firstDayOfJan);
        }
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter year and what day the first January fell on(1-7, 1 being sunday and 7 being saturday: ");
        int year = 2016; // input.nextInt();
        int firstDayOfJan = 6; // input.nextInt() - 1;
        // 1 sunday
        // 7 saturday
        twelveMonths(firstDayOfJan, year);

        input.close();
    }

}