/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Request {
    private String httpMethod;
    private String resource;
    private String protocol;
    private String protocolVersion;
    private String host;
    private String userAgent;
    private String accept;
    private String acceptLanguage;
    private String acceptEncoding;
    private String connection;
    private HashMap<String, String> cookie = new HashMap<String, String>();
    private String cacheControl;
    private String requestData;

    public Request(String dataRequest) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        this.requestData = dataRequest;
        String[] requestAsArray = dataRequest.split("\\n");
        String[] firstLine = requestAsArray[0].split(" ");
        this.setHttpMethod(firstLine[0]);
        this.setResource(firstLine[1]);
        this.setProtocol(firstLine[2].split("/")[0]);
        this.setProtocolVersion(firstLine[2].split("/")[1]);
        this.setHeaders(requestAsArray);
    }
    
    private void setHeaders(String[] data) throws InvocationTargetException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
        int len = data.length;
        String str = "";
        String fld = "";
        String nativeFld = "";
        Method ref;
        Class reflectionClass = Class.forName("chatserver.Request");
        for (int i=1; i<len; i++){
            //preparing input data - somtimes crash on empty strings (why? todo)
            str = data[i].replaceAll("\r|\n", "");
            if (!str.isEmpty()){
                try{
                    nativeFld = str.split("\\:")[0].toString();
                    if (nativeFld.indexOf("-")>0){
                        StringBuilder builder = new StringBuilder();
                        for(String s : nativeFld.split("\\-")) {
                            builder.append(s);
                        }
                        fld = builder.toString();
                        builder = null;
                    }else{
                        fld = nativeFld;
                    }
                    ref = reflectionClass.getMethod("set" + fld, String.class);
                    String args = str.replace(nativeFld + ": ", "");
                    ref.invoke(this, args);
                    fld = null;
                    nativeFld = null;
                    str = null;
                }catch(NoSuchMethodException ex){
                    System.out.println("set" + nativeFld + " is not exist");
                }
            }
        }
    }
    
    public String getRequestData(){
        return this.requestData;
    }
    
    /**
     * @return the httpMethod
     */
    public String getHttpMethod() {
        return this.httpMethod;
    }

    /**
     * @param method the httpMethod to set
     */
    public void setHttpMethod(String method) {
        this.httpMethod = method;
    }

    /**
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol the protocol to set
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return the protocolVersion
     */
    public String getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * @param protocolVersion the protocolVersion to set
     */
    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the accept
     */
    public String getAccept() {
        return accept;
    }

    /**
     * @param accept the accept to set
     */
    public void setAccept(String accept) {
        this.accept = accept;
    }

    /**
     * @return the acceptLanguage
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * @param acceptLanguage the acceptLanguage to set
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    /**
     * @return the acceptEncoding
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * @param acceptEncoding the acceptEncoding to set
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    /**
     * @return the connection
     */
    public String getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(String connection) {
        this.connection = connection;
    }

    /**
     * @return the cookie
     */
    public String getCookie(String cookieName) {
        return cookie.get(cookieName);
    }

    /**
     * @param cookie the cookie to set
     */
    public void setCookie(String cookies) {
        String[] cookiesArray = cookies.split("; ");
        String[] thisCookie;
        for (int i=0; i<cookiesArray.length; i++){
            thisCookie = cookiesArray[i].split("=");
            this.cookie.put(thisCookie[0], thisCookie[1]);
            thisCookie = null;
        }
        cookiesArray = null;
    }
    /**
     * @return the cache
     */
    public String getCacheControl() {
        return cacheControl;
    }

    /**
     * @param cache the cache to set
     */
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }
}
