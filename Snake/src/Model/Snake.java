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
public class Snake {
    
    protected BodyPart b;
    protected ArrayList<BodyPart> snake;
    
    protected Integer points;
    
    private int x = 10, y = 10;
    protected int size = 5; 
    
    Random ran;
    
    private boolean right = true, left = false, up = false, down = false;
    
    public Snake(){
        this.ran = new Random();
        this.snake = new ArrayList<>();
        this.points = 0;
        x = 10;//ran.nextInt(59);          //Porque hay 79 cuadrados
        y = ran.nextInt(59);
    }

    public ArrayList<BodyPart> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<BodyPart> snake) {
        this.snake = snake;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
    
    public void addToSnake(){
        b = new BodyPart(x,y);       //Si la serpiente no tiene nada, creamos una parte y se la añadimos
        snake.add(b);
    }
    
    public void addPoints(){
        points += 50;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void addSize(){
        size++;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
    
    
    
}
