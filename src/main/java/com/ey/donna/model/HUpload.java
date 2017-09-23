package com.ey.donna.model;

public class HUpload extends HObject {
	
	private int id;
	private byte[] bytes;
	private int length;
	private String name;
	private String saveName;
	private String type;
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = convertFilePath(path);
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public int getId() {
	    return id;
	}
	public void setId(int id) {
	    this.id = id;
	}
	public byte[] getBytes() {
	    return bytes;
	}
	public void setBytes(byte[] bytes) {
	    this.bytes = bytes;
	}
	
	
}
