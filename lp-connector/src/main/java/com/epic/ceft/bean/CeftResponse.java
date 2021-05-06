package com.epic.ceft.bean;

public class CeftResponse {
	  
    private String responsecode;
    private String description;
    private String uuid;
    
    @Override
	public String toString() {
		return "CeftResponse [uuid=" + uuid + ", responsecode=" + responsecode + ", description=" + description + "]";
	}
	public CeftResponse() {
		
	}
	public String getResponsecode() {
		return responsecode;
	}
	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
     
	  
    
}
