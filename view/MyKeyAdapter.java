package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controllers.controller;

public class MyKeyAdapter extends KeyAdapter {
	public void keyPressed(KeyEvent e, controller currentController) {
		if(!currentController.isStarted() || currentController.isCurrentPieceNoShaped()) {
			return;
		}
		
		int Key = e.getKeyCode();
		
		if(Key == 'p' || Key == 'P') {
			currentController.pause();
			return;
		}
		
		if(currentController.isPaused()) {
			return;
		}
		
		switch(Key) {
		case KeyEvent.VK_LEFT:
			currentController.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			currentController.moveRight();
			break;
		case KeyEvent.VK_DOWN:
			currentController.directDown();
			break;
		
		}
	}
}
