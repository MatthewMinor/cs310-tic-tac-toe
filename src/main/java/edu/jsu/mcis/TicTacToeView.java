
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
        System.out.println("\n  012");
        System.out.println("0 ---");
        System.out.println("1 ---");
        System.out.println("2 ---\n");

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        System.out.println("Player 1 (X) move: \nEnter the row and column numbers, seperated by a space: ");
        Scanner in = new Scanner(System.in);
        int rowInput = in.nextInt();
        int colInput = in.nextInt();
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
        

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}