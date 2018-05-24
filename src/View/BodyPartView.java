/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BodyPart;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DiegoPC
 */
public class BodyPartView extends BodyPart{
    
    private int width,heigth;
    
    public BodyPartView(int x, int y, int size) {
        super(x, y);
        this.width = size;
        this.heigth = size;
    }
    
    public void draw(Graphics g){       //PINTA LA SERPIENTE
        g.setColor(Color.BLACK);
        g.fillRect(getX() * width ,getY() * heigth, width, heigth);
        g.setColor(Color.GREEN);
        g.fillRect(getX() * width + 2,getY() * heigth + 2, width - 4, heigth - 4);
    }
    
}
