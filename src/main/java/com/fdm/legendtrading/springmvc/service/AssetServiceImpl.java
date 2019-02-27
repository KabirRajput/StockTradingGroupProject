package com.fdm.legendtrading.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.dao.AssetDao;
import com.fdm.legendtrading.springmvc.model.Asset;	

@Service("assetService")
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetDao assetDao;

	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}
	
	@Override
	@Transactional
	public void addAsset(Asset t) {
		this.assetDao.addAsset(t);
	}
	
}
