/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Game;
import Model.Snake;

/**
 *
 * @author DiegoPC
 */
public class BotController extends Thread{
    
    private Game game;
    private Snake snake;
    private Thread thread;
    private Boolean running = false;
    
    public BotController(Game game,Snake snakeBot){
        this.game = game;
        this.snake = snakeBot;
        start();
    }
    
    public void botMovement(){
        if(game.getApples().isEmpty()) return;
        
        if(snake.getX() > game.getApples().get(0).getX()){
            snake.setUp(false);
            snake.setDown(false);
            snake.setLeft(true);
        }
        if(snake.getX() < game.getApples().get(0).getX()){
            snake.setUp(false);
            snake.setDown(false);
            snake.setRight(true);    
        }
        if(snake.getX() == game.getApples().get(0).getX()){
           if((snake.getY()<game.getApples().get(0).getY())){
                snake.setRight(false);
                snake.setLeft(false);
                snake.setDown(true);
            }
            if((snake.getY()>game.getApples().get(0).getY())){
                snake.setRight(false);
                snake.setLeft(false);
                snake.setUp(true);
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
            System.out.println(snake.getX());
            System.out.println(game.getApples().get(0).getX());
        }
    }
    
}
