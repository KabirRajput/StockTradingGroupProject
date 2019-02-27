package com.fdm.legendtrading.springmvc.dao;

import com.fdm.legendtrading.springmvc.model.Entitlement;

public interface EntitlementDao {
	
	public void add(Entitlement entitlement);
	public Entitlement getByUsername(String username);
	
	

}
