package view;

import java.awt.Component;
import javax.swing.JLabel;

public interface DesignView {

	JLabel getStatus();

	void init();

	//in order to meet the demand of main, implemented in JFrame
	void setLocationRelativeTo(Component C);

}
