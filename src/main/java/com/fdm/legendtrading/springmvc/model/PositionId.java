package com.fdm.legendtrading.springmvc.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PositionId implements Serializable {

	private String assetSymbol;
	private long accountId;
	
	public PositionId() {
		
	}

	public PositionId(String assetSymbol, long accountId) {
		super();
		this.assetSymbol = assetSymbol;
		this.accountId = accountId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAssetSymbol() {
		return assetSymbol;
	}

	public void setAssetSymbol(String assetSymbol) {
		this.assetSymbol = assetSymbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
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
		PositionId other = (PositionId) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

}
