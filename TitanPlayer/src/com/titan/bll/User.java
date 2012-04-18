/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.bll;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class User {
    
    protected String username;
    protected String email;
    protected String password;      
    protected boolean enabled;
    protected List<String> auths = new ArrayList<String>();

    
    public User(String username, String email, String password, boolean enabled){
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void addAuths(String auth){
        auths.add(auth);
    }

    public List<String> getAuths() {
        return auths;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
