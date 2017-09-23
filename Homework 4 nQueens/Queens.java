/*
    
// https://stackoverflow.com/questions/4130640/solving-eight-queens-problem-with-2-d-array-indexoutofbounds-error
// https://coderanch.com/t/512909/java/Determining-queen-attack-piece
// https://developers.google.com/optimization/puzzles/queens

*/

public class Queens{
    public int row_size = 0;
    public int column_size = 0;
    private int board[][];
    public int totalSolutions = 0;

    public Queens(int row, int column){
        row_size = row;
        column_size = column;
        totalSolutions = 0;
        board = new int[row_size][column_size];
        
    }
    public void populateBoard(int row, int column){
        /*
            loop through the board and put queens and check each queen
            if bigchecker fails, remove queen
            if bigchecker passes, continue loop
            
            TODO : change to while maybe?
            everything lel
        */
        for(int i = 0; i < row; i++){ // goes through rows
            for(int j = 0; j < column; j++){ // goes through columns
                if(bigChecker(i, j)){
                    addQueen(i, j);
                } else {
                    removeQueen(i, j);
                }
                
            }
        }
        printSolution(row, column);
    }
    public void printSolution(int row, int column){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    private boolean bigChecker(int row, int column){
        /*
            checks rows and columns for queens
            if there's more then one queen per row or column, return false
            otherwise true
            TODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checkingTODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checkingTODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checkingTODO: diagonal checking
            TODO: diagonal checking
            TODO: diagonal checkingTODO: diagonal checking
            TODO: diagonal checking

        */
        int rowCounter = 0; // amount of queens in the row
        int columnCounter = 0; // amount of queens in the column
        int diagCounter1 = 0; // amount of queens in diagonal
        int diagCounter2 = 0; // other diagonal
        for(int i = 0; i < row; i++){
            if(board[row][i] == 1){
                // checks row
                rowCounter++;
            }
            if(rowCounter > 1){
                return false;
            }

            if(board[i][row] == 1){
                // checks column
                columnCounter++;
            }
            if(columnCounter > 1){
                return false;
            }
        }
        return true;
    }

    private void addQueen(int row, int column){
        // adds a queen to row x column
        board[row][column] = 1;
    }
    private void removeQueen(int row, int column){
        // removes a queen from row x column
        board[row][column] = 0;
    }
    
}

