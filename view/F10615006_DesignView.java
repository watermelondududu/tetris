package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.controller;


public class F10615006_DesignView extends JPanel implements ActionListener {

	private controller currentController;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		currentController.gameAction();
	}

}
