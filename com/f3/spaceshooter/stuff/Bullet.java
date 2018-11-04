package com.f3.spaceshooter.stuff;

import java.awt.*;

public class Bullet extends GameObject {
    private Handler handler;

    public Bullet(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;

        velY = -5;
    }

    @Override
    public void tick() {
        y += velY;

        if(y <= 0)
            handler.removeBullet(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 6, 13);
    }
}
