
import java.util.Scanner;

package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        System.out.print("  ");
        for(int col = 0; col < model.getWidth(); col++){
            System.out.print(col);
        }
        System.out.print("\n");
        for(int row = 0; row < model.getWidth(); row++){
            System.out.print(row + " ");
            for(int col = 0; col < model.getWidth(); col++){
                System.out.print(model.getMark(row, col));
            }
            System.out.print("\n");
        }
        
        /*
        System.out.println("\n\n  012");
        System.out.println("0 "+model.getMark(0,0)+model.getMark(0,1)+model.getMark(0,2));
        System.out.println("1 "+model.getMark(1,0)+model.getMark(1,1)+model.getMark(1,2));
        System.out.println("2 "+model.getMark(2,0)+model.getMark(2,1)+model.getMark(2,2)+"\n");
        */
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        if(model.isXTurn()){
            System.out.println("Player 1 (X) move: \nEnter the row and column numbers, separated by a space: ");
        }
        else{
            System.out.println("Player 2 (O) move: \nEnter the row and column numbers, separated by a space: ");
        }
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		System.out.println("That is not a valid input.");
        

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}