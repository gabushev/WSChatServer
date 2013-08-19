/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;


/**
 *
 * @author Admin
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        WebServer ws = new WebServer();
        ws.start();
        ChatServerMediator chs = new ChatServerMediator();
        chs.start();
    }
}
