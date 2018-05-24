/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Field;
import View.Screen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiegoPC
 */
public class BotController extends Thread{
    
    private Field game;
    
    private Thread thread;
    private Boolean running = false;
    
    public BotController(Field game){
        this.game = game;
        start();
    }
    
    public void botMovement(){
            if(game.getSnakeBot().getX() == game.getApples().get(0).getX()){
               if((game.getSnakeBot().getY()<game.getApples().get(0).getY())){
                    game.getSnakeBot().setRight(false);
                    game.getSnakeBot().setLeft(false);
                    game.getSnakeBot().setDown(true);
                }
                if((game.getSnakeBot().getY()>game.getApples().get(0).getY())){
                    game.getSnakeBot().setRight(false);
                    game.getSnakeBot().setLeft(false);
                    game.getSnakeBot().setUp(true);
                }
            }
            if(game.getSnakeBot().getY() == game.getApples().get(0).getY()){
               if((game.getSnakeBot().getX()<game.getApples().get(0).getX())){
                    game.getSnakeBot().setUp(false);
                    game.getSnakeBot().setDown(false);
                    game.getSnakeBot().setRight(true);
                }
                if((game.getSnakeBot().getY()>game.getApples().get(0).getY())){
                    game.getSnakeBot().setUp(false);
                    game.getSnakeBot().setDown(false);
                    game.getSnakeBot().setLeft(true);
                }
            }
    }
    
    @Override
    public void start(){    
        running = true;
        thread = new Thread(this,"Hilo del bot");             //CREAMOS HILO DEL JUEGO DE LA CLASE SCREEN
        thread.start();
    }
    
    @Override
    public void run(){
        //botMovement();
        while(true){
            botMovement();
            System.out.println(game.getSnakeBot().getX());
            System.out.println(game.getApples().get(0).getX());
        }
    }
    
}
