/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;


import Comunication.Header;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;




/**
 *
 * @author Daniel
 */
public class ServerHandler extends Handler{
    
    

    private boolean playing;
    
    public ServerHandler(Socket socket, DataInputStream in, DataOutputStream out) {
        this.dataSocket = socket;
        this.input = in;
        this.output = out;
        System.out.println("Componentes iniciados correctamente!");
    }

    
    
    
    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
       
        System.out.println("Lanzando nuevo hilo para el jugador!");
        sendMessage("Bienvenido al server!!");
        
        
        playing = true;

        while(playing){
            String line = "Cliente >> " + readMessage();
            if(line == null) continue;
            System.out.println(line);
            if(line.equals(Header.FIN.toString()))
                break;
        }
       
        
        
        //////////////////////
        // close the listener //
        //                  //
        //                  //
        // close the listener // 
        //////////////////////
        try {
            output.close();
            input.close();
        } catch (IOException ex) {
            System.err.println("Error cerrando los componentes!");;
        }
        
    }
    

    
    
    
}
