package com.epic.lpconnector.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "smssmppconfiguration")
public class Smppconfiguration {

	@Id
	private String smppcode;
    private String description;
    private int maxtps; 
    private String primaryip;
    private String systemid;
    private String password;
    private int bindport;
    private String bindmode;
    private String mtport;
    private String moport;
    private String secondaryip;
    private int maxbulktps;
    private String status;
    private int isconnected;
    private String connectedip;
    
    
	public String toStringPrimary() {
		return "with [description=" + description + ", primaryip=" + primaryip
				+ ", systemid=" + systemid + ", password=" + password + ", bindport=" + bindport + ", bindmode="
				+ bindmode + ", maxbulktps=" + maxbulktps + ", maxtps=" + maxtps + "]";
	}
	public String toStringSecondary() {
		return "with [description=" + description + ", secondaryip=" + secondaryip
				+ ", systemid=" + systemid + ", password=" + password + ", bindport=" + bindport + ", bindmode="
				+ bindmode + ", maxbulktps=" + maxbulktps + ", maxtps=" + maxtps + "]";
	}
	public String getSmppcode() {
		return smppcode;
	}
	public void setSmppcode(String smppcode) {
		this.smppcode = smppcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	public String getPrimaryip() {
		return primaryip;
	}
	public void setPrimaryip(String primaryip) {
		this.primaryip = primaryip;
	}
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBindport() {
		return bindport;
	}
	public void setBindport(int bindport) {
		this.bindport = bindport;
	}
	public String getBindmode() {
		return bindmode;
	}
	public void setBindmode(String bindmode) {
		this.bindmode = bindmode;
	}
	public String getMtport() {
		return mtport;
	}
	public void setMtport(String mtport) {
		this.mtport = mtport;
	}
	public String getMoport() {
		return moport;
	}
	public void setMoport(String moport) {
		this.moport = moport;
	}
	public String getSecondaryip() {
		return secondaryip;
	}
	public void setSecondaryip(String secondaryip) {
		this.secondaryip = secondaryip;
	}
	 
	public int getMaxtps() {
		return maxtps;
	}
	public void setMaxtps(int maxtps) {
		this.maxtps = maxtps;
	}
	public int getMaxbulktps() {
		return maxbulktps;
	}
	public void setMaxbulktps(int maxbulktps) {
		this.maxbulktps = maxbulktps;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIsconnected() {
		return isconnected;
	}
	public void setIsconnected(int isconnected) {
		this.isconnected = isconnected;
	}
	public String getConnectedip() {
		return connectedip;
	}
	public void setConnectedip(String connectedip) {
		this.connectedip = connectedip;
	}
     
    
}
