/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunication;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    
    
    
    public static Packet getPacketFromString(String message){
        
        StringTokenizer tokenizer = new StringTokenizer(message);
        
        Header header = Header.valueOf(tokenizer.nextToken(";"));
        
        List<String> args = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            args.add(tokenizer.nextToken(";"));
        }
        return new Packet(header,args);
    }
    
    
}
