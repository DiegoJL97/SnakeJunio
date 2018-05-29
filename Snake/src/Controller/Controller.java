/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Comunication.Header;
import Comunication.Packet;
import Handler.ClientHandler;
import Model.Game;
import View.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DiegoPC
 */
public class Controller implements KeyListener{
    
    private Game game;
    private Frame view;
    private BotController botController;
    private ClientHandler handler;
    
    public Controller(Game field, ClientHandler handler){
        this.game = field;
        this.view = new Frame(this);  
        this.botController = new BotController(field);
        this.handler = handler;
    }

    public Game getGame() {
        return game;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
            
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
       
       
       List<String> args = new ArrayList<>();
       Header header = Header.DIR;
       Packet packet = new Packet(header);
       
       if(key == KeyEvent.VK_RIGHT && !game.getSnakePlayer().isLeft()){
           game.getSnakePlayer().setUp(false);
           game.getSnakePlayer().setDown(false);
           game.getSnakePlayer().setRight(true);
           args.add("DERECHA");
       }
       if(key == KeyEvent.VK_LEFT && !game.getSnakePlayer().isRight()){
           game.getSnakePlayer().setUp(false);
           game.getSnakePlayer().setDown(false);
           game.getSnakePlayer().setLeft(true);
           args.add("IZQUIERDA");
       }
       if(key == KeyEvent.VK_UP && !game.getSnakePlayer().isDown()){
           game.getSnakePlayer().setRight(false);
           game.getSnakePlayer().setLeft(false);
           game.getSnakePlayer().setUp(true);
           args.add("ARRIBA");
       }
       if(key == KeyEvent.VK_DOWN && !game.getSnakePlayer().isUp()){
           game.getSnakePlayer().setRight(false);
           game.getSnakePlayer().setLeft(false);
           game.getSnakePlayer().setDown(true);
           args.add("ABAJO");
       }
       
       packet.setArgs(args);
       handler.sendMessage(packet.getCraftedPacket());
       
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
