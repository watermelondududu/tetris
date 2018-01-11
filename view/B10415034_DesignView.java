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
	private String layoutStyle = "yyyyy";

	public B10415034_DesignView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        status = new JLabel("Terminated");
        status.setFont(new Font("Segoe Script", Font.PLAIN, 18));
        
        View = new ShowView(this);
        currentController = View.getController();
        View.setBounds(0, -16, 200, 400);
        View.setBackground(Color.DARK_GRAY);
        getContentPane().add(View);
        
        View.setDesign(this);
        
        JPanel panelForStatus = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelForStatus.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panelForStatus.setBounds(201, 0, 198, 39);
        getContentPane().add(panelForStatus);
        panelForStatus.add(status);
        
        panelForStatus.setBackground(UIManager.getColor("Button.background"));
        status.setForeground(UIManager.getColor("Button.foreground"));
        
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnGame = new JMenu("Tetris");
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
        		"Press \"up\" to rotate.\nPress \"left/right\" to move.\n"
				+ "Press \"down\" for soft drop.\nPress \"D\" for hard drop.\n"
				+ "Press \"P\" to pause .\nPress \"R\" to restart");
        txtpnGameControls.setBounds(201, 64, 198, 193);
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
		
        setSize(418, 451);
        setVisible(true);
        setTitle("Tetris");
	}
	
    public JLabel getStatus() {
        return status;
    }
    
    public 	Color[] getColors() {
    	Color[] tmp = new Color[8];
    	
    	if (layoutStyle.equals("yyyyy"))
    	{
    		tmp[0] = new Color(0, 0, 0);
    		tmp[1] = new Color(255,128, 191);
    		tmp[2] = new Color(186, 85, 211);
    		tmp[3] = new Color(100, 149, 237);
    		tmp[4] = new Color(0, 255, 128);
    		tmp[5] = new Color(255, 255,77);
    		tmp[6] = new Color(255, 179, 102);
    		tmp[7] = new Color(102, 255, 230);
    	}
    
    	
		return tmp;
    }
}
