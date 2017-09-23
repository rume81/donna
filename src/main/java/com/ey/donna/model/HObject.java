package com.ey.donna.model;

import java.util.Date;

public class HObject {
    private boolean isdeleted;
    private String modifiedby;
    private Date instime;
    private Date modifiedtime;
    
    
    public boolean isIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getInstime() {
        return instime;
    }

    public void setInstime(Date instime) {
        this.instime = instime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }
    
    protected String convertFilePath(String path){
		String formatedPath = "";
		for(int i=0;i<path.length();i++)
		{
			if(path.charAt(i) == '\\')
				formatedPath = formatedPath + '/';
			else
				formatedPath = formatedPath + path.charAt(i);
		}
		
		return formatedPath;	
	}
    
    
}
