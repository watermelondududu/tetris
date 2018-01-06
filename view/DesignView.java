package view;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import model.shape;

public interface DesignView extends ActionListener {
	abstract void setStatusText(String text);

	abstract void repaint();
	
	abstract void drawSquare(Graphics g, int x, int y, shape.Shapes shape);
}
