package com.qht.model;

import java.io.Serializable;

public class LoginResultModel implements Serializable{	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7517522955101884170L;
	/**
     * token
     */
    protected String token;
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "LoginResultModel [token=" + token + "]";
	}  
	
	
    
}
