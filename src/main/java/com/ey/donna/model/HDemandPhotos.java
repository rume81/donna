package com.ey.donna.model;

public class HDemandPhotos extends HObject {
	
	private long id;
	private String did;
	private HUpload link;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public HUpload getLink() {
		return link;
	}
	public void setLink(HUpload link) {
		this.link = link;
	}
	
	

}
