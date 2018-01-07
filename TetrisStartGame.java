package tetris;

import view.DesignView;
import view.ShowView;
import view.F10615006_DesignView;

import javax.swing.*;
import java.awt.*;

public class TetrisStartGame extends JFrame {
    public static void main(String[] args) {
        DesignView game = new F10615006_DesignView();
        game.setLocationRelativeTo(null);
        game.init();
    }
}
