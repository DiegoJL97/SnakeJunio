/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Controller.Controller;
import Handler.ClientHandler;
import Interface.iSnake;
import Model.Field;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Daniel
 */
public class Client implements iSnake{
    
    public static void main(String[] args) throws IOException{
        
        Socket s = null;
        
        try {
            s = new Socket(HOST,PORT);
        } catch (UnknownHostException ex) {
            System.err.println("No se encuentra el host en: " + HOST + " " + PORT);
            System.exit(1);
        }
        
        ClientHandler client = new ClientHandler(s, new DataInputStream(s.getInputStream()), new DataOutputStream(s.getOutputStream()));
        client.start();
        
        Field game = new Field();
        Controller controller = new Controller(game);
        //BotController botController = new BotController(game);
        //new Table().setVisible(true);
    }
    
}
