package com.f3.spaceshooter.game;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final long serialVersionUID = -4439146456236464666L;

    public Window(int WIDTH, int HEIGHT, String title, Game game){
        this.setTitle(title);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(game);
        this.setVisible(true);
        game.start();
    }
}
