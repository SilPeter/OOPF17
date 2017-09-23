/*
    inefficient nqueens solution
*/

public class nQueens{
    public static void main(String args[]){
        // 1 for queen. 0 for empty space. can use boolean maybe?
        int row = Integer.parseInt(args[0]);
        int column = Integer.parseInt(args[0]);
        
        System.out.println("Row: " + row + "\nColumn: " + column);

        Queens board1 = new Queens(row, column);
        
        board1.populateBoard(row, column);

    }

}