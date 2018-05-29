/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author DiegoPC
 */
public class GeneralView {
    
    private Frame view;
    private Controller controller;
    
    public GeneralView(Controller controller){
        this.controller = controller;
        String bots = JOptionPane.showInputDialog("Introduce el numero de bots que quieres");
        this.view = new Frame(controller);  
        controller.getGame().setNumberBots(bots);
    }

}
