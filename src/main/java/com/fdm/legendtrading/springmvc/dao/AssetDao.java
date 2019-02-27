package com.fdm.legendtrading.springmvc.dao;

import java.util.List;

import com.fdm.legendtrading.springmvc.model.Asset;

public interface AssetDao {
	
	public void addAsset(Asset a);
	public List<Asset> listAssets();
	public Asset getAssetBySymbol(String symbol);

}
