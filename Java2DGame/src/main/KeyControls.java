package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControls implements KeyListener {

    //DO NOT FORGET! THIS WON'T RUN UNLESS YOU CREATED AN INSTANCE!!!

    static boolean w, a, s, d, none;


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();

        if(input == KeyEvent.VK_W){
            w = true;
        }
        if(input == KeyEvent.VK_A){
            a = true;
        }
        if(input == KeyEvent.VK_S){
            s = true;
        }
        if(input == KeyEvent.VK_D){
            d = true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();

        if(input == KeyEvent.VK_W){
            w = false;
        }
        if(input == KeyEvent.VK_A){
            a = false;
        }
        if(input == KeyEvent.VK_S){
            s = false;
        }
        if(input == KeyEvent.VK_D){
            d = false;
        }

    }
}
