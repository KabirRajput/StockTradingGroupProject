package com.fdm.legendtrading.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue
	private int accountId;
	@Column(nullable=false)
	private String type;
	@Column(nullable=false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "accountId")
	private List<Position> positionsList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trade> buysTradeRecords;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trade> sellsTradeRecords;

	@OneToMany
	private List<Entitlement> entitlementList;

//	@OneToMany(mappedBy = "positionId.account", targetEntity = Position.class, orphanRemoval = true, fetch = FetchType.EAGER)
//	private List<Position> positionsList;

	public Account() {
	}

	public Account(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
