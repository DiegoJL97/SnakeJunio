/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Field;
import View.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author DiegoPC
 */
public class Controller implements KeyListener{
    
    private Field game;
    private Frame view;
    
    public Controller(Field field){
        this.game = field;
        this.view = new Frame(this);  
    }

    public Field getGame() {
        return game;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
       if(key == KeyEvent.VK_RIGHT && !game.isLeft()){
           game.setUp(false);
           game.setDown(false);
           game.setRight(true);
       }
       if(key == KeyEvent.VK_LEFT && !game.isRight()){
           game.setUp(false);
           game.setDown(false);
           game.setLeft(true);
       }
       if(key == KeyEvent.VK_UP && !game.isDown()){
           game.setRight(false);
           game.setLeft(false);
           game.setUp(true);
       }
       if(key == KeyEvent.VK_DOWN && !game.isUp()){
           game.setRight(false);
           game.setLeft(false);
           game.setDown(true);
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
