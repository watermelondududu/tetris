package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.controller;
import model.shape;


public class ShowView extends JPanel implements ActionListener {
	
	final int BOARD_WIDTH = 10;
	final int BOARD_HEIGHT = 22;
	private JLabel status;
	
	private controller currentController;
	
	public ShowView(DesignView parent) {
		//Constructor
		setFocusable(true);
		currentController = new controller(BOARD_WIDTH, BOARD_HEIGHT, this);
		status = parent.getStatus();
		addKeyListener(new MyKeyAdapter(currentController));
	}

	public void start() {
		currentController.start();
	}
	
	public void pause() {
		currentController.pause();
	}
	
	// paint
	public void paint(Graphics g) {
		super.paint(g);
		currentController.paint(g, getSize().getWidth(), getSize().getHeight());
	}
	
	public controller getController() {
		return currentController;
	}
	
	// draw this square
	public void drawSquare(Graphics g, int x, int y, shape.Shapes shape) {
		//the color of all the shapes
		Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102), 
				new Color(102, 204, 102), new Color(102, 102, 204), 
				new Color(204, 204, 102), new Color(204, 102, 204),
				new Color(102, 204, 204), new Color(218, 170, 0)
		};
		Color color = colors[shape.ordinal()];
		
		int squareWidth = (int)getSize().getWidth() / BOARD_WIDTH;
		int squareHeight = (int)getSize().getHeight() / BOARD_HEIGHT;
		
		// fill the color of the square
		g.setColor(color);
		g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
		
		// left and top sides of the square are brighter
		g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight - 1, x, y);
		g.drawLine(x, y, x + squareWidth - 1, y);
		
		// bottom and right sides of the square are darker
		// in order to make the square more 3D >_<
		g.setColor(color.darker());
		g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1, x + squareWidth - 1, y + 1);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		currentController.gameAction();
	}

	public void setStatusText(String text) {
		// TODO Auto-generated method stub
		status.setText(text);
	}

}
