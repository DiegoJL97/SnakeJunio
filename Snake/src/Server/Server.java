/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Handler.ServerHandler;
import Interface.iSnake;
import Model.Game;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class Server implements iSnake{
    
    public static Game game;
    
    public static void main(String[] args) throws IOException{
        game = new Game();
        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("Inicializado el servidor!");
        try{
            //bucle infinito que escucha la conexion al servidor
            while(true){
                System.out.println("Esperando nueva conexion al servidor!");
                Socket socket = listener.accept();
                ServerHandler server = new ServerHandler(socket, new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()));
                server.start();
            }
        }
        catch(IOException e){
            System.err.println("Fallo al aceptar la conexion!");
            System.exit(1);
        }
        
        //cerrar el servidor
        finally {
            try {
                Objects.requireNonNull(listener).close();
            }
            catch (IOException e){
                System.err.println("No puedo cerrar el puerto");
                System.exit(1);
            }
        }
        
    }}
