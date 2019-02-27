package com.fdm.legendtrading.springmvc.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EntitlementId implements Serializable{
	
	
	private String username;
	private int accountId;
	
	
	public EntitlementId() {
		
	}
	
	public EntitlementId(String username, int accountId) {
		super();
		this.username = username;
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + accountId;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntitlementId other = (EntitlementId) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (accountId != other.accountId)
			return false;
		return true;
	}
	
	
}
