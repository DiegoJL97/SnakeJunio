/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Comunication.SnakeDirection;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DiegoPC
 */
public class Game {
     
    private Snake snakePlayer;
    
    private ArrayList<Snake> bots;
        
    private Apple a;
    private ArrayList<Apple> apples;
    
    private Random r;
    
    private int ticks;
    
    public Game(){
        r = new Random();
        snakePlayer = new Snake();
        bots = new ArrayList();
        //snakeBot = new Snake();
        apples = new ArrayList<>();
    }
    
    public void tick(){                     //ACTUALIZA
        if(snakePlayer.getSnake().isEmpty() /* && snakeBot.getSnake().size()==0*/ ){
           snakePlayer.addToSnake();
           for(int i = 0; i<bots.size();i++){
               bots.get(i).addToSnake();
           }
        }
        
        if(apples.isEmpty()){
            int x = 0;          //Porque hay 79 cuadrados
            
            
            //numero menor que 10 se carga el juego JAXDLOL
            while(x <= 10){
                x = r.nextInt(59);
            }
            
            int y = r.nextInt(59);
            a = new Apple(x,y);
            apples.add(a);
        }
        
        
        //ITERA ENTRE TODAS LAS MANZANAS PARA COMPROBAR SI EL JUGADOR O LOS BOTS LAS COGEN
        for(int i = 0;i<apples.size();i++){
            if(snakePlayer.getX() == apples.get(i).getX() && snakePlayer.getY() == apples.get(i).getY()){
                snakePlayer.addSize();
                if(!apples.isEmpty()){
                        apples.remove(i);
                        i--;
                        snakePlayer.addPoints();
                        break;
                    }
                //apples.remove(i);                 //AQUI ESTA EL PROBLEMA
                //i--;
                snakePlayer.addPoints();
            }
            
            // ITERA ENTRE LOS BOTS PARA COMPROBAR SI SE COMEN LA MANZANA
            for (Snake snakeBot : bots) {
                if(snakeBot.getX() == apples.get(i).getX() && snakeBot.getY() == apples.get(i).getY()){       //DESCOMENTAR PARA SNAKEBOT
                    snakeBot.addSize();
                    if(!apples.isEmpty()){
                        apples.remove(i);
                        i--;
                        snakeBot.addPoints();
                        break;
                    }
                }
            } 
        }
        
        
        
        // JUGADOR MUERTO SI SE CHOCA CONSIGO MISMO
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
        if(ticks>1500000){
            if(snakePlayer.isRight()) snakePlayer.setX(snakePlayer.getX()+1);
            if(snakePlayer.isLeft()) snakePlayer.setX(snakePlayer.getX()-1);                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
            if(snakePlayer.isUp()) snakePlayer.setY(snakePlayer.getY()-1);
            if(snakePlayer.isDown()) snakePlayer.setY(snakePlayer.getY()+1);
            
            for(Snake snakeBot: bots){
                if(snakeBot.isRight()) snakeBot.setX(snakeBot.getX()+1);
                if(snakeBot.isLeft()) snakeBot.setX(snakeBot.getX()-1);                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
                if(snakeBot.isUp()) snakeBot.setY(snakeBot.getY()-1);
                if(snakeBot.isDown()) snakeBot.setY(snakeBot.getY()+1);
                snakeBot.addToSnake();
                if(snakeBot.getSnake().size()>snakeBot.getSize()){
                    snakeBot.getSnake().remove(0);
                }
            }
            /*if(snakeBot.isRight()) snakeBot.setX(snakeBot.getX()+1);
            if(snakeBot.isLeft()) snakeBot.setX(snakeBot.getX()-1);                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
            if(snakeBot.isUp()) snakeBot.setY(snakeBot.getY()-1);
            if(snakeBot.isDown()) snakeBot.setY(snakeBot.getY()+1);*/
            
            ticks = 0;
            
            snakePlayer.addToSnake();
            //snakeBot.addToSnake();
            
            if(snakePlayer.getSnake().size()>snakePlayer.getSize()){
                snakePlayer.getSnake().remove(0);
            }
            /*if(snakeBot.getSnake().size()>snakeBot.getSize()){
                snakeBot.getSnake().remove(0);
            }*/
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


    public void changeDirection(SnakeDirection dir){
        
        switch(dir){
            
            case ABAJO:
                
            case ARRIBA:
                    
            case DERECHA:
                
            case IZQUIERDA:
        }
        
    }

    public ArrayList<Snake> getBots() {
        return bots;
    }

    public void setNumberBots(String bots) {
        Integer num  = Integer.parseInt(bots);
        for(int i = 0; i<num; i++){
            Snake bot = new Snake();
            this.bots.add(bot);
        }
    }

}
