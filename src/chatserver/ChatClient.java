/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Admin
 */
public class ChatClient extends Thread{
    private Socket client = null;
    private ChatServerMediator mediator;
    private OutputStream outStream = null;
    private InputStream inStream = null;
    //defined in spec
    private String charset = "utf-8";
    private final static String MAGIC_KEY = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private Integer clientId = null;
    private String username = "";

    public ChatClient(Socket clientSocket, Integer newId, ChatServerMediator owner) throws IOException, NoSuchAlgorithmException {
        this.client = clientSocket;
        this.clientId = newId;
        this.inStream = this.client.getInputStream();
        this.outStream = this.client.getOutputStream();
        this.mediator = owner;
        byte buf[] = new byte[64*1024];
        int r = inStream.read(buf);
        String data = new String(buf, 0, r);
        String[] raws = data.split("\\r\\n");
        String key = null;
        for (int i=0; i<raws.length; i++){
            if (raws[i].indexOf("Sec-WebSocket-Key")>-1){
                key = raws[i].replace("Sec-WebSocket-Key: ", "");
            }
        }
        this.setUsername("User"+ this.getClientId().toString());
        outStream.write((
                "HTTP/1.1 101 Switching Protocols\r\n"+
                "Upgrade: WebSocket\r\n"+
                "Connection: Upgrade\r\n"+
                "Sec-WebSocket-Accept: "+
                this.getKey(key) +
                "\r\n\r\n" + this.getKey(key)
                ).getBytes());
        outStream.flush();
    }
    
    public void setUsername(String name){
        this.username = name;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public Integer getClientId(){
        return this.clientId;
    }
    
    public void setCharset(String encoding){
        this.charset = encoding;
    }
    
    public String getCharset(){
        return this.charset;
    }
    
    private String getKey(String strWebSocketKey) throws 
           NoSuchAlgorithmException {

     strWebSocketKey += MAGIC_KEY;

     MessageDigest shaMD = MessageDigest.getInstance("SHA-1");
     shaMD.reset();
     shaMD.update(strWebSocketKey.getBytes());
     byte messageDigest[] = shaMD.digest();
     BASE64Encoder b64 = new BASE64Encoder();

     return b64.encode(messageDigest);
     }
    
    @Override
    public void run() {
        try {
            this.userLogin();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        int len = 0;            
        int bufLen = 64*1024;
        byte[] b = new byte[bufLen];
        while(true){
            try {
                len = this.inStream.read(b);
                if(len!=-1){

                    byte rLength = 0;
                    int rMaskIndex = 2;
                    int rDataStart = 0;
                    //b[0] is always text in my case so no need to check;
                    byte data = b[1];
                    byte op = (byte) 127;
                    rLength = (byte) (data & op);

                    if(rLength==(byte)126) rMaskIndex=4;
                    if(rLength==(byte)127) rMaskIndex=10;

                    byte[] masks = new byte[4];

                    int j=0;
                    int i=0;
                    for(i=rMaskIndex;i<(rMaskIndex+4);i++){
                        masks[j] = b[i];
                        j++;
                    }

                    rDataStart = rMaskIndex + 4;

                    int messLen = len - rDataStart;

                    byte[] message = new byte[messLen];

                    for(i=rDataStart, j=0; i<len; i++, j++){
                        message[j] = (byte) (b[i] ^ masks[j % 4]);
                    }
                    String tmpMessage = new String(message);
                    if (tmpMessage.indexOf("command:")==0){
                        String[] commandPair = message.toString().split("^command:")[0].split(":");
                        if (commandPair[0].equals("setName")){
                            this.setName(commandPair[1]);
                        }
                        if (commandPair[0].equals("setCharset")){
                            this.setName(commandPair[1]);
                        }
                    }else{
                        this.mediator.sendToAll(tmpMessage, this.getCharset());
                    }
                    tmpMessage = null;
                    b = new byte[bufLen];
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void destroy() {
        try {
            this.userLogout();
            super.destroy();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(String msg) throws IOException{
        byte[] mes = this.brodcast(msg);
        this.outStream.write( new String("0x00" + msg + "0xFF").getBytes());
                //(mes, 0, mes.length);
                //(this.brodcast(msg));
        this.outStream.flush();
    }    
    
    private byte[] brodcast(String mess) throws IOException{
    byte[] rawData = mess.getBytes();

    int frameCount  = 0;
    byte[] frame = new byte[10];

    frame[0] = (byte) 129;

    if(rawData.length <= 125){
        frame[1] = (byte) rawData.length;
        frameCount = 2;
    }else if(rawData.length >= 126 && rawData.length <= 65535){
        frame[1] = (byte) 126;
        byte len = (byte) rawData.length;
        frame[2] = (byte)((len >> 8 ) & (byte)255);
        frame[3] = (byte)(len & (byte)255); 
        frameCount = 4;
    }else{
        frame[1] = (byte) 127;
        byte len = (byte) rawData.length;
        frame[2] = (byte)((len >> 56 ) & (byte)255);
        frame[3] = (byte)((len >> 48 ) & (byte)255);
        frame[4] = (byte)((len >> 40 ) & (byte)255);
        frame[5] = (byte)((len >> 32 ) & (byte)255);
        frame[6] = (byte)((len >> 24 ) & (byte)255);
        frame[7] = (byte)((len >> 16 ) & (byte)255);
        frame[8] = (byte)((len >> 8 ) & (byte)255);
        frame[9] = (byte)(len & (byte)255);
        frameCount = 10;
    }

    int bLength = frameCount + rawData.length;

    byte[] reply = new byte[bLength];

    int bLim = 0;
    for(int i=0; i<frameCount;i++){
        reply[bLim] = frame[i];
        bLim++;
    }
    for(int i=0; i<rawData.length;i++){
        reply[bLim] = rawData[i];
        bLim++;
    }
        return reply; 
    }
    
    public void userLogin() throws IOException{
        this.mediator.sendToAll("User "+this.getUsername() + " has login", this.getCharset());
    }
    
    public void userLogout() throws IOException{
        this.mediator.userDelete(this.getClientId());
        this.mediator.sendToAll("User "+this.getUsername() + " has logout", this.getCharset());
    }

}
