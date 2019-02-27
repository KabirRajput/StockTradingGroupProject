package com.fdm.legendtrading.springmvc.service;

import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.model.Asset;

public interface AssetService {

	void addAsset(Asset t);

}