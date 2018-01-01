package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.controller;
import model.shape;
import model.shape.Shapes;


public class F10615006_DesignView extends JPanel implements ActionListener {

	private controller currentController;
	
	public F10615006_DesignView() {
		//Constructor
		
	}

	public void start() {
		currentController.start();
	}
	
	// paint
	public void paint(Graphics g) {
		super.paint(g);
		currentController.paint(g, getSize().getWidth(), getSize().getHeight());
	}
	
	// draw this square
	public void drawSquare(Graphics g, int x, int y, shape.Shapes shape) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		currentController.gameAction();
	}

}
