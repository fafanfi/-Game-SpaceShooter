package com.f3.spaceshooter.listener;

import com.f3.spaceshooter.stuff.Handler;
import com.f3.spaceshooter.stuff.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private static final int vel = 5;
    private Handler handler;

    private boolean[] keyDown = new boolean[2];

    public KeyListener(Handler handler){
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int key = e.getKeyCode();
        Player player = handler.getPlayer();

        if(key == KeyEvent.VK_RIGHT) {
            player.setVelX(vel);
            keyDown[0] = true;
        }
        if(key == KeyEvent.VK_LEFT) {
            player.setVelX(-vel);
            keyDown[1] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        int key = e.getKeyCode();
        Player player = handler.getPlayer();

        if(key == KeyEvent.VK_RIGHT)
            keyDown[0] = false;
        if(key == KeyEvent.VK_LEFT)
            keyDown[1] = false;

        if(!keyDown[0] && !keyDown[1])
            player.setVelX(0);
    }
}
