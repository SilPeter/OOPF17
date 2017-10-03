// backtracking

class QueensBT{
    // need checker function
    // need printer function
    // need queensbt constructor

    private int board[];
    private int boardSize; // shares queen, column, and row
    private int totalSolutions;
    public QueensBT(int size){
        boardSize = size;
        totalSolutions = 0;
        board = new int[boardSize];
    }

    private boolean checker(int n){
        for(int i = 0; i < n; i++){
            if(board[i] == board[n]){
                // column checker
                return false;
            }
            if((board[i] - board[n]) == (n - i)){
                // checks diagonal
                return false;
            }
            if((board[n] - board[i]) == (n - i)){
                // checks other diagonal
                return false;
            }
        }
        return true;
    }

    private void backtrack(int column){
        if(column == board.length){
            // base case
            totalSolutions++;
            printer();
        } else {
            // tries to place queens in pos 0 to length of board
            for(int i = 0; i < board.length; i++){
                board[column] = i;
                if(checker(column)){
                    backtrack(column + 1);
                }
            }
        }
    }


    private void printer(){
        for(int i = 0; i < board.length; i++){
            // prints columns
            for(int j = 0; j < board.length; j++){
                // prints rows
                if(board[i] == j){
                    
                    System.out.print("1 ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void hitMe(int size, int startingColumn){
        backtrack(startingColumn);
        if(totalSolutions == 0){
            System.out.println("There is no solution found");
        } else {
            System.out.println("There is a total of: " + totalSolutions + " solutions given a board of " + size + " by " + size + " with " + size + " queens.");
        }
    }

}