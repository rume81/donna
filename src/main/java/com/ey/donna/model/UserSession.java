package com.ey.donna.model;

public class UserSession {
    private int sessionId;
    private String clientIpAddress;
        
    protected HMember user = null;
    
    public int getSessionId() {
        return sessionId;
    }
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
    public String getClientIpAddress() {
        return clientIpAddress;
    }
    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }
    public HMember getUser() {
        return user;
    }
    public void setUser(HMember user) {
        this.user = user;
    }
}
