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
    private BotController botController;
    
    public Controller(Field field){
        this.game = field;
        this.view = new Frame(this);  
        this.botController = new BotController(field);
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
       if(key == KeyEvent.VK_RIGHT && !game.getSnakePlayer().isLeft()){
           game.getSnakePlayer().setUp(false);
           game.getSnakePlayer().setDown(false);
           game.getSnakePlayer().setRight(true);
       }
       if(key == KeyEvent.VK_LEFT && !game.getSnakePlayer().isRight()){
           game.getSnakePlayer().setUp(false);
           game.getSnakePlayer().setDown(false);
           game.getSnakePlayer().setLeft(true);
       }
       if(key == KeyEvent.VK_UP && !game.getSnakePlayer().isDown()){
           game.getSnakePlayer().setRight(false);
           game.getSnakePlayer().setLeft(false);
           game.getSnakePlayer().setUp(true);
       }
       if(key == KeyEvent.VK_DOWN && !game.getSnakePlayer().isUp()){
           game.getSnakePlayer().setRight(false);
           game.getSnakePlayer().setLeft(false);
           game.getSnakePlayer().setDown(true);
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
