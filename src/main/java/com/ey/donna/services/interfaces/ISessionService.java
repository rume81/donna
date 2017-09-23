package com.ey.donna.services.interfaces;

import javax.servlet.http.HttpServletRequest;

import com.ey.donna.model.HMember;
import com.ey.donna.model.UserSession;


public interface ISessionService {
    public UserSession insertSession(HttpServletRequest request,HMember user)  throws Exception;
	
    public boolean isSessionValid();

    public void invalidateSession(int sessionId);
	
    public UserSession getUserSession();
	
    //public void setEmployee(HEmployee emp);
}
