package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
        grid = new Mark[width][width];
        /*DONE INSERT YOUR CODE HERE */

        /* Initialize grid by filling every square with empty marks */

    /*DONE INSERT YOUR CODE HERE */
        for(int i = 0; i < DEFAULT_WIDTH; i++){
                for(int j = 0; j < DEFAULT_WIDTH; j++){
                        grid[i][j] = Mark.EMPTY;
                }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /*DONE INSERT YOUR CODE HERE */
        if(isValidSquare(row, col) && isSquareMarked(row, col) == false){
                if(xTurn && grid[row][col] == Mark.EMPTY){
                        grid[row][col] = Mark.X;
                }
                else if(!xTurn && grid[row][col] == Mark.EMPTY){
                        grid[row][col] = Mark.O;
                }
        }
        
        xTurn = !xTurn;

        return false; /* remove this line! */
        
    }
	
    public boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /*DONE INSERT YOUR CODE HERE */
		if(row >= 0 && row <= DEFAULT_WIDTH-1 || col >= 0 && col <= DEFAULT_WIDTH-1){
                    return true;
		}
		else{
                    return false;
		}
    }
	
    public boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /*DONE INSERT YOUR CODE HERE */
		if(grid[row][col] != Mark.EMPTY){
			return true;
		}
                else{
                    return false;
                }
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /*DONE INSERT YOUR CODE HERE */
		Mark mark = grid[row][col];

        return mark; 
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		if(isMarkWin(Mark.X)){
			return Result.X;
		}
		else if(isMarkWin(Mark.O)){
			return Result.O;
		}
		else if(isTie()){
			return Result.TIE;
		}
                else{
                    return Result.NONE;
                }
                
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /*DONE INSERT YOUR CODE HERE */
        int countMarks = 0;
        //check win vertical
        for(int row = 0; row < DEFAULT_WIDTH; row++){
            for(int col = 0; col< DEFAULT_WIDTH; col++){
                if(getMark(col, row) == mark){
                        countMarks++;
                }
                else{
                    countMarks = 0;
                }
                if(countMarks == DEFAULT_WIDTH){
                    return true;
                }
            }
            countMarks = 0;
        }

        //check win horizontal
        for(int row = 0; row < DEFAULT_WIDTH; row++){
            for(int col = 0; col < DEFAULT_WIDTH; col++){
                if(getMark(row, col) == mark){
                        countMarks++;
                }
                else{
                    countMarks = 0;
                }
                if(countMarks == DEFAULT_WIDTH){
                    return true;
                }
            }
            countMarks = 0;
        }

        //check diagonal from left to right
        for(int i = 0; i < DEFAULT_WIDTH; i++){
                if(getMark(i, i) == mark){
                   countMarks++; 
                }
                if(countMarks == DEFAULT_WIDTH){
                    return true;
                }
        }
        countMarks = 0;

        //check diagonal from right to left
        for(int i = (DEFAULT_WIDTH-1); i >=0; i--){
            for(int j =0; j< DEFAULT_WIDTH; j++){
                   
                if(countMarks == DEFAULT_WIDTH){
                    return true;
                } 
                if(getMark(j, i) == mark){
                        countMarks++;
                }
                if(countMarks == DEFAULT_WIDTH){
                    return true;
                }
            }
            countMarks = 0;
        }
        return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        for(int i = 0; i < DEFAULT_WIDTH; i++){
            for(int j = 0; j < DEFAULT_WIDTH; j++){
                if(grid[i][j].equals(Mark.EMPTY)){
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isGameover(){
        return Result.NONE != getResult();
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}