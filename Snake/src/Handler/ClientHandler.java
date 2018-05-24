package Handler;

import Comunication.Header;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DiegoPC
 */
public class ClientHandler extends Handler{
    
    
    public ClientHandler(Socket socket, DataInputStream in, DataOutputStream out) {
        this.dataSocket = socket;
        this.input = in;
        this.output = out;
    }
    
    
    @Override
    public void run(){
        
        String line = " ";
        while(!Header.FIN.toString().equals(line)){
            try {
                line = "Servidor >> " + input.readUTF();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(line!= null)
                System.out.println(line);
        }

    }
    

    
    
}
