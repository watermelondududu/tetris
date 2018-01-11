package tetris;

import view.DesignView;
import view.ShowView;
import view.F10615006_DesignView;
import view.F10615007_DesignView;
import view.B10413040_DesignView;

import javax.swing.*;
import java.awt.*;

public class TetrisStartGame extends JFrame {
    public static void main(String[] args) {
//    	DesignView game = new F10615006_DesignView();
 //      DesignView game = new F10615007_DesignView();
  //    DesignView game = new B10415034_DesignView();
        DesignView game = new B10413040_DesignView();
        game.setLocationRelativeTo(null);
        game.init();
    }
}
