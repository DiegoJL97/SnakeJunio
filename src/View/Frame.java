package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.Controller;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author DiegoPC
 */
public class Frame extends JFrame{          //VENTANA PRINCIPAL DEL JUEGO
    
    private Controller controller;
    
    public Frame(Controller controller){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //CUANDO PULSAS X CIERRA TODO EL PROGRAMA
        setTitle("Snake Multijugador");
        setResizable(false);                                //PARA QUE NO SE CAMBIE TAMAÑO VENTANA
        this.controller = controller;
        init();
    }
    
    public void init(){                     //METODO PARA INICIALIZAR
        setLayout(new GridLayout(1,1,0,0));
        
        Screen s = new Screen(controller);
        add(s);
        
        pack();                         //Para ajustar Jframe a la pantalla del juego
        
        setLocationRelativeTo(null);    //Centra la pantalla 
        setVisible(true);
    }
    
}
