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

public class B10413040_DesignView extends JFrame implements DesignView {

	private JFrame frame;
    private JLabel status;
    private ShowView View;
    private controller currentController;
	private String layoutStyle = "dark";

	public B10413040_DesignView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        status = new JLabel("Terminated");
        status.setFont(new Font("MV Boli", Font.PLAIN, 16));
        
        View = new ShowView(this);
        currentController = View.getController();
        View.setBounds(0, 30, 200, 400);
        View.setBackground(new Color(50, 50, 50));
        getContentPane().add(View);
        
        View.setDesign(this);
        
        JPanel panelForStatus = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelForStatus.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panelForStatus.setBounds(0, 0, 200, 31);
        getContentPane().add(panelForStatus);
        panelForStatus.add(status);
        
        panelForStatus.setBackground(new Color(50, 50, 50));
        status.setForeground(new Color(240, 240, 240));
        
        
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
        
        JMenu mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);
        
        JMenu mnLayoutStyle = new JMenu("Layout Style");
        mnSettings.add(mnLayoutStyle);
        
        
        JRadioButton rdbtnDark = new JRadioButton("Dark", true);
        JRadioButton rdbtnBright = new JRadioButton("Bright", false);
        JRadioButton rdbtnCold = new JRadioButton("Cold", false);
        JRadioButton rdbtnWarm = new JRadioButton("Warm", false);
        
        rdbtnDark.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		layoutStyle = "dark";
        		rdbtnDark.setSelected(true);
        		rdbtnBright.setSelected(false);
        		rdbtnCold.setSelected(false);
        		rdbtnWarm.setSelected(false);
                panelForStatus.setBackground(new Color(50, 50, 50));
                status.setForeground(new Color(240, 240, 240));
                View.setBackground(new Color(50, 50, 50));
        	}
        });
        mnLayoutStyle.add(rdbtnDark);
        
        
        rdbtnBright.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		layoutStyle = "bright";
        		rdbtnDark.setSelected(false);
        		rdbtnBright.setSelected(true);
        		rdbtnCold.setSelected(false);
        		rdbtnWarm.setSelected(false);
                panelForStatus.setBackground(new Color(245, 245, 245));
                status.setForeground(new Color(0, 0, 0));
                View.setBackground(new Color(245, 245, 245));
        	}
        });
        mnLayoutStyle.add(rdbtnBright);
        
        
        rdbtnCold.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		layoutStyle = "cold";
        		rdbtnDark.setSelected(false);
        		rdbtnBright.setSelected(false);
        		rdbtnCold.setSelected(true);
        		rdbtnWarm.setSelected(false);
                panelForStatus.setBackground(new Color(0x285e83));
                status.setForeground(new Color(0xc4f3ff));
                View.setBackground(new Color(0x285e83));
        	}
        });
        mnLayoutStyle.add(rdbtnCold);
        
        
        rdbtnWarm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		layoutStyle = "warm";
        		rdbtnDark.setSelected(false);
        		rdbtnBright.setSelected(false);
        		rdbtnCold.setSelected(false);
        		rdbtnWarm.setSelected(true);
                panelForStatus.setBackground(new Color(0x832844));
                status.setForeground(new Color(0xffffff));
                View.setBackground(new Color(0x832844));
        	}
        });
        mnLayoutStyle.add(rdbtnWarm);
        
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmHowToPlay = new JMenuItem("How To Play");
        mntmHowToPlay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		boolean uesrPressedThis = false;
        		if (!currentController.isPaused()) {
        			currentController.pause();
        			uesrPressedThis = true;
        		}
        		JOptionPane.showMessageDialog(null, "Press \"up\" to rotate.\nPress \"left/right\" to move.\n"
        				+ "Press \"down\" to drop one line\nPress \"D\" to drop down to the bottom.\n"
        				+ "Press \"P\" to pause game.\nPress \"R\" to restart game.", "How To Play", JOptionPane.PLAIN_MESSAGE);
        		if (currentController.isPaused() && uesrPressedThis == true)
        			currentController.pause();	
        	}
        });
        mnHelp.add(mntmHowToPlay);
        getContentPane().setLayout(null);
        
        
	}

	public DesignView getDesign() {
		return this;
}
	
	public B10413040_DesignView(String layout) {
		layoutStyle = layout;
	}
	
	public void init() {
		setLocationRelativeTo(this);
        getContentPane().add(View);
        View.start();
        
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setSize(216, 493);
        setVisible(true);
        setTitle("Let's play tetris!");
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
    	if (layoutStyle.equals("bright"))
    	{
    		tmp[0] = new Color(0, 0, 0);
    		tmp[1] = new Color(255, 120, 0);
    		tmp[2] = new Color(0, 170, 50);
    		tmp[3] = new Color(22, 62, 152);
    		tmp[4] = new Color(0, 210, 154);
    		tmp[5] = new Color(176, 89, 235);
    		tmp[6] = new Color(255, 216, 0);
    		tmp[7] = new Color(200, 0, 0);
    	}
    	if (layoutStyle.equals("cold"))
    	{
    		tmp[0] = new Color(0, 0, 0);
    		tmp[1] = new Color(0x7b81ff);
    		tmp[2] = new Color(0x64f6e4);
    		tmp[3] = new Color(0x4eb2ff);
    		tmp[4] = new Color(0x126dff);
    		tmp[5] = new Color(0x1f7bcc);
    		tmp[6] = new Color(0x00b4ce);
    		tmp[7] = new Color(0xececec);
    	}
    	if (layoutStyle.equals("warm"))
    	{
    		tmp[0] = new Color(0, 0, 0);
    		tmp[1] = new Color(0xe5005c);
    		tmp[2] = new Color(0xffa87b);
    		tmp[3] = new Color(0xf664c3);
    		tmp[4] = new Color(0xff6574);
    		tmp[5] = new Color(0xff6c00);
    		tmp[6] = new Color(0xffb0bc);
    		tmp[7] = new Color(0xc74a0d);
    	}
    	
		return tmp;
    }
}
