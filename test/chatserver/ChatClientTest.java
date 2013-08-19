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
public class ChatClientTest {
    
    public ChatClientTest() {
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
     * Test of setUsername method, of class ChatClient.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String name = "";
        ChatClient instance = null;
        instance.setUsername(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class ChatClient.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        ChatClient instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientId method, of class ChatClient.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        ChatClient instance = null;
        Integer expResult = null;
        Integer result = instance.getClientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class ChatClient.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ChatClient instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ChatClient.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        ChatClient instance = null;
        instance.destroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class ChatClient.
     */
    @Test
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        String msg = "";
        ChatClient instance = null;
        instance.sendMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLogin method, of class ChatClient.
     */
    @Test
    public void testUserLogin() throws Exception {
        System.out.println("userLogin");
        ChatClient instance = null;
        instance.userLogin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userLogout method, of class ChatClient.
     */
    @Test
    public void testUserLogout() throws Exception {
        System.out.println("userLogout");
        ChatClient instance = null;
        instance.userLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
