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
public class ResponseTest {
    
    public ResponseTest() {
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
     * Test of getProtocol method, of class Response.
     */
    @Test
    public void testGetProtocol() {
        System.out.println("getProtocol");
        Response instance = null;
        String expResult = "";
        String result = instance.getProtocol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolVer method, of class Response.
     */
    @Test
    public void testGetProtocolVer() {
        System.out.println("getProtocolVer");
        Response instance = null;
        String expResult = "";
        String result = instance.getProtocolVer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Response.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Response instance = null;
        Integer expResult = null;
        Integer result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Response.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Integer status = null;
        Response instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextStatus method, of class Response.
     */
    @Test
    public void testGetTextStatus() {
        System.out.println("getTextStatus");
        Response instance = null;
        String expResult = "";
        String result = instance.getTextStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Response.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Response instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContentLanguage method, of class Response.
     */
    @Test
    public void testGetContentLanguage() {
        System.out.println("getContentLanguage");
        Response instance = null;
        String expResult = "";
        String result = instance.getContentLanguage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContentLanguage method, of class Response.
     */
    @Test
    public void testSetContentLanguage() {
        System.out.println("setContentLanguage");
        String contentLanguage = "";
        Response instance = null;
        instance.setContentLanguage(contentLanguage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContentType method, of class Response.
     */
    @Test
    public void testSetContentType() {
        System.out.println("setContentType");
        String contentType = "";
        Response instance = null;
        instance.setContentType(contentType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstLine method, of class Response.
     */
    @Test
    public void testGetFirstLine() {
        System.out.println("getFirstLine");
        Response instance = null;
        String expResult = "";
        String result = instance.getFirstLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResource method, of class Response.
     */
    @Test
    public void testSetResource() {
        System.out.println("setResource");
        String resource = "";
        Response instance = null;
        instance.setResource(resource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Response.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Response instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientResponse method, of class Response.
     */
    @Test
    public void testGetClientResponse() throws Exception {
        System.out.println("getClientResponse");
        Response instance = null;
        String expResult = "";
        String result = instance.getClientResponse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
