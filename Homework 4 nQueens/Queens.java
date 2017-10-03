/*
    inefficient and incomplete nqueens
// https://stackoverflow.com/questions/4130640/solving-eight-queens-problem-with-2-d-array-indexoutofbounds-error
// https://coderanch.com/t/512909/java/Determining-queen-attack-piece
// https://developers.google.com/optimization/puzzles/queens
*/
import java.util.*;
public class Queens{
    private int size = 0;
    private int board[][];
    
    private int totalSolutions = 0;

    public Queens(int size){
        this.size = size;
        totalSolutions = 0;
    
        board = new int[this.size][this.size];        
    }

    public void hitMe(int column, int startingPosition){
        starting(startingPosition);
        // if(totalSolutions == 0){
        //     System.out.println("There is no solution found");
        // } else {
        //     System.out.println("There is a total of: " + totalSolutions + " solutions given a board of " + size + " by " + size + " with " + size + " queens.");
        // }
    }

    private void starting(int position){
        // http://www.oxfordmathcenter.com/drupal7/node/627
        /*
        For the N-Queens problem, one way we can do this is given by the following:

For each row, place a queen in the first valid position (column), and then move to the next row
If there is no valid position, then one backtracks to the previous row and try the next position
If one can successfully place a queen in the last row, then a solution is found. Now backtrack to find the next solution
        */
        if(position == board.length){
            // base case when row reaches size of board
            totalSolutions++;
            return;
        }
        for(int i = 0; i < board.length; i++){
            addQueen(i, position);
            //if(checker())
        }

    }


    private boolean checker(int row, int column){
        // checks row, column and diagonals if queen is in path
        // if it is in path, return true and reject position in backtrack
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == board[row][column]){
                return false;
            }
        }
        
        // to do check diagonal
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
    
    private void printSolution(int column, int placeHolder){
        for (int i = 0; i < column; i++){
            for (int j = 0; j < column; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
// dead
    private void populateBoard(int column, int startingPos){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                addQueen(i, j);
                if(checker(i, j)){
                    System.out.println("broke");
                } 
                
            }
            
        }


        printSolution(column, startingPos);
    }
}