/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunication;

import java.util.List;

/**
 *
 * @author Daniel
 */
public class Packet {
    
    
    protected Header header;
    
    protected List<String> args;

    public Packet(Header header, List<String> args) {
        this.header = header;
        this.args = args;
    }
    
    public Packet(Header header){
        this.header = header;
    }
    
    public String getCraftedPacket(){
        String packet = header.toString() + "; ";
        for(String arg : args){
            packet = packet.concat(arg) + ";";
        }
        return packet;
    }
    
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
    
}
