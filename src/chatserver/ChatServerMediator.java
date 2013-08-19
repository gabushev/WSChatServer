/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ChatServerMediator extends Thread{
    private static final int serverPort = 5000;
    private ServerSocket serverSock = null;
    private Socket accepted = null;
    private Map clientList = new HashMap();
    public AtomicInteger cnt = new AtomicInteger(0);
   
    public ChatServerMediator() {
    }

    @Override
    public void run() {
        try {
            this.serverSock = new ServerSocket(serverPort);
        } catch (IOException ex) {
            Logger.getLogger(ChatServerMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            try {
                int newClientIndex = this.cnt.incrementAndGet();
                ChatClient newClient = new ChatClient(this.serverSock.accept(), newClientIndex, this) ;
                newClient.start();
                this.clientList.put(newClientIndex, newClient);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ChatServerMediator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChatServerMediator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sendToAll(String message, String encoding) throws IOException{
        for (ChatClient val : (Collection<ChatClient>)this.clientList.values()) {
            System.out.println(message);
            val.sendMessage(new String(new String(message.getBytes(), encoding).getBytes(val.getCharset())));
        }
    }
    
    public void userDelete(Integer userId){
        this.clientList.remove(userId);
        this.cnt.decrementAndGet();
    }
    
    
}
