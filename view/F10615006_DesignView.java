package view;

import java.awt.*;

import javax.swing.*;

public class F10615006_DesignView extends JFrame implements DesignView {
	private JLabel status;
	private ShowView View;
	
	public F10615006_DesignView() {
		//create a board and start
		status = new JLabel("0");
		View = new ShowView(this);
		add(status, BorderLayout.SOUTH);
		
		//set parameters
		setSize(200, 400);
		setTitle("Tetris Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		setLayout(new BorderLayout());
        add(status, BorderLayout.SOUTH);
        add(View, BorderLayout.CENTER);
        View.start();
        setSize(200, 400);
        setPreferredSize(new Dimension(200, 400));
        setTitle("TetrisGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
	}
	
	public JLabel getStatus() {
		return status;
	}

}
