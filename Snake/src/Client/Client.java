package Client;


import Controller.BotController;
import Controller.Controller;
import Model.Field;
import View.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DiegoPC
 */
public class Client {
    
    public static void main(String[] args){
        
        Field game = new Field();
        Controller controller = new Controller(game);
        //BotController botController = new BotController(game);
        //new Table().setVisible(true);
        
    }
    
}
