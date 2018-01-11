package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.controller;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class B10415034_DesignView extends JFrame implements DesignView {

	private JFrame frame;
    private JLabel status;
    private ShowView View;
    private controller currentController;
	private String layoutStyle = "dark";

	public B10415034_DesignView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        status = new JLabel("Terminated");
        status.setFont(new Font("MV Boli", Font.PLAIN, 16));
        
        View = new ShowView(this);
        currentController = View.getController();
        View.setBounds(0, 0, 200, 400);
        View.setBackground(new Color(50, 50, 50));
        getContentPane().add(View);
        
        View.setDesign(this);
        
        JPanel panelForStatus = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelForStatus.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panelForStatus.setBounds(201, 0, 198, 31);
        getContentPane().add(panelForStatus);
        panelForStatus.add(status);
        
        panelForStatus.setBackground(UIManager.getColor("Button.background"));
        status.setForeground(UIManager.getColor("Button.foreground"));
        
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnGame = new JMenu("Game");
        menuBar.add(mnGame);
        
        JMenuItem mntmRestart = new JMenuItem("New Game");
        mntmRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		currentController.start();
        	}
        });
        mnGame.add(mntmRestart);
        
        JMenuItem mntmPause = new JMenuItem("Pause");
        mntmPause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                if(currentController.isStarted())
                	currentController.pause();
        	}
        });
        mnGame.add(mntmPause);
        
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        mnGame.add(mntmExit);
        getContentPane().setLayout(null);
        
        JButton btnPause = new JButton("Pause");
        btnPause.setBounds(252, 335, 99, 27);
        getContentPane().add(btnPause);
        
        btnPause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                if(currentController.isStarted())
                	currentController.pause();
        	}
        });
        
        JButton btnRestart = new JButton("Restart");
        btnRestart.setBounds(252, 308, 99, 27);
        getContentPane().add(btnRestart);
        
        btnRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                if(currentController.isStarted())
                	currentController.start();
        	}
        });
        
        JTextPane txtpnGameControls = new JTextPane();
        txtpnGameControls.setBackground(UIManager.getColor("Button.background"));
        txtpnGameControls.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        txtpnGameControls.setText("Game Control\n"+
        		"Press \"¡ü\" to rotate.\nPress \"¡û/¡ú\" to move.\n"
				+ "Press \"¡ý\" for soft drop.\nPress \"D\" for hard drop.\n"
				+ "Press \"P\" to pause .\nPress \"R\" to restart");
        txtpnGameControls.setBounds(217, 64, 182, 193);
        getContentPane().add(txtpnGameControls);
        
        
	}

	public DesignView getDesign() {
		return this;
}
	
	public B10415034_DesignView(String layout) {
		layoutStyle = layout;
	}
	
	public void init() {
		setLocationRelativeTo(this);
        getContentPane().add(View);
        View.start();
        
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setSize(416, 470);
        setVisible(true);
        setTitle("Tetris");
	}
	
    public JLabel getStatus() {
        return status;
    }
    
    public 	Color[] getColors() {
    	Color[] tmp = new Color[8];
    	
    	if (layoutStyle.equals("dark"))
    	{
    		tmp[0] = new Color(0, 0, 0);
    		tmp[1] = new Color(230, 230, 230);
    		tmp[2] = new Color(240, 70, 120);
    		tmp[3] = new Color(255, 250, 120);
    		tmp[4] = new Color(125, 190, 250);
    		tmp[5] = new Color(255, 148, 61);
    		tmp[6] = new Color(113, 240, 163);
    		tmp[7] = new Color(161, 102, 250);
    	}
    
    	
		return tmp;
    }
}
