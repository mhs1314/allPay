package com.qht.auth.util;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;
    /**
     * 1-平台,2-运营商,3-教师,4-学生
     */
    private int type;


    public JwtAuthenticationRequest(String username, String password,int type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public JwtAuthenticationRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
    
}
