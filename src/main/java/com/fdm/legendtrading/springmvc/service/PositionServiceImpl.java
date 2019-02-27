package com.fdm.legendtrading.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.legendtrading.springmvc.dao.PositionDao;
import com.fdm.legendtrading.springmvc.model.Position;
import com.fdm.legendtrading.springmvc.model.PositionId;
import com.fdm.legendtrading.springmvc.model.Trade;

/**
 * Updates user account's information-symbol,quantity,account,asset
 * 
 * @author Kabir.Rajput
 *
 */

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	long buypositionQ = 0;
	long sellpositionQ = 0;

	@Autowired
	private PositionDao positionDao;

	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	@Transactional
	public void addPosition(Position position) {
		this.positionDao.addPosition(position);
	}

	@Override
	public List<Position> getPositionsByAccountId(long id) {
		return this.positionDao.getPositionsByAccountId(id);
	}

	@Override
	@Transactional
	public void updatePosition(Trade trade) {

		Position p1 = positionDao.getPositionByAssetSymbolAndAccountId(trade.getAssetSymbol(),
				trade.getBuyerAccountId());
		Position p2 = positionDao.getPositionByAssetSymbolAndAccountId(trade.getAssetSymbol(),
				trade.getSellerAccountId());

		if (p2 != null) {
			sellpositionQ = p2.getQuantity();
			if (p1 != null) {
				buypositionQ = p1.getQuantity();
				if (trade.getQuantity() <= sellpositionQ) {
					buypositionQ += trade.getQuantity();
					sellpositionQ -= trade.getQuantity();
				}
			} else {

				if (trade.getQuantity() <= sellpositionQ) {
					PositionId pi1 = new PositionId(trade.getAssetSymbol(), trade.getBuyerAccountId());
					buypositionQ = trade.getQuantity();
					Position position = new Position(pi1, buypositionQ);
					this.positionDao.addPosition(position);
					sellpositionQ -= trade.getQuantity();
				}
			}
		}
		this.positionDao.updatePosition(trade.getBuyerAccountId(), trade.getAssetSymbol(), buypositionQ);
		this.positionDao.updatePosition(trade.getSellerAccountId(), trade.getAssetSymbol(), sellpositionQ);
	}

}

