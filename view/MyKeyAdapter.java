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
		
		/*
		 * 'P'/'p': pause
		 */
		if(Key == 'p' || Key == 'P') {
			currentController.pause();
			return;
		}
		
		if(currentController.isPaused()) {
			return;
		}
		
		/*
		 * <-: move left
		 * ->: move right
		 * ↓: one line down
		 * 'A'/'a': rotate left
		 * 'D'/'d': rotate right
		 * 'S'/'s': direct down
		 */
		if (Key == KeyEvent.VK_LEFT) {
			currentController.moveLeft();
		}
		else if(Key == KeyEvent.VK_RIGHT) {
			currentController.moveRight();
		}
		else if(Key == KeyEvent.VK_DOWN) {
			currentController.oneLineDown();
		}
		else if(Key == KeyEvent.VK_SPACE) {
			currentController.directDown();
		}
		else if(Key == 'A' || Key == 'a') {
			currentController.rotateLeft();
		}
		else if(Key =='D' || Key == 'd') {
			currentController.rorateRight();
		}
		else if(Key == 'S' || Key == 's') {
			currentController.directDown();
		}
	}
}
