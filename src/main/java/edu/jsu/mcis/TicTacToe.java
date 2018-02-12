package edu.jsu.mcis;

import java.awt.*;
import java.applet.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TicTacToe {

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
        
        /* If a different size is provided as a command-line argument, use it instead */

        if(args.length >= 1) {
            
            try {
                width = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e) {}
            
        }
        
        /* Create MVC Objects */

        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        
		
		//creating the window
        JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.out.println("Panel has been added to the frame");
		frame.pack();
		frame.setSize(1000, 800);
		frame.add(view);
		
	}
}