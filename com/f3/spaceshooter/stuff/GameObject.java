package com.f3.spaceshooter.stuff;

import java.awt.*;

public abstract class GameObject{
    protected int x, y;
    protected int velX, velY;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
