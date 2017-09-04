package com.customer.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@Column(name = "CUST_ID")
	private int    custID;
	@Column(name ="FIRST_NAME")
	private String f_Name;
	@Column(name = "LAST_NAME")
	private String l_Name;
	@Column(name = "BRANCH_NAME")
	private String branch_Name;
	@Column(name = "ACCONT_TYPE")
	private String acct_Type;
	
	
	public int getCustID() {
		return custID;
	}
	public void setCust_ID(int custID) {
		this.custID = custID;
	}
	public String getF_Name() {
		return f_Name;
	}
	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}
	public String getL_Name() {
		return l_Name;
	}
	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}
	public String getAcct_Type() {
		return acct_Type;
	}
	public void setAcct_Type(String acct_Type) {
		this.acct_Type = acct_Type;
	}
	
	
	

}
