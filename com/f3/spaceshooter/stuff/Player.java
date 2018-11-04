package com.f3.spaceshooter.stuff;

import com.f3.spaceshooter.game.Game;

import java.awt.*;

public class Player extends GameObject {
    private final int width = 45;
    private final int height = 8;

    private Handler handler;

    public Player(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        x = Game.clamp(x, 0, Game.WIDTH - 45);

        if(Game.spawner == 10) {
            handler.addBullet(new Bullet(x + 20, y - 8, handler));
            Game.spawner = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        // meriam
        g.fillRect(x, y - 10, 6, 6);
        g.fillRect(x + 39, y - 10, 6, 6);
    }
}
