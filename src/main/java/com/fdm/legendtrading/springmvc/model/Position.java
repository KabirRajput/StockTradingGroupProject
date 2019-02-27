package com.fdm.legendtrading.springmvc.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Position {

	@EmbeddedId
	private PositionId positionId;
	private long quantity;
	
	public Position() {
		
	}

	public Position(PositionId positionId, long quantity) {
		super();
		this.positionId = positionId;
		this.quantity = quantity;
	}
	
	public PositionId getId() {
		return positionId;
	}

	public void setId(PositionId positionId) {
		this.positionId = positionId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public PositionId getPositionId() {
		return positionId;
	}


	public void setPositionId(PositionId positionId) {
		this.positionId = positionId;
	}

}
