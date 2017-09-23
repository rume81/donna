package com.ey.donna.dao.interfaces;

import com.ey.donna.model.Session;

public interface ISessionDAO {
	
	public int getSessionLastId();
	
	public int insertSession(Session session)  throws Exception;
}
