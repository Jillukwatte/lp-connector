package com.epic.ceft.bean;

import java.io.Serializable;

/**
 * @author jayana_i
 *
 */
@SuppressWarnings("serial")
public class CeftRequest implements Serializable { 
	private String refno;  
	private String uuid;  
	private int txnid;  
    private String alerttype;
    private String customerid;
    private String accountno;
    private String mobile; 
    private String txnamount;
    private String txnlocation;
    private String txndatetime; 
    private String avlbalance; 
    private String status;   
    private String retrysms; 
    
	  
	 
	@Override
	public String toString() {
		return "CeftRequest [uuid=" + uuid + ", refno=" + refno + ", txnid=" + txnid + ", alerttype=" + alerttype
				+ ", customerid=" + customerid + ", accountno=" + accountno + ", mobile=" + mobile + ", txnamount="
				+ txnamount + ", txnlocation=" + txnlocation + ", txndatetime=" + txndatetime + ", avlbalance="
				+ avlbalance + ", status=" + status + ", retrysms=" + retrysms + "]";
	}
	public int getTxnid() {
		return txnid;
	}
	public void setTxnid(int txnid) {
		this.txnid = txnid;
	}
	 
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	 
	public String getAlerttype() {
		return alerttype;
	}
	public void setAlerttype(String alerttype) {
		this.alerttype = alerttype;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTxnamount() {
		return txnamount;
	}
	public void setTxnamount(String txnamount) {
		this.txnamount = txnamount;
	}
	public String getTxnlocation() {
		return txnlocation;
	}
	public void setTxnlocation(String txnlocation) {
		this.txnlocation = txnlocation;
	}
	public String getTxndatetime() {
		return txndatetime;
	}
	public void setTxndatetime(String txndatetime) {
		this.txndatetime = txndatetime;
	}
	public String getAvlbalance() {
		return avlbalance;
	}
	public void setAvlbalance(String avlbalance) {
		this.avlbalance = avlbalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRetrysms() {
		return retrysms;
	}
	public void setRetrysms(String retrysms) {
		this.retrysms = retrysms;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	 
    
}
