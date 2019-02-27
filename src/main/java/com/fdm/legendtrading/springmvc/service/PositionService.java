package com.fdm.legendtrading.springmvc.service;

import java.util.List;

import com.fdm.legendtrading.springmvc.model.Position;
import com.fdm.legendtrading.springmvc.model.Trade;

/**
 * Interface to update positions
 * @author Kabir.Rajput
 *
 */

public interface PositionService {

	public void addPosition(Position position);

	public void updatePosition(Trade trade);

	public List<Position> getPositionsByAccountId(long id);

}
