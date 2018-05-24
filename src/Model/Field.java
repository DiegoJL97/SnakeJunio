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
    
    private BodyPart b;
    private ArrayList<BodyPart> snake;
    
    private Apple a;
    private ArrayList<Apple> apples;
    
    private Integer points;
    
    private Random r;
    
    private int ticks;
    
    private boolean right = true, left = false, up = false, down = false;
    
    private int x = 10, y = 10;
    private int size = 5; 
    
    public Field(){
        points = 0;
        r = new Random();
        snake = new ArrayList<>();
        apples = new ArrayList<>();
    }
    
    public void tick(){                     //ACTUALIZA
        if(snake.size()==0){
            b = new BodyPart(x,y);       //Si la serpiente no tiene nada, creamos una parte y se la añadimos
            snake.add(b);
        }
        if(apples.size()==0){
            int x = r.nextInt(59);          //Porque hay 79 cuadrados
            int y = r.nextInt(59);
            a = new Apple(x,y);
            apples.add(a);
        }
        for(int i = 0;i<apples.size();i++){
            if(x == apples.get(i).getX() && y == apples.get(i).getY()){
                size++;
                apples.remove(i);
                i--;
                points += 50;
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
        if(ticks>250000){
            if(right) x++;
            if(left) x--;                   //Dependiendo del booleano que esta activado pinta en una direccion u otra
            if(up) y--;
            if(down) y++;
            
            ticks = 0;
            
            b = new BodyPart(x,y);       //Creamos cuerpos (cuadrados) hacia la direccion que este activa
            snake.add(b);
            
            if(snake.size()>size){          //Borramos el final de la serpiente
                snake.remove(0);
            }
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public ArrayList<BodyPart> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<BodyPart> snake) {
        this.snake = snake;
    }

    public ArrayList<Apple> getApples() {
        return apples;
    }

    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }
    
}
