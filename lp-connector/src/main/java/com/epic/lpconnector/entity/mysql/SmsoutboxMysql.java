package com.epic.lpconnector.entity.mysql;
 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name = "smsoutbox")
public class SmsoutboxMysql {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;  
    private String refno; 
    private String mobile; 
    private String message;
    private String status; 
    private String delstatus;
    private String delrefno; 
    private int bulkid;
    private String lastupdateduser;
    private Date lastupdatedtime;
    private Date createdtime;
    private String bulktype;
    private int partcount;
    private String telco;
    private String alerttype;
    private String mtport;
    private double charge;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelstatus() {
		return delstatus;
	}
	public void setDelstatus(String delstatus) {
		this.delstatus = delstatus;
	}
	public String getDelrefno() {
		return delrefno;
	}
	public void setDelrefno(String delrefno) {
		this.delrefno = delrefno;
	}
	public int getBulkid() {
		return bulkid;
	}
	public void setBulkid(int bulkid) {
		this.bulkid = bulkid;
	}
	public String getLastupdateduser() {
		return lastupdateduser;
	}
	public void setLastupdateduser(String lastupdateduser) {
		this.lastupdateduser = lastupdateduser;
	}
	public Date getLastupdatedtime() {
		return lastupdatedtime;
	}
	public void setLastupdatedtime(Date lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public String getBulktype() {
		return bulktype;
	}
	public void setBulktype(String bulktype) {
		this.bulktype = bulktype;
	}
	public int getPartcount() {
		return partcount;
	}
	public void setPartcount(int partcount) {
		this.partcount = partcount;
	}
	public String getTelco() {
		return telco;
	}
	public void setTelco(String telco) {
		this.telco = telco;
	}
	public String getAlerttype() {
		return alerttype;
	}
	public void setAlerttype(String alerttype) {
		this.alerttype = alerttype;
	}
	public String getMtport() {
		return mtport;
	}
	public void setMtport(String mtport) {
		this.mtport = mtport;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
       	 
	 
} 