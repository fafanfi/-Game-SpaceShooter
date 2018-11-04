package com.f3.spaceshooter.game;

import com.f3.spaceshooter.stuff.Handler;
import com.f3.spaceshooter.listener.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = -2783224254361320222L;

    public static final int WIDTH = 350, HEIGHT = 450;

    private Thread thread;
    private Handler handler;

    private boolean running = false;
    public static int spawner = 0;

    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyListener(handler));

        new Window(WIDTH, HEIGHT, "Space Shooter", this);
    }

    public void run(){
        this.requestFocus();

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public void stop(){
        try{
            thread.join();
            running = false;
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void tick(){
        spawner++;
        handler.tick();
    }

    public void render(){
        Toolkit.getDefaultToolkit().sync();
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int x, int min, int max){
        if(x <= min)
            return min;
        else if(x >= max)
            return max;
        else
            return x;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new Game();
        });
    }

}
