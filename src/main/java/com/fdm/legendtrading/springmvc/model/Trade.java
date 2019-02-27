package com.fdm.legendtrading.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TRADE")
public class Trade {
	@Id
	@GeneratedValue
	@Column(name = "TRADE_ID")
	private long tradeId;
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "TRANSACTION_TIME", nullable = false)
	private Date transactionTime;
	@Column(name = "QUANTITY", nullable = false)
	private long quantity;
	@Column(nullable = false)
	private double pricePerShare;
	@Column(nullable = false)
	private String assetSymbol;
	@Column(nullable = false)
	private long buyerAccountId;
	@Column(nullable = false)
	private long sellerAccountId;


	public Trade() {

	}

	public Trade(String username, Date transactionTime, long quantity, double pricePerShare, String assetSymbol,
			long buyerAccountId, long sellerAccountId) {
		this.username = username;
		this.transactionTime = transactionTime;
		this.quantity = quantity;
		this.pricePerShare = pricePerShare;
		this.assetSymbol = assetSymbol;
		this.buyerAccountId = buyerAccountId;
		this.sellerAccountId = sellerAccountId;
	}

	public String getAssetSymbol() {
		return assetSymbol;
	}
	public void setAssetSymbol(String assetSymbol) {
		this.assetSymbol = assetSymbol;
	}
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public long getBuyerAccountId() {
		return buyerAccountId;
	}

	public void setBuyerAccountId(long buyerAccountId) {
		this.buyerAccountId = buyerAccountId;
	}

	public long getSellerAccountId() {
		return sellerAccountId;
	}

	public void setSellerAccountId(long sellerAccountId) {
		this.sellerAccountId = sellerAccountId;
	}
}