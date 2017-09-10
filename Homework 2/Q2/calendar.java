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

import java.util.*;
public class calendar{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in); 
        Calendar cal = Calendar.getInstance();

        int year = 2016;
        int firstDayOfJan = 6; // friday
        int month = cal.get(Calendar.MONTH); // 0 - 11
        int day = cal.get(Calendar.DAY_OF_MONTH); // 1 - 7
        cal.setMinimalDaysInFirstWeek(6);
        int mindaysfirstweek = cal.getMinimalDaysInFirstWeek();
        cal.set(year, 0, firstDayOfJan);
        //System.out.println("What year and day does the first of January fall on?");
        System.out.println(mindaysfirstweek);
        System.out.printf("%5d%5d%5d", year, month, day); 

        System.out.println(cal.get(Calendar.MONTH));

    }

}