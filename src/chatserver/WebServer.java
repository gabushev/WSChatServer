/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class WebServer extends Thread {
    private ServerSocket serverSock = null;
    private Socket accepted = null;
    private Request clientRequest = null;
    private final int serverPort = 80;
    //this value must be changet to current path with test files
    private final String webServerRootDir = "D:\\index";
    
    public WebServer() {
        try {
            this.serverSock = new ServerSocket(serverPort);
        } catch (IOException ex) {
            Logger.getLogger(ChatServerMediator.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Http server started");
    }

    @Override
    public void run() {
        
        while(true){
            try {
                this.accepted = this.serverSock.accept();
                InputStream is = this.accepted.getInputStream();
                OutputStream os = this.accepted.getOutputStream();
                byte buf[] = new byte[64*1024];
                int r = is.read(buf);
                if (r!=-1){
                    this.clientRequest = new Request(new String(buf, 0, r));
                    Response resp = new Response(clientRequest, this.webServerRootDir);
                    os.write(resp.getClientResponse().getBytes());
                    this.accepted.close();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChatServerMediator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}