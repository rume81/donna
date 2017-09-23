package com.ey.donna.model;

import java.util.Date;

public class HTransactionLog extends HObject {
    private String tsid;
    private Date dtts;
    private String action;
    private String actionid;
    private String location;
    private String updatedinfo;
    private String previousinfo;
    private String changeby;
    
    public String getTsid() {
        return tsid;
    }
    public void setTsid(String tsid) {
        this.tsid = tsid;
    }
    public Date getDtts() {
        return dtts;
    }
    public void setDtts(Date dtts) {
        this.dtts = dtts;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getActionid() {
        return actionid;
    }
    public void setActionid(String actionid) {
        this.actionid = actionid;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getUpdatedinfo() {
        return updatedinfo;
    }
    public void setUpdatedinfo(String updatedinfo) {
        this.updatedinfo = updatedinfo;
    }
    public String getPreviousinfo() {
        return previousinfo;
    }
    public void setPreviousinfo(String previousinfo) {
        this.previousinfo = previousinfo;
    }
    public String getChangeby() {
        return changeby;
    }
    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }
    
    
}
