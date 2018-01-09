package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JLabel;

import model.shape.Shapes;

public interface DesignView {

	JLabel getStatus();

	void init();

	//in order to meet the demand of main, implemented in JFrame
	void setLocationRelativeTo(Component C);

	//a function to fill all colors of squares into an array.
	Color[] getColors();

	DesignView getDesign();
}
