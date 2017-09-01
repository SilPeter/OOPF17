/*
 * 
 Write a program that randomly generates an integer between 1 & 12, and 
displays the English name of that month. Run the program & show the 
output.
 */

public class MonthGenerator {
	public static void main(String[] args) {
		int maxShowing = 24;
		for(int i = 0; i < maxShowing; i++){
			double month = Math.random() * 12 + 1;
			
			if((int)month == 1){
				System.out.println((int)month + " is January");
			}
			if((int)month == 2){
				System.out.println((int)month + " is February");
			}
			if((int)month == 3){
				System.out.println((int)month + " is March");
			}
			if((int)month == 4){
				System.out.println((int)month + " is April");
			}
			if((int)month == 5){
				System.out.println((int)month + " is May");
			}
			if((int)month == 6){
				System.out.println((int)month + " is June");
			}
			if((int)month == 7){
				System.out.println((int)month + " is July");
			}
			if((int)month == 8){
				System.out.println((int)month + " is August");
			}
			if((int)month == 9){
				System.out.println((int)month + " is September");
			}
			if((int)month == 10){
				System.out.println((int)month + " is October");
			}
			if((int)month == 11){
				System.out.println((int)month + " is November");
			}
			if((int)month == 12){
				System.out.println((int)month + " is December");
			}
			
			
		}
		
	}
}
