package tetris;

import view.F10615006_DesignView;

import javax.swing.*;
import java.awt.*;


public class TetrisStartGame extends JFrame {
	JLabel status;
	public TetrisStartGame() {
		//create a board and start
		status = new JLabel("0");
		add(status, BorderLayout.SOUTH);
		F10615006_DesignView board = new F10615006_DesignView(this);
		add(board);
		board.start();
		
		//set parameters
		setSize(200, 400);
		setTitle("Tetris Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JLabel getStatus() {
		return status;
	}
	
    public static void main(String[] args) {
        TetrisStartGame game = new TetrisStartGame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
