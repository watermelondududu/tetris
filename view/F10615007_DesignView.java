package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JFrame;
import javax.swing.*;
import controller.controller;

public class F10615007_DesignView extends JFrame implements DesignView {
	private JLabel status;
	private ShowView view;
	private controller currentController;
	private Color LightGray;
	
	public F10615007_DesignView(){
		status=new JLabel("Terminated");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		view=new ShowView(this);
		view.setDesign(this);
		currentController=view.getController();
		
		LightGray=new Color(211,211,211);
	}

	@Override
	public JLabel getStatus() {
		return status;
	}

	@Override
	public void init() {
		Container contentPane = getContentPane();
		add(view);
		view.start();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.setBackground(LightGray);
		status.setFont(new   java.awt.Font("Sanserif",   1,   25));
		jp1.add(status,BorderLayout.NORTH);
		contentPane.add(jp1,BorderLayout.NORTH);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1,3));
		
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

		JButton pbutton =new JButton("PAUSE/PLAY");
		//ImageIcon icon = new ImageIcon("./img/pauseplay.jpg");//图片
		//pbutton.setIcon(icon);
		jp2.add(pbutton);
		pbutton.addActionListener(new StartButtonHandler());
        pbutton.addKeyListener(new MyKeyAdapter(currentController));
        
        JButton rebutton = new JButton("RESTART");
        jp2.add(rebutton);
        rebutton.addActionListener(new reButtonHandler());
        rebutton.addKeyListener(new MyKeyAdapter(currentController));
        
        contentPane.add(jp2,BorderLayout.SOUTH);
		
		setSize(250,500);
		setVisible(true);
		setLocation(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class StartButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
              if(!currentController.isStarted())
            	  currentController.start();
              else
            	  currentController.pause();
        }
    }
	
	private class reButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            	  currentController.start();
        }
    }
        
       
	@Override
	public Color[] getColors() {
		Color[] tmp = new Color[8];
   
   		tmp[0] = new Color(255,192,203, 145);
   		tmp[1] = new Color(95,158,160, 145);
   		tmp[2] = new Color(176,224,230, 145);
   		tmp[3] = new Color(252,222,173, 145);
   		tmp[4] = new Color(240,128,128, 145);
   		tmp[5] = new Color(169,169,169, 145);
   		tmp[6] = new Color(255,228,181, 145);
   		tmp[7] = new Color(176,196,222,145);
   		
   		return tmp;
	}

	@Override
	public DesignView getDesign() {
		return this;
	}

}
