package com.ey.donna.model;

public class HSupplyPhotos extends HObject {
    	private long id;
	private String sid;
	private HUpload link;
	
	public long getId() {
	    return id;
	}
	public void setId(long id) {
	    this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public HUpload getLink() {
		return link;
	}
	public void setLink(HUpload link) {
		this.link = link;
	}
	
	

}
