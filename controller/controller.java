package controller;

import javax.swing.Timer;

import model.shape;

public class controller {
	//current shape and its location
	private shape currentShape;
	private int currentX = 0;
	private int currentY = 0;

	//board
	private shape.Shapes[] board;
	private int boardWidth;
	private int boardHeight;
	
	//assign STATES and initial
	private boolean isStarted = false;
	private boolean isPaused = false;
	private boolean isFallingFinished = false;
	
	private Timer timer;
	
	public controller() {
		
	}
	
	//start or end
	public boolean isStarted() {
		return isStarted;
	}
	
	//running or paused
	public boolean isPaused() {
		return isPaused;
	}
	
	public boolean isCurrentPieceNoShaped() {
		return currentShape.getPieceShape() == shape.Shapes.NoShape;
	}
	
	//able to move?
	private boolean tryMove(shape currentShape2, int currentX2, int currentY2) {
		
		return true;
	}
	
	//generate new piece
	private void newPiece() {
		currentShape.setRandomShape();
		currentX = boardWidth/2 + 1;
		currentY = boardHeight - 1 + currentShape.minY();
		
		//if cannot generate new piece, game over
		if(!tryMove(currentShape, currentX, currentY)) {
			
		}
	}
	
	//move down
	private void oneLineDown() {
		
	}
	
	//fall or finished
	public void gameAction() {
		if(isFallingFinished) {
			isFallingFinished = false;
			newPiece();
		} else {
			oneLineDown();
		}
	}


}
