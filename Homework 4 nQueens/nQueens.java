/*
    inefficient nqueens solution
*/

public class nQueens{
    public static void main(String args[]){
        // 1 for queen. 0 for empty space. can use boolean maybe?
        
        int size = Integer.parseInt(args[0]);

        //System.out.println("Row: " + row + "\nColumn: " + size);

        // Queens board = new Queens(size);
        // board.hitMe(size, 0);

        QueensBT boardBT = new QueensBT(size);
        boardBT.hitMe(size, 0);


    }

}