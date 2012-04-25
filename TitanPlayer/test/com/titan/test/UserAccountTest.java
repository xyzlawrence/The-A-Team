/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.test;

import com.titan.bll.User;
import com.titan.dacl.DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Brandon
 */
public class UserAccountTest {
    
    public UserAccountTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void userAccountCreated(){
        char[] pwd = {'v' + 'v'};
        User newAccount = new User("Username", "HIDDSA", pwd);
        assertEquals(newAccount.getUsername(), "Username");
    }
    
    @Test
    public void userAccountSaveDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception{
        char[] pwd = {'v' + 'v'};
        User newAccount = new User("Test", "Y@yahoo.com", pwd);
        assertEquals(newAccount.getUsername(), "Test");
        String dbURL = "jdbc:derby://localhost:1527/TitanPlayer;create=true;user=Admin;password=Admin";
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Connection conn = DriverManager.getConnection(dbURL);
        DataAccess.save(newAccount,conn);
                }
    
    @Test
    public void userAccountLoadDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception{
         
        
        String dbURL = "jdbc:derby://localhost:1527/TitanPlayer;create=true;user=Admin;password=Admin";
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Connection conn = DriverManager.getConnection(dbURL);
        User loadAccount = DataAccess.load("Test", conn);
        assertEquals(loadAccount.getUsername(), "Test");
                }
    
    
}
