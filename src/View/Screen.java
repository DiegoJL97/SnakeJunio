package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author DiegoPC
 */
public class Screen extends JPanel implements Runnable {        //JUEGO
    
    public static final int WIDTH = 600, HEIGHT = 600;
    
    private Controller controller;
    
    private Thread thread;
    private Boolean running = false;
 
    
    public Screen(Controller controller){
        setFocusable(true);
        addKeyListener(controller);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));          //ESTABLECER TAMAÑO PANTALLA
        this.controller = controller;
        start();
    }
    
    @Override
    public void paint(Graphics g){                              //DIBUJA EL TABLERO DE LA SERPIENTE
        g.clearRect(0, 0, WIDTH, HEIGHT);                       //Borra el cuerpo de la serpiente del final
        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        for(int i = 0;i < WIDTH/10;i++){
            g.drawLine(i*10,0,i*10,HEIGHT);                     //DIBUJA LAS LINEAS EN VERTICAL
        }
        for(int i = 0;i < HEIGHT/10;i++){
            g.drawLine(0,i*10,WIDTH,i*10);                      //DIBUJA LAS LINEAS EN HORIZONTAL
        }
        for(int i = 0;i < controller.getGame().getSnake().size();i++){                    //DIBUJA LA SERPIENTE
            BodyPartView b = new BodyPartView(controller.getGame().getSnake().get(i).getX(),controller.getGame().getSnake().get(i).getY(),10);
            b.draw(g);
        }
        for(int i = 0;i<controller.getGame().getApples().size();i++){
            AppleView a = new AppleView(controller.getGame().getApples().get(i).getX(),controller.getGame().getApples().get(i).getY(),10);
            a.draw(g);
        }
    }
  
    public void start(){
        running = true;
        thread = new Thread(this,"Hilo del juego");             //CREAMOS HILO DEL JUEGO DE LA CLASE SCREEN
        thread.start();
    }
    
    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(running){
            controller.getGame().tick();
            repaint();
        }
    }
    
}
