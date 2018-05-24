/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Apple;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DiegoPC
 */
public class AppleView extends Apple{
    
    private int width,height;
    
    public AppleView(int x, int y, int size) {
        super(x, y);
        this.width = size;
        this.height = size;
        
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(getX() * width,getY() * height, width, height);
    }
    
}
