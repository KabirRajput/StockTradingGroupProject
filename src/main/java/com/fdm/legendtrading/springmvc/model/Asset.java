package com.fdm.legendtrading.springmvc.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "ASSETS")
public class Asset {

	@Id
	private String symbol;
	private String description;
	@Column (nullable = false)
	private String type;
	
	@OneToMany
	private List<Position> position;

	public Asset() {
		
	}
	
	public Asset(String symbol, String description, String type) {
		super();
		this.symbol = symbol;
		this.description = description;
		this.type = type;
	}

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Assets [ symbol = " + symbol + ", description = " + description + ", type = " + type + "]";
	}

}
