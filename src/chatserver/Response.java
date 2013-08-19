package chatserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.activation.MimetypesFileTypeMap;

public class Response {
    private String protocol = "HTTP";
    private String protocolVer = "1.1";
    private String location;
    private Integer status;
    private String textStatus;
    private String contentLanguage;
    private String contentType;
    private String data;
    private String resource;
    private Request currentRequest;
    private String serverRoot;

    public Response(Request reqest, String servRoot) {
        this.currentRequest = reqest;
        this.serverRoot = servRoot;
        File file = new File(this.serverRoot + File.separator + this.currentRequest.getResource());
        if (!file.exists()){
            this.makeNotFound();
        }else{
            this.setStatus(0);
        }        
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @return the protocolVer
     */
    public String getProtocolVer() {
        return protocolVer;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the textStatus
     */
    public String getTextStatus() {
        switch (this.getStatus()){
            case 200:
                return "OK";
            case 202:
                return "Accepted";
            case 404:
                return "Not Found";
            default:
                return "Internal Server Error";
        }
    }

    /**
     * @return the date
     */
    public String getDate() {
        //Thu, 19 Feb 2009 11:08:01 GMT
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        Date date = new Date();
        return "Date: " + dateFormat.format(date);
    }

    /**
     * @return the contentLanguage
     */
    public String getContentLanguage() {
        return contentLanguage;
    }

    /**
     * @param contentLanguage the contentLanguage to set
     */
    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFirstLine(){
        return this.getProtocol() + "/" + this.getProtocolVer() + " " + this.getFullStatus() + "\n";
    }

    private String getFullStatus() {
        return this.getStatus() + " " + this.getTextStatus();
    }
    
    public void setResource(String resource){
        this.resource = resource;
    }
    
    public String getLocation(){
        return "Location: " + this.currentRequest.getHost() + this.currentRequest.getResource() + "\n";
    }
    
    public String getClientResponse() throws FileNotFoundException, IOException{
        StringBuilder clientResp = new StringBuilder();
        clientResp.append(this.getFirstLine());
        clientResp.append(this.getLocation());
        clientResp.append(this.getDate());
        clientResp.append(this.getResource());
        
        return clientResp.toString();
    }
    
    private String getResource() throws FileNotFoundException, IOException{
        StringBuilder res = new StringBuilder();
        res.append(this.getContentType());//? System.lineSeparator
        res.append("\r\n\r\n");//? System.lineSeparator
        String s;
        BufferedReader in = new BufferedReader(new FileReader(this.serverRoot + File.separator + this.currentRequest.getResource()));
        while((s = in.readLine()) != null) {
                s += "\r\n";
                res.append(new String(s.getBytes(),"UTF-8"));
        }
        return res.toString();
    }
    
    private String getContentType(){
        File f = new File(this.serverRoot + File.separator + this.currentRequest.getResource());
        return "Content-Type: " + new MimetypesFileTypeMap().getContentType(f).toString() + "; charset=utf-8";
    }
    
    private void makeBadRequest(){
        //TODO to other domain layer
    }
    
    private void makeNotFound(){
        //TODO to other domain layer
        this.setStatus(404);
    }
}
