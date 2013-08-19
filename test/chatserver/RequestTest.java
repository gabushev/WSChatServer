/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class RequestTest {
    
    public RequestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRequestData method, of class Request.
     */
    @Test
    public void testGetRequestData() {
        System.out.println("getRequestData");
        Request instance = null;
        String expResult = "";
        String result = instance.getRequestData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHttpMethod method, of class Request.
     */
    @Test
    public void testGetHttpMethod() {
        System.out.println("getHttpMethod");
        Request instance = null;
        String expResult = "";
        String result = instance.getHttpMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHttpMethod method, of class Request.
     */
    @Test
    public void testSetHttpMethod() {
        System.out.println("setHttpMethod");
        String method = "";
        Request instance = null;
        instance.setHttpMethod(method);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResource method, of class Request.
     */
    @Test
    public void testGetResource() {
        System.out.println("getResource");
        Request instance = null;
        String expResult = "";
        String result = instance.getResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResource method, of class Request.
     */
    @Test
    public void testSetResource() {
        System.out.println("setResource");
        String resource = "";
        Request instance = null;
        instance.setResource(resource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocol method, of class Request.
     */
    @Test
    public void testGetProtocol() {
        System.out.println("getProtocol");
        Request instance = null;
        String expResult = "";
        String result = instance.getProtocol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProtocol method, of class Request.
     */
    @Test
    public void testSetProtocol() {
        System.out.println("setProtocol");
        String protocol = "";
        Request instance = null;
        instance.setProtocol(protocol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolVersion method, of class Request.
     */
    @Test
    public void testGetProtocolVersion() {
        System.out.println("getProtocolVersion");
        Request instance = null;
        String expResult = "";
        String result = instance.getProtocolVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProtocolVersion method, of class Request.
     */
    @Test
    public void testSetProtocolVersion() {
        System.out.println("setProtocolVersion");
        String protocolVersion = "";
        Request instance = null;
        instance.setProtocolVersion(protocolVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHost method, of class Request.
     */
    @Test
    public void testGetHost() {
        System.out.println("getHost");
        Request instance = null;
        String expResult = "";
        String result = instance.getHost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHost method, of class Request.
     */
    @Test
    public void testSetHost() {
        System.out.println("setHost");
        String host = "";
        Request instance = null;
        instance.setHost(host);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserAgent method, of class Request.
     */
    @Test
    public void testGetUserAgent() {
        System.out.println("getUserAgent");
        Request instance = null;
        String expResult = "";
        String result = instance.getUserAgent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserAgent method, of class Request.
     */
    @Test
    public void testSetUserAgent() {
        System.out.println("setUserAgent");
        String userAgent = "";
        Request instance = null;
        instance.setUserAgent(userAgent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccept method, of class Request.
     */
    @Test
    public void testGetAccept() {
        System.out.println("getAccept");
        Request instance = null;
        String expResult = "";
        String result = instance.getAccept();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccept method, of class Request.
     */
    @Test
    public void testSetAccept() {
        System.out.println("setAccept");
        String accept = "";
        Request instance = null;
        instance.setAccept(accept);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAcceptLanguage method, of class Request.
     */
    @Test
    public void testGetAcceptLanguage() {
        System.out.println("getAcceptLanguage");
        Request instance = null;
        String expResult = "";
        String result = instance.getAcceptLanguage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcceptLanguage method, of class Request.
     */
    @Test
    public void testSetAcceptLanguage() {
        System.out.println("setAcceptLanguage");
        String acceptLanguage = "";
        Request instance = null;
        instance.setAcceptLanguage(acceptLanguage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAcceptEncoding method, of class Request.
     */
    @Test
    public void testGetAcceptEncoding() {
        System.out.println("getAcceptEncoding");
        Request instance = null;
        String expResult = "";
        String result = instance.getAcceptEncoding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcceptEncoding method, of class Request.
     */
    @Test
    public void testSetAcceptEncoding() {
        System.out.println("setAcceptEncoding");
        String acceptEncoding = "";
        Request instance = null;
        instance.setAcceptEncoding(acceptEncoding);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class Request.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Request instance = null;
        String expResult = "";
        String result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConnection method, of class Request.
     */
    @Test
    public void testSetConnection() {
        System.out.println("setConnection");
        String connection = "";
        Request instance = null;
        instance.setConnection(connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCookie method, of class Request.
     */
    @Test
    public void testGetCookie() {
        System.out.println("getCookie");
        String cookieName = "";
        Request instance = null;
        String expResult = "";
        String result = instance.getCookie(cookieName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCookie method, of class Request.
     */
    @Test
    public void testSetCookie() {
        System.out.println("setCookie");
        String cookies = "";
        Request instance = null;
        instance.setCookie(cookies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCacheControl method, of class Request.
     */
    @Test
    public void testGetCacheControl() {
        System.out.println("getCacheControl");
        Request instance = null;
        String expResult = "";
        String result = instance.getCacheControl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCacheControl method, of class Request.
     */
    @Test
    public void testSetCacheControl() {
        System.out.println("setCacheControl");
        String cacheControl = "";
        Request instance = null;
        instance.setCacheControl(cacheControl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
