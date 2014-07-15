package com.yk.yboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.yboard.dao.YboardDAO;
import com.yk.yboard.dto.Yboard;
import com.yk.yboard.dto.YboardSearch;

@Service
public class YboardServiceImpl implements YboardService {

	@Autowired
	private YboardDAO yboardDAO;

	@Override
	public int selectTotalCountYboard(YboardSearch yboardSearch) {
		return yboardDAO.selectTotalCountYboard(yboardSearch);
	}

	@Override
	public List<Yboard> selectYboard(YboardSearch yboardSearch) {
		return yboardDAO.selectYboard(yboardSearch);
	}

	@Override
	public Yboard viewYboard(Map<String, Object> map) {
		return yboardDAO.viewYboard(map);
	}

	@Override
	public int insertYboard(Yboard yboard) {
		return yboardDAO.insertYboard(yboard);
	}

	@Override
	public int updateYboard(Yboard yboard) {
		return yboardDAO.updateYboard(yboard);
	}

	@Override
	public void deleteYboard(List<Map<String, Object>> mapList) {
		yboardDAO.deleteYboard(mapList);
	}

}
