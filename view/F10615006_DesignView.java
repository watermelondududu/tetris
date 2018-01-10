package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.controller;
import model.shape;

public class F10615006_DesignView extends JFrame implements DesignView {
        private JLabel status;
        private ShowView View;
        private controller currentController;
        
        public F10615006_DesignView() {
                //create a board and start
                status = new JLabel("Terminated");
                View = new ShowView(this);
                View.setDesign(this);
                currentController = View.getController();
        }
        
        public DesignView getDesign() {
        		return this;
        }
        
        public void init() {
        Container contentPane = getContentPane();
        
        add(View);
        View.pause();

        //panel1 contains a status bar
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        panel1.setBackground(Color.ORANGE);
        panel1.add(status, BorderLayout.NORTH);
        contentPane.add(panel1, BorderLayout.NORTH);
        
        //panel2 contains start & pause button
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        panel2.setBorder(BorderFactory.createEtchedBorder());
        
        JButton startbutton = new JButton("Restart");
        panel2.add(startbutton, BorderLayout.NORTH);
        startbutton.addActionListener(new StartButtonHandler());
        startbutton.addKeyListener(new MyKeyAdapter(currentController));
        
        JButton pausebutton = new JButton("Pause");
        panel2.add(pausebutton);
        pausebutton.addActionListener(new PauseButtonHandler());
        pausebutton.addKeyListener(new MyKeyAdapter(currentController));
        
        contentPane.add(panel2, BorderLayout.SOUTH);
        
        //panel3 contains operations instructions
        JPanel panel3 = new JPanel(new GridLayout(20, 1));
        panel3.setPreferredSize(new Dimension(200, 450));
        panel3.setBorder(BorderFactory.createEtchedBorder());
        panel3.setBackground(Color.CYAN);
        JLabel label0 = new JLabel();
        JLabel label1 = new JLabel("  Instructions" + '\n');
        label1.setFont(new Font("Dialog", 1, 20));
        JLabel label2 = new JLabel("1. Pause: P/p" + '\n');
        label2.setFont(new Font("Times New Roman", 0, 15));
        JLabel label3 = new JLabel("2. Drop: D/d" + '\n');
        label3.setFont(new Font("Times New Roman", 0, 15));
        JLabel label4 = new JLabel("3. Rotate: KEY_Up" + '\n');
        label4.setFont(new Font("Times New Roman", 0, 15));
        JLabel label5 = new JLabel("4. Move Left: KEY_Left" + '\n');
        label5.setFont(new Font("Times New Roman", 0, 15));
        JLabel label6 = new JLabel("5. Move Right: KEY_Right" + '\n');
        label6.setFont(new Font("Times New Roman", 0, 15));
        JLabel label7 = new JLabel("6. One line down: KEY_Down");
        label7.setFont(new Font("Times New Roman", 0, 15));
        panel3.add(label1);
        panel3.add(label0);
        panel3.add(label2);
        panel3.add(label3);
        panel3.add(label4);
        panel3.add(label5);
        panel3.add(label6);
        panel3.add(label7);
        contentPane.add(panel3, BorderLayout.EAST);
        
        setSize(500, 650);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TetrisGame");
        }
        
        public JLabel getStatus() {
                return status;
        }
        
        private class StartButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//              if(!currentController.isStarted())
                        currentController.start();
        }
        }
        
        private class PauseButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                if(currentController.isStarted())
                        currentController.pause();
        }
        }
        
        public Color[] getColors() {
    		Color tmp[] = { new Color(0, 0, 0), new Color(204, 102, 102), 
    				new Color(102, 204, 102), new Color(102, 102, 204), 
    				new Color(204, 204, 102), new Color(204, 102, 204),
    				new Color(102, 204, 204), new Color(218, 170, 0)
    		};
    		return tmp;
        }

}
