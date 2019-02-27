package com.fdm.legendtrading.springmvc.dao;

import java.util.List;

import com.fdm.legendtrading.springmvc.model.Position;

public interface PositionDao {

	public void addPosition(Position position);
	public void removePosition(Position position);
	public Position getPositionByAssetSymbolAndAccountId(String assetSymbol, long accountId);
	public void updatePosition(long accountId, String assetSymbol, long quantity);
	public List<Position> getPositionsByAccountId(long id);
}
