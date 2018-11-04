package com.f3.spaceshooter.stuff;

import com.f3.spaceshooter.game.Game;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    private LinkedList<GameObject> bullets = new LinkedList<>();
    private Player player;

    public Handler(){
        player = new Player((Game.WIDTH / 2) - 20, Game.HEIGHT - 20, this);
    }

    public Player getPlayer(){
        return player;
    }

    public LinkedList<GameObject> getBullets(){
        return bullets;
    }

    public void addBullet(GameObject gameObject){
        bullets.add(gameObject);
    }

    public void removeBullet(GameObject gameObject){
        bullets.remove(gameObject);
    }

    public void tick(){
        player.tick();

        for(int i = 0; i < bullets.size(); i++){
            GameObject bullet = bullets.get(i);
            bullet.tick();
        }
    }

    public void render(Graphics g){
        player.render(g);

        for(int i = 0; i < bullets.size(); i++){
            GameObject bullet = bullets.get(i);
            bullet.render(g);
        }
    }
}
