/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DiegoPC
 */
public class Field {
     
    private Snake snakePlayer,snakeBot;
    
    //private SnakeBot snakeBot;
    
    private Apple a;
    private ArrayList<Apple> apples;
    
    private Random r;
    
    private int ticks;
    
    public Field(){
        r = new Random();
        snakePlayer = new Snake();
        snakeBot = new Snake();
        apples = new ArrayList<>();
    }
    
    public void tick(){                     //ACTUALIZA
        if(snakePlayer.getSnake().size()==0 && snakeBot.getSnake().size()==0){
           snakePlayer.addToSnake();
           snakeBot.addToSnake();
        }
        if(apples.size()==0){
            int x = r.nextInt(59);          //Porque hay 79 cuadrados
            int y = r.nextInt(59);
            a = new Apple(x,y);
            apples.add(a);
        }
        for(int i = 0;i<apples.size();i++){
            if(snakePlayer.getX() == apples.get(i).getX() && snakePlayer.getY() == apples.get(i).getY()){
                snakePlayer.addSize();
                apples.remove(i);
                i--;
                snakePlayer.addPoints();
            }
            if(snakeBot.getX() == apples.get(i).getX() && snakeBot.getY() == apples.get(i).getY()){       //DESCOMENTAR PARA SNAKEBOT
                snakeBot.addSize();
                apples.remove(i);
                i--;
                snakeBot.addPoints();
            }
        }
        /*for(int i = 0;i<snake.size();i++){
            if(x == snake.get(i).getX() && y == snake.get(i).getY()){       //Si te chocas con tu propio cuerpo para el juego
                if(i != snake.size()-1){
                    stop();
                }
            }
        }
        if(x < 0 || x > 69 || y < 0 || y > 69){
            stop();
        }*/
        ticks++;    
        if(ticks>1000000){
            if(snakePlayer.isRight()) snakePlayer.setX(snakePlayer.getX()+1);
            if(snakePlayer.isLeft()) snakePlayer.setX(snakePlayer.getX()-1);                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
            if(snakePlayer.isUp()) snakePlayer.setY(snakePlayer.getY()-1);
            if(snakePlayer.isDown()) snakePlayer.setY(snakePlayer.getY()+1);
            
            if(snakeBot.isRight()) snakeBot.setX(snakeBot.getX()+1);
            if(snakeBot.isLeft()) snakeBot.setX(snakeBot.getX()-1);                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
            if(snakeBot.isUp()) snakeBot.setY(snakeBot.getY()-1);
            if(snakeBot.isDown()) snakeBot.setY(snakeBot.getY()+1);
            
            ticks = 0;
            
            snakePlayer.addToSnake();
            snakeBot.addToSnake();
            
            if(snakePlayer.getSnake().size()>snakePlayer.getSize()){
                snakePlayer.getSnake().remove(0);
            }
            if(snakeBot.getSnake().size()>snakeBot.getSize()){
                snakeBot.getSnake().remove(0);
            }
        }
    }

    public Snake getSnakePlayer() {
        return snakePlayer;
    }

    public void setSnakePlayer(Snake snakePlayer) {
        this.snakePlayer = snakePlayer;
    }

    public ArrayList<Apple> getApples() {
        return apples;
    }

    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }

    public Snake getSnakeBot() {
        return snakeBot;
    }

    public void setSnakeBot(Snake snakeBot) {
        this.snakeBot = snakeBot;
    }

}
