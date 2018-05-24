/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Interface.iHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Daniel
 */
public abstract class Handler extends Thread implements iHandler{
    
    
    protected Socket dataSocket;
    protected DataInputStream input;
    protected DataOutputStream output;
    
    @Override
    public String readMessage(){
        String line = null;
        try {
            line = input.readUTF();
        } 
        catch (IOException ex){}
        
        return line;            
    }
    
    
    
    @Override
    public void sendMessage(String message){
        try {
            output.writeUTF(message);
        } 
        catch (IOException ex){}        
    }
    
}
