package com.fdm.legendtrading.springmvc.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Entitlement {

	@EmbeddedId
	private EntitlementId entitlementId;
	
	@ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private Login login;
	
	@ManyToOne
    @JoinColumn(name = "accountId",insertable = false, updatable = false)
    private Account account;
	
	public Entitlement() {
		
	}
	
	public Entitlement(EntitlementId entitlementId) {
		super();
		this.entitlementId = entitlementId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public EntitlementId getEntitlementId() {
		return entitlementId;
	}

	public void setEntitlementId(EntitlementId entitlementId) {
		this.entitlementId = entitlementId;
	}
	
	
	
	
	
}
